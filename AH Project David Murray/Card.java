public class Card {
    private Suit Suit;
    private Rank Rank;

    //contructor
    public Card(Suit suit, Rank rank) {
        this.Suit = suit;
        this.Rank = rank;
    }

    //creates a string output for each card
    @Override
    public String toString() {
        return Character.toString(Suit.value) + Integer.toString(Rank.value) + Character.toString(Rank.type);
    }

    //returns the numerical value of a card
    public int getValue() {
        return this.Rank.value;
    }
    
    // returns the type in order to differentiate tens, jack, queens and kings
    public char getType() {
        return this.Rank.type;
    }
}
