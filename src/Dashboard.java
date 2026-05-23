import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

        String username; //to declare an instance variable to hold the username of the currently logged in user to display a welcome message on the dashboard
        JButton addPersonalDetails, viewDetails,updatePersonalDetails,checkPackage,bookPackage,viewPackage, viewHotels,dest,bookHotel,viewBookedHotel,b11,b12,b13,b14,deletePersonalDetails; //to declare a button for adding personal details as an instance variable so that it can be accessed in the actionPerformed method

    Dashboard(String username) { //to create a constructor for the Dashboard class that takes a username as a parameter to display a welcome message on the dashboard
        this.username = username; //to assign the username passed as a parameter to the instance variable username

        setExtendedState(JFrame.MAXIMIZED_BOTH); //to set the dashboard to full screen mode
        setTitle("Dashboard");
        setLayout(null); //to set the layout of the dashboard to null to allow absolute positioning of components

        JPanel p1 = new JPanel(); //to create a new panel to hold the components of the dashboard
        p1.setLayout(null); //to set the layout of the panel to null to allow absolute positioning of components
        p1.setBackground(new Color(0,0,102)); //to set the background color of the panel to a dark blue color using RGB values
        p1.setBounds(0, 0, 1600, 65); //to set the position and size of the panel at the top of the dashboard
        add(p1);

//Image:
        java.net.URL url = Dashboard.class.getResource("icons/dashboard.png");

        if(url != null)
        {
            ImageIcon i1 = new ImageIcon(url);
            Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel icon = new JLabel(i3);
            icon.setBounds(5, 0, 70, 70);
            p1.add(icon);
        }
        else{
              System.out.println("Image not found!");
        }
//Heading:
        JLabel heading = new JLabel("Dashboard"); //to create a JLabel for the dashboard heading
        heading.setBounds(80, 10, 300, 40); //to set the position and size of the heading on the dashboard
        p1.add(heading); //to add the heading to the dashboard
        heading.setFont(new Font("Tahoma", Font.BOLD, 35)); //to set the font of the dashboard heading to Tahoma, bold, and size 20
        heading.setForeground(Color.WHITE); //to set the color of the dashboard heading to white

//Panel 2:
        JPanel p2 = new JPanel(); //to create a new panel to hold the components of the dashboard
        p2.setLayout(null); //to set the layout of the panel to null to allow absolute positioning of components
        p2.setBackground(new Color(0,0,102)); //to set the background color of the panel to a dark blue color using RGB values
        p2.setBounds(0, 65, 300, 900); //to set the position and size of the panel on the left side of the dashboard
        add(p2); //to add the panel to the dashboard

//Buttons:
        addPersonalDetails = new JButton("Add Personal Details"); //to create a button for adding personal details
        addPersonalDetails.setBounds(0, 0, 300, 50); //to set the position and size of the button on the dashboard
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        addPersonalDetails.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        addPersonalDetails.setForeground(Color.WHITE); //to set the text color of the button to white
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60)); //to set the margin of the button to create space between the text and the left edge of the button
        addPersonalDetails.addActionListener(this); //to add an action listener to the button to handle button clicks
        p2.add(addPersonalDetails); //to add the button to the dashboard

        updatePersonalDetails = new JButton("Update Personal Details"); //to create a button for updating personal details
        updatePersonalDetails.setBounds(0, 50, 300, 50); //to set the position and size of the button on the dashboard
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        updatePersonalDetails.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        updatePersonalDetails.setForeground(Color.WHITE); //to set the text color of the button to white 
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30)); //to set the margin of the button to create space between the text and the left edge of the button
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails); //to add the button to the dashboard

        viewDetails = new JButton("View Details"); //to create a button for viewing details
        viewDetails.setBounds(0, 100, 300, 50); //to set the position and size of the button on the dashboard
        viewDetails.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        viewDetails.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        viewDetails.setForeground(Color.WHITE); //to set the text color of the button to white   
        viewDetails.setMargin(new Insets(0, 0, 0, 130)); //to set the margin of the button to create space between the text and the left edge of the button
        viewDetails.addActionListener(this);
        p2.add(viewDetails); //to add the button to the dashboardf

        deletePersonalDetails = new JButton("Delete Personal Details"); //to create a button for deleting personal details
        deletePersonalDetails.setBounds(0, 150, 300, 50); //to set the position and size of the button on the dashboard
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        deletePersonalDetails.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        deletePersonalDetails.setForeground(Color.WHITE); //to set the text color of the button to white
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 35)); //to set the margin of the button to create space between the text and the left edge of the button
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails); //to add the button to the dashboard

        checkPackage = new JButton("Check Package"); //to create a button for checking packages
        checkPackage.setBounds(0, 200, 300, 50); //to set the position and size of the button on the dashboard    
        checkPackage.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        checkPackage.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        checkPackage.setForeground(Color.WHITE); //to set the text color of the button to white
        checkPackage.setMargin(new Insets(0, 0, 0, 105)); //to set the margin of the button to create space between the text and the left edge of the button
        checkPackage.addActionListener(this);
        p2.add(checkPackage); //to add the button to the dashboard


        bookPackage = new JButton("Book Package"); //to create a button for booking packages
        bookPackage.setBounds(0, 250, 300, 50); //to set the position and size of the button on the dashboard
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        bookPackage.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        bookPackage.setForeground(Color.WHITE); //to set the text color of the button to white
        bookPackage.setMargin(new Insets(0, 0, 0, 115)); //to set the margin of the button to create space between the text and the left edge of the button
        bookPackage.addActionListener(this); //to add an action listener to the button to handle button clicks
        p2.add(bookPackage); //to add the button to the dashboard

        viewPackage = new JButton("View Package"); //to create a button for viewing packages
        viewPackage.setBounds(0, 300, 300, 50); //to set the position and size of the button on the dashboard
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        viewPackage.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        viewPackage.setForeground(Color.WHITE); //to set the text color of the button to white
        viewPackage.setMargin(new Insets(0, 0, 0, 115)); //to set the margin of the button to create space between the text and the left edge of the button
        viewPackage.addActionListener(this);
        p2.add(viewPackage); //to add the button to the dashboard

        viewHotels = new JButton("View Hotels"); //to create a button for viewing packages
        viewHotels.setBounds(0, 350, 300, 50); //to set the position and size of the button on the dashboard
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        viewHotels.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        viewHotels.setForeground(Color.WHITE); //to set the text color of the button to white   
        viewHotels.setMargin(new Insets(0, 0, 0, 130)); //to set the margin of the button to create space between the text and the left edge of the button
        viewHotels.addActionListener(this);
        p2.add(viewHotels); //to add the button tothe dashboard

        bookHotel = new JButton("Book Hotel"); //to create a button for booking hotels
        bookHotel.setBounds(0, 400, 300, 50); //to set the position and size of the button on the dashboard
        bookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        bookHotel.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        bookHotel.setForeground(Color.WHITE); //to set the text color of the button to white
        bookHotel.setMargin(new Insets(0, 0, 0, 140)); //to set the margin of the button to create space between the text and the left edge of the button
        bookHotel.addActionListener(this);
        p2.add(bookHotel); //to add the button to the dashboard

        viewBookedHotel = new JButton("View Booked Hotel"); //to create a button for viewing booked hotels
        viewBookedHotel.setBounds(0, 450, 300, 50); //to set the position and size of the button on the dashboard
        viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        viewBookedHotel.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        viewBookedHotel.setForeground(Color.WHITE); //to set the text color of the button to white
        viewBookedHotel.setMargin(new Insets(0, 0, 0, 70)); //to set the margin of the button to create space between the text and the left edge of the button
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel); //to add the button to the dashboard

        dest = new JButton("Destinations"); //to create a button for viewing destinations
        dest.setBounds(0, 500, 300, 50); //to set the position and size of the button on the dashboard
        dest.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        dest.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        dest.setForeground(Color.WHITE); //to set the text color of the button to white
        dest.setMargin(new Insets(0, 0, 0, 130)); //to set the margin of the button to create space between the text and the left edge of the button
        dest.addActionListener(this);
        p2.add(dest); //to add the button to the dashboard

        b11 = new JButton("Payment"); //to create a button for making payments
        b11.setBounds(0, 550, 300, 50); //to set the position and size of the button on the dashboard
        b11.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        b11.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        b11.setForeground(Color.WHITE); //to set the text color of the button to white
        b11.setMargin(new Insets(0, 0, 0, 160)); //to set the margin of the button to create space between the text and the left edge of the button
        b11.addActionListener(this);
        p2.add(b11); //to add the button to the dashboard

        b12 = new JButton("Calculator"); //to create a button for opening the calculator
        b12.setBounds(0, 600, 300, 50); //to set the position and size of the button on the dashboard
        b12.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        b12.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        b12.setForeground(Color.WHITE); //to set the text color of the button to white
        b12.setMargin(new Insets(0, 0, 0, 145)); //to set the margin of the button to create space between the text and the left edge of the button
        b12.addActionListener(this);
        p2.add(b12); //to add the button to the dashboard

        b13 = new JButton("Notepad"); //to create a button for opening the notepad
        b13.setBounds(0, 650, 300, 50); //to set the position and size of the button on the dashboard
        b13.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        b13.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        b13.setForeground(Color.WHITE); //to set the text color of the button to white
        b13.setMargin(new Insets(0, 0, 0, 160)); //to set the margin of the button to create space between the text and the left edge of the button
        b13.addActionListener(this);
        p2.add(b13); //to add the button to the dashboard

        b14 = new JButton("About"); //to create a button for viewing information about the application
        b14.setBounds(0, 700, 300, 50); //to set the position and size of the button on the dashboard
        b14.setFont(new Font("Tahoma", Font.PLAIN, 20)); //to set the font of the button to Tahoma, plain, and size 20
        b14.setBackground(new Color(0,0,102)); //to set the background color of the button to the same dark blue color as the panel
        b14.setForeground(Color.WHITE); //to set the text color of the button to white
        b14.setMargin(new Insets(0, 0, 0, 170)); //to set the margin of the button to create space between the text and the left edge of the button
        b14.addActionListener(this);
        p2.add(b14); //to add the button to the dashboard

