/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Loginbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LATITUDE
 */
public class Logincust extends HttpServlet {

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
        PrintWriter out = response.getWriter();
                String Uname = request.getParameter("usern");
                String pwd = request.getParameter("passw");
    
       
      
        try {
            //step1: load the driver
            Class.forName("com.mysql.jdbc.Driver"); //load the server driver  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logincust.class.getName()).log(Level.SEVERE, null, ex);
        }
            String url = "jdbc:mysql://localhost:3306/phcdb";// database url
            
            
        
             
            Connection conn;  //database connection variable name 
                try {
                    conn = DriverManager.getConnection(url, "root", "");//connection
                    PreparedStatement ps =(PreparedStatement)conn.prepareStatement("select * from registry where username=? and pass=?");
                    
                    
                        Loginbean lb = new  Loginbean();
                        lb.setUsername(Uname);
                        lb.setPassword(pwd);
                    
                    ps.setString(1, lb.getUsername());
                    ps.setString(2, lb.getPassword());
                    
                   ResultSet rs = ps.executeQuery(); 
               
              if(rs.next()) {
        
                    HttpSession session = request.getSession();
                    session.setAttribute("user", Uname);
                    RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                    rd.include(request, response);
              }
        
              else {
                  
                    out.println("Wrong id and password");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.include(request, response);
      }
               
                   
                } catch (SQLException ex) {
                    Logger.getLogger(Logincust.class.getName()).log(Level.SEVERE, null, ex);
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
