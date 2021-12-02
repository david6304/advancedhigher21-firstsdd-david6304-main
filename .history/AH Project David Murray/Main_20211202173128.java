public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        while (true) {
            System.out.println(playAgain);
            if (playAgain) {
                playAgain = false;
                try {
                    BlackJack game = new BlackJack();
                    UserInputGUI uiGUI = new UserInputGUI(game);
                    if (uiGUI.isVisible() == false) {
                        GUI gameGUI = new GUI(game);
                        if (gameGUI.isVisible() == false) {
                            OutcomeGUI endGUI = new OutcomeGUI(game);
                            outcome
                            System.out.println(playAgain + " after if statement");

                        }
                    }
                    
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }    
        }
        
        
        //GUI gui = new GUI(game);

        /* BlackJack game = new BlackJack();
        while (game.playAgain) {
            game.startGame();
            game.playRound();
        }
        game.closeScanner(); */
    }
}
