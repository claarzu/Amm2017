
package amm2017.Classi;

/**
 *
 * @author claar
 */
public class Post {
    
    public enum Type{
        TEXT, IMAGE
    };
    
    protected int id;
    protected Iscritto user;
    protected Gruppi group;
    private String content;
    private Type postType;
    
    public Post(){
        id = 0;
        user = null;
        content = "";
        postType = Type.TEXT;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Iscritto getUser(){
        return user;
    }    
    public void setUser(Iscritto user){
        this.user = user;
    }
    
    public Gruppi getGruppo(){
        return group;
    }    
    public void setGruppo(Gruppi group){
        this.group = group;
    }
    
    public String getContent(){
        return content;
    }    
    public void setContent(String content){
        this.content = content;
    }
    
    public Type getPostType(){
        return postType;
    }
    
    public void setPostType(Type postType){
        this.postType = postType;
    }    
}
