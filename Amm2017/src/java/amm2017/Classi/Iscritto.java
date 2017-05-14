/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017.Classi;

/**
 *
 * @author claar
 */
public class Iscritto {
   protected int id;
   protected String nome;
   protected String cognome;
   protected String urlImmProfilo;
   protected String frase;
   protected String nascita;
   protected String username;
   protected String password;
   protected String c_Password;
   protected boolean loggedIn;
   
   public Iscritto(){
       id = 0;
       nome = "";
       cognome = "";
       urlImmProfilo = "";
       frase = "";
       nascita = "";
       password = "";
       c_Password = "";
       loggedIn = false;
   }
   
   public int getId(){
       return id;
   }
   public void setId(int id){
       this.id = id;
   }
   public String getNome(){
       return nome;
   }
   public void setNome(String nome){
       this.nome = nome;
   }
   public String getCognome(){
       return cognome;
   }
   public void setCognome(String cognome){
       this.cognome = cognome;
   }   
   public String getFrase(){
       return frase;
   }
   public void setFrase(String frase){
       this.frase = frase;
   }
   public String getNascita(){
       return nascita;
   }
   public void setNascita(String nascita){
       this.nascita = nascita;
   }
   public String getUsername(){
       return username;
   }
   public void setUsername(String username){
       this.username = username;
   }
   public String getPsw(){
       return password;
   }
   public void setPsw(String password){
       this.password = password;
   }
   public String getC_Psw(){
       return c_Password;
   }
   public void setC_Psw(String c_Password){
       this.c_Password = c_Password;
   }
   
   public boolean getLog(){
       return loggedIn;
   }
   public void setLog(boolean loggedIn){
       this.loggedIn = loggedIn;
   }
   
   @Override
   public boolean equals(Object altroIscritto){
       if (altroIscritto instanceof Iscritto)
           if(this.getId() == ((Iscritto)altroIscritto).getId())
                return true;
       return false;  
   }
   public String getUrlImmProfilo(){
       return urlImmProfilo;
   }
   public void setUrlImmProfilo(String urlImmProfilo){
       this.urlImmProfilo = urlImmProfilo;
   }
}
