
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel lbltitle, lblid, lblnumber, lblname, lblgender, lblcountry, lblallocatedrooms, lblcheckintime, lbldeposit, txtcheckintime, image;
    JButton addcust, back;
    JComboBox txtid;
    Choice txtallocatedrooms;
    JTextField txtnum, txtname, txtCountry, txtdeposit;
    JRadioButton male, female;
     
    AddCustomer(){
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,200,800,550);
        setVisible(true);
       
        
        lbltitle=new JLabel("NEW CUSTOMER FORM");
        lbltitle.setBounds(100,15,300,30);
        lbltitle.setFont(new Font("Tahoma",Font.BOLD,20));
        lbltitle.setForeground(Color.blue);
        add(lbltitle);
        
        lblid=new JLabel ("ID");
        lblid.setBounds(30, 60, 150, 30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblid);
        
        String idoptions[]={"","PassPort", "Adhar Card", "Voter ID", "Pan Card", "Driving License"};
        txtid= new JComboBox(idoptions);
        txtid.setBounds(230,60,180,30);
        txtid.setFont(new Font("Tahoma",Font.PLAIN,17));
        txtid.setBackground(Color.WHITE);
        add(txtid);
        
         lblnumber=new JLabel ("Number");
        lblnumber.setBounds(30, 110, 150, 30);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblnumber);
        
         txtnum =new JTextField();
         txtnum.setBounds(230,110,180,30);
         txtnum.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(txtnum);
        
         lblname=new JLabel ("Name");
        lblname.setBounds(30, 160, 150, 30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
         txtname =new JTextField();
         txtname.setBounds(230,160,180,30);
         txtname.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(txtname);
         
         lblgender=new JLabel ("Gender");
        lblgender.setBounds(30, 210, 150, 30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        male=new JRadioButton("Male");
        male.setBounds(240, 210, 80, 30);
        male.setFont(new Font("Tahoma",Font.PLAIN,15));
        male.setBackground(Color.WHITE);
        add(male);  
        
        female=new JRadioButton("Female");
        female.setBounds(320, 210, 80, 30);
        female.setFont(new Font("Tahoma",Font.PLAIN,15));
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup bg=new ButtonGroup();  //at a time only one readio button will choose
        bg.add(male);
        bg.add(female);
        
        lblcountry=new JLabel ("Country");
        lblcountry.setBounds(30, 260, 150, 30);
        lblcountry.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcountry);
        
         txtCountry =new JTextField();
         txtCountry.setBounds(230,260,180,30);
         txtCountry.setFont(new Font("Tahoma",Font.PLAIN,17));
         txtCountry.setBackground(Color.WHITE);
         add(txtCountry);
    
         lblallocatedrooms=new JLabel ("Allocated Room Number");
        lblallocatedrooms.setBounds(30, 310, 200, 30);
        lblallocatedrooms.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblallocatedrooms);
        
        
         txtallocatedrooms =new Choice();
         
         try{
             Conn conn=new Conn();
             String query ="select * from room where availability ='Avaialble'";
            ResultSet rs= conn.s.executeQuery(query);
            while(rs.next()){
              txtallocatedrooms.add(rs.getString("roomnumber"));
            }
             
         }catch(Exception ev){
         ev.printStackTrace();
         }
         txtallocatedrooms.setBounds(230,310,180,30);
         txtallocatedrooms.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(txtallocatedrooms);
         
        lblcheckintime=new JLabel ("Check in Time");
        lblcheckintime.setBounds(30, 360, 150, 30);
        lblcheckintime.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcheckintime);
        
           Date date=new Date();
           
         txtcheckintime =new JLabel("" + date); //we can't convert date into string so we have to concate string with date
         txtcheckintime.setBounds(230,360,180,30);
         txtcheckintime.setFont(new Font("Tahoma",Font.PLAIN,12));
         add(txtcheckintime);
         
         lbldeposit=new JLabel ("Deposit");
        lbldeposit.setBounds(30, 410, 150, 30);
        lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbldeposit);
        
         txtdeposit =new JTextField();
         txtdeposit.setBounds(230,410,180,30);
         txtdeposit.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(txtdeposit);
    
         addcust=new JButton("Add Customer");
         addcust.setBounds(60,470,150,30);
         addcust.setBackground(Color.BLACK);
         addcust.setForeground(Color.WHITE);
         addcust.addActionListener(this);
         add(addcust);
         
         back=new JButton("Back");
         back.setBounds(250,470,150,30);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
          back.addActionListener(this);
         add(back);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
         Image i2=i1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         image=new JLabel(i3);
         image.setBounds(430,40,400,450);
         add(image);
         
        
    }
    
    @Override
        public void actionPerformed(ActionEvent e)
        {
        if(e.getSource() == addcust){
        
            String id= (String)txtid.getSelectedItem();
            String name= txtname.getText();
            String number= txtnum.getText();
            String gender=null;
            
            if(male.isSelected()){
              gender="Male";
            }else{
              gender= "Female";
            }
            
            String country=txtCountry.getText();
            String allocatedrooms=txtallocatedrooms.getSelectedItem();
            String checkintime=txtcheckintime.getText();
            String deposit=txtdeposit.getText();
            
            try{
                String query="insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"','"+allocatedrooms+"', '"+checkintime+"', '"+deposit+"')";
                String query2="update room set availability = 'Occupied' where roomnumber= '"+allocatedrooms+"'";
                
                Conn conn=new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeLargeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added succeccfully");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception eve){
            eve.printStackTrace();
            }
            
        }else if (e.getSource() == back){
         setVisible(false);
         new Reception();
        }
        }
    
    
    
    
    public static void main(String[]args){
    
    new AddCustomer();
    }
    
}
