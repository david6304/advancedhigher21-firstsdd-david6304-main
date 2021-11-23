import java.awt.*;

import javax.swing.*;

public class GUI extends JFrame {
    JPanel panel = new JPanel();
    JButton button = new JButton("Test Button");
    JLabel label = new JLabel("Test Label");

    public GUI() {}
        panel.add(button);
        panel.add(label);
        add(panel);

        setSize(400, 400);
        setBackground(Color.BLACK);
        setTitle("Test Card Game GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}