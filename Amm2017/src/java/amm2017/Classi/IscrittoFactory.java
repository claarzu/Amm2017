
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
    
    
    private ArrayList<Iscritto> listaIscritti = new ArrayList<Iscritto>();
    
    private IscrittoFactory(){
        //Creazione Iscritti
       
        Iscritto iscritto1 = new Iscritto();
        iscritto1.setId(0);
        iscritto1.setNome("Utente");
        iscritto1.setCognome("Amm");
        iscritto1.setUrlImmProfilo("http://localhost:8080/Amm2017/Immagini/utenti.png");
        iscritto1.setFrase("");
        iscritto1.setNascita("10/08/1942");
        iscritto1.setUsername("userrr");
        iscritto1.setPsw("123");
        iscritto1.setC_Psw("123");
        
        Iscritto iscritto2 = new Iscritto();
        iscritto2.setId(1);
        iscritto2.setNome("Pluto");
        iscritto2.setCognome("Disney");
        iscritto2.setUrlImmProfilo("http://localhost:8080/Amm2017/Immagini/pt.png");
        iscritto2.setFrase("Il mio social");
        iscritto2.setNascita("30/04/1931");
        iscritto2.setUsername("cane");
        iscritto2.setPsw("222");
        iscritto2.setC_Psw("222");
        
        Iscritto iscritto3 = new Iscritto();
        iscritto3.setId(2);
        iscritto3.setNome("Topolino");
        iscritto3.setCognome("Disney");
        iscritto3.setUrlImmProfilo("http://localhost:8080/Amm2017/Immagini/tp.png");
        iscritto3.setFrase("Il mio social");
        iscritto3.setNascita("18/11/1928");
        iscritto3.setUsername("topo");
        iscritto3.setPsw("333");
        iscritto3.setC_Psw("333");
        
        Iscritto iscritto4 = new Iscritto();
        iscritto4.setId(3);
        iscritto4.setNome("Paperino");
        iscritto4.setCognome("Disney");
        iscritto4.setUrlImmProfilo("http://localhost:8080/Amm2017/Immagini/pp.png");
        iscritto4.setFrase("Il mio social");
        iscritto4.setNascita("09/06/1934");
        iscritto4.setUsername("papera");
        iscritto4.setPsw("111");
        iscritto4.setC_Psw("111");
        
        
        listaIscritti.add(iscritto1);
        listaIscritti.add(iscritto2);
        listaIscritti.add(iscritto3);
        listaIscritti.add(iscritto4);
    }
    
    
    
    public Iscritto getIscrittoById(int id){
        for (Iscritto iscritto : this.listaIscritti){
            if (iscritto.getId() == id){
                return iscritto;
            }
        }
        return null;
    }
    
    
    
    
    public int getIdByUserAndPassword(String user, String password){
        for(Iscritto iscritto : this.listaIscritti){
            if(iscritto.getUsername().equals(user) && iscritto.getPsw().equals(password)){
                return iscritto.getId();
            }
        }
        return -1;
    }
    
    
    
    public ArrayList<Iscritto> getIscrittoList(){        
        return listaIscritti;
    }
    
    

}
