import java.awt.Color;

import javax.swing.*;

public class cardGUI {
    public static void createGUI() {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.getContentPane().setBackground(Color.decode("#209222"));
        JLabel label = new JLabel("Test Label");
        JButton button = new JButton("Test Button");
        frame.add(label);
        frame.add(button);
    }
}