import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class myJButton extends JButton implements ActionListener{
    private boolean pressed = false;
    addactionlistener

    public void actionPerformed(ActionEvent e) {
        this.pressed = true;
        System.out.println("Button pressed");
    }

    public void setPressedFalse() {
        this.pressed = false;
    }

    public boolean isPressed() {
        return this.pressed;
    }
}
