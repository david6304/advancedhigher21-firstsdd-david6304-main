import java.util.ArrayList;
import java.util.Arrays;

public class Dealer {
    //array list so the size can be changed as cards are dealt
    private ArrayList<Card> hand = new ArrayList<Card>();
    private boolean bust = false;

    public void initialDeal(Deck d, Player[] pArr) {
        for (int i = 0; i < 2; i++) {
            this.DealtoSelf(d, this);
            for (Player p : pArr) {
                p.addToHand(d.cards.get(0));
                d.cards.remove(0);
            }
        }
    } 

    //setter and getter for boolean bust
    public void setBust() {
        this.bust = true;
    }

    public boolean isBust() {
        return this.bust;
    }

    //adds a card to a players hand and removes it from the deck
    public void Deal(Deck d, Player p) {
        p.addToHand(d.cards.get(0));
        d.cards.remove(0);
    }

    //gets hand array list
    public ArrayList<Card> getHand() {
        return this.hand;
    }
    
    //returns a string representation of a hand
    public String printHand() {
        return Arrays.toString(this.hand.toArray());
    }
        
    //calculate numerical value of a hand
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

    //adds a card to the dealers hand
    public void addToHand(Card c) {
        this.hand.add(c);
    }

    //adds next card in the deck to the dealer and removes this card from the deck
    public void DealtoSelf(Deck d, Dealer dealer) {
        dealer.addToHand(d.cards.get(0));
        d.cards.remove(0);
    }

    //clears the dealers hand
    public void clearHand() {
        this.hand.clear();
    }
}
