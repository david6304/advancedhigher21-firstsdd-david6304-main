import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    //variable declaration 
    private ArrayList<Card> hand = new ArrayList<Card>();
    private long money;
    private int bet = -1;
    private String name;
    private boolean bust = false;
    private boolean win;
    private boolean draw = false;

    //constructor
    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    //returns a string output based on the value of win
    public String printWin() {
        if (this.win) {
            return " won";
        }
        else {
            return " lost";
        }
    }

    //getters and setters
    public void setDraw(boolean b) {
        this.draw = b;
    }

    public boolean getDraw() {
        return this.draw;
    }

    public void setWin(boolean b) {
        this.win = b;
    }

    public boolean getWin() {
        return this.win;
    }

    public void setBust() {
        this.bust = true;
    }

    public boolean isBust() {
        return this.bust;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public long getMoney() {
        return this.money;
    }

    public String getName() {
        return this.name;
    }

    public void placeBet(int bet) {
        this.bet = bet;
    }

    public void setMoney(long i) {
        this.money = i;
    }

    public int getBet() {
        return this.bet;
    }

    //adds a card to the players hand
    public void addToHand(Card c) {
        this.hand.add(c);
    }

    //returns a string representation of the players hand
    public String printHand() {
        return Arrays.toString(this.hand.toArray());
    }

    //calculate the numerical value of a hand
    public int handValue() {
        int val = 0;
        int aces = 0;
        for (Card c : this.hand) {
            val += c.getValue();
            if (c.getValue() == 11) {
                aces += 1;
            }
        }
        //use aces as 1 instead of 11 if it prevents bust
        while (val > 21 && aces > 0) {
            val -= 10;
            aces -= 1;
        }
        return val;
    }



    //check if player is bust
    public boolean checkBust() {
        if (this.handValue() > 21) {
            return true;
        }
        return false;
    }

    //clears players hand and bet
    public void clearHandBet() {
        this.hand.clear();
        this.bet = 0;
    }

    //changes the toString default method to return the players name
    @Override 
    public String toString() {
        return this.name;
    }
}
