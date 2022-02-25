public enum Rank {
    Two(2,'c'),
    Three(3,'c'),
    Four(4,'c'),
    Five(5,'c'),
    Six(6,'c'),
    Seven(7,'c'),
    Eight(8,'c'),
    Nine(9,'c'),
    Ten(10,'c'),
    Jack(10,'j'),
    Queen(10,'q'),
    King(10,'k'),
    Ace(11,'c');

    public final int value;
    //type is only needed to differentiate tens, jacks, queens and kings
    public final char type;

    //constructor
    private Rank(int value, char type) {
        this.value = value;
        this.type = type;
    }
}
