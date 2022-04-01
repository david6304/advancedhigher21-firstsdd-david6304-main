
public class Main {
    public static void main(String[] args) {

        try {
            BlackJack game = new BlackJack()
            OutcomeGUI og = new OutcomeGUI();
            boolean b = og.playAgainCheck(game)
        } catch (Exception e) {}
    
        //create playAgain boolean so game continues while player wants to play again
        /* boolean playAgain = true;
        while (true) {
            if (playAgain) {
                //set playAgain to false so it will only loop again if player clicks play again button to set playAgain to true
                playAgain = false;
                try {
                    //create instances of blackjack and userinputgui
                    BlackJack game = new BlackJack();
                    UserInputGUI uiGUI = new UserInputGUI(game);

                    //if statements so the next jframe isn't created until the previous one is no longer visible
                    if (uiGUI.isVisible() == false) {
                        GUI gameGUI = new GUI(game);
                        if (gameGUI.isVisible() == false) {
                            OutcomeGUI endGUI = new OutcomeGUI(game);
                            
                            //sets playAgain value based on what player clicks
                            playAgain = endGUI.playAgainCheck(game);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }    
        } */
    }
}
