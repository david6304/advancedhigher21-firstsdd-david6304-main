//Title of programming exercise:-
//Your Name:- 
//Date started:- 
//School :-
//Computer:- 
//Memory:- 
//OS:- 
//Language:- 
//Environment:-
//

//2import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbWrite {
   public static void main(String args[]) {
   
      String database = "jdbc:mariadb://192.168.1.3:3306/javadb_movies";
      String user = "javadb";
      String pass = "password";
      Statement stmt = null;
      
      String query = "INSERT INTO movie (name, rating, studio, director) VALUES ('Toy Story', 10, 'Pixar', 'John Lasseter') ";
      try {
         Connection conn = DriverManager.getConnection(database, user, pass);
         stmt = conn.createStatement();
         System.out.println("I am connected");
         stmt.executeQuery(query);
        
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
