package amm2017.Classi;

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
    
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private PostFactory(){
        IscrittoFactory iscrittoFactory = IscrittoFactory.getInstance();
        
        Post post1 = new Post();
        post1.setContent("Il mio primo post");
        post1.setId(0);
        post1.setUser(iscrittoFactory.getIscrittoById(0));
        
        Post post2 = new Post();
        post2.setContent("Il mio primo post");
        post2.setId(1);
        post2.setUser(iscrittoFactory.getIscrittoById(1));
        
        Post post3 = new Post();
        post3.setContent("Immagini/schedamadre.jpg");
        post3.setId(2);
        post3.setUser(iscrittoFactory.getIscrittoById(2));
        post3.setPostType(Post.Type.IMAGE);
        
        Post post4 = new Post();
        post4.setContent("https://unica.it");
        post4.setId(3);
        post4.setUser(iscrittoFactory.getIscrittoById(3));
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
    }
    
    public Post getPostById(int id){
        for (Post post : this.listaPost){
            if (post.getId() == id){
                return post;
            }
        }
        return null;
    }
    
    public List getPostList(Iscritto iscr){
        List<Post> listaPost = new ArrayList<Post>();
        
        for (Post post : this.listaPost){
            if(post.getUser().equals(iscr)){
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
    public List getPostList2(Gruppi grr){
        List<Post> listaPost = new ArrayList<Post>();
        
        for (Post post : this.listaPost){
            if (post.getGruppo().equals(grr)){
                listaPost.add(post);
            }
        }
        return listaPost;
    }

 
}
