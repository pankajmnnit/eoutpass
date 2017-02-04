
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOSHI
 */
public class Wardenlogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrintWriter out=response.getWriter();
         String d=request.getParameter("id");
         int id= Integer.parseInt(d);
         
         String pass=request.getParameter("userPass");
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
            
            
            
            Statement stmt=conn.createStatement();  
       
  
       
       ResultSet rs=stmt.executeQuery("Select password,ID from hostel.warden"); 
      
       while(rs.next()){
          String pwd= rs.getString(1);
          int coer_id =rs.getInt(2);
          
          if((pwd.equals(pass)) && (coer_id==id))
          {
              
           RequestDispatcher view = request.getRequestDispatcher("Warden_dashboard.html");
       view.forward(request, response);    
              
          }
           else
     {
        
         out.println("<HTML><H4>WRONG PASSWORD OR USERNAME</H4></HTML>");
         
         
     }
          
          
           
       }
       
            
        } 
         catch (Exception ex) {
           out.println(ex.getMessage());
        }
  
  
  
  
  
  
    } 
        
    }
    
    
    
    
    
    
    
    

