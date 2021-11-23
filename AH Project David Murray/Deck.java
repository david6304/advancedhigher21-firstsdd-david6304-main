import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    public ArrayList<Card> cards = new ArrayList<Card>();

    public void create() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card c = new Card(s, r);
                cards.add(c);
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < 1000; i++) {
            int r1 = ThreadLocalRandom.current().nextInt(0, 52);
            int r2 = ThreadLocalRandom.current().nextInt(0, 52);
            Collections.swap(cards, r1, r2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(cards.toArray());
    }
    
}
