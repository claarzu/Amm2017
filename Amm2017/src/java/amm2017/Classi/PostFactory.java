package amm2017.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author claar
 */
public class PostFactory {
    
    private static PostFactory singleton;
    
    public static PostFactory getInstance(){
        
        if (singleton == null){
            singleton = new PostFactory();
        }        
        return singleton;
    }
    
    private String connectionString;
    
    public String getConnectionString() {
        return connectionString;
    }
    public void setConnectionString(String s) {
        this.connectionString = s;
    }
    
    private PostFactory(){
        
    }
    
    public Post getPostById(int id){
        IscrittoFactory iscrittoFactory = IscrittoFactory.getInstance();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = "select * from posts "
                    + "join posttype on posts.type = posttype.posttype_id "
                    + "where post_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            
            ResultSet res = stmt.executeQuery();
            
            if (res.next()){
                Post current = new Post();
                
                current.setId(res.getInt("post_id")); 
                current.setContent(res.getString("content"));
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                
                Iscritto autore = iscrittoFactory.getIscrittoById(res.getInt("author"));
                current.setUser(autore);
                
                
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
    
    public Post getPostByIscritto(Iscritto i){
        IscrittoFactory iscrittoFactory = IscrittoFactory.getInstance();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = "select * from posts "
                    + "join posttype on posts.type = posttype.posttype_id "
                    + "where author = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setObject(1, i);
            
            
            ResultSet res = stmt.executeQuery();
            
            if (res.next()){
                Post current = new Post();
                
                current.setId(res.getInt("post_id")); 
                current.setContent(res.getString("content"));
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                
                Iscritto autore = iscrittoFactory.getIscrittoById(res.getInt("author"));
                current.setUser(autore);
                
                
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
    
    
    public List getPostList(Iscritto iscr){
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = 
                      "select * from posts "
                    + "join posttype on posts.type = posttype.posttype_id "
                    + "where author = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, iscr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));

                //imposto l'autore del post
                current.setUser(iscr);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPost;
    }
    
    public List getPostList2(Gruppi grr){
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = 
                      "select * from posts "
                    + "join posttype on posts.type = posttype.posttype_id "
                    + "where author = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, grr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContent(res.getString("content"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_name")));

                //imposto il gruppo in cui è inserito il post
                current.setGruppo(grr);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPost;
    }
    
    public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = 
                      "insert into posts (post_id, content, type, author) "
                    + "values (default, ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContent());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

   

    private Post.Type postTypeFromString(String type) {
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type){
        
        if(type == Post.Type.TEXT)
                return 1;
            else
                return 2;
    }

}
