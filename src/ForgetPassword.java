import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class ForgetPassword extends JFrame implements ActionListener {
    
    JTextField tUsername , tName, tfQuestion, tAnswer, tfPassword;
    JButton search, retrieve, back;
    ForgetPassword() {

        
        setBounds(350, 200, 900, 400);
        setTitle("Forget Password");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);   
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70 ,200, 200); 
        add(image);


        JPanel p1 = new JPanel(); //to create a new panel to hold the components of the forget password screen
        p1.setLayout(null); //to set the layout of the panel to null so that we can manually position the components
        p1.setBounds(30, 30, 500, 280); //to set the bounds of the panel to position it on the left side of the frame
        add(p1);

        //Username:
        JLabel l1lUsername = new JLabel("Username");
        l1lUsername.setBounds(40, 20, 100, 25);
        l1lUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l1lUsername);

        tUsername = new JTextField();
        tUsername.setBounds(220, 20, 150, 25);
        tUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tUsername);
// Search Button:
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);
//Name:
        JLabel l2name = new JLabel("Name");
        l2name.setBounds(40, 60, 100, 25);
        l2name.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l2name);

        tName = new JTextField();
        tName.setBounds(220, 60, 150, 25);
        tName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tName);

//Security Question:
        JLabel lQuestion = new JLabel("Security Question");
        lQuestion.setBounds(40, 100, 150, 25);
        lQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lQuestion);

        tfQuestion = new JTextField();
        tfQuestion.setBounds(220, 100, 150, 25);   
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion);
//Answer:
        JLabel lAnswer = new JLabel("Answer");
        lAnswer.setBounds(40, 140, 100, 25);
        lAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lAnswer);

        tAnswer = new JTextField();
        tAnswer.setBounds(220, 140, 150, 25);
        tAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tAnswer);
// Retrieve Button:
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY); 
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380, 140, 100, 25);  
        retrieve.addActionListener(this);
        p1.add(retrieve);

//Password:
        JLabel l3Password = new JLabel("Password");
        l3Password.setBounds(40, 180, 150, 25);
        l3Password.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(l3Password);

        tfPassword = new JTextField();
        tfPassword.setBounds(220, 180, 150, 25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

// Back Button:
        back = new JButton("Back");
        back.setBackground(Color.GRAY); 
        back.setForeground(Color.WHITE);
        back.setBounds(150, 240, 100, 25);
        back.addActionListener(this);
        p1.add(back);

        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            try {
                String username = tUsername.getText(); //to get the text entered in the username field
                Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
                String query = "select * from account where username = '"+username+"'"; //to create a SQL query to select all columns from the account table where the username matches the text entered in the username field
                ResultSet rs = c.s.executeQuery(query); //to execute the SQL query and store the result in a ResultSet object
                while (rs.next()) { //to iterate through the ResultSet object
                    tName.setText(rs.getString("name")); //to set the text of the name field to the value of the name column in the current row of the ResultSet
                    tfQuestion.setText(rs.getString("securityQuestion")); //to set the text of the security question field to the value of the securityQuestion column in the current row of the ResultSet

                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == retrieve){
            try {
                String username = tUsername.getText(); //to get the text entered in the username field
                String answer = tAnswer.getText(); //to get the text entered in the answer field
                Conn c = new Conn(); //to create a new instance of the Conn class to establish a connection to the database
                String query = "select * from account where username = '"+username+"' and answer = '"+answer+"'"; //to create a SQL query to select all columns from the account table where the username and answer match the text entered in the username and answer fields
                ResultSet rs = c.s.executeQuery(query); //to execute the SQL query and store
                while (rs.next()) { //to iterate through the ResultSet object
                    tfPassword.setText(rs.getString("password")); //to set the text of the password field to the value of the password column in the current row of the ResultSet
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
