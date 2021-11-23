public class Main {
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        GUI gameGUI = new GUI(game);
        Userbet rbGUI = new ReceiveBetGUI(game);
        gameGUI.setVisible(false);
        rbGUI.setVisible(true);

        /* BlackJack game = new BlackJack();
        while (game.playAgain) {
            game.startGame();
            game.playRound();
        }
        game.closeScanner(); */
    }
}
