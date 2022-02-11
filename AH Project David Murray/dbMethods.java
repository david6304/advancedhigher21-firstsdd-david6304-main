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

    public void updatePlayerData(String name, int money) {
        String query = "UPDATE users SET Money = " + money + " WHERE Username = \"" + name + "\"";
        try {
            stmt.executeQuery(query);
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
    }

    public void updateBrokePlayers() {
        String query = "UPDATE users SET Money = 100 WHERE Money = 0";
        try {
            stmt.executeQuery(query);
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
    }

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

    public void bubbleSort(Player[] arr) {
        int length = arr.length;
        boolean swapped = true;
        while (swapped && length >= 0) {
            swapped = false;
            for (int i = 0; i < length - 2; i++) {
                if (arr[i].getMoney() > arr[i+1].getMoney()) {
                    Player temp = new Player(arr[i].getName(), ((int)arr[i].getMoney()));
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            length -= 1;
        }
    }
    
    public void printMostMoney() {
        String query = "SELECT Username, Money FROM users";
        try {
            ResultSet rs = stmt.executeQuery(query);
            int size = 0;
            if (rs != null) {
                rs.last();   
                size = rs.getRow(); 
                rs.beforeFirst();
            }
            Player[] players = new Player[size];
            while(rs.next()) {
                int i = 0;
                players[i] = new Player(rs.getString("Username"), rs.getInt("Money"));
            }
            bubbleSort(players);
            System.out.println(players[0].getName()+ " has the most money with £" + players[0].getMoney());
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
    }
}
