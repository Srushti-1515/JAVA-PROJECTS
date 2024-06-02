
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateRoomStatus extends JFrame implements ActionListener{
    JLabel title, lblid, lblroom, lblavailable, lblpaid,lblpending, lblcleanstatus,img;
    Choice ccustomer;
    JTextField txtroom, txtavailable, txtcleanstatus, txtpaid, txtpending;
    JButton check, update, back;
    
    UpdateRoomStatus(){
        getContentPane().setBackground(Color.WHITE);
         setLayout(null);
        setBounds(300,200,980,450);
       
        setVisible(true);
        
    title =new JLabel("Update Room Status");
    title.setFont(new Font("Tahoma",Font.PLAIN,25));
    title.setBounds(30,20,250,30);
    title.setForeground(Color.BLUE);
    add(title);
    
   lblid =new JLabel("Cutomer ID");
    lblid.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblid.setBounds(30,80,150,20);
    add(lblid);
    
    ccustomer = new Choice();
    ccustomer.setBounds(200,80,165,30);
    add(ccustomer);
    
    try{
    Conn conn=new Conn();
    ResultSet rs= conn.s.executeQuery("select * from customer");
        while(rs.next()){
        ccustomer.add(rs.getString("number"));
        }
    
    }catch(Exception ae){
    ae.printStackTrace();
       }
        
     lblroom =new JLabel("Room Number");
    lblroom.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblroom.setBounds(30,130,150,20);
    add(lblroom);
    
    txtroom =new JTextField();
    txtroom.setBounds(200,130,165,25);
    add(txtroom);
    
    lblavailable =new JLabel("Availibility");
    lblavailable.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblavailable.setBounds(30,180,100,20);
    add(lblavailable);
    
    txtavailable =new JTextField();
    txtavailable.setBounds(200,180,165,25);
    add(txtavailable);
    
    lblcleanstatus =new JLabel("Cleaning Status");
    lblcleanstatus.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblcleanstatus.setBounds(30,230,160,20);
    add(lblcleanstatus);
    
    txtcleanstatus =new JTextField();
    txtcleanstatus.setBounds(200,230,165,25);
    add(txtcleanstatus);
    
  
    
    check=new JButton("Check");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    check.setBounds(30,300,100,30);
    check.addActionListener(this);
    add(check);
    
    update=new JButton("Update");
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.setBounds(150,300,100,30);
    update.addActionListener(this);
    add(update);
    
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(270,300,100,30);
    back.addActionListener(this);
    add(back);
    
    ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
    Image i2=image.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    img =new JLabel(i3);
    img.setBounds(400,50,500,300);
    add(img);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
    if(ev.getSource()== check){
        String id = ccustomer.getSelectedItem();
        String str= "select * from customer where number= '"+id+"'";
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
            txtroom.setText(rs.getString("room"));
       
            }
            
            ResultSet rs2=c.s.executeQuery("select * from room where roomnumber = '"+txtroom.getText()+"'");
            while(rs2.next()){
             txtavailable.setText(rs2.getString("availability"));
             txtcleanstatus.setText(rs2.getString("cleaning_status"));
            }
            
        
        }catch(Exception e5){
        e5.printStackTrace();
        }
        
    }else if(ev.getSource()== update){
        
        String number = ccustomer.getSelectedItem();
        String available = txtavailable.getText();
        String room = txtroom.getText();
        String status = txtcleanstatus.getText();
        
        
        try{
        
            Conn con=new Conn();
            con.s.executeUpdate("update room set  availability = '"+available+"',cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
            
            JOptionPane.showMessageDialog(null,"data Update Successfully");
            
            setVisible(false);
             new Reception();
            
        }catch(Exception e6){
        e6.printStackTrace();
        }  
    }else{
    setVisible(false);
        new Reception();
    }
    
    }
    
      public static void main(String[] args){
        
        new UpdateRoomStatus( );
    }
    
}

