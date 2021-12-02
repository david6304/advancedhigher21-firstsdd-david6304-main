public class BlackJack {
    //create deck, dealer and player
    Deck pack = new Deck();
    Dealer dealer = new Dealer();
    Boolean playAgain = true;
    private Player[] players;
    int playerNo = 0;

    public void createPlayerArray(int size) {
        this.players = new Player[size]; 
    }

    public void startGame() {
        //create and shuffle deck
        pack.create();
        pack.shuffle();
        //initial deal to players
        dealer.initialDeal(pack, players);
    }


    //calculate the outcome of the round and settle the bets
    public void findOutcome() {
        for (Player p : players) {
            //check if player is bust
            if (p.isBust()) {
                p.setWin(false);
                p.setMoney((Math.round(p.getMoney() - p.getBet())));
            }
            //check for blackjack
            else if (p.handValue() == 21 && p.getHand().size() == 2 && dealer.handValue() != 21) {
                p.setWin(true);
                p.setMoney((Math.round(p.getMoney() + 1.5*p.getBet())));
            }
            //check if players hand is better than dealers
            else if (p.handValue() > dealer.handValue()) {
                p.setMoney((Math.round(p.getMoney() + p.getBet())));
                p.setWin(true);
            }
            //check if dealer is bust
            else if (dealer.handValue() > 21) {
                p.setMoney((Math.round(p.getMoney() + p.getBet())));
                p.setWin(true);
            }
            //check if dealers hand is better than players
            else if (p.handValue() < dealer.handValue()) {
                p.setMoney((Math.round(p.getMoney() - p.getBet())));
                p.setWin(false);
            }
            //if same hand value then draw so bet is returned
            else {
                p.setDraw(true);
            }
        }
    }

    public void clearHandsBets() {
        dealer.clearHand();
        for (Player p : players) {
            p.clearHandBet();
        }
    }

    public Player[] getPlayersArray() {
        return this.players;
    }

}
