import java.awt.*;
import javax.swing.*;


public class Loading extends JFrame implements Runnable {
    
    Thread t;
    JProgressBar progressBar;
    String username;


    public void run(){
        try{
            for (int i = 1; i <= 101; i++){
                int m = progressBar.getMaximum(); //to get the maximum value of the progress bar
                int v = progressBar.getValue(); //to get the current value of the progress bar
                if (v < m){
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 101;
                    setVisible(false);
                    new Dashboard(username); //to open the dashboard after the loading process is complete and pass the username to display a welcome message on the dashboard


                } //to increment the value of the progress bar by 1 until it reaches the maximum value
                Thread.sleep(50);
            }
        } catch (Exception e){
            e.printStackTrace(); //to print the stack trace of any exceptions that occur during the loading process
        }
    }

    Loading(String username ){
        this.username = username; //to assign the username passed as a parameter to the instance variable username

        t=new Thread(this); //to create a new thread to run the loading process in the background

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        


        JLabel l1 = new JLabel("Travel and Tourism Application");
        l1.setBounds(50, 20, 600, 40);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Raleway", Font.BOLD, 35));
        add(l1);

        //Bar:
        progressBar = new JProgressBar();
        progressBar.setBounds(150, 100, 300, 35);
        progressBar.setStringPainted(true);
        add(progressBar);

        //Loading:
        JLabel loading = new JLabel("Loading..."); 
        loading.setBounds(230, 130, 150, 30);
        loading.setForeground(Color.RED);  
        loading.setFont(new Font("RALEWAY", Font.BOLD, 18));
        add(loading); 

        JLabel lusername = new JLabel("Welcome"+" "+username);
        lusername.setBounds(20, 310, 400, 40);
        lusername.setForeground(Color.BLUE);  
        lusername.setFont(new Font("RALEWAY", Font.BOLD, 35));
        add(lusername); 

        t.start(); //to start the thread to run the loading process

        setVisible(true);

    }
    public static void main(String[] args) {
        new Loading(" "); //to create an instance of the Loading class and pass an empty string as the username to display a welcome message without a username
    }
}
 