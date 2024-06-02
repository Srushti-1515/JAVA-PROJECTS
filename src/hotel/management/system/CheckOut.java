
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener{
    
    
    JLabel title, lblid,lblroom,lblroomnumber,lblcheckintime,lblcheckin,lblcheckouttime,lblcheckout, image, image2;
    Choice ccustomer;
    JButton checkout,back;
    
    CheckOut(){
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,800,400);
        setVisible(true);
        
        title =new JLabel("Checkout");
        title.setBounds(100,20,100,30);
        title.setForeground(Color.blue);
        title.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(title);
        
        lblid =new JLabel("Customer ID");
         lblid.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblid.setBounds(30,80,100,30);
         add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,165,40);
        add(ccustomer);

        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(370,80,20,20);
        add(image);
        
        lblroom =new JLabel("Room Number");
         lblroom.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblroom.setBounds(30,130,150,30);
         add(lblroom);
        
          lblroomnumber =new JLabel("");
         lblroomnumber.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblroomnumber.setBounds(200,130,100,30);
         add(lblroomnumber);
         
         lblcheckin =new JLabel("CheckIn Time");
         lblcheckin.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblcheckin.setBounds(30,180,150,30);
         add(lblcheckin);
        
          lblcheckintime =new JLabel("");
         lblcheckintime.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblcheckintime.setBounds(200,180,100,30);
         add(lblcheckintime);
         
         lblcheckout =new JLabel("CheckOut Time");
         lblcheckout.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblcheckout.setBounds(30,230,150,30);
         add(lblcheckout);
        
         Date date=new Date();
          lblcheckouttime =new JLabel(""+date);
         lblcheckouttime.setFont(new Font("Tahoma", Font.PLAIN,14));
        lblcheckouttime.setBounds(200,230,250,30);
         add(lblcheckouttime);
        
        checkout=new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(50,300,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260,300,120,30);
        back.addActionListener(this);
        add(back);
        
        try{
        Conn conn=new Conn();
        ResultSet rs= conn.s.executeQuery("select * from customer");
            while(rs.next()){
            ccustomer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("room"));
            lblcheckintime.setText(rs.getString("checkintime"));
            }

        }catch(Exception ae){
        ae.printStackTrace();
        }
         
        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image j2=j1.getImage().getScaledInstance(350, 250,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        image2 = new JLabel(j3);
        image2.setBounds(410,60,350,250);
        add(image2);
        
        }
    
    
    @Override
    public void actionPerformed(ActionEvent e8){
    if(e8.getSource()==checkout){
    String query1="delete from customer where number    = '"+ccustomer.getSelectedItem()+"'";
    String query2="update room set availability = 'Available' where roomnumber ='"+lblroomnumber.getText()+"' ";
    
    try{
        Conn c=new Conn();
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        
        JOptionPane.showMessageDialog(null, "Checkout Done");
        
        setVisible(false);
        new Reception();
    
    }catch(Exception e){
    e.printStackTrace();
    }
        
    }else{
    setVisible(false);
    new Reception();
    }
    }
        
    
    public static void main (String[] args){
    
    new CheckOut();
    }
}
