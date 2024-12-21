
package hospital.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class HospitalManagementSystem  extends JFrame implements ActionListener{
   
        
        JLabel l1;
        JButton b1;
        
        public HospitalManagementSystem()  {
		
                setSize(1366,430);          // setContentPane(300,300,1366,390);   frame size
                setLayout(null);
                setLocation(100,250);

		l1 = new JLabel("");
                b1 = new JButton("Next");
                
                b1.setBackground(Color.BLUE);
                b1.setForeground(Color.WHITE);
		b1.setFont(new Font("serif",Font.PLAIN,18));
               
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                JLabel lid=new JLabel("HOSPITAL MANAGEMENT SYSTEM");
                lid.setBounds(30,300,1200,60);
                lid.setFont(new Font("serif",Font.PLAIN,50));
                lid.setForeground(Color.red);
                l1.add(lid);
                b1.setBounds(1170,325,150,50);
		l1.setBounds(0, 0, 1366, 390);
                
                l1.add(b1);
		add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                 while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(1000); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){}
                }
 }
        public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
  
    public static void main(String[] args) {
        new HospitalManagementSystem();
       
    }
    
}
