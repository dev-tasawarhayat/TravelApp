import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewCustomer extends JFrame implements ActionListener {

    JButton back;

    ViewCustomer(String username) {
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("View Customer Details");

//Label:
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25); 
        add(lblusername);

        JLabel labelusername = new JLabel(); //to create a label to display the username of the customer whose details are being viewed
        labelusername.setBounds(220, 50, 150, 25);  
        add(labelusername);

//ID:
        JLabel lblID = new JLabel("ID");
        lblID.setBounds(30, 110, 150, 25);
        add(lblID);
        JLabel labelID = new JLabel(); //to create a label to display the ID of the customer whose details are being viewed
        labelID.setBounds(220, 110, 150, 25);
        add(labelID);

//Number:
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 170, 150, 25);
        add(lblNumber);
        JLabel labelNumber = new JLabel(); //to create a label to display the number of the customer whose details are being viewed
        labelNumber.setBounds(220, 170, 150, 25);
        add(labelNumber);

//Name:
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 230, 150, 25);
        add(lblName);
        JLabel labelName = new JLabel(); //to create a label to display the name of the customer whose details are being viewed
        labelName.setBounds(220, 230, 150, 25);
        add(labelName);

//Gender:
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 290, 150, 25);
        add(lblGender);
        JLabel labelGender = new JLabel(); //to create a label to display the gender of the customer whose details are being viewed
        labelGender.setBounds(220, 290, 150, 25);
        add(labelGender);

//Country:
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(500, 50, 150, 25);
        add(lblCountry);
        JLabel labelCountry = new JLabel(); //to create a label to display the country of the customer whose details are being viewed
        labelCountry.setBounds(650, 50, 150, 25);
        add(labelCountry);

//Address:
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(500, 110, 150, 25);
        add(lblAddress);
        JLabel labelAddress = new JLabel(); //to create a label to display the address of the customer whose details are being viewed
        labelAddress.setBounds(650, 110, 150, 25);
        add(labelAddress);

//Email:
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(500, 170, 150, 25);
        add(lblEmail);
        JLabel labelEmail = new JLabel(); //to create a label to display the email of the customer whose details are being viewed
        labelEmail.setBounds(650, 170, 150, 25);
        add(labelEmail);

//Phone:
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(500, 230, 150, 25);
        add(lblPhone);
        JLabel labelPhone = new JLabel(); //to create a label to display the phone number of the customer whose details are being viewed
        labelPhone.setBounds(650, 230, 150, 25);
        add(labelPhone);

//back button:
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this); //to add an action listener to the back button to handle button clicks and close the view customer screen when the button is clicked
        add(back);

//Image:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg")); //to load an image from the specified path to be displayed on the view customer screen
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);   
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg")); //to load an image from the specified path to be displayed on the view customer screen
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);   
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);



         try {
             Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
             ResultSet rs =c.s.executeQuery("select * from customer where username = '" + username + "'"); //to execute a SQL query to retrieve the account details of the currently logged in user from the database
             while (rs.next()) {
                 labelusername.setText(rs.getString("username")); //to set the text of the labelusername to the username retrieved from the database
                 labelName.setText(rs.getString("name")); //to set the text of the labelName to the name retrieved from the database
                 labelID.setText(rs.getString("id")); //to set the text of the labelID to the ID retrieved from the database
                 labelNumber.setText(rs.getString("number")); //to set the text of the labelNumber to the number retrieved from the database
                 labelGender.setText(rs.getString("gender")); //to set the text of the labelGender to the gender retrieved from the database
                 labelCountry.setText(rs.getString("country")); //to set the text of the labelCountry to the country retrieved from the database
                 labelAddress.setText(rs.getString("address")); //to set the text of the labelAddress to the address retrieved from the database
                 labelEmail.setText(rs.getString("email")); //to set the text of the labelEmail to the email retrieved from the database
                 labelPhone.setText(rs.getString("phone")); //to set the text of the labelPhone to the phone number retrieved from the database
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
        new ViewCustomer(""); //to create a new instance of the ViewCustomer class to display the view customer screen when the application is run
    }
    
}
 