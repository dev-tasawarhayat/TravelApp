import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, forgotPassword;
    JTextField tUsername, tPassword;

    Login() {
        setLayout(null);
        setTitle("Login");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350, 200);
        

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);  //to convert the scaled image back to ImageIcon
        JLabel image = new JLabel(i3); //to set the scaled image as the icon of the label
        image.setBounds(100, 120 ,200, 200); //to position the image in the center of the panel
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 340);
        add(p2);

        //Username:

        JLabel l1lUsername = new JLabel("Username");
        l1lUsername.setBounds(60, 30, 100, 25);
        l1lUsername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        tUsername = new JTextField();
        tUsername.setBounds(60, 60, 300, 30);
        tUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(l1lUsername);
        p2.add(tUsername);

        //Password:

        JLabel l2Password = new JLabel("Password");
        l2Password.setBounds(60, 100, 100, 25);
        l2Password.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        tPassword = new JTextField();
        tPassword.setBounds(60, 140, 300, 30);
        tPassword.setBorder(BorderFactory.createEmptyBorder());

        //Buttons:
        login = new JButton("Login");                         //to create a login button
        login.setBounds(60, 200, 130, 30);             //to position the login button below the password field
        login.setBackground(new Color(131, 193, 233));           //to set the background color of the login button
        login.setForeground(Color.WHITE);                              //to set the text color of the login button to white
        login.setBorder(BorderFactory.createEmptyBorder());          //to remove the border of the login button
        login.addActionListener(this);


        signup = new JButton("Signup");                        //to create a signup button
        signup.setBounds(230, 200, 130, 30);             //to position the signup button below the login button
        signup.setBackground(new Color(131, 193, 233));           //to set the background color of the signup button
        signup.setForeground(Color.WHITE);                              //to set the text color of the signup button to white
        signup.setBorder(BorderFactory.createEmptyBorder());           //to remove the border of the signup button
        signup.addActionListener(this);
        
        forgotPassword = new JButton("Forgot Password");          //to create a forgot password button
        forgotPassword.setBounds(130, 250, 130, 30);        //to position the forgot password button below the signup button
        forgotPassword.setBackground(new Color(131, 193, 233));      //to set the background color of the forgot password button
        forgotPassword.setForeground(Color.WHITE);                           //to set the text color of the forgot password button to white
        forgotPassword.setBorder(BorderFactory.createEmptyBorder());       //to remove the border of the forgot password button
        forgotPassword.addActionListener(this);

        JLabel tb = new JLabel("Trouble in Login...?");
        tb.setBounds(300, 250, 150, 20);
        tb.setForeground(Color.RED);

        p2.add(l2Password);
        p2.add(tPassword);

        p2.add(login);
        p2.add(signup);
        p2.add(forgotPassword);
        p2.add(tb);

        setVisible(true);   
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tUsername.getText(); //to get the text entered in the username field
                String password = tPassword.getText(); //to get the text entered in the password field

                String query = "select * from account where username = '"+username+"' and password = '"+password+"'"; //to create a SQL query to check if the entered username and password match with any record in the account table
                Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
                ResultSet rs = c.s.executeQuery(query); //to execute the SQL query and store the result in a ResultSet object
                if (rs.next()) { //to check if there is a record in the ResultSet object, which means the login credentials are correct
                    setVisible(false); //to hide the login screen if the login is successful
                    new Loading(username); //to open the loading screen after the login screen is hidden and pass the username to display a welcome message on the loading screen
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Login"); //to show a message dialog if the login credentials are incorrect
                }
            } 
            catch (Exception e) {
                e.printStackTrace(); //to print the stack trace of any exceptions that occur during the loading process
            }

        } 

        else if (ae.getSource() == signup) {
            setVisible(false); //to hide the login screen when the signup button is clicked
            new Signup(); //to open the signup screen after the login screen is hidden
        } 

        else if (ae.getSource() == forgotPassword) {
            setVisible(false); //to hide the login screen when the forgot password button is clicked
           new ForgetPassword(); //to open the forget password screen after the login screen is hidden
        }
    }

    public static void main(String[] args) {
       
        new Login(); //to create a new instance of the Login class to display the login screen when the application is run

    }
}
