
package amm2017;

import amm2017.Classi.IscrittoFactory;
import amm2017.Classi.Post;
import amm2017.Classi.PostFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author claar
 */
public class NewPost extends HttpServlet {

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
        
        if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){         
        
            if(request.getParameter("Submit")!=null){
                String thereIsPost = request.getParameter("Submit");
                String content = request.getParameter("textPost");
                String type = request.getParameter("postType");
                if(thereIsPost.equals("needConfirm")){
                    request.setAttribute("content", content);
                    request.setAttribute("typePost", type);
                    request.setAttribute("newpost", "true");
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);

                }
                else{                        
                    Post post = new Post();
                    post.setContent(content);
                    if(type.equals("textType"))
                        post.setPostType(Post.Type.TEXT);
                    else
                        post.setPostType(Post.Type.IMAGE);

                    post.setUser(IscrittoFactory.getInstance().getIscrittoById((Integer)session.getAttribute("loggedUserId")));
                    PostFactory.getInstance().addNewPost(post);
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);

            }            
        }else{
            request.getRequestDispatcher("Login").forward(request, response);
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
