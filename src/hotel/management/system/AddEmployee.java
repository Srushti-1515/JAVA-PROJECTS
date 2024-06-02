
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JLabel name, age, gender, job, salary, phone, email, adhar ,image;
    JTextField ename, eage, esalary, ephone, eemail, eadhar;
    JRadioButton male, female;
    JComboBox subjob;
    JButton submit;
    
   
    AddEmployee(){
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         setBounds(330,200,850,540);
         setVisible(true);
        
        name=new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(name);
        
        ename=new JTextField();
        ename.setBounds(200, 30, 150, 30);
        add(ename);
        
        age=new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(age);
        
        eage=new JTextField();
        eage.setBounds(200, 80, 150, 30);
        add(eage);
        
        gender=new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(200, 130, 70, 30);
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(Color.WHITE);
        add(male);  
        
        female=new JRadioButton("Female");
        female.setBounds(280, 130, 70, 30);
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup bg=new ButtonGroup();  //at a time only one readio button will choose
        bg.add(male);
        bg.add(female);
        
        job=new JLabel("JOB");
        job.setBounds(60,180,150,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(job);
        
        String str[]= {" ","Manager", "Accountant","Front Desk Clerks", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress"};
        subjob=new JComboBox(str);
        subjob.setBounds(200,180,150,30);
        subjob.setBackground(Color.WHITE);
        add(subjob);
        
        
        salary=new JLabel("Salary");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(salary);
        
        esalary=new JTextField();
        esalary.setBounds(200, 230, 150, 30);
        add(esalary);
        
        phone=new JLabel("Phone");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(phone);
        
        ephone=new JTextField();
        ephone.setBounds(200, 280, 150, 30);
        add(ephone);
        
        email=new JLabel("Email");
        email.setBounds(60,330,120,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(email);
        
        eemail=new JTextField();
        eemail.setBounds(200, 330, 150, 30);
        add(eemail);
        
        adhar=new JLabel("Adhar");
        adhar.setBounds(60,380,120,30);
        adhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(adhar);
        
        eadhar=new JTextField();
        eadhar.setBounds(200, 380, 150, 30);
        add(eadhar);
        
        
        submit=new JButton("SUBMIT");
        submit.setBounds(200,450,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);  //we can not pass Image class to JLabel directly so used reference variable instead
        image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
    }   
    
    @Override
        public void actionPerformed(ActionEvent e){
        
        String name= ename.getText();
        String age= eage.getText();
        String salary= esalary.getText();
        String email= eemail.getText();
        String phone= ephone.getText();
        String adhar= eadhar.getText();
        
        String gender=null;
        
        if (name.equals("")){
         JOptionPane.showMessageDialog(null, "Name should not be empty");
          return;
        }
        
//        if (email.equals("") && contains("@") && contains("com")){
//        JOptionPane.showMessageDialog(null, "Email should not be empty");
//        }
        
        
        if(male.isSelected()){
           gender="Male";
        }else if(female.isSelected()){
           gender="Female";
        }
        
        String job= (String) subjob.getSelectedItem();
        
        try {
        Conn conn= new Conn();
        
        String query="insert into employee values ('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"','"+adhar+"')";
        
        conn.s.executeUpdate(query);
        
           JOptionPane.showMessageDialog(null, "Employee added successfully");
           setVisible(false);
           
        
        }catch (Exception e1){
        e1.printStackTrace();
        }
        
        }
        
    
    
    
    public static void main(String[]args){
    new AddEmployee();
    }
    
}
