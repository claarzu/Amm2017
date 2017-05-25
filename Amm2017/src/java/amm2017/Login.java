
package amm2017;

import amm2017.Classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet (name="Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)

public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    @Override
    public void init() {
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        IscrittoFactory.getInstance().setConnectionString("jdbc:derby://localhost:1527/ammdb");
        PostFactory.getInstance().setConnectionString("jdbc:derby://localhost:1527/ammdb");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        HttpSession session = request.getSession();

        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {

            request.getRequestDispatcher("Bacheca").forward(request, response);

        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null){
                int loggedUserId = IscrittoFactory.getInstance().getIdByUserAndPassword(username, password);
                
                if(loggedUserId != -1){
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserId", loggedUserId);                    
                    
                    Iscritto i = IscrittoFactory.getInstance().getIscrittoById(loggedUserId);
                    
                    if(i.getNome().equals("") || i.getCognome().equals("") || i.getUrlImmProfilo().equals("") || i.getFrase().equals("") || i.getNascita().equals("")){
                        session.setAttribute("loggedIn", true);
                        session.setAttribute("loggedUserId", loggedUserId);
                        request.getRequestDispatcher("Profilo").forward(request, response);
                    } else{
                        request.getRequestDispatcher("Bacheca").forward(request, response);
                    }
                } else {
                    request.setAttribute("errore", "credenziali di accesso errate");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                    
            }
                
        }

        
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
