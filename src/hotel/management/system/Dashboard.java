
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame  implements ActionListener{
    
    Dashboard(){
        setBounds(0,0,1550,1000);
                setVisible(true);
                setLayout(null);
    
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
                Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
                ImageIcon i3=new ImageIcon(i2);
                JLabel img =new JLabel(i3);
                img.setBounds(0,0,1550,1000);
                add(img);
                
                JLabel text =new JLabel("THE TAJ GROUPS WELCOMES YOU");
                text.setBounds(350, 30, 800, 80);
                text.setFont(new Font("Tahoma",Font.PLAIN,50));
                text.setForeground(Color.WHITE);
                img.add(text);
                
                
                JMenuBar mb=new JMenuBar();
                mb.setBounds(0,0,1550,30);
                img.add(mb);
                
                JMenu hotel=new JMenu("HOTEL MANAGEMENT");
                hotel.setForeground(Color.red);
                mb.add(hotel);
                
                JMenuItem reception =new JMenuItem("RECEPTION");
                reception.addActionListener(this);
                hotel.add(reception);
                
             
                
                JMenu admin=new JMenu("ADMIN");
                admin.setForeground(Color.blue);
                mb.add(admin);
                
                JMenuItem addemploye =new JMenuItem("ADD EMPLOYEE");
                addemploye.addActionListener(this);
                admin.add(addemploye);
                
                JMenuItem addrooms =new JMenuItem("ADD ROOMS");
                addrooms.addActionListener(this);
                admin.add(addrooms);
                
                JMenuItem adddrivers =new JMenuItem("ADD DRIVERS");
                adddrivers.addActionListener(this);
                admin.add(adddrivers);
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    
        if(e.getActionCommand().equals("ADD EMPLOYEE")){
        new AddEmployee();
        }else if(e.getActionCommand().equals("ADD ROOMS")){
        new AddRooms();
        }else if(e.getActionCommand().equals("ADD DRIVERS")){
        new AddDriver();
        }else if(e.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
        
        
    }
    public static void main(String[]args)
    {
    
    new Dashboard();
    }
}
