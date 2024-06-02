
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateStatus extends JFrame implements ActionListener{
    JLabel title, lblid, lblroom, lblname, lblpaid,lblpending, lbltime,img;
    Choice ccustomer;
    JTextField txtroom, txtname, txttime, txtpaid, txtpending;
    JButton check, update, back;
    
    UpdateStatus(){
        getContentPane().setBackground(Color.WHITE);
         setLayout(null);
        setBounds(300,200,980,500);
       
        setVisible(true);
        
    title =new JLabel("Update Status");
    title.setFont(new Font("Tahoma",Font.PLAIN,20));
    title.setBounds(100,20,200,30);
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
    lblroom.setBounds(30,120,150,20);
    add(lblroom);
    
    txtroom =new JTextField();
    txtroom.setBounds(200,120,165,25);
    add(txtroom);
    
    lblname =new JLabel("Name");
    lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblname.setBounds(30,160,100,20);
    add(lblname);
    
    txtname =new JTextField();
    txtname.setBounds(200,160,165,25);
    add(txtname);
    
    lbltime =new JLabel("Check in Time");
    lbltime.setFont(new Font("Tahoma",Font.PLAIN,17));
    lbltime.setBounds(30,200,160,20);
    add(lbltime);
    
    txttime =new JTextField();
    txttime.setBounds(200,200,165,25);
    add(txttime);
    
    lblpaid =new JLabel("Amount Paid");
    lblpaid.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblpaid.setBounds(30,240,100,20);
    add(lblpaid);
    
    txtpaid =new JTextField();
    txtpaid.setBounds(200,240,165,25);
    add(txtpaid);
    
    lblpending =new JLabel("Amount Pending");
    lblpending.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblpending.setBounds(30,280,130,20);
    add(lblpending);
    
    txtpending =new JTextField();
    txtpending.setBounds(200,280,165,25);
    add(txtpending);
    
    check=new JButton("Check");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    check.setBounds(30,340,100,30);
    check.addActionListener(this);
    add(check);
    
    update=new JButton("Update");
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.setBounds(150,340,100,30);
    update.addActionListener(this);
    add(update);
    
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(270,340,100,30);
    back.addActionListener(this);
    add(back);
    
    ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
    img =new JLabel(image);
    img.setBounds(400,50,500,300);
    add(img);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
    if(ev.getSource()== check){
        String id = ccustomer.getSelectedItem();
        String query= "select * from customer where number= '"+id+"'";
        
        try{
            
            Conn con=new Conn();
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next()){
            txtroom.setText(rs.getString("room"));
            
            txtname.setText(rs.getString("name"));
           txttime.setText(rs.getString("checkintime"));
           txtpaid.setText(rs.getString("deposite"));
            
            }
            
            ResultSet rs2=con.s.executeQuery("select * from room where roomnumber = '"+txtroom.getText()+"'");
            while(rs2.next()){
            String price = rs2.getString("price");
            int amountpaid= Integer.parseInt(price) - Integer.parseInt(txtpaid.getText());
            txtpending.setText(""+amountpaid);
            }
            
        
        }catch(Exception e5){
        e5.printStackTrace();
        }
        
    }else if(ev.getSource()== update){
        
        String number = ccustomer.getSelectedItem();
        String name = txtname.getText();
        String room = txtroom.getText();
        String checkin = txttime.getText();
        String deposite = txtpaid.getText();
        
        try{
        
            Conn con=new Conn();
            con.s.executeUpdate("update customer set  room = '"+room+"', name = '"+name+"',checkintime = '"+checkin+"',deposite = '"+deposite+"' where number = '"+number+"'");
            
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
        
        new UpdateStatus( );
    }
    
}
