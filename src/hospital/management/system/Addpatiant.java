package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Addpatiant extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField tfnumber, tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    JLabel checkintime;
    JButton add,back;
    Choice croom;
    Addpatiant(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel ("ADDMISSION FORM");
        text.setBounds(118, 11, 260, 53);
        text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(text);
        
        
        
        JLabel lblid = new JLabel ("ID");
        lblid.setBounds(35, 76, 200, 20);
        lblid.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lblid);
        
        String option[] ={"Voater-Id", "Passport", "Driver License"};
        comboid= new JComboBox(option);
        comboid.setBounds(271, 73, 150, 20);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        
        JLabel lblnum = new JLabel ("Number");
        lblnum.setBounds(35, 111, 200, 20);
        lblnum.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lblnum);
         
        tfnumber =new JTextField();
        tfnumber.setBounds(271, 111, 150, 20);
        add(tfnumber);
        
        
        JLabel lblname = new JLabel ("Name");
        lblname.setBounds(35, 151, 200, 20);
        lblname.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lblname);
         
        tfname =new JTextField();
        tfname.setBounds(271, 151, 150, 20);
        add(tfname);
        
        JLabel lblgender = new JLabel ("Gender");
        lblgender.setBounds(35, 191, 100, 20);
        lblgender.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lblgender);
         
        rmale = new JRadioButton("Male");
        rmale.setFont(new Font("Raleway", Font.BOLD, 14));
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(350, 191, 60, 12);
        add(rmale);
        
        
        rfemale = new JRadioButton("Female");
        rfemale.setFont(new Font("Raleway", Font.BOLD, 14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(271, 191, 100, 12);
        add(rfemale);
        
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rfemale);
        bg.add(rmale);
            
        
        JLabel lblcountry = new JLabel ("Country");
        lblcountry.setBounds(35, 231, 200, 20);
        lblcountry.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lblcountry);
         
        tfcountry =new JTextField();
        tfcountry.setBounds(271, 231, 150, 20);
        add(tfcountry);
        
        JLabel lblroom = new JLabel ("Room");
        lblroom.setBounds(35, 274, 200, 20);
        lblroom.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lblroom);
        
        croom =new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "select * from CABINE where available = 'Available'";
                    ResultSet rs=conn.s.executeQuery(query);
                    while(rs.next()){
                        croom.add(rs.getString("room"));
                    }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(271, 274, 150, 20);
        add(croom);
        
        JLabel lbltime = new JLabel ("Checked In");
        lbltime.setBounds(35, 316, 200, 20);
        lbltime.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lbltime);
        
        Date date = new Date();
                
        checkintime = new JLabel (""+date);
        checkintime.setBounds(271, 316, 150, 20);
        checkintime.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(checkintime);
        
        JLabel lbldeposit = new JLabel ("Deposit");
        lbldeposit.setBounds(35, 359, 200, 20);
        lbldeposit.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	add(lbldeposit);
         
        tfdeposit =new JTextField();
        tfdeposit.setBounds(271, 359, 150, 20);
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBounds(100, 430, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        
        back = new JButton("Back");
        back.setBounds(260, 430, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/patiant.jpg"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);
        
        
        setBounds(400, 200, 850, 550);
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==add){
            String id = (String)comboid.getSelectedItem();
            String number =  tfnumber.getText();
	    String name =  tfname.getText();
            String gender = null;
            if(rmale.isSelected()){ 
                  gender = "Male";
                        }
            else if(rfemale.isSelected()){ 
                 gender = "Female";
             }
	    String country =  tfcountry.getText();
	    String room =  croom.getSelectedItem();
            String time =  checkintime.getText();
            String deposit = tfdeposit.getText();
            try{
                String q1 = "insert into ADDMISSION values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String q2 = "update CABINE set available = 'Occupied' where room = '"+room+"'";
                
                Conn conn = new Conn();
                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                setVisible(false);
                new Reception();
                                
            }
            catch(Exception e){
                e.printStackTrace();
            }
                                
                                
                                
                                
        }
        else if(ae.getSource()==back){
            setVisible(false);
                new Reception();
        }
    }
    public static void main (String[] args){
        new Addpatiant();
    }
}