import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class myJButton extends JButton implements ActionListener{
    private boolean pressed = false;

    //sets pressed to true when button is pressed
    public void actionPerformed(ActionEvent e) {
        
        this.pressed = true;
    }

    //sets pressed to false 
    public void setPressedFalse() {
        this.pressed = false;
    }

    //returns the value of pressed 
    public boolean isPressed() {
        return this.pressed;
    }
}
