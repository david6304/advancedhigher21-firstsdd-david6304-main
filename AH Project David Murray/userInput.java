import java.util.Scanner;

public class userInput {
    Scanner in = new Scanner(System.in);

    public void getBet(Player p) {
        System.out.println(p.getName() + " enter your bet: ");
        int bet = Math.round(Float.parseFloat(in.nextLine()));
        //validate bet
        while (bet > p.getMoney() || bet < 0) {
            System.out.println("Cannot bet that amount. Enter a bet between 0 and " + Long.toString(p.getMoney()));
            bet = Math.round(Float.parseFloat(in.nextLine()));
        }
        p.placeBet(bet);
    }

    public String hitOrStand(Player p) {
        System.out.println(p.getName() + ", Stand or Hit:   (s or h)");
        String choice = in.nextLine();
        return choice;
    }

    public void close() {
        this.in.close();
    }

    public boolean playAgain() {
        System.out.println("Would you like to play again?       (y/n)");
        String p = in.nextLine(); 
        //validate p
        while (!p.equals("y") && !p.equals("n")) {
            System.out.println("Enter y or n: ");
            p = in.nextLine();
        }
        if (p.equals("y")) {
            return true;
        }
        return false;
    }
    
    public int getNoPlayers() {
        System.out.println("How Many players are playing:        (1-6)");
        int nPlayers = Math.round(Float.parseFloat(in.nextLine()));
        //validate number of players
        while (nPlayers > 6 || nPlayers < 1) {
            System.out.println("Enter a number between 1-6: ");
            nPlayers = Math.round(Float.parseFloat(in.nextLine()));
        }
        return nPlayers;
    }

    public String getPlayerName() {
        return in.nextLine();
    }

    public String wantToSplit(Player p) {
        System.out.println(p.getName() + "Would you like to split your hand?       (y/n)");
        String split = in.nextLine(); 
        //validate p
        while (!split.equals("y") && !split.equals("n")) {
            System.out.println("Enter y or n: ");
            split = in.nextLine();
        }
        return split;
    }
}
