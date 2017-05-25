
package amm2017;

import amm2017.Classi.Iscritto;
import amm2017.Classi.IscrittoFactory;
import amm2017.Classi.Post;
import amm2017.Classi.PostFactory;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author claar
 */
@WebServlet (name="Bacheca", urlPatterns = {"/bacheca.html"})
public class Bacheca extends HttpServlet {

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
            throws ServletException, IOException {
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

                List<Post> listaStati = PostFactory.getInstance().getPostList(iscritto);     
                
                request.setAttribute("listaStati", listaStati);                 
           
                
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);       
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }             
        } else {
            request.setAttribute("invalidData", true); 
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
