
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    CustomerInfo(){
    getContentPane().setBackground(Color.WHITE);
    setBounds(300,200,1000,600);
    setLayout(null);
    setVisible(true);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/"));
    Image i2= i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel img=new JLabel(i3);
    img.setBounds(500, 0, 600, 600);
    add(img);
    
     JLabel l1=new JLabel("Document");
    l1.setBounds(50,10,100,30);
    add(l1);
    
    JLabel l2=new JLabel("Number");
    l2.setBounds(180,10,100,30);
    add(l2);
    
    JLabel l3=new JLabel("Name");
    l3.setBounds(290,10,100,30);
    add(l3);
    
    JLabel l5=new JLabel("Gender");
    l5.setBounds(410,10,100,30);
    add(l5);
    
    JLabel l4=new JLabel("Country");
    l4.setBounds(540,10,100,30);
    add(l4);
    
    JLabel l6=new JLabel("Room Number");
    l6.setBounds(640,10,100,30);
    add(l6);
    
    JLabel l7=new JLabel("Check in Time");
    l7.setBounds(780,10,100,30);
    add(l7);
    
    JLabel l8=new JLabel("Deposit");
    l8.setBounds(890,10,100,30);
    add(l8);
    
    
    
    table=new JTable();
    table.setBounds(0,40,1000,400);
    add(table);
    
    try{
        
        Conn con=new Conn();
        ResultSet rs=con.s.executeQuery("select * from customer ");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch(Exception e){
    e.printStackTrace();
    }
    
    
    back=new JButton("Back");
    back.setBounds(450,500,120,30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    
   
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    setVisible(false);
    new Reception();
    }
    
    public static void main(String[] args){
    
    new CustomerInfo();
    }
}

