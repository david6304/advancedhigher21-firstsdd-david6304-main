public class Main {
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        GUI gameGUI = new GUI(game);
        ReceiveBetGUI rbGUI = new ReceiveBetGUI(game);
        gameGUI.setVisible(false);
        rbGUI.set

        /* BlackJack game = new BlackJack();
        while (game.playAgain) {
            game.startGame();
            game.playRound();
        }
        game.closeScanner(); */
    }
}
