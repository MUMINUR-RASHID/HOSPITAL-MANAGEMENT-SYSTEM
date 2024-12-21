
package hospital.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame {
     public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("HOSPITAL MANAGEMENT SYSTEM");
	
        setForeground(Color.CYAN);
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BG.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        JLabel AirlineManagementSystem = new JLabel("YOU ARE WELCOME TO OUR HOSPITAL");
	AirlineManagementSystem.setForeground(Color.RED);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
	AirlineManagementSystem.setBounds(400, 60, 1000, 85);
	NewLabel.add(AirlineManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("HOSPITAL MANAGEMENT");
        AirlineSystem.setForeground(Color.BLUE);
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("RECEPTION");
	AirlineSystem.add(FlightDetails);
        FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
		
	JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.RED);
	menuBar.add(AirlineSystemHello);
        
        JMenuItem FlightDetailshello1 = new JMenuItem("ADD DOCTORS");
	AirlineSystemHello.add(FlightDetailshello1);
        FlightDetailshello1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDoctors().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        
        JMenuItem FlightDetailshello4 = new JMenuItem("ADD NURSES");
	AirlineSystemHello.add(FlightDetailshello4);
        FlightDetailshello4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddNurses().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        
        JMenuItem FlightDetailshello15= new JMenuItem("ADD OFFICE STAFF");
	AirlineSystemHello.add(FlightDetailshello15);
        FlightDetailshello15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Addofficialstaff().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        
        JMenuItem FlightDetailshello6 = new JMenuItem("ADD OTHER STAFF");
	AirlineSystemHello.add(FlightDetailshello6);
        FlightDetailshello6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Addotherstaff().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        
        

        JMenuItem FlightDetailshello2 = new JMenuItem("ADD CABINE");
	AirlineSystemHello.add(FlightDetailshello2);
         
        FlightDetailshello2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Addcabine().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	
        
        
        
        JMenuItem FlightDetailshello3 = new JMenuItem("ADD DRIVERS");
	AirlineSystemHello.add(FlightDetailshello3);
        
       FlightDetailshello3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDriver().setVisible(true);
                }catch(Exception e ){}
            }
	});
		
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    
}
