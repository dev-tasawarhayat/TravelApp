import java.awt.Desktop;
import java.net.URI;

public class OpenSite {
    public static void main(String[] args) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.jazzcash.com.pk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}