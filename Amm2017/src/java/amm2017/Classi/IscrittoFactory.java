
package amm2017.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
            String query = 
                    "select iscritto_id from iscritti  "
                    + "where username = ? and password = ?";
            
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
    public void aggiornaIscritto (Iscritto i){
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = 
                      "UPDATE iscritti SET nome=?, cognome=?, urlImmProf=?, frase=?, data_iscritto=?, username=?, password=?"
                    + "WHERE iscritto_id=?";
   
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
 
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getCognome());
            stmt.setString(3, i.getUrlImmProfilo());
            stmt.setString(4, i.getFrase());
            stmt.setString(5, i.getNascita());
            stmt.setString(6, i.getUsername());
            stmt.setString(7, i.getPsw());
            stmt.setInt(8, i.getId());
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteIscritto (Iscritto i, Post p) throws SQLException{
        
        Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
        
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        
        
        String delQuery = 
                "DELETE FROM posts"
                +"JOIN iscritti"
                +"ON posts.author=iscritti.iscritto_id"
               +"WHERE posts.post_id=? AND iscritti.iscritto_id=?";
        String delQuery2=
                "DELETE FROM iscritti"
                +"WHERE iscritto_id=?";
        try{
            conn.setAutoCommit(false);
            
            stmt = conn.prepareStatement(delQuery);
            stmt2= conn.prepareStatement(delQuery2);
            
            stmt.setInt(1, p.getUser().getId()); 
            stmt.setInt(2, i.getId());
            
            stmt2.setInt(1, i.getId());
            
            int r = stmt.executeUpdate();
            int r2 = stmt2.executeUpdate();
            
            if(r!=1 || r2!=1){
                conn.rollback();
            }
            
            conn.commit();
            conn.close();
            
        }catch(SQLException e){
            e.printStackTrace();
            
            if (conn != null){
                try{
                conn.rollback();
                }catch(SQLException ex){
                    e.printStackTrace();
                }
            }
        } finally{
            if(stmt != null){
                stmt.close();
            }
            if(stmt2 != null){
                stmt2.close();
            }
        
            conn.setAutoCommit(true);
            conn.close();
        }
    }
    
    
    public List getIscrittiList(String nome){
        List<Iscritto> usersList = new ArrayList<Iscritto>();
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = "select * from iscritti"
                    +"where nome like ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, "%"+nome+"%");
            
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                Iscritto i = new Iscritto();
                i.setId(res.getInt("iscritto_id"));
                i.setNome(res.getString("nome"));
                i.setCognome(res.getString("cognome"));
                i.setUrlImmProfilo(res.getString("urlImmProf"));
                i.setFrase(res.getString("frase"));
                i.setNascita(res.getString("data_iscritto"));
                i.setUsername(res.getString("username"));
                i.setPsw(res.getString("password"));
                
                usersList.add(i);
            }
            
            stmt.close();
            conn.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return usersList;
    }
    
    public List getIscrittiList(){
        List<Iscritto> usersList = new ArrayList<Iscritto>();
        
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = "select * from iscritti";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Iscritto current = new Iscritto();
                current.setId(res.getInt("iscritto_id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUrlImmProfilo(res.getString("urlImmProf"));
                current.setFrase(res.getString("frase"));
                current.setNascita(res.getString("data_iscritto"));
                current.setUsername(res.getString("username"));
                current.setPsw(res.getString("password"));                
                
                usersList.add(current);
            }

            stmt.close();
            conn.close();
                       
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return usersList;
    }

}
