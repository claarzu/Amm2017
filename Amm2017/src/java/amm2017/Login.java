/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;


import amm2017.Classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet (name="Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
        
        HttpSession session = request.getSession();
       
        if(request.getParameter("logout")!=null){
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        if (request.getParameter("Submit")!= null){
            
            String username = request.getParameter("username");
            String password = request.getParameter("psw");
            
            ArrayList<Iscritto> listaIscritti = IscrittoFactory.getInstance().getIscrittoList();
            
            
            for (Iscritto i : listaIscritti){
                if(i.getUsername().equals(username) && i.getPsw().equals(password)){
                    int loggedUserId = IscrittoFactory.getInstance().getIdByUserAndPassword(username, password);
                    if (loggedUserId != -1){
                        session.setAttribute("loggedIn", true);
                        session.setAttribute("loggedUserId", loggedUserId);
                    }
                    if (i instanceof Iscritto){
                        
                    } if (i.getNome().equals("") || i.getCognome().equals("") || i.getFrase().equals("") || i.getNascita().equals("")){
                        
                        request.getRequestDispatcher("Profilo").forward(request, response); 
                       } else{                           
                                                       
                            request.getRequestDispatcher("Bacheca").forward(request, response);
                         }
                }                
            }
            for (Iscritto i2 : listaIscritti){
                if (!i2.getUsername().equals(username) || !i2.getPsw().equals(password)) {
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
