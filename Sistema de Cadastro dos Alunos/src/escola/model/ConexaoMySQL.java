package escola.model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class ConexaoMySQL {
    
    
      public  Connection connectBD(){
          Connection conn = null;
    
           try {
            String url = "jdbc:mysql://localhost:3306/escola?user=root";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e){
               System.out.println("Erro " + e);
        }
           
           return conn;
      }
        
   
}
