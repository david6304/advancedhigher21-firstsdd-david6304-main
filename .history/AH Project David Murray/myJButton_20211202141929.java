import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class myJButton extends JButton implements ActionListener{
    private boolean pressed = false;

    public void actionPerformed(ActionEvent e) {
        this.pressed = true;
    }

    public void setPressedFalse() {
        this.pressed = false;
    }
}
