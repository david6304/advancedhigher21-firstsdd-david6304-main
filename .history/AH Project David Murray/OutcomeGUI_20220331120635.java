import java.awt.Color;

public class OutcomeGUI extends javax.swing.JFrame {

    /**
     * Creates new form OutcomeGUI
     * @throws InterruptedException
     */
    public OutcomeGUI(BlackJack game) throws InterruptedException {
        initComponents(game);
        setVisible(true);
        playAgainButton.addActionListener(playAgainButton);
        mostMoneyButton.addActionListener(mostMoneyButton);
        Card c = new Card(Suit.Hearts, Rank.Ten);
        Card a = new Card(Suit.Hearts, Rank.Ace);
        Card c2 = new Card(Suit.Hearts, Rank.Eight);
        Card c3 = new Card(Suit.Hearts, Rank.Seven);
        game.dealer.addToHand(c);
        game.dealer.addToHand(c);
        Player p = new Player("D", 500);
        Player p2 = new Player("M", 1000);
        Player p3 = new Player("A", 550);
        p.setWin(false);
        p.addToHand(c);
        p.addToHand(c2);
        p.addToHand(c3);
        p2.setWin(true);
        p2.addToHand(c);
        p2.addToHand(a);
        p3.setDraw(true);
        p3.addToHand(c);
        p3.addToHand(c2);
        game.createPlayerArray(3);
        game.getPlayersArray()[0] = p;
        game.getPlayersArray()[1] = p2;
        game.getPlayersArray()[2] = p3;
        displayOutcomes(game);
        //game.clearHandsBets();
    }

    //waits for play again to be pressed and then breaks out of the loop and sets this jframe to not visible
    public boolean playAgainCheck(BlackJack game) throws InterruptedException {
        boolean playAgain = false;
        while (true) {
            Thread.sleep(100);
            if (playAgainButton.isPressed()) {
                playAgain = true;
            }
            //check if user wants to display richest player
            if (mostMoneyButton.isPressed()) {
                game.testMostMoney();
                mostMoneyButton.setPressedFalse();
            }
            if (playAgain) {
                setVisible(false);
                break;
            }
        }   
        return playAgain;
    }



    //displays the outcome of the round for each player and their new amount of money
    public void displayOutcomes(BlackJack game) {
        //2d array since each player has 3 labels
        javax.swing.JLabel[][] labelArr = {
            {player1NameLabel, player2NameLabel, player3NameLabel, player4NameLabel, player5NameLabel, player6NameLabel},
            {player1HandValue, player2HandValue, player3HandValue, player4HandValue, player5HandValue, player6HandValue},
            {player1Money, player2Money, player3Money, player4Money, player5Money, player6Money}
        };

        //int j used to increment from 0 to (number of players - 1) so all elements in the array can be accessed
        int j = 0;

        //loop for each player in the game to set the outcomes text for the labels
        for (Player p : game.getPlayersArray()) {
            if (p.getDraw()) {
                labelArr[0][j].setText(p.getName() + " drew");
                labelArr[1][j].setText("Hv: " + Integer.toString(p.handValue()));
                labelArr[2][j].setText("M: " + Long.toString(p.getMoney()));
            }
            else {
                labelArr[0][j].setText(p.getName() + p.printWin());
                labelArr[1][j].setText("Hv: " + Integer.toString(p.handValue()));
                labelArr[2][j].setText("M: " + Long.toString(p.getMoney()));
            }
            j++;
        }
    }

                        
    private void initComponents(BlackJack game) {

        //sets background colour to dark green
        getContentPane().setBackground(Color.decode("#2e6716"));
        //instantiating the buttons and labels
        playAgainButton = new myJButton();
        mostMoneyButton = new myJButton();
        dealerHandLabel = new javax.swing.JLabel();
        dealerHandValueLabel = new javax.swing.JLabel();
        player3NameLabel = new javax.swing.JLabel();
        player4NameLabel = new javax.swing.JLabel();
        player5NameLabel = new javax.swing.JLabel();
        player6NameLabel = new javax.swing.JLabel();
        player2NameLabel = new javax.swing.JLabel();
        player1NameLabel = new javax.swing.JLabel();
        player3HandValue = new javax.swing.JLabel();
        player4HandValue = new javax.swing.JLabel();
        player5HandValue = new javax.swing.JLabel();
        player6HandValue = new javax.swing.JLabel();
        player2HandValue = new javax.swing.JLabel();
        player1HandValue = new javax.swing.JLabel();
        player1Money = new javax.swing.JLabel();
        player2Money = new javax.swing.JLabel();
        player3Money = new javax.swing.JLabel();
        player4Money = new javax.swing.JLabel();
        player5Money = new javax.swing.JLabel();
        player6Money = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //setting text for some of the buttons and labels
        playAgainButton.setText("Play Again?");

        mostMoneyButton.setText("Display richest player");

        dealerHandLabel.setText("Dealer hand value: ");

        dealerHandValueLabel.setText(Integer.toString(game.dealer.handValue()));

        //auto generated code using NetBeans gui designer
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(dealerHandLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dealerHandValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(player1NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(player2NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(player1HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player2HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(player1Money, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player2Money, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(player3HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(player3NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(player3Money, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(player4NameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(player4HandValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(player4Money, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(player5NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(player6NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(player5HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(player6HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(player5Money, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(player6Money, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(playAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(mostMoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dealerHandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dealerHandValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player3NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player5NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player6NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player2NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player3HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player5HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player6HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player2HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1HandValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player2Money, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1Money, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player3Money, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4Money, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player5Money, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player6Money, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostMoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)))
        );

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel dealerHandLabel;
    private javax.swing.JLabel dealerHandValueLabel;
    private myJButton playAgainButton;
    private myJButton mostMoneyButton;
    private javax.swing.JLabel player1NameLabel;
    private javax.swing.JLabel player2NameLabel;
    private javax.swing.JLabel player3HandValue;
    private javax.swing.JLabel player4HandValue;
    private javax.swing.JLabel player5Money;
    private javax.swing.JLabel player6Money;
    private javax.swing.JLabel player5HandValue;
    private javax.swing.JLabel player6HandValue;
    private javax.swing.JLabel player2HandValue;
    private javax.swing.JLabel player1HandValue;
    private javax.swing.JLabel player1Money;
    private javax.swing.JLabel player2Money;
    private javax.swing.JLabel player3Money;
    private javax.swing.JLabel player4Money;
    private javax.swing.JLabel player3NameLabel;
    private javax.swing.JLabel player4NameLabel;
    private javax.swing.JLabel player5NameLabel;
    private javax.swing.JLabel player6NameLabel;
    // End of variables declaration                   
}