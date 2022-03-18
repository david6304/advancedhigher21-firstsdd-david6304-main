import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbMethods {
    //database details
    String database = "jdbc:mariadb://192.168.1.3:3306/dmurray_blackjack_players";
    String user = "murrayd";
    String pass = "100528231";
    Statement stmt = null;
    
    //constructor which creates connection to database
    public dbMethods() {
        try {
            Connection conn = DriverManager.getConnection(database, user, pass);
            stmt = conn.createStatement();
        }
        catch ( SQLException err ) {
            System.out.println("ERROR: " +  err.getMessage( ));
        }
    }

    //checks if player name exists and database and returns their money if so
    public int getExistingPlayer(String name) {
        String query = "SELECT Username, Money FROM users";
        try {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                String username = rs.getString("Username");
                if (username.equals(name)) {
                    int money = rs.getInt("Money");
                    return money;
                }
            }
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
        return 0;
    }

    //adds a new player to the database with a username and money value
    public void addPlayer(String name) {
        String query = "INSERT INTO users (Username, Money) VALUES ('"+name+"', 500)";
        try {
            stmt.executeQuery(query);
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
    }

    //updates a users money after a round has ended
    public void updatePlayerData(String name, int money) {
        String query = "UPDATE users SET Money = " + money + " WHERE Username = \"" + name + "\"";
        try {
            stmt.executeQuery(query);
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
    }

    //if a player in the database has 0 money then it gives them 100 so they aren't in the database and unable to play
    public void updateBrokePlayers() {
        String query = "UPDATE users SET Money = 100 WHERE Money = 0";
        try {
            stmt.executeQuery(query);
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
    }

    //method to close the stmt
    public void closeStmt() {
        if (stmt!=null) {
            try {
                stmt.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //bubble sort which sorts an array of player objects in descending order of money
    public void bubbleSort(Player[] arr) {
        int length = arr.length;
        boolean swapped = true;
        while (swapped && length >= 0) {
            swapped = false;
            for (int i = 0; i < length - 2; i++) {
                if (arr[i].getMoney() < arr[i+1].getMoney()) {
                    Player temp = new Player(arr[i].getName(), ((int)arr[i].getMoney()));
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            length -= 1;
        }
    }
    
    //gets all info from database and creates an array of player objects, which have a username and money, to be sorted
    public void printMostMoney() {
        //two queries to stop grouping from the COUNT(*) affecting the first query
        String query = "SELECT Username, Money FROM users";
        String countQuery = "SELECT COUNT(*) FROM users";
        try {
            //two result sets to store both queries results
            ResultSet rs = stmt.executeQuery(query);
            ResultSet rs2 = stmt.executeQuery(countQuery);
            rs.first();
            rs2.first();
            //COUNT(*) is used to get number of rows in table so correctly sized player array can be made
            int size = rs2.getInt("COUNT(*)");
            Player[] players = new Player[size];
            //for loop to fill the array 
            for (int i = 0; i < size; i++) {
                players[i] = new Player(rs.getString("Username"), rs.getInt("Money"));
                rs.next();
            }
            bubbleSort(players);
            System.out.println(players[0].getName()+ " has the most money with £" + players[0].getMoney());
        }
        catch (SQLException err) {
            System.out.println("ERROR " + err.getMessage());
        }
    }
}
