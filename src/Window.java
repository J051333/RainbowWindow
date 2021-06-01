//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// how to create a window in java
public class Window {

    // we want to start off by creating our window field
    public static JFrame frame;
    // next we want some content for our window
    public static JPanel panel;
    public static JLabel appText;

    /**
     * No-args constructor for <code>Window</code> class.
     */
    public Window() {
        // initialization
        frame = new JFrame();
        panel = new JPanel(new GridLayout(2, 1));

        appText = new JLabel("Press the Button for a Rainbow");

        //panel.setBackground(Color.blue); // we get a blue window

        // panel setup
        panel.add(appText);

        // frame setup
        frame.add(panel);
        frame.setSize(100, 200); // setting the size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // application will exit on closure of the window
        frame.setVisible(true); // showing the window


    }

    public static void main(String[] args) {

        new Window();

    }

}