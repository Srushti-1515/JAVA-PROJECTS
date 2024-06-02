/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem  extends JFrame implements ActionListener{

    
    HotelManagementSystem() {
     setSize(1366,565);  //width,height
     setLocation(100,100);  //location:left(x)-location:top(y) location with respect to the Screen
     setLayout(null); //default-layout is border-layout
     
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
     JLabel image=new JLabel(i1);
     image.setBounds(0,0,1366,565);   //location:x, loaction:y,width,height; location with respect to the frame(Combination of setsixze and setlocation)
     add(image);
    
     JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
     text.setBounds(20,430,600,40);
     text.setForeground(Color.WHITE);
     text.setFont(new Font("serif",Font.PLAIN,40));
     image.add(text);
     
     JButton next=new JButton("Next");
     next.setBounds(1150,450,150,50);
     next.setForeground(Color.magenta);
     next.addActionListener(this);
     next.setFont(new Font("serif",Font.PLAIN,30));
     next.setBackground(Color.WHITE); 
     image.add(next);
     
     setVisible(true);
      
     while(true){
         text.setVisible(false);
     try{
         Thread.sleep(500);
     
     }catch(Exception e){
     e.printStackTrace();
     }
        text.setVisible(true);
        try{
         Thread.sleep(500);
     
     }catch(Exception e){
     e.printStackTrace();
     }
     }  
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }
    
}
