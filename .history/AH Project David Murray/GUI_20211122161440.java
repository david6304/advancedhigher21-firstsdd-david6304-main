import java.awt.Color;
import java.awt.*;

import javax.swing.*;

public class GUI {
    public static void createGUI() {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.getContentPane().setBackground(Color.decode("#209222"));
        JLabel label = new JLabel("Test Label");
        JButton button = new JButton("Test Button");
        frame.add(label);
        frame.add(button);
        frame.setLayout(new LayoutManager());
    }
}