import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Rainbow {
    public static int wait = 20;

    public Rainbow() {

        int wait = 20;
        AtomicBoolean end = new AtomicBoolean(false);

        JFrame f = new JFrame("FEEL THE RAINBOW");

        f.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {

                end.set(true);
                f.dispose();

            }

        });
        f.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {

                keyPressWait(e.getKeyChar());

            }

            @Override
            public void keyTyped(KeyEvent e) {

                System.out.println(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {

                System.out.println(e);

            }
        });

        JPanel panel = new JPanel();

        f.add(panel);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        System.out.println("Test");

        Thread t = new Thread(() -> {

            rainbow(panel, end);

        });

        t.start();

    }

    public static void keyPressWait(char e) {

        if (e == '=' || e == '+') {

            wait += 5;

        }
        if (e == '-' || e == '_') {

            wait -= 5;

        }

        while (wait < 1) {

            wait++;

        }

        System.out.println(wait);

    }

    public static void rainbow(JPanel p, AtomicBoolean end) {

        int r = 255;
        int g = 0;
        int b = 0;

        while (true) {
            //Lock.moveMouse(new Point((int)screenSize.getWidth() / 2, (int)screenSize.getHeight() / 2));
            try {

                Thread.sleep(wait);

            } catch (Exception e) {

                System.out.println("oops");
                e.printStackTrace();

            }
            if(r > 0 && b == 0){
                r--;
                g++;
            }
            if(g > 0 && r == 0){
                g--;
                b++;
            }
            if(b > 0 && g == 0){
                r++;
                b--;
            }

            p.setBackground(new Color(r, g, b));

            if (end.get()) {

                Thread.currentThread().interrupt();
                break;

            }
        }
    }
}
