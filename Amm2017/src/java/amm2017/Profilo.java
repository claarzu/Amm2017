
package amm2017;

import amm2017.Classi.*;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author claar
 */
@WebServlet (name="Profilo", urlPatterns = {"/profilo.html"})
public class Profilo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
       HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("loggedIn")!=null &&
            session.getAttribute("loggedIn").equals(true)){
            
            String user = request.getParameter("user");
            int userID;
            
            if (user != null){
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserId = (Integer)session.getAttribute("loggedUserId");
                userID = loggedUserId;                       
            }
            
            
            Iscritto iscritto = IscrittoFactory.getInstance().getIscrittoById(userID);
            
            if (iscritto != null){
                request.setAttribute("iscritto", iscritto);
                request.setAttribute("c_account", true);
                
                if (request.getParameter("conferma") != null){

                    String nome = request.getParameter("nome");
                    String cognome = request.getParameter("cognome");
                    String urlImmProfilo = request.getParameter("url_img");
                    String frase = request.getParameter("frase");
                    String nascita = (String)request.getParameter("data");
                    String username = request.getParameter("username");
                    String password = request.getParameter("psw");
                   
                    
                    if (!nome.isEmpty() && !cognome.isEmpty() && !urlImmProfilo.isEmpty() && !frase.isEmpty() && !nascita.isEmpty() && !username.isEmpty() && !password.isEmpty()){
                        iscritto.setId((int)session.getAttribute("loggedUserId"));
                        iscritto.setNome(nome);
                        iscritto.setCognome(cognome);
                        iscritto.setUrlImmProfilo(urlImmProfilo);
                        iscritto.setFrase(frase);
                        iscritto.setNascita(nascita);
                        iscritto.setUsername(username);
                        iscritto.setPsw(password);
                        
                        IscrittoFactory.getInstance().aggiornaIscritto(iscritto);                        
                   
                        request.setAttribute("avviso", true);   
                        request.getRequestDispatcher("profilo.jsp").forward(request, response); 
                    } 
                    
                }
                if (request.getParameter("elimina")!=null){
                    List<Post> lista = PostFactory.getInstance().getPostList(iscritto);
                    for (Post post : lista){ 
                        IscrittoFactory.getInstance().deleteIscritto(iscritto, post);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                    
                    session.setAttribute("loggedIn", false);
                }
                
                
                request.getRequestDispatcher("profilo.jsp").forward(request, response);                
            } else{
                request.setAttribute("iscritto", "");                
                request.getRequestDispatcher("profilo.jsp").forward(request, response); 
            }   
            
                    
        } else{
            request.setAttribute("invalidData", true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }
       
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Profilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Profilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
