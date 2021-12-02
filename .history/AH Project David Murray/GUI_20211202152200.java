
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI(BlackJack game) {
        initComponents();
        setVisible(true);
        try {
            initialDealFrame(game);
            playRoundsFrame(game);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void initialDealFrame(BlackJack game) throws InterruptedException {
        Thread.sleep(500);
        DealerCardImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + game.dealer.getHand().get(0).toString() + ".png")));
        Thread.sleep(500);
        DealerCardImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/red.png")));
        Thread.sleep(500);
        DealerHandValueLabel.setText("?");
    }

    public void playRoundsFrame(BlackJack game) throws InterruptedException {
        HitButton.addActionListener(HitButton);
        StandButton.addActionListener(StandButton);
        for (Player p : game.getPlayersArray()) {
            PlayerCardImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + p.getHand().get(0).toString() + ".png")));
            Thread.sleep(500);
            PlayerCardImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + p.getHand().get(1).toString() + ".png")));
            Thread.sleep(500);
            PlayerCardImg1.setIcon(null);
            Thread.sleep(100);
            PlayerCardImg4.setIcon(null);
            Thread.sleep(100);
            PlayerNameLabelValue.setText(p.getName());
            PlayerMoneyLabelValue.setText(Long.toString(p.getMoney()));
            PlayerBetLabelValue.setText(Long.toString(p.getBet()));
            PlayerHandValueLabel.setText(Integer.toString(p.handValue()));
            while (!StandButton.isPressed() && p.getHand().size() < 4 && !p.isBust()) {
                Thread.sleep(100);
                if (HitButton.isPressed() && p.getHand().size() == 2) {
                    System.out.println("hit once");
                    game.dealer.Deal(game.pack, p);
                    PlayerCardImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + p.getHand().get(2).toString() + ".png")));
                    PlayerHandValueLabel.setText(Integer.toString(p.handValue()));
                    HitButton.setPressedFalse();
                    if (p.handValue() > 21) {
                        p.setBust();
                    }
                }
                else if (HitButton.isPressed() && p.getHand().size() == 3) {
                    System.out.println("hit twice");
                    game.dealer.Deal(game.pack, p);
                    PlayerCardImg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + p.getHand().get(3).toString() + ".png")));
                    PlayerHandValueLabel.setText(Integer.toString(p.handValue()));
                    HitButton.setPressedFalse();
                    if (p.handValue() > 21) {
                        p.setBust();
                    }
                }
            }
            if (p.isBust()) {
                System.out.println(p.getName() + " is bust!");
            }
            else if (p.getHand().size() > 3) {
                System.out.println(p.getName() + " has the maximum number of cards");
            }
            else {
                System.out.println(p.getName() + " chose to stand");
            }
            StandButton.setPressedFalse();
            Thread.sleep(500);
        }
    }    

    public void DealerPlays(BlackJack game) throws InterruptedException {
        DealerCardImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + game.dealer.getHand().get(1).toString() + ".png")));
        Thread.sleep(500);
        DealerHandValueLabel.setText(Integer.toString(game.dealer.handValue()));
        while (game.dealer.handValue() < 17 && game.dealer.getHand().size() < 4) {
            game.dealer.DealtoSelf(game.pack, game.dealer);
            Thread.sleep(100);
                if (HitButton.isPressed() && p.getHand().size() == 2) {
                    System.out.println("hit once");
                    game.dealer.Deal(game.pack, p);
                    PlayerCardImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + p.getHand().get(2).toString() + ".png")));
                    PlayerHandValueLabel.setText(Integer.toString(p.handValue()));
                    HitButton.setPressedFalse();
                    if (p.handValue() > 21) {
                        p.setBust();
                    }
                }
                else if (HitButton.isPressed() && p.getHand().size() == 3) {
                    System.out.println("hit twice");
                    game.dealer.Deal(game.pack, p);
                    PlayerCardImg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/" + p.getHand().get(3).toString() + ".png")));
                    PlayerHandValueLabel.setText(Integer.toString(p.handValue()));
                    HitButton.setPressedFalse();
                    if (p.handValue() > 21) {
                        p.setBust();
                    }
                }
                }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        HitButton = new myJButton();
        StandButton = new myJButton();
        PlayerNameLabel = new javax.swing.JLabel();
        PlayerMoneyLabel = new javax.swing.JLabel();
        PlayerBetLabel = new javax.swing.JLabel();
        PlayerHandLabel = new javax.swing.JLabel();
        DealerCardImg2 = new javax.swing.JLabel();
        DealerCardImg3 = new javax.swing.JLabel();
        DealerCardImg1 = new javax.swing.JLabel();
        DealerCardImg4 = new javax.swing.JLabel();
        PlayerCardImg2 = new javax.swing.JLabel();
        PlayerCardImg3 = new javax.swing.JLabel();
        PlayerCardImg4 = new javax.swing.JLabel();
        PlayerCardImg1 = new javax.swing.JLabel();
        CardDeckImgLabel = new javax.swing.JLabel();
        DealerHandLabel = new javax.swing.JLabel();
        DealerHandValueLabel = new javax.swing.JLabel();
        PlayerMoneyLabelValue = new javax.swing.JLabel();
        PlayerNameLabelValue = new javax.swing.JLabel();
        PlayerBetLabelValue = new javax.swing.JLabel();
        PlayerHandValueLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HitButton.setText("Hit");

        StandButton.setText("Stand");

        PlayerNameLabel.setText("Player Name: ");

        PlayerMoneyLabel.setText("Player Money: ");

        PlayerBetLabel.setText("Bet: ");

        PlayerHandLabel.setText("Hand Value: ");

        CardDeckImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/png_96_dpi/red.png"))); // NOI18N

        DealerHandLabel.setText("Dealer Hand Value: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PlayerHandLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayerBetLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayerMoneyLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayerNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DealerHandLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PlayerMoneyLabelValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayerNameLabelValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DealerHandValueLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 65, Short.MAX_VALUE)
                        .addComponent(DealerCardImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PlayerBetLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayerHandValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(PlayerCardImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PlayerCardImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PlayerCardImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DealerCardImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DealerCardImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DealerCardImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayerCardImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(StandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(165, 165, 165)))
                .addComponent(CardDeckImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DealerCardImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DealerCardImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DealerCardImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DealerCardImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DealerHandValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(HitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PlayerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PlayerNameLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(StandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PlayerMoneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PlayerMoneyLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PlayerBetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PlayerBetLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PlayerHandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PlayerHandValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(PlayerCardImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayerCardImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayerCardImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayerCardImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DealerHandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CardDeckImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                                            
   

    // Variables declaration - do not modify                     
    private javax.swing.JLabel CardDeckImgLabel;
    private javax.swing.JLabel DealerCardImg1;
    private javax.swing.JLabel DealerCardImg2;
    private javax.swing.JLabel DealerCardImg3;
    private javax.swing.JLabel DealerCardImg4;
    private javax.swing.JLabel DealerHandLabel;
    private javax.swing.JLabel DealerHandValueLabel;
    private myJButton HitButton;
    private javax.swing.JLabel PlayerBetLabel;
    private javax.swing.JLabel PlayerBetLabelValue;
    private javax.swing.JLabel PlayerCardImg1;
    private javax.swing.JLabel PlayerCardImg2;
    private javax.swing.JLabel PlayerCardImg3;
    private javax.swing.JLabel PlayerCardImg4;
    private javax.swing.JLabel PlayerHandLabel;
    private javax.swing.JLabel PlayerMoneyLabel;
    private javax.swing.JLabel PlayerMoneyLabelValue;
    private javax.swing.JLabel PlayerNameLabel;
    private javax.swing.JLabel PlayerNameLabelValue;
    private myJButton StandButton;
    private javax.swing.JLabel PlayerHandValueLabel;
    // End of variables declaration                   
}

