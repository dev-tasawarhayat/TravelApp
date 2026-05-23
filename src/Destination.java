import java.awt.*;
import javax.swing.*;

public class Destination extends JFrame implements Runnable {

    JLabel  l2, l3, l4, l5, l6, l7, l8;
    JLabel caption;
    Thread th;

    public void run() {
        try {

            l2.setVisible(true);
            caption.setText("Fairy Meadows ");
            l2.add(caption);
            Thread.sleep(2800);
            l2.setVisible(false);
            l3.setVisible(true);
            caption.setText("Hunza Valley ");
            l3.add(caption);
            l3.setVisible(true);
            Thread.sleep(2800);
            l3.setVisible(false);
            l4.setVisible(true);
            caption.setText("Kalam ");
            l4.add(caption);
            Thread.sleep(2800);
            l4.setVisible(false);
            l5.setVisible(true);
            caption.setText("Malam Jabba ");
            l5.add(caption);
            Thread.sleep(2800);
            l5.setVisible(false);
            l6.setVisible(true);
            caption.setText("Muree ");
            l6.add(caption);
            Thread.sleep(2800);
            l6.setVisible(false);
            l7.setVisible(true);
            caption.setText("Neelum Valley ");
            l7.add(caption);
            Thread.sleep(2800);
            l7.setVisible(false);
            l8.setVisible(true);
            caption.setText("Swat ");
            l8.add(caption);

            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Destination() {

        setBounds(500, 220, 900, 700);
        getContentPane().setBackground(new Color(220, 250, 250));
        
        th = new Thread(this);
    
        caption = new JLabel();
        caption.setBounds(50, 550, 1000, 70);
        caption.setForeground(Color.BLACK);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(caption);

//1      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fairymeadowscottages.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 700);
        add(l2);

        setLayout(null);
//2
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/hunza-valley.jpg"));
        Image i5 = i4.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i4);
        l3.setBounds(0, 0, 900, 700);
        add(l3);
        l3.setVisible(false);
//3
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/kalam.jpg"));
        Image i8 = i7.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(0, 0, 900, 700);
        add(l4);
        l4.setVisible(false);
//4
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/malam-jabba.jpg"));
        Image i11 = i10.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(0, 0, 900, 700);
        add(l5);
        l5.setVisible(false);
//5
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/murree.jpg"));
        Image i14 = i13.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 900, 700);
        add(l6);
        l6.setVisible(false);
//6
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/Neeulm_Valley_AJK.jpg"));
        Image i17 = i16.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        l7 = new JLabel(i18);
        l7.setBounds(0, 0, 900, 700);
        add(l7);
        l7.setVisible(false);
//7
        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/Swat.jpg"));
        Image i20 = i19.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(i20);
        l8 = new JLabel(i21);
        l8.setBounds(0, 0, 900, 700);
        add(l8);
        l8.setVisible(false);

        th.start();
        setVisible(true);

    }

    public static void main(String args[]) {
        new Destination();

    }

}