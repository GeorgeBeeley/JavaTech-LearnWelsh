package servlets;

import database.DatabaseManager;
import database.Login;
import database.LoginHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * logs in user
 * @author Jack
 */
public class LoginServlet extends HttpServlet {

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
        try {
            DatabaseManager dbm = new DatabaseManager();
            LoginHandler login = new LoginHandler(dbm);
            
            String user = request.getParameter("email");
            Login log = login.login(user,request.getParameter("password"));
            
            dbm.closeConnection();
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out= response.getWriter();
            switch(log){
                case SUCCESS:
                    HttpSession session = request.getSession();
                    Cookie loginCookie = new Cookie("user",user);
                    loginCookie.setMaxAge(60*60); //1 hour
                    response.addCookie(loginCookie);
                    session.setAttribute("User", user);
                    response.sendRedirect("/WelcomePage.jsp");
                    break;
                case NO_USER:
                    out.println("<script type='text/javascript'>alert('This email is not registered');</script>");
                    rd.include(request, response);
                    response.sendRedirect("/index.jsp");
                    break;
                case WRONG_PASS:
                    out.println("<script type='text/javascript'>alert('Invalid email or password');</script>");
                    rd.include(request, response);
                    response.sendRedirect("/index.jsp");
                    break;
                case FAILED:
                    out.println("<script type='text/javascript'>alert('Internal Server Error');</script>");
                    rd.include(request, response);
                    response.sendRedirect("/index.jsp");
                    break;
                default:
                    out.println("<script type='text/javascript'>alert('Internal Server Error');</script>");
                    rd.include(request, response);
                    response.sendRedirect("/index.jsp");
                    break;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
