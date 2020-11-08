/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import java.lang.NullPointerException;

/**
 *
 * @author LATITUDE
 */
public class Custregisrtry extends HttpServlet {

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
            throws ServletException, IOException{
        
        
        String id = request.getParameter("regid");
        String uname = request.getParameter("user");
        String mail = request.getParameter("email");
        String pwd = request.getParameter("pass");
        String cpwd = request.getParameter("cpass");
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        if(pwd.equals(cpwd)){
            //String AlertMsg = "CONFIRMED";
           // request.setAttribute("AlertMsg", AlertMsg );
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                 dispatcher.include(request, response);
        
        }
        else{
         RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
                 dispatcher.include(request, response);
        
        }
        
       
        Connection conn = null;
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/phcdb";
            try {
                conn = DriverManager.getConnection(url,"root", "");
                PreparedStatement ps = conn.prepareStatement("insert into registry values(?,?,?,?,?)");
                ps.setString(1, id);
                ps.setString(2, uname);
                ps.setString(3, mail);
                ps.setString(4, pwd);
                ps.setString(5, cpwd);
                ps.executeUpdate();
                
               
           
                   
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
                
               
            }
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();

            }
            
            finally
                {
                try{
                 conn.close();
                }
            catch(SQLException sqlex)
            {
              sqlex.printStackTrace();
            }
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
