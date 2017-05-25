
package amm2017.Classi;

/**
 *
 * @author claar
 */
public class Gruppi {
    protected int id;
    protected Iscritto utente;
    protected Post post_gruppo;
    private String nome_gruppo;
    
    public Gruppi(){
        id = 0;
        utente = null;
        post_gruppo = null;
        nome_gruppo = "";
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public Iscritto getUtente(){
        return utente;
    }
    public void setUtente(Iscritto utente){
        this.utente = utente;
    }
    
    public Post getPostGruppo(){
        return post_gruppo;
    }
    public void setPostGruppo(Post post_gruppo){
        this.post_gruppo = post_gruppo;
    }
    
    public String getNomeGruppo(){
        return nome_gruppo;
    }
    public void setNomeGruppo(String nome_gruppo){
        this.nome_gruppo = nome_gruppo;
    }

}
