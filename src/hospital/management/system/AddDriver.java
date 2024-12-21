
package hospital.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class AddDriver extends JFrame implements ActionListener {
    
     private JPanel contentPane;
    private JTextField t1,t2,t3,t4, t5;
    private JComboBox comboBox, comboBox_1,comboBox_2;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }


    public AddDriver() {
        setBounds(400, 200, 1000, 500);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Add Drivers");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Name");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(60, 70, 120, 22);
	contentPane.add(l1);
        
        
        t1 = new JTextField();
	t1.setBounds(180, 70, 156, 20);
	contentPane.add(t1);
        

	JLabel l2 = new JLabel("Age");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(60, 110, 120, 22);
	contentPane.add(l2);
        
        t2 = new JTextField();
	t2.setBounds(180, 110, 156, 20);
	contentPane.add(t2);


	JLabel l3 = new JLabel("Gender");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(60, 150, 120, 22);
	contentPane.add(l3);
        
        comboBox = new JComboBox(new String[] { "Male", "Female" });
	comboBox.setBounds(180, 150, 154, 20);
	contentPane.add(comboBox);

	JLabel l4 = new JLabel("Ambulance Type");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(60, 190, 120, 22);
	contentPane.add(l4);
        
        comboBox_2 = new JComboBox(new String[] { "AC", "NON-AC" });
	comboBox_2.setBounds(180, 190, 154, 20);
	contentPane.add(comboBox_2);

        JLabel l5 = new JLabel("Ambulance No.");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(60, 230, 120, 22);
	contentPane.add(l5);


        t4 = new JTextField();
	t4.setBounds(180, 230, 156, 20);
	contentPane.add(t4);

	
        JLabel l6 = new JLabel("Available");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(60, 270, 120, 22);
	contentPane.add(l6);


        comboBox_1 = new JComboBox(new String[] { "Yes", "No" });
	comboBox_1.setBounds(180, 270, 154, 20);
	contentPane.add(comboBox_1);

        
        JLabel l7 = new JLabel("Location");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(60, 310, 120, 22);
	contentPane.add(l7);


        t5 = new JTextField();
	t5.setBounds(180, 310, 156, 20);
	contentPane.add(t5);
        
	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 380, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 380, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                Conn c = new Conn();
                String name = t1.getText();
                String age = t2.getText();
                String gender = (String)comboBox.getSelectedItem();
                String type = (String)comboBox_2.getSelectedItem();
                String number = t4.getText();
                String available = (String)comboBox_1.getSelectedItem();
                String location = t5.getText();
                String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+type+"', '"+number+"', '"+available+"','"+location+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
