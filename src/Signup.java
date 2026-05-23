import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 


public class Signup extends JFrame implements ActionListener{
    JButton create, back;   //to declare the create and back buttons as instance variables so that they can be accessed in the actionPerformed method
    JTextField tUsername, tName, tPassword, tAnswer; //to declare the text fields for username, name, password, and answer as instance variables so that they can be accessed in the actionPerformed method
    JComboBox c1SecurityQuestion; //to declare the combo box for security questions as an instance variable so that it can be accessed in the actionPerformed method

    Signup(){
        setBounds(350, 200, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Signup");
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);


        //Image:
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png")); //to load the image from the resource folder
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);  //to scale the image to fit the panel
        ImageIcon i3 = new ImageIcon(i2);  //to convert the scaled image back to ImageIcon
        JLabel image = new JLabel(i3); //to set the scaled image as the icon of the label
        image.setBounds(580, 50 ,250, 250); //to position the image in the center of the panel
        add(image);

        //Username:
        JLabel l1lUsername = new JLabel("Username");
        l1lUsername.setBounds(50, 20, 125, 25);
        l1lUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        tUsername = new JTextField();
        tUsername.setBounds(190, 20, 180, 25);
        tUsername.setBorder(BorderFactory.createEmptyBorder());

        //Name:
        JLabel l2Name = new JLabel("Name");
        l2Name.setBounds(50, 60, 100, 25);
        l2Name.setFont(new Font("Tahoma", Font.BOLD, 14));
        tName = new JTextField();
        tName.setBounds(190, 60, 180, 25);
        tName.setBorder(BorderFactory.createEmptyBorder());

        //Password:
        JLabel l2Password = new JLabel("Password");
        l2Password.setBounds(50, 100, 100, 25);
        l2Password.setFont(new Font("Tahoma", Font.BOLD, 14));
        tPassword = new JTextField();
        tPassword.setBounds(190, 100, 180, 25);
        tPassword.setBorder(BorderFactory.createEmptyBorder());

        //Security Question:
        JLabel l3SecurityQuestion = new JLabel("Security Question");
        l3SecurityQuestion.setBounds(50, 140, 125, 25);
        l3SecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        String[] securityQuestions = {"Your Nickname?", "Your Lucky Number?", "Your Childhood Name?"};
        c1SecurityQuestion = new JComboBox(securityQuestions);
        c1SecurityQuestion.setBounds(190, 140, 180, 25);
        c1SecurityQuestion.setBackground(Color.WHITE);
        c1SecurityQuestion.setBorder(BorderFactory.createEmptyBorder());

        //Answer:
        JLabel l4Answer = new JLabel("Answer");
        l4Answer.setBounds(50, 180, 125, 25);
        l4Answer.setFont(new Font("Tahoma", Font.BOLD, 14));
        tAnswer = new JTextField();
        tAnswer.setBounds(190, 180, 180, 25);
        tAnswer.setBorder(BorderFactory.createEmptyBorder());

        //Buttons:
        create = new JButton("Create");                         //to create a create button
        create.setBounds(50, 250, 150, 30);             //to position the create button below the answer field
        create.setForeground(new Color(131, 193, 233));                 //to set the text color of the create button to the same color as the panel background
        create.setBackground(Color.WHITE);               //to set the background color of the create button
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBorder(BorderFactory.createEmptyBorder());          //to remove the border of the create
        create.addActionListener(this); //to add an action listener to the create button to handle the button click event

        back = new JButton("Back");                         //to create a back button
        back.setBounds(220, 250, 150, 30);             //to position the back button next to the create button
        back.setBackground(Color.WHITE);           //to set the background color of the back button
        back.setForeground(new Color(131, 193, 233));                 //to set the text color of the back button to the same color as the panel background
        back.setFont(new Font("Tahoma", Font.BOLD, 14));        
        back.setBorder(BorderFactory.createEmptyBorder());          //to remove the border of the back button   
        back.addActionListener(this); //to add an action listener to the back button to handle the button click event



        //adding components to the panel:
        p1.add(l1lUsername);
        p1.add(tUsername);
        p1.add(l2Name);
        p1.add(tName);
        p1.add(l2Password);
        p1.add(tPassword);
        p1.add(l3SecurityQuestion);
        p1.add(c1SecurityQuestion);
        p1.add(l4Answer);
        p1.add(tAnswer);
        p1.add(create);
        p1.add(back);



        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tUsername.getText(); //to get the text entered in the username field
            String name = tName.getText(); //to get the text entered in the name field
            String password = tPassword.getText(); //to get the text entered in the password field
            String securityQuestion = (String) c1SecurityQuestion.getSelectedItem(); //to get the selected item from the security question combo box
            String answer = tAnswer.getText(); //to get the text entered in the answer field



            String query = "INSERT INTO account(username, name, password, securityQuestion, answer) VALUES('"
        + username + "','"
        + name + "','"
        + password + "','"
        + securityQuestion + "','"
        + answer + "')";

          
            try {
                Conn c = new Conn(); //to create an instance of the Conn class to establish a connection to the database
                c.s.executeUpdate(query); //to execute the SQL query to insert the user details into the database
                JOptionPane.showMessageDialog(null, "Account Created Successfully"); //to show a message dialog indicating that the account has been created successfully
                setVisible(false); //to hide the signup screen
                new Login(); //to open the login screen
            } catch (Exception e) {
                e.printStackTrace(); //to print the stack trace of any exception that occurs while executing the SQL query
            }
    }
        else if(ae.getSource() == back){
            setVisible(false); //to hide the signup screen
            new Login(); //to open the login screen
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
    
}

