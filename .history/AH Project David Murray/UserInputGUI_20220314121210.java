import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInputGUI extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form UserInputGUI
     * @throws InterruptedException
     */
    public UserInputGUI(BlackJack game) throws InterruptedException {
        //calling the methods in order 
        initComponents(game);
        setVisible(true);
        setNoPlayers(game);
        setPlayerNames(game);
        placePlayerBets(game);
        game.startGame();
        //set visible false so next jframe can be seen
        setVisible(false);
    }
    
    //not an ideal solution but global variables that are used to get strings that are entered when buttons are pressed
    String input = "0";
    boolean buttonPressed = false;

    //when a button is pressed the input variable is changed to the string in the above text field 
    @Override
    public void actionPerformed(ActionEvent e) {
        input = PlayerInputTextField.getText();
        buttonPressed = true;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(BlackJack game) {
        //creates the initial jframe elements and background colour
        getContentPane().setBackground(Color.decode("#2e6716"));
        PlayerInputLabel = new javax.swing.JLabel();
        PlayerInputTextField = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();
        EnterButton.addActionListener(this);

        //auto generated code using netbeans gui designer
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

    //get new input
    public void newInput() throws InterruptedException {
        while (true) {
            //sleep is to fix timing issues
            Thread.sleep(100);
            if (buttonPressed) {
                break;
            }
        }
        buttonPressed = false;
    }

    //get number of players
    public void setNoPlayers(BlackJack game) throws InterruptedException { 
        PlayerInputLabel.setText("Welcome to BlackJack, how many players are playing: (1-6)"); 
        newInput();
        while (game.playerNo < 1 || game.playerNo > 6) {
            try {
                game.playerNo = Math.round(Float.parseFloat(input));
            } catch (Exception e) {
                newInput();
            }
        }  
        game.createPlayerArray(game.playerNo);
    }

    //get each players name
    public void setPlayerNames(BlackJack game) throws InterruptedException {
        dbMethods db = new dbMethods();
        for (int i = 0; i < game.playerNo; i++) {
            PlayerInputLabel.setText("Enter Player " + (i+1) + "'s name: (8 char max)");
            newInput();
            boolean doubleNameCheck = false;
            if (i > 0) {
                doubleNameCheck = checkDuplicateNames(game);
            }
            while (input.length() < 1 || input.length() > 8 || doubleNameCheck) {
                newInput();
                if (i > 0) {
                    doubleNameCheck = checkDuplicateNames(game);
                }
            }  
            //check if player name exists in database
            if (db.getExistingPlayer(input) != 0) {
                existingPlayer(i, game, input, db.getExistingPlayer(input));
            }
            //otherwise create a new player and add them to database
            else {
                newPlayer(i, game, input);
                db.addPlayer(input);
            }
        } 
        db.closeStmt();
    }

    //checks if a player in the game already has a name that another player enters
    public boolean checkDuplicateNames(BlackJack game) {
        for (Player p : game.getPlayersArray()) {
            if (p != null && input.equals(p.getName())) {
                return true;
            }
        }
        return false;
    }

    //creates a player that has played before with their money
    public void existingPlayer(int i, BlackJack game, String name, int money) {
        while (game.getPlayersArray()[i] == null) {
            game.getPlayersArray()[i] = new Player(name, money);
        }
    }
    //creates a new player
    public void newPlayer(int i, BlackJack game, String name) {
        while (game.getPlayersArray()[i] == null) {
            game.getPlayersArray()[i] = new Player(name, 500);
        }
    }

    //get each players bet
    public void placePlayerBets(BlackJack game) throws InterruptedException {
        for (Player p : game.getPlayersArray()) {
            PlayerInputLabel.setText(p.getName() + " enter your bet: (0-" + Long.toString(p.getMoney()) + ")");
            newInput();
            while (p.getBet() < 0 || p.getBet() > p.getMoney()) {
                try {
                    p.placeBet(Math.round(Float.parseFloat(input)));
                } catch (Exception e) {
                    newInput();
                }
            }
            
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton EnterButton;
    private javax.swing.JLabel PlayerInputLabel;
    private javax.swing.JTextField PlayerInputTextField;
    // End of variables declaration
}
