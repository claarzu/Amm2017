
package amm2017.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author claar
 */
public class IscrittoFactory {
    
    private static IscrittoFactory singleton;
    
    //nuova instanza di Iscrittofactory
    public static IscrittoFactory getInstance(){
        if (singleton == null){
            singleton = new IscrittoFactory();
        }
        return singleton;
    }
    
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }
    
    public String getConnectionString() {
        return this.connectionString;
    }

    private IscrittoFactory(){       
    }
    
    public Iscritto getIscrittoById(int id){
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = "select * from iscritti  "
                    + "where iscritto_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            
            ResultSet res = stmt.executeQuery();
            
            if (res.next()){
                Iscritto current = new Iscritto();
                current.setId(res.getInt("iscritto_id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUrlImmProfilo(res.getString("urlImmProf"));
                current.setFrase(res.getString("frase"));
                current.setNascita(res.getString("data_iscritto"));
                current.setUsername(res.getString("username"));
                current.setPsw(res.getString("password"));

                stmt.close();
                conn.close();
                
                return current;
                
            }
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdByUserAndPassword (String username, String password){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = "select iscritto_id from iscritti  "
                    + "where username = ?  and password = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet res = stmt.executeQuery();
            
            if (res.next()){
                int id = res.getInt("iscritto_id");
                                                
                stmt.close();
                conn.close();
                
                return id;                
            }
            
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    
    
}
