import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername,labelName;
    JComboBox comboID;
    JRadioButton rbMale, rbFemale;
    JTextField tNumber, tfCountry, tfaddress,tfemail,tfphone,tfid,tfgender;
    JButton add, back;

    UpdateCustomer(String username) {
        setBounds(500, 200, 850, 550);
        setLayout(null);
        setTitle("Add Customer");
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
      

//Username:
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);

        labelusername = new JLabel(""); //to create a label to display the username of the customer being added
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

//ID:
        JLabel lblID = new JLabel("ID");
        lblID.setBounds(30, 90, 150, 25);   
        add(lblID);
        tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 130, 150, 25);  
        add(lblNumber);
        tNumber = new JTextField();
        tNumber.setBounds(220, 130, 170, 25);
        add(tNumber);

//Name:
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 170, 150, 25);    
        add(lblName);


        labelName = new JLabel("");
        labelName.setBounds(220, 170, 170, 25);
        add(labelName);

//Gender:
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 210, 150, 25);
        add(lblGender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 170, 25);
        add(tfgender);

//Country:
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30, 250, 150, 25);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(220, 250, 170, 25);
        add(tfCountry);

//Address:
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 290, 150, 25); 
        add(lblAddress);
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 170, 25);
        add(tfaddress);

//Email:
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 330, 150, 25);
        add(lblEmail);
        tfemail = new JTextField();
        tfemail.setBounds(220, 330, 170, 25);   
        add(tfemail);

//Phone:
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 370, 150, 25);
        add(lblPhone);
        tfphone = new JTextField();
        tfphone.setBounds(220, 370, 170, 25);
        add(tfphone);


//BUttons:
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        
//Image:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png")); //to load an image from the specified path to be displayed on the add customer screen
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 450, 300);
        add(image);
        setVisible(true);

        try {
            Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
            ResultSet rs =c.s.executeQuery("select * from customer where username = '" + username + "'"); //to execute a SQL query to retrieve the account details of the currently logged in user from the database
            while (rs.next()) {
                labelusername.setText(rs.getString("username")); //to set the text of the labelusername to the username retrieved from the database
                labelName.setText(rs.getString("name")); //to set the text of the labelName to the name retrieved from the database
                tfid.setText(rs.getString("id"));
                tNumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfCountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
            }
        } 
        catch (Exception e) {
                e.printStackTrace();
        }

    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText(); 
            String name = labelName.getText(); 
            String id = tfid.getText();
            String number = tNumber.getText(); 
            String gender = tfgender.getText();
            String country = tfCountry.getText(); 
            String address = tfaddress.getText(); 
            String email = tfemail.getText(); 
            String phone = tfphone.getText(); 
                try {
                    Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
                   String query = "UPDATE customer SET "
                + "id = '"+id+"', "
                + "number = '"+number+"', "
                + "gender = '"+gender+"', "
                + "country = '"+country+"', "
                + "address = '"+address+"', "
                + "email = '"+email+"', "
                + "phone = '"+phone+"' "
                + "WHERE username = '"+username+"'";
                
                    c.s.executeUpdate(query); //to execute the SQL query to insert the new customer details

                    JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully"); //to display a message dialog box to inform the user that the new customer has been added successfully
                    setVisible(false);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
        }
        else{
                setVisible(false); //to hide the add customer screen when the back button is clicked
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer(""); //to create a new instance of the AddCustomer class to display the add customer screen when the application is run
    }
}
