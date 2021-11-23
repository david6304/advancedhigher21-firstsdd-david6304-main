import java.util.ArrayList;
import java.util.Arrays;

public class Dealer {
    private ArrayList<Card> hand = new ArrayList<Card>();

    public void initialDeal(Deck d, Player[] pArr) {
        int counter = 0;
        while (counter < pArr.length*2) {
            this.addToHand(d.cards.get(0));
            d.cards.remove(0);
            for (Player p : pArr) {
                p.addToHand(d.cards.get(0));
                d.cards.remove(0);
                counter++;
            }
        }
    } 

    public void Deal(Deck d, Player p) {
        p.addToHand(d.cards.get(0));
        d.cards.remove(0);
    }

    public void addToHand(Card c) {
        this.hand.add(c);
    }

    public Card[] getHand() {
        return this.hand
    }
    
    public String printHand() {
        return Arrays.toString(this.hand.toArray());
    }

    public void printInfo() {
        System.out.println("Dealer info: ");
        System.out.println("    Hand: " + this.printHand());
        System.out.println("    Hand value: " + Integer.toString(this.handValue()));
    }

    public int handValue() {
        int val = 0;
        for (Card c : this.hand) {
            val += c.getValue();
        }
        return val;
    }

    public void DealtoSelf(Deck d, Dealer dealer) {
        dealer.addToHand(d.cards.get(0));
        d.cards.remove(0);
    }

    public void clearHand() {
        this.hand.clear();
    }
}
