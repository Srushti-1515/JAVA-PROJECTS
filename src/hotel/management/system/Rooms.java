
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    Rooms(){
    getContentPane().setBackground(Color.WHITE);
    setBounds(300,200,1050,600);
    setLayout(null);
    setVisible(true);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
    Image i2= i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel img=new JLabel(i3);
    img.setBounds(500, 0, 600, 600);
    add(img);
    
    JLabel l1=new JLabel("Room Number");
    l1.setBounds(10,10,100,30);
    add(l1);
    
    JLabel l2=new JLabel("Avalibility");
    l2.setBounds(120,10,100,30);
    add(l2);
    
    JLabel l3=new JLabel("Status");
    l3.setBounds(230,10,100,30);
    add(l3);
    
    JLabel l5=new JLabel("Price");
    l5.setBounds(340,10,100,30);
    add(l5);
    
    JLabel l4=new JLabel("Bed Type");
    l4.setBounds(430,10,100,30);
    add(l4);
    
    
    
    table=new JTable();
    table.setBounds(0,40,500,400);
    add(table);
    
    try{
        
        Conn con=new Conn();
        ResultSet rs=con.s.executeQuery("select * from room");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch(Exception e){
    e.printStackTrace();
    }
    
    
    back=new JButton("Back");
    back.setBounds(200,500,120,30);
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
    
    new Rooms();
    }
}
