
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    
    JTable table ;
    JButton back, submit;
    Choice typeofcar;
    JCheckBox available;
    
    Pickup(){
    getContentPane().setBackground(Color.WHITE);
    setBounds(300,150,1000,650);
    setLayout(null);
    setVisible(true);
    
   JLabel title =new JLabel("PickUp Service");
    title.setFont(new Font("Tahoma",Font.PLAIN,20));
    title.setBounds(400,10,200,30);
    add(title);
    
   JLabel type= new JLabel("Type of cars");
    type.setFont(new Font("Tahoma",Font.PLAIN,18));
    type.setBounds(30,50,100,20);
    add(type);    
    
    
    typeofcar=new Choice();
    typeofcar.setBounds(150,50,200,25);
    typeofcar.setBackground(Color.WHITE);
    add(typeofcar);
    
    
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from driver");
        while(rs.next()){
        typeofcar.add(rs.getString("car_model"));
        }
    
    }catch(Exception e){
    e.printStackTrace();
    }
    
    available=new JCheckBox("Only Display Available");
    available.setBounds(700,50,200,25);
    available.setFont(new Font("Tahoma",Font.PLAIN,17));
    available.setBackground(Color.WHITE);
//    available.setBorderPainted(("false"));
    add(available);
    
    JLabel l1=new JLabel("Name");
    l1.setBounds(60,80,100,30);
    add(l1);
    
    JLabel l2=new JLabel("age");
    l2.setBounds(210,80,100,30);
    add(l2);
    
    JLabel l3=new JLabel("gender");
    l3.setBounds(330,80,100,30);
    add(l3);
    
    JLabel l5=new JLabel("Company Brand");
    l5.setBounds(460,80,100,30);
    add(l5);
    
    JLabel l4=new JLabel("Car Model");
    l4.setBounds(620,80,100,30);
    add(l4);
    
    JLabel l7=new JLabel("Avalibility");
    l7.setBounds(740,80,100,30);
    add(l7);
    
    JLabel l6=new JLabel("Loaction");
    l6.setBounds(880,80,100,30);
    add(l6);
    
    
    
    table=new JTable();
    table.setBounds(0,120,1000,400);
    add(table);
    
    try{
        
        Conn con=new Conn();
        ResultSet rs=con.s.executeQuery("select * from driver");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }catch(Exception e){
    e.printStackTrace();
    }
    
    submit=new JButton("Submit");
    submit.setBounds(360,550,120,30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    add(submit);
    
    back=new JButton("Back");
    back.setBounds(560,550,120,30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    
   
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== submit){
            try{
                String query1= " select * from driver where car_model= '"+typeofcar.getSelectedItem()+"' ";
                String query2= "select * from driver where available = 'Available' AND car_model = '"+typeofcar.getSelectedItem()+"'";
                Conn conn=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                  rs = conn.s.executeQuery(query2);
                }else {
                  rs = conn.s.executeQuery(query1);
                }
            
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception ea){
            ea.printStackTrace();
            }
    }else{
    setVisible(false);
    new Reception();
            }
    }
    
    public static void main(String[] args){
    
    new Pickup();
    }
}
