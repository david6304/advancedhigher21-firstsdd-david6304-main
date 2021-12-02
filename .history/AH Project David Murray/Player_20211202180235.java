import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private long money;
    private int bet = -1;
    private String name;
    private boolean bust = false;
    private boolean win;
    private boolean draw = false;
    //second hand in case player can split hands
    //private ArrayList<Card> splitHand = new ArrayList<Card>();

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String printWin() {
        if (this.win) {
            return " won";
        }
        else {
            return " lost";
        }
    }

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

    public void addToHand(Card c) {
        this.hand.add(c);
    }

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

    public void placeBet(int bet) {
        this.bet = bet;
    }

    public void setMoney(long i) {
        this.money = i;
    }

    public int getBet() {
        return this.bet;
    }

    public void printInfo() {
        System.out.println(this.name + " info: ");
        System.out.println("    Hand: " + printHand());
        System.out.println("    Hand value: " + Integer.toString(handValue()));
        System.out.println("    Money: " + Long.toString(money));
        System.out.println("    Bet: " + Integer.toString(this.bet));
        
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

    public String getName() {
        return this.name;
    }
}
