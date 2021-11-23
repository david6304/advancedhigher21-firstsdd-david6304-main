import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbRead {
   public static void main(String args[]) {
   
      String database = "jdbc:mariadb://192.168.1.3:3306/javadb_movies";
      String user = "javadb";
      String pass = "password";
      Statement stmt = null;
      
      String query = "SELECT name, rating, studio FROM movie";
      try {
         Connection conn = DriverManager.getConnection(database, user, pass);
         stmt = conn.createStatement();
         System.out.println("I am connected");
         //stmt.executeQuery(query);
         ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            String name = rs.getString("name");
            int rating = rs.getInt("rating");
            String studio = rs.getString("studio");

            System.out.println(name + "\t\t\t\t\t\t" + rating + "\t\t\t\t\t\t" + studio);

        }
         if(stmt != null){
            stmt.close();
        }
      }
      catch ( SQLException err ) {
         System.out.println("ERROR" +  err.getMessage( ) );
      }

      System.exit(0);
   
   }	
}
