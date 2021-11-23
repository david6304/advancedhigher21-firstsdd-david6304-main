import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class UserInputGUI extends javax.swing.JFrame {

    /**
     * Creates new form UserInputGUI
     */
    public UserInputGUI(BlackJack game) {
        initComponents(game);
        setVisible(true);
        setNoPlayers(game);
        placePlayerBets(game);
        setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(BlackJack game) {

        PlayerInputLabel = new javax.swing.JLabel();
        PlayerInputTextField = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        EnterButton.setText("Enter");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(280, 280, 280)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PlayerInputTextField).addComponent(PlayerInputLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup().addGap(290, 290, 290).addComponent(EnterButton,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(283, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup().addGap(138, 138, 138)
                                        .addComponent(PlayerInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PlayerInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(143, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    //get number of players
    public void setNoPlayers(BlackJack game) {
        PlayerInputLabel.setText("Welcome to BlackJack, how many players are playing: (1-6)");
        EnterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.playerNo = Integer.parseInt(PlayerInputTextField.getText());
            }
        });
    }

    //get each players name
    public void setPlayerNames(BlackJack game) {
        game.createPlayerArray(game.playerNo);
        for (int i = 0; i < game.playerNo; i++) {
            PlayerInputLabel.setText("Enter Player " + (i+1) + "'s name: ");
            EnterButton.addActionListener(ActionaListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.getPlayersArray()[i] = new Player(PlayerInputTextField.getText(), 500);
                }
            });
            EnterButton.removeActionListener(l);
            
        }
        
    }

    //get each players bet
    public void placePlayerBets(BlackJack game) {
        for (Player p : game.getPlayersArray()) {
            PlayerInputLabel.setText(p.getName() + " enter your bet: (1-500)");
            EnterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    p.placeBet(Integer.parseInt(PlayerInputTextField.getText()));
                }
            });
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton EnterButton;
    private javax.swing.JLabel PlayerInputLabel;
    private javax.swing.JTextField PlayerInputTextField;
    // End of variables declaration
}
