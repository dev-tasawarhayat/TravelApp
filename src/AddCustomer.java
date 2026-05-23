import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername,labelName;
    JComboBox comboID;
    JRadioButton rbMale, rbFemale;
    JTextField tNumber, tfCountry, tfaddress,tfemail,tfphone;
    JButton add, back;

    AddCustomer(String username) {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        setTitle("Add Customer");
        getContentPane().setBackground(Color.WHITE);
      

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
        comboID = new JComboBox(new String[] {"Passport", "National Identity Card", "International Driving License", "Residence Permit"}); //to create a combo box with different ID types for the customer to select from
        comboID.setBounds(220, 90, 170, 25);
        comboID.setBackground(Color.WHITE);
        add(comboID);

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
        rbMale = new JRadioButton("Male");   
        rbMale.setBounds(220, 210, 70, 25);
        rbMale.setBackground(Color.WHITE);
        add(rbMale);
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(300, 210, 70, 25);
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);
        ButtonGroup bg = new ButtonGroup(); //to group the male and female radio buttons together so that only one can be selected at a time
        bg.add(rbMale);
        bg.add(rbFemale);

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
        add = new JButton("Add");
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
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg")); //to load an image from the specified path to be displayed on the add customer screen
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 400, 500);
        add(image);
        setVisible(true);

        try {
            Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
            ResultSet rs =c.s.executeQuery("select * from account where username = '" + username + "'"); //to execute a SQL query to retrieve the account details of the currently logged in user from the database
            while (rs.next()) {
                labelusername.setText(rs.getString("username")); //to set the text of the labelusername to the username retrieved from the database
                labelName.setText(rs.getString("name")); //to set the text of the labelName to the name retrieved from the database
            }
        } 
        catch (Exception e) {
                e.printStackTrace();
        }

    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText(); //to get the text of the labelusername to be used as the username for the new customer being added
            String id = (String) comboID.getSelectedItem(); //to get the selected item from the combo box to be used as the ID type for the new customer being added where String is typecasted to convert the selected item from the combo box to a String data type
            String number = tNumber.getText(); //to get the text entered in the number field to be used as the ID number for the new customer being added
            String name = labelName.getText(); //to get the text of the labelName to be used as the name for the new customer being added
            String gender = null; //to declare a variable to hold the gender of the new customer being added
            if (rbMale.isSelected()) { //to check if the male radio button is selected and set the gender variable to "Male"
                gender = "Male";
        }
                else{
                        gender = "Female"; //to set the gender variable to "Female" if the female radio button is selected
                }
                String country = tfCountry.getText(); //to get the text entered in the country field to be used as the country for the new customer being added
                String address = tfaddress.getText(); //to get the text entered in the address field to be used as the address for the new customer being added
                String email = tfemail.getText(); //to get the text entered in the email field to be used as the email for the new customer being added
                String phone = tfphone.getText(); //to get the text entered in the phone field to be used as the phone number for the new customer being added
                try {
                    Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
                    String query = "INSERT INTO customer VALUES('"+username+"', '"+id+"', '"+number+"', '"+name+"','"+gender+"', '"+country+"', '"+address+"', '"+email+"', '"+phone+"')"; //to create a SQL query to insert the details of the new customer being added into the customer table in the database
                    c.s.executeUpdate(query); //to execute the SQL query to insert the new customer details

                    JOptionPane.showMessageDialog(null, "Customer Details Added Successfully"); //to display a message dialog box to inform the user that the new customer has been added successfully
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
        new AddCustomer(""); //to create a new instance of the AddCustomer class to display the add customer screen when the application is run
    }
}
