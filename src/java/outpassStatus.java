
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class outpassStatus  extends HttpServlet{
    
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
    
        int counter=0;
        try {  
            Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        Statement stmt=conn.createStatement();  
        PrintWriter out=response.getWriter();
      
        
        
    HttpSession session=request.getSession(false);
    int str=(Integer)session.getAttribute("id");
    out.println("<html><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" /><br></br><br></br><br></br><center><h1>"+str+"</h1>");
    
     ResultSet rs=stmt.executeQuery("Select Confirmation,Outpass_No from hostel.outpass_data where COER_ID="+str);
      while(rs.next())
      {
          String conf=rs.getString("Confirmation");
          String no=rs.getString("Outpass_No");
          if (conf.equals("Granted"))
          {
             out.println("<div class=\"pg\"><br><h2>YOUR OUTPASS NO IS</h2></br><h2>"+no+"</h2><br><h2>Don't Share with anyone</h2></br><br><h2>Kindly show it in main gate</h2></br></center></div></body></html>"); 
             counter=1;
             break;
              
          }
          else if(conf.equals("pending"))
          {
              counter=1;
              out.println("OUTPASS HAS NOT BEEN CONFIRMED YET BY WARDEN<br>Kindly check later</center></body></html>");
              break;
          }
          
      }
      if(counter==0)
      {out.println("<center><h3>Fill outpass first</h3><center>");
      }
    
    
    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
}
}
