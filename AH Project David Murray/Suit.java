public enum Suit {
    Clubs('c'),
    Spades('s'),
    Hearts('h'),
    Diamonds('d');

    public final char value;

    private Suit(char value) {
        this.value = value;
    }
}
