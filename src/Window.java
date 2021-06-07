import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window {

    public static JFrame frame;
    public static JPanel panel;
    public static JLabel appText;
    public static JButton rainbowButton;

    /**
     * No-args constructor for <code>Window</code> class.
     */
    public Window() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // initialization
        frame = new JFrame();
        panel = new JPanel(new GridLayout(2, 1));

        appText = new JLabel("Press the Button for a Rainbow");
        appText.setHorizontalAlignment(JLabel.CENTER);
        rainbowButton = new JButton("Rainbows Await");
        rainbowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Rainbow();
            }
        });

        // panel setup
        panel.add(appText);
        panel.add(rainbowButton);

        // frame setup
        frame.add(panel);
        frame.setSize(300, 200); // setting the size of the window
        frame.setLocation((int) ((screenSize.getWidth() - frame.getWidth()) / 2), (int) ((screenSize.getHeight() - frame.getHeight()) / 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // application will exit on closure of the window
        frame.setVisible(true); // showing the window


    }

    public static void main(String[] args) {

        new Window();

    }

}