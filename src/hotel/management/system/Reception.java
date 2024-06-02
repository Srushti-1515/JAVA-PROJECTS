
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton newcust, rooms, dept, allemp, custinfo, managerinfo, checkout, updatestatus, updateroomstatus, pickupservice, searchroom, logout;
    JLabel image;
    
    Reception(){
    getContentPane().setBackground(Color.WHITE);
    
    setLayout(null);
    setBounds(350,200,800,570);
    setVisible(true);
    
         newcust=new JButton("New Cutomer Form");
         newcust.setBounds(10,30,150,30);
         newcust.setBackground(Color.BLACK);
         newcust.setForeground(Color.white);
         newcust.addActionListener(this);
         add(newcust);
         
     
         rooms=new JButton("Rooms");
         rooms.setBounds(10,70,150,30);
         rooms.setBackground(Color.BLACK);
          rooms.setForeground(Color.white);
          rooms.addActionListener(this);
         add(rooms);
     
         dept=new JButton("Department");
         dept.setBounds(10,110,150,30);
         dept.setBackground(Color.BLACK);
          dept.setForeground(Color.white);
          dept.addActionListener(this);
         add(dept);
      
         allemp=new JButton("All Employee");
         allemp.setBounds(10,150,150,30);
         allemp.setBackground(Color.BLACK);
          allemp.setForeground(Color.white);
           allemp.addActionListener(this);
         add(allemp);
       
         custinfo=new JButton("Customer Info");
         custinfo.setBounds(10,190,150,30);
         custinfo.setBackground(Color.BLACK);
          custinfo.setForeground(Color.white);
          custinfo.addActionListener(this);
         add(custinfo);
        
         managerinfo=new JButton("Manager Info");
         managerinfo.setBounds(10,230,150,30);
         managerinfo.setBackground(Color.BLACK);
          managerinfo.setForeground(Color.white);
          managerinfo.addActionListener(this);
         add(managerinfo);
         
         checkout=new JButton("Checkout");
         checkout.setBounds(10,270,150,30);
         checkout.setBackground(Color.BLACK);
          checkout.setForeground(Color.white);
           checkout.addActionListener(this);
         add(checkout);
          
         updatestatus=new JButton("Update Status");
         updatestatus.setBounds(10,310,150,30);
         updatestatus.setBackground(Color.BLACK);
          updatestatus.setForeground(Color.white);
          updatestatus.addActionListener(this);
         add(updatestatus);
           
         updateroomstatus=new JButton("Update Room Status");
         updateroomstatus.setBounds(10,350,150,30);
         updateroomstatus.setBackground(Color.BLACK);
          updateroomstatus.setForeground(Color.white);
          updateroomstatus.addActionListener(this);
         add(updateroomstatus);
            
         pickupservice=new JButton("Pickup Services");
         pickupservice.setBounds(10,390,150,30);
         pickupservice.setBackground(Color.BLACK);
          pickupservice.setForeground(Color.white);
          pickupservice.addActionListener(this);
         add(pickupservice);
             
         searchroom=new JButton("Search Room");
         searchroom.setBounds(10,430,150,30);
         searchroom.setBackground(Color.BLACK);
          searchroom.setForeground(Color.white);
          searchroom.addActionListener(this);
         add(searchroom);
              
         logout=new JButton("Logout");
         logout.setBounds(10,470,150,30);
         logout.setBackground(Color.BLACK);
          logout.setForeground(Color.white);
          logout.addActionListener(this);
         add(logout);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
         Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         image=new JLabel(i3);
         image.setBounds(220,55,500,400);
         add(image);
         
               
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    if (e.getSource()== newcust){
    setVisible(false);
    new AddCustomer();
    }else if(e.getSource()== rooms){
    setVisible(false);
    new Rooms();
    }else if(e.getSource()== dept){
    setVisible(false);
    new Department();
    }else if(e.getSource()== allemp){
    setVisible(false);
    new EmployeeInfo();
    }else if(e.getSource()==custinfo){
    setVisible(false);
    new CustomerInfo();
    }else if(e.getSource()==managerinfo){
    setVisible(false);
    new ManagerInfo();
    }else if(e.getSource() == searchroom){
        setVisible(false);
        new SearchRoom();
    }else if(e.getSource()==updatestatus){
        setVisible(false);
        new UpdateStatus();
    }else if (e.getSource()==updateroomstatus){
        setVisible(false);
        new UpdateRoomStatus();
    }else if(e.getSource()== pickupservice){
        setVisible(false);
        new Pickup();
    }else if(e.getSource()==checkout){
       setVisible(false);
        new CheckOut();
    }else{
    setVisible(false);
    }
    }
    
    public static void main(String []args){
    
     new Reception ();
    }
    
}
