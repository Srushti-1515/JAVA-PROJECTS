
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table ;
    JButton back, submit;
    JComboBox bedtype;
    JCheckBox available;
    
    SearchRoom(){
    getContentPane().setBackground(Color.WHITE);
    setBounds(300,150,1000,650);
    setLayout(null);
    setVisible(true);
    
   JLabel title =new JLabel("Search for Rooms");
    title.setFont(new Font("Tahoma",Font.PLAIN,20));
    title.setBounds(400,10,200,30);
    add(title);
    
   JLabel lblbed= new JLabel("Bed Type");
    lblbed.setFont(new Font("Tahoma",Font.PLAIN,18));
    lblbed.setBounds(20,30,200,30);
    add(lblbed);    
    
    
    bedtype=new JComboBox(new String[]{"Single Bed","Double Bed"});
    bedtype.setBounds(150,30,150,25);
    bedtype.setBackground(Color.WHITE);
    add(bedtype);
    
    available=new JCheckBox("Only Display Available");
    available.setBounds(700,30,200,25);
    available.setFont(new Font("Tahoma",Font.PLAIN,17));
    available.setBackground(Color.WHITE);
//    available.setBorderPainted(("false"));
    add(available);
    
    JLabel l1=new JLabel("Room Number");
    l1.setBounds(80,80,100,30);
    add(l1);
    
    JLabel l2=new JLabel("Avalibility");
    l2.setBounds(280,80,100,30);
    add(l2);
    
    JLabel l3=new JLabel("Status");
    l3.setBounds(480,80,100,30);
    add(l3);
    
    JLabel l5=new JLabel("Price");
    l5.setBounds(680,80,100,30);
    add(l5);
    
    JLabel l4=new JLabel("Bed Type");
    l4.setBounds(880,80,100,30);
    add(l4);
    
    
    
    table=new JTable();
    table.setBounds(0,120,1000,400);
    add(table);
    
    try{
        
        Conn con=new Conn();
        ResultSet rs=con.s.executeQuery("select * from room");
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
                String query1= " select * from room where bed_type= '"+bedtype.getSelectedItem()+"' ";
                String query2= "select * from room where availability = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
                
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
    
    new SearchRoom();
    }
}
