
package hotel.management.system;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JLabel heading, roomnum, available, cleaningstatus, rprice, bedtype, image;
    JTextField txtroomnum, txtprice;
    JButton btnaddroom, cancel;
    JComboBox roomavailable, roomcleaningstatus, roombedtype;
    
    
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(330,200,850,500);
        setVisible(true);
        
        heading=new JLabel("Add Rooms");
        heading.setBounds(100, 30, 120, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        roomnum=new JLabel("Room Number");
        roomnum.setBounds(50,100,150,30);
        roomnum.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(roomnum);
        
        
        txtroomnum=new JTextField();
        txtroomnum.setBounds(180,100,150,30);
        add(txtroomnum);
        
        available=new JLabel("Available");
        available.setBounds(50,150,150,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(available);
 
        
        String availabeoptions[]={" ","Available","Occupied"};
        roomavailable=new JComboBox(availabeoptions);
        roomavailable.setBounds(180,150,150,30);
        roomavailable.setBackground(Color.WHITE);
        add(roomavailable);
        
        
        cleaningstatus=new JLabel("Cleaning Status");
        cleaningstatus.setBounds(50,200,150,30);
        cleaningstatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(cleaningstatus);
        
        String cleanoption[]={"","Cleaned","Dirty"};
        roomcleaningstatus=new JComboBox(cleanoption);
        roomcleaningstatus.setBounds(180,200,150,30);
        roomcleaningstatus.setBackground(Color.WHITE);
        add(roomcleaningstatus);
        
        rprice=new JLabel("Price");
        rprice.setBounds(50,250,150,30);
        rprice.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(rprice);
        
        txtprice=new JTextField();
        txtprice.setBounds(180,250,150,30);
        add(txtprice);
        
        bedtype=new JLabel("Bed Type");
        bedtype.setBounds(50,300,150,30);
        bedtype.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(bedtype);
        
        String bedtypeoption[]={"","Single Bed", "Double Bed"};
        roombedtype=new JComboBox(bedtypeoption);
        roombedtype.setBounds(180,300,150,30);
        roombedtype.setBackground(Color.WHITE);
        add(roombedtype);
        
        
        btnaddroom=new JButton("ADD ROOM");
        btnaddroom.setBounds(50,380,120,30);
        btnaddroom.setBackground(Color.BLACK);
        btnaddroom.setForeground(Color.WHITE);
        btnaddroom.addActionListener(this);
        add(btnaddroom);
    
        
        cancel=new JButton("CANCEL");
        cancel.setBounds(210,380,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        image=new JLabel(i1);
        image.setBounds(400,30,400,320);
        add(image);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e3){
        if (e3.getSource()== btnaddroom){
            
            String roomnumber=txtroomnum.getText();
            String availability=(String)roomavailable.getSelectedItem();
            String cleaning_status=(String) roomcleaningstatus.getSelectedItem();
            String bed_type=(String) roombedtype.getSelectedItem();
            String price=txtprice.getText();
        
            try{
            Conn conn=new Conn();
            String str="insert into room values('"+roomnumber+"','"+availability+"','"+cleaning_status+"','"+price+"','"+bed_type+"') ";
            conn.s.executeLargeUpdate(str);
            
            JOptionPane.showMessageDialog(null,"New Room Added successfully");
            
            setVisible(false);
            
            }catch(Exception e){
            e.printStackTrace();
            }
        }else{
        setVisible(false);
        }
        
    
    }
    
    public static void main(String[]args){
    
    new AddRooms();
    }
    
}
