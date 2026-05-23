import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;

    ViewBookedHotel(String username) {
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Booked Hotel Details");


        JLabel text = new JLabel("View Booked Hotel Details");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);

//Label:
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25); 
        add(lblusername);

        JLabel labelusername = new JLabel(); //to create a label to display the username of the customer whose details are being viewed
        labelusername.setBounds(220, 50, 150, 25);  
        add(labelusername);

//Hotel:
        JLabel lblpackage = new JLabel("Hotel Name");
        lblpackage.setBounds(30, 90, 150, 25);
        add(lblpackage);
        JLabel labelpackage = new JLabel(); //to create a label to display the ID of the customer whose details are being viewed
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);
        
//Persons:
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);
        JLabel labelpersons = new JLabel(); //to create a label to display the name of the customer whose details are being viewed
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);

//Days:
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);
        JLabel labeldays = new JLabel(); //to create a label to display the name of the customer whose details are being viewed
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);
//AC / Non-AC:
        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);
        JLabel labelac = new JLabel(); //to create a label to display the name of the customer whose details are being viewed
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);
//Food:
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);
        JLabel labelfood = new JLabel(); //to create a label to display the name of the customer whose details are being viewed
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);

//ID:
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);
        JLabel labelid = new JLabel(); //to create a label to display the name of the customer whose details are being viewed
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);   

//Number:

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 330, 150, 25);
        add(lblNumber);
        JLabel labelNumber = new JLabel(); //to create a label to display the number of the customer whose details are being viewed
        labelNumber.setBounds(220, 330, 150, 25);
        add(labelNumber);


//Phone:
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 370, 150, 25);
        add(lblPhone);
        JLabel labelPhone = new JLabel(); //to create a label to display the phone number of the customer whose details are being viewed
        labelPhone.setBounds(220, 370, 150, 25);
        add(labelPhone);

//Total:
        JLabel lbltotal = new JLabel("Total Cost");
        lbltotal.setBounds(30, 410, 150, 25);
        add(lbltotal);
        JLabel labeltotal = new JLabel(); //to create a label to display the phone number of the customer whose details are being viewed
        labeltotal.setBounds(220, 410, 150, 25);
        add(labeltotal);


//back button:
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 460, 100, 25);
        back.addActionListener(this); //to add an action listener to the back button to handle button clicks and close the view customer screen when the button is clicked
        add(back);

//Image:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg")); //to load an image from the specified path to be displayed on the view customer screen
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);   
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);




         try {
             Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
             ResultSet rs =c.s.executeQuery("select * from bookhotel  where username = '" + username + "'"); //to execute a SQL query to retrieve the account details of the currently logged in user from the database
             while (rs.next()) {
                 labelusername.setText(rs.getString("username")); //to set the text of the labelusername to the username retrieved from the database
                 labelpackage.setText(rs.getString("name")); //to set the text of the labelusername to the username retrieved from the database
                 labelpersons.setText(rs.getString("persons")); //to set the text of the labelusername to the username retrieved from the database
                 labeldays.setText(rs.getString("days")); //to set the text of the labelusername to the username retrieved from the database
                 labelac.setText(rs.getString("ac")); //to set the text of the labelusername to the username retrieved from the database
                 labelfood.setText(rs.getString("food")); //to set the text of the labelusername to the username retrieved from the database
                 labelid.setText(rs.getString("id")); //to set the text of the labelID to the ID retrieved from the database
                 labelNumber.setText(rs.getString("number")); //to set the text of the labelNumber to the number retrieved from the database
                 labelPhone.setText(rs.getString("phone")); 
                 labeltotal.setText(rs.getString("total")); 
             }
         } catch (Exception e) {
             e.printStackTrace();
         }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    

    public static void main(String[] args) {
        new ViewBookedHotel(""); 
    }
    
}
 