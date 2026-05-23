import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class BookPackage extends JFrame implements ActionListener{

    JComboBox comboBox;
    String username;
    JTextField tfpersons;
    JLabel labelUsername,labelid,labelnumber,labelphone,labeltotal;
    JButton checkprice,bookpackage,back;

    BookPackage(String Username) {
        this.username = Username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

//Labels:
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10, 200, 30 );
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);

//Username:
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 70, 100, 20);
        lblUsername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblUsername);
        labelUsername = new JLabel();
        labelUsername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelUsername.setBounds(250, 70, 200, 20);
        add(labelUsername);


//Packages:
        JLabel lbpackage = new JLabel("SELECT PACKAGE");
        lbpackage .setBounds(40, 110, 150, 20);   
        lbpackage .setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbpackage );
        comboBox = new JComboBox(new String[] {"GOLD PACKAGE","SILVER PACKAGE","BRONZE PACKAGE"});
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(250,110,150,20);
        add(comboBox);

//Total Persons:

        JLabel lblPerson = new JLabel("Total Persons");
        lblPerson.setBounds(40, 150, 150, 20);  
        lblPerson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPerson);
        tfpersons = new JTextField();
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);

//ID:
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setBounds(40,190,150,20);
        add(lblid);
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelid.setBounds(250,190,200,20);
        add(labelid);

//Number:
        JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setBounds(40, 230, 150, 25); 
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));   
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);    
        add(labelnumber);

//Phone:
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setBounds(40,270,150,20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelphone.setBounds(250,270,200,20);
        add(labelphone);

//Total Price:

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 310, 150, 25); 
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));   
        add(lbltotal);
        labeltotal = new JLabel();
        labeltotal.setBounds(250, 310, 150, 25);    
        add(labeltotal);


        try {
             Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
             ResultSet rs =c.s.executeQuery("select * from customer where username = '" + username + "'"); //to execute a SQL query to retrieve the account details of the currently logged in user from the database
             while (rs.next()) {
                labelUsername.setText(rs.getString("username")); //to set the text of the labelusername to the username retrieved from the database
                labelid.setText(rs.getString("id")); //to set the text of the labelID to the ID retrieved from the database
                labelnumber.setText(rs.getString("number")); //to set the text of the labelNumber to the number retrieved from the database
                labelphone.setText(rs.getString("phone")); //to set the text of the labelPhone to the phone number retrieved from the database
             }
         } catch (Exception e) {
             e.printStackTrace();
        }


        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkprice){
            String pack = (String) comboBox.getSelectedItem();
            int cost = 0;
            if(pack.equals("GOLD PACKAGE")){
                cost += 90000;
            }
            else if (pack.equals("SILVER PACKAGE")){
                cost += 70000;
            }
            else{
                cost += 50000;
            }

            int persons= Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labeltotal.setText("Rs " +cost);
        }
        else if(ae.getSource() == bookpackage){

            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookpackage values('"+labelUsername.getText()+"', '"+comboBox.getSelectedItem()+"', '"+tfpersons.getText()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");

                JOptionPane.showMessageDialog(null, "Pacakge Booked Successfully");
                setVisible(false);
            } 
            catch (Exception e) {
                e.printStackTrace();
            }


        }
        else{
            setVisible(false);;
        }
    }

    


    public static void main(String[] args) {
        new BookPackage("");
    }
}