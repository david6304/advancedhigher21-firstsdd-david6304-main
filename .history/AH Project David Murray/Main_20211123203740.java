public class Main {
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        GUI gameGUI = new GUI(game);
        UserInputGUI uiGUI = new UserInputGUI(game);
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
