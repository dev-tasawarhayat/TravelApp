import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class BookHotel extends JFrame implements ActionListener{

    Choice chotel , cac, cfood;
    String username;
    JTextField tfpersons,tfdays;
    JLabel labelUsername,labelac,labelfood,labelphone,labeltotal,labelid,labelnumber;
    JButton checkprice,bookpackage,back;

    BookHotel(String Username) {
        this.username = Username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

//Labels:
        JLabel text = new JLabel("BOOK HOTEL");
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


//Hotel:
        JLabel lbhotel = new JLabel("Select Hotel");
        lbhotel .setBounds(40, 110, 150, 20);   
        lbhotel .setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbhotel);
            chotel = new Choice();
            chotel.setBounds(250,110,200,20);
            add(chotel);

        try {
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }


//Total Persons:

        JLabel lblPerson = new JLabel("Total Persons");
        lblPerson.setBounds(40, 150, 150, 20);  
        lblPerson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPerson);
        tfpersons = new JTextField();
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);

//No of Days:
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40, 190, 150, 20);  
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldays);
        tfdays = new JTextField();
        tfdays.setBounds(250,190,200,25);
        add(tfdays);

//AC:
        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblac.setBounds(40,230,150,20);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,30);
        add(cac);

        

//Food:
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfood.setBounds(40,270,150,20);
        add(lblfood);
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);

//ID:
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setBounds(40,310,150,20);
        add(lblid);

        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelid.setBounds(250,310,200,20);
        add(labelid);

//Number:        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,350,150,20);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelnumber.setBounds(250,350,200,20);
        add(labelnumber);

//Phone:
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setBounds(40,390,150,20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelphone.setBounds(250,390,200,20);
        add(labelphone);



//Total Price:

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 430, 150, 25); 
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));   
        add(lbltotal);
        labeltotal = new JLabel();
        labeltotal.setBounds(250, 430, 150, 25);    
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
        checkprice.setBounds(60,480,140,30);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(220,480,140,30);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(380,480,140,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkprice){
            try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());

                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();

                if(persons * days > 0){
                    int total = 0;
                    total += acselected.equals("AC") ? ac: 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    total += cost;
                    total = total * persons * days;
                    labeltotal.setText("Rs "+total);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
        else if(ae.getSource() == bookpackage){

            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookhotel values('"+labelUsername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
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
        new BookHotel("");
    }
}