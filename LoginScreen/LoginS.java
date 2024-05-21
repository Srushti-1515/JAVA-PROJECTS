import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class LoginS extends JFrame
{
  JLabel label1, label2, label3, label4, img;
  JTextField textfield;
  JPasswordField passfield;
  JButton button1, button2, button3;
  LoginS(String ftitle)
  {
    super(ftitle);
  }
  LoginS()
  {
  
  }

 void setComponents()
  {
    getContentPane().setBackground(Color.YELLOW);//

    Font font=new Font("Times New Roman", Font.BOLD,28);
    Font font1=new Font("Callibri", Font.BOLD,18);
    Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
    Cursor cursor2=new Cursor(Cursor.WAIT_CURSOR);
    Cursor cursor3=new Cursor(Cursor.CROSSHAIR_CURSOR);  //predefined variable so for call it we have to write classname.type of cursor
    
  
    label1=new JLabel("Java Learning Portal");
    label1.setFont(font);
    label1.setForeground(Color.red);
    
    
    label2=new JLabel("USERNAME");
    label2.setFont(font1);
    label2.setForeground(Color.blue); 


    label3=new JLabel("PASSWORD");
    label3.setFont(font1);
    label3.setForeground(Color.blue);
    label4=new JLabel();
    
    img=new JLabel();
    ImageIcon image=new ImageIcon("C:/Users/admin/OneDrive/Desktop/GitProjects/JAVA-PROJECTS/LoginScreen/Log.jpg");
    img.setIcon(image);
    //Dimension size = img.getPreferredSize();

    textfield=new JTextField();;
    passfield=new JPasswordField();
   

    button1=new JButton("Login");
    button1.setCursor(cursor2);
    button1.setBackground(Color.PINK);

    button2=new JButton("Autofill");
    button2.setCursor(cursor);
    button2.setBackground(Color.PINK);

    button3=new JButton("Add");
    button3.setCursor(cursor3);
    button3.setBackground(Color.MAGENTA);


    setLayout(null);

    img.setBounds(100,50,100,100);
    label1.setBounds(250,50,300,30);
    label2.setBounds(150,200,200,30);
    label3.setBounds(150,350,200,30);
    label4.setBounds(100,550,200,30);
    

    textfield.setBounds(350,200,200,30);
    passfield.setBounds(350,350,200,30);

    button1.setBounds(200,450,100,30);
    button2.setBounds(400,450,100,30);
    button3.setBounds(500,550,100,30);

    
    add(label1);
    add(label2);
    add(label3);
    add(label4);
    add(img);

    add(textfield);
    add(passfield);

    add(button1);
    add(button2);
    add(button3);

    button1.addActionListener(new Login());
    button2.addActionListener(new Clear());
    button3.addActionListener(new Add());
    label2.addMouseListener(new MouseL());
  }
  class MouseL implements MouseListener
{
   public void mouseExited(MouseEvent e3)
   {
    label2.setForeground(Color.blue);
   }
   public void mouseClicked(MouseEvent e3)
   {

   }
   public void mouseEntered(MouseEvent e3)
   {
      label2.setForeground(Color.green);
   }
   public void mousePressed(MouseEvent e3)  
   {

   }
   public void mouseReleased(MouseEvent e3)
   {
    
   }
   
}
public static void main(String[] args)
{
  LoginS frame=new LoginS("Welcome to Java Lerning Portal");
  frame.setVisible(true);
  frame.setComponents();
  frame.setSize(800,800);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

}

class Login implements ActionListener
{
public void actionPerformed(ActionEvent e1)
{
  String log=textfield.getText();
  String pass=passfield.getText();
  if(log.equals("Srushti") && pass.equals("pass123"))
  {
    JOptionPane.showMessageDialog(null, "Login Successfully");
    label4.setText("Login Successful");
  }else{
    JOptionPane.showMessageDialog(null, "2 Attempts Left", "Alert",  
                                           JOptionPane.WARNING_MESSAGE);
    label4.setText("Login unsuccessful");
  }
}
}

class Clear implements ActionListener
{
  public void actionPerformed(ActionEvent e1)
  {
  textfield.setText("Srushti");
  passfield.setText("pass123");
  }
}

class Add implements ActionListener
{
  public void actionPerformed(ActionEvent e1)
  {
    try
    {
    int a=Integer.parseInt(textfield.getText());
    int b=Integer.parseInt(passfield.getText());
    int add=a+b;
    label4.setText("Addition is: "+add);
    }
    catch(Exception e2)
    {
      label4.setText("Please, Enter the Number only");
    }

  }
}
}