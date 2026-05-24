import java.awt.*;
import javax.swing.*;


public class Splash extends JFrame implements Runnable {

    Thread thread;
    
    Splash(){
       //setTitle("Splash Screen");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to exit the application when the splash screen is closed
        setLocationRelativeTo(null);

        
        ImageIcon i1 = new ImageIcon(Splash.class.getResource("/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT); //to scale the image to fit the frame
        JLabel l1 = new JLabel(new ImageIcon(i2)); 
        ImageIcon i3 = new ImageIcon(i2); //to convert the scaled image back to ImageIcon
        l1.setIcon(i3); //to set the scaled image as the icon of the label
        add(l1);

        setVisible(true);
        thread = new Thread(this);
        thread.start();
    } 

    public void run(){
        try{
            Thread.sleep(7000); //to keep the splash screen visible for 7 seconds
            setVisible(false); //to hide the splash screen after 7 seconds
           new Login(); //to open the login screen after the splash screen is hidden
        }
        catch (Exception e){
        }
    }

    public static void main(String[] args) {
        Splash frame = new Splash();

        int x=1;

        for(int i =1; i<=500; x+=7, i+=6){
            frame.setLocation (750 - (x+i)/2, 400 - i/2); //to move the frame diagonally across the screen
            frame.setSize(x+i ,i); //to increase the size of the frame as it moves across the screen
            try{
                Thread.sleep(10);

            }
            catch (Exception e){

            }
        }
    }
}
