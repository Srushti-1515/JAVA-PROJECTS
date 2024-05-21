 import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
 import java.util.Calendar;
 class DigitalC extends JFrame
 {
  JLabel label1, label2;
  SimpleDateFormat time, day;
  DigitalC(String fname)
  {
   super(fname);
  }
  DigitalC()
  {

  }
  void setComponents()
  {
    label1 =new JLabel();
    label2=new JLabel();
    label1.setFont(new Font ("Verdana", Font.BOLD,50));
    label2.setFont(new Font ("Verdana", Font.BOLD,50));
    Color color=Color.RED;
    Color color2=color.brighter();
    label1.setBackground(Color.BLACK);
    label1.setForeground(color2);
    label1.setOpaque(true);
    label2.setBackground(Color.BLACK);
    label2.setForeground(color2);
    label2.setOpaque(true);

   
    setLayout(null);
    add(label1);
    add(label2);
    label1.setBounds(40,150,400,80);
    label2.setBounds(40,250,400,80);

    time=new SimpleDateFormat("hh:mm:ss a");
    String time1=time.format(Calendar.getInstance().getTime());
    label1.setText(time1);

    day=new SimpleDateFormat("EE:MM:YYYY");
    String dayy=day.format(Calendar.getInstance().getTime());
    label2.setText(dayy);

    while (true) {
      time1=time.format(Calendar.getInstance().getTime());
      label1.setText(time1);
   
      dayy=day.format(Calendar.getInstance().getTime());
      label2.setText(dayy);
      try{
      Thread.sleep(1000);
      }catch(Exception e1){
    
      }
    }

    
  }

  public static void main(String[] args) {
    DigitalC frame=new DigitalC("Digital CLock");
    frame.setVisible(true);
    frame.setSize(500,500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setComponents();
    

  }

  
}
