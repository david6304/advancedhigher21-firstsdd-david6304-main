import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbMethods {
    String database = "http://192.168.1.3:8080/phpmyadmin/db_structure.php?server=1&db=dmurray_blackjack_players";
    String user = "dmurray";
    String pass = "100528231";
    Statement stmt = null;
    
    public dbMethods() {
        try {
            Connection conn = DriverManager.getConnection(database, user, pass);
            stmt = conn.createStatement();
            System.out.println("I am connected");
            if(stmt != null){
                stmt.close();
            }
        }
        catch ( SQLException err ) {
            System.out.println("ERROR" +  err.getMessage( ) );
        }
    }

    public int getExistingPlayer(String name) {
        String query = "SELECT name, money FROM Players";
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

    public void addPlayer(String name) {
        String query = "INSERT INTO Players (Username, Money) VALUES ('" + name + "', 500)";
        try {
            stmt.executeQuery(query);
        }
        catch (SQLException err) {
            System.out.println("ERROR" + err.getMessage());
        }
    }

    public void updatePlayerData(String name, int money){
        
    }
}
