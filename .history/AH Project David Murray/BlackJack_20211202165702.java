public class BlackJack {
    //create deck, dealer and player
    Deck pack = new Deck();
    Dealer dealer = new Dealer();
    //Player p = new Player(500);
    userInput UI = new userInput();
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

    public void playRound() {
        for (Player p : players) {
            //lets players split pairs of cards
            /* if (p.getHand().get(0).getValue() == p.getHand().get(1).getValue() && p.getHand().get(0).getType() == p.getHand().get(1).getType()) {
                String playerSplit = UI.wantToSplit(p);
                if (playerSplit.equals("y")) {

                }
            } */
            //loops until player decides to stand or goes bust
            int counter = 0;
            String choice = UI.hitOrStand(p);
            while (!choice.equals("s") && counter < 4) {
                //validate input
                while (!choice.equals("s") && !choice.equals("h")) {
                    UI.hitOrStand(p);
                    System.out.println(choice);
                }
                dealer.Deal(pack, p);
                System.out.println(p.printHand());
                System.out.println("Hand Value: " + Integer.toString(p.handValue()));
                if (p.checkBust()) {
                    break;
                }
                counter += 1;
                choice = UI.hitOrStand(p);
            }
        }
        int noOfBustPlayers = checkBust();
        //deals cards to dealer until >16
        while (dealer.handValue() < 17 && noOfBustPlayers != players.length) {
            dealer.DealtoSelf(pack, dealer);
            dealer.printInfo();
        }
        findOutcome();  
        dealer.clearHand();
        dealer.printInfo();
        for (Player p : players) {
            p.clearHand();
            p.printInfo();
        }
        playAgain = UI.playAgain();
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
                System.out.println("Dealer is bust, " + p.getName() + " wins");
            }
            //check if dealers hand is better than players
            else if (p.handValue() < dealer.handValue()) {
                p.setMoney((Math.round(p.getMoney() - p.getBet())));
                System.out.println("Dealer wins, " + p.getName() + " loses");
            }
            //if same hand value then draw so bet is returned
            else {
                System.out.println("Draw");
            }
        }
    }

    public void closeScanner() {
        this.UI.close();
    }

    //check if any players are bust
    public int checkBust() {
        int nBust = 0;
        for (Player p : players) {
            if (p.handValue() > 21) {
                nBust++;
            }
        }
        return nBust;
    }

    public Player[] getPlayersArray() {
        return this.players;
    }

}
