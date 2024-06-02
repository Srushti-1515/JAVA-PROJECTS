
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    EmployeeInfo(){
    getContentPane().setBackground(Color.WHITE);
    setBounds(300,200,1000,600);
    setLayout(null);
    setVisible(true);
    
 
    
    JLabel l1=new JLabel("Name");
    l1.setBounds(50,10,100,30);
    add(l1);
    
    JLabel l2=new JLabel("Age");
    l2.setBounds(180,10,100,30);
    add(l2);
    
    JLabel l3=new JLabel("Gender");
    l3.setBounds(290,10,100,30);
    add(l3);
    
    JLabel l5=new JLabel("Job Title");
    l5.setBounds(410,10,100,30);
    add(l5);
    
    JLabel l4=new JLabel("Salary");
    l4.setBounds(540,10,100,30);
    add(l4);
    
    JLabel l6=new JLabel("Mobile Number");
    l6.setBounds(640,10,100,30);
    add(l6);
    
    JLabel l7=new JLabel("Email");
    l7.setBounds(790,10,100,30);
    add(l7);
    
    JLabel l8=new JLabel("Document ID");
    l8.setBounds(890,10,100,30);
    add(l8);
    
    
    
    table=new JTable();
    table.setBounds(0,40,1000,400);
    add(table);
    
    try{
        
        Conn con=new Conn();
        ResultSet rs=con.s.executeQuery("select * from employee");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch(Exception e){
    e.printStackTrace();
    }
    
    
    back=new JButton("Back");
    back.setBounds(420,500,120,30);
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
    
    new EmployeeInfo();
    }
}

