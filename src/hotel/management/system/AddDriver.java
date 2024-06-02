
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener {
    
    JLabel heading, name, age, gender,carcompany, carmodel, available, location, image;
    JButton adddriver, cancel;
    JTextField txtname, txtage, txtlocation;
    JComboBox txtgender, txtcarcompany, txtcarmodel, txtavailable ;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(330,200,850,540);
        setVisible(true);
        
        
        heading=new JLabel("Add Driver");
        heading.setBounds(150, 10, 120, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        name=new JLabel("NAME");
        name.setBounds(60,60,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(name);
        
        txtname=new JTextField();
        txtname.setBounds(200, 60, 150, 30);
        add(txtname);
        
        age=new JLabel("AGE");
        age.setBounds(60,110,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(age);
        
        txtage=new JTextField();
        txtage.setBounds(200, 110, 150, 30);
        add(txtage);
        
        gender=new JLabel("GENDER");
        gender.setBounds(60,160,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(gender);
        
        String genderoptions[] = {"", "Male", "Female" };
        txtgender=new JComboBox(genderoptions);
        txtgender.setBounds(200,160,150,30);
        txtgender.setBackground(Color.WHITE);
        add(txtgender);
        
        carcompany=new JLabel("Car Company");
        carcompany.setBounds(60,210,120,30);
        carcompany.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(carcompany);
        
        String carcompanyoptions[] = {"", "Toyoto", "Tata", "Honda", "Ford", "Vilkswagen","Hyundai",};
        txtcarcompany=new JComboBox(carcompanyoptions);
        txtcarcompany.setBounds(200,210,150,30);
        txtcarcompany.setBackground(Color.WHITE);
        add(txtcarcompany);
        
        carmodel=new JLabel("Car Model");
        carmodel.setBounds(60,260,120,30);
        carmodel.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(carmodel);
        
        
        String carmodeloptions[] = {"Toyoto Fortuner", "Toyoto Innovo Hycross", "Urban Cruiser Taisor", "Innovo Crysta", "Tata Taigor", "Tata Punch", "Tata Nexon", "Honda City", "Honda Jazz", "Ford Mastang", "Ford EcoSport", "Ford Figo",  "Hyundai Creta", "Hyundai Verna", "Hyundai vennue", "Volkswagen Tiguan", "Volkswagen Virtus", "Volkswagen Jetta"};
        txtcarmodel=new JComboBox(carmodeloptions);
        txtcarmodel.setBounds(200,260,150,30);
        txtcarmodel.setBackground(Color.WHITE);
        add(txtcarmodel);
        
        
        available=new JLabel("Available");
        available.setBounds(60,310,120,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(available);
        
        String availableoptions[] = {"", "Available", "Occupied" };
        txtavailable=new JComboBox(availableoptions);
        txtavailable.setBackground(Color.WHITE);
        txtavailable.setBounds(200,310,150,30);
        add(txtavailable);
        
        location=new JLabel("Location");
        location.setBounds(60,360,120,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(location);
        
        txtlocation=new JTextField();
        txtlocation.setBounds(200, 360, 150, 30);
        add(txtlocation);
        
    
        adddriver=new JButton("ADD DRIVER");
        adddriver.setBounds(80, 420, 120, 30);
        adddriver.setBackground(Color.BLACK);
        adddriver.setForeground(Color.WHITE);
        adddriver.addActionListener(this);
        add(adddriver);
        
        cancel=new JButton("CANCEL");
        cancel.setBounds(220, 420, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(420, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(380,50,420,350);
        add(image);
        
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
     if (e.getSource()==(adddriver)){
     
         String name=txtname.getText();
         String age=txtage.getText();  //for textfield
         String location=txtlocation.getText();
         String gender=(String)txtgender.getSelectedItem() ;
         String company_name=(String)txtcarcompany.getSelectedItem(); //for combobox
         String car_model=(String)txtcarmodel.getSelectedItem();
         String available=(String)txtavailable.getSelectedItem();
         
         try{
             
         Conn conn=new Conn();
         String str="insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company_name+"', '"+car_model+"', '"+available+"', '"+location+"')";
      
         conn.s.executeUpdate(str);
         
         JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
         
         setVisible(false);
         
         }catch(Exception e4){
         e4.printStackTrace();
         }
            
     }else {
     setVisible(false);
     }
        
    }

    
    
    public static void main (String[] args){
    
        new AddDriver();
    }
    
}
