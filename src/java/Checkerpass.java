
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOSHI
 */
public class Checkerpass extends HttpServlet{
    
    
  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
   {
    
       PrintWriter out=response.getWriter();
      
      try {  
          Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
          Statement stmt=conn.createStatement(); 
          
          HttpSession session=request.getSession(false);
        int c=(Integer)session.getAttribute("id");
        
        
        
         ResultSet rs=stmt.executeQuery("Select * from hostel.outpass_data where COER_ID="+c); 
         if (!rs.isBeforeFirst())
         {
             RequestDispatcher view = request.getRequestDispatcher("OutpassDetails.html");
              view.forward(request, response); 
         }
         else
         {
             out.println("<HTML> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" /><br></br><br></br><br></br><br></br><div><CENTER><H1>YOU HAVE ALREADY FILLED OUTPASS</H1></CENTER></div></HTML>");      
         }
        
      } catch (Exception ex) {
          out.println(ex.getMessage());
      }
  } 
    
}