//Image:

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg")); //to load the home image from the resources folder
        Image i5 = i4.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT); //to scale the image to fit the dashboard
        ImageIcon i6 = new ImageIcon(i5); //to create a new ImageIcon from the scaled image
        JLabel image = new JLabel(i6); //to create a JLabel to hold the image   
        image.setBounds(0, 0, 1600, 900); //to set the position and size of the image to cover the entire dashboard
        add(image); //to add the image to the dashboard

        JLabel text = new JLabel("Travel and Tourism Management System"); //to create a JLabel for the dashboard text
        text.setBounds(400, 70, 1200, 70); //to set the position and size of the text on the dashboard
        text.setFont(new Font("Raleway", Font.PLAIN, 55)); //to set the font of the dashboard text to Raleway, bold, and size 55
        text.setForeground(Color.WHITE); //to set the color of the dashboard text to white
        image.add(text); //to add the text to the image on the dashboard

        setVisible(true); 


    }

    public void actionPerformed(ActionEvent ae) { //to handle button clicks on the dashboard
        if (ae.getSource() == addPersonalDetails) { //to check if the addPersonalDetails button was clicked
            new AddCustomer(username); //to create a new instance of the AddCustomer class to open the add personal details screen and pass the username of the currently logged in user to display a welcome message on the add personal details screen
        }
        else if (ae.getSource() == viewDetails) { //to check if the viewDetails button was clicked
            new ViewCustomer(username); //to create a new instance of the ViewCustomer class to open the view customer details screen and pass the username of the currently logged in user to display a welcome message on the view customer details screen
        }
        else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        }
        else if(ae.getSource() == checkPackage){
            new CheckPackage();
        }
        else if(ae.getSource() == bookPackage){
            new BookPackage(username);
        }
        else if (ae.getSource() == viewPackage ) {
            new ViewPackage(username);
            
        }
        else if(ae.getSource() == viewHotels){
            new CheckHotels();
        }
        else if(ae.getSource() == dest){
            new Destination();
        }
        else if(ae.getSource() == bookHotel){
            new BookHotel(username);
        }
        else if(ae.getSource() == viewBookedHotel){
            new ViewBookedHotel(username);
        }
        else if (ae.getSource() == b11) {
            new Payment();
        }
        else if(ae.getSource() == b12){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b13){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }           
        }
        else if(ae.getSource() == b14){
            new About();
        }
        else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
        }
    }

    // public static void main(String[] args) {
    //     new Dashboard(""); //to create an instance of the Dashboard class to display the dashboard screen
    // }
    


}
