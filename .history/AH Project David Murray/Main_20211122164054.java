public class Main {
    public static void main(String[] args) {
        //new GUI();
        BlackJack game = new BlackJack();
        while (game.playAgain) {
            game.startGame();
            game.playRound();
        }
        game.closeScanner();
    }
}
