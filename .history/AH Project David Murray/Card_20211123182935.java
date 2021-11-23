public class Card {
    private Suit Suit;
    private Rank Rank;

    public Card(Suit suit, Rank rank) {
        this.Suit = suit;
        this.Rank = rank;
    }

    @Override
    public String toString() {
        return Character.toString(Suit.value) + Integer.toString(Rank.value);
    }

    public int getValue() {
        return this.Rank.value;
    }
    
    public char getType() {
        return this.Rank.type;
    }
    
    public String identifyCard() {
        return this.
    }

}
