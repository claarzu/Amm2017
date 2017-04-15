package amm2017.Classi;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author claar
 */
public class GruppiFactory {
    private static GruppiFactory singleton;
    
    public static GruppiFactory getInstance(){
        if (singleton == null){
            singleton = new GruppiFactory();
        }
        return singleton;
    }
    
    private ArrayList<Gruppi> listaGruppi = new ArrayList<Gruppi>();
    
    private GruppiFactory(){
        IscrittoFactory iscrittoFactory = IscrittoFactory.getInstance();
        PostFactory postFactory = PostFactory.getInstance();
        
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setNomeGruppo("Parliamone");
        gruppo1.setId(0);
        gruppo1.setUtente(iscrittoFactory.getIscrittoById(0));
        
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setNomeGruppo("Il mio primo post");
        gruppo2.setId(1);
        gruppo2.setUtente(iscrittoFactory.getIscrittoById(1));
        
        Gruppi gruppo3 = new Gruppi();
        gruppo3.setNomeGruppo("Wi-Fi Free");
        gruppo3.setId(2);
        gruppo3.setUtente(iscrittoFactory.getIscrittoById(2));
        gruppo3.setPostGruppo(postFactory.getPostById(2));
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);        
    }
    
    public Gruppi getGruppitById(int id){
        for (Gruppi gruppo : this.listaGruppi){
            if (gruppo.getId() == id){
                return gruppo;
            }
        }
        return null;
    }
    
    public List getGruppiList(Iscritto iscr, Post pst){
        List<Gruppi> listaGruppi = new ArrayList<Gruppi>();
        
        for (Gruppi gruppo : this.listaGruppi){
            if(gruppo.getUtente().equals(iscr) && gruppo.getPostGruppo().equals(pst)){
                listaGruppi.add(gruppo);
            }
        }
        return listaGruppi;
    }
}
