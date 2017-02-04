/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Update extends HttpServlet
{
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int coerid = 0;
     PrintWriter out=response.getWriter();
     
          HttpSession session = request.getSession(true);
           int var = (int) session.getAttribute("myId");
        //  int id=Integer.parseInt(var);
          try
          {
         Class.forName("com.mysql.jdbc.Driver");     
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","");        
         Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("Select Changed from hostel.outpass_data where COER_ID="+var);
         
         
         while(rs.next())
         {
          coerid=rs.getInt("Changed");             
         }
         coerid--;
         PreparedStatement pr=conn.prepareStatement("UPDATE outpass_data SET Changed=(?)WHERE COER_ID=(?)");
          pr.setInt(1,coerid);
          pr.setInt(2,var);
          pr.executeUpdate();
         String Num=null;
         String pass=null;
         session.removeAttribute("myId");
     } catch (Exception ex) {
         out.println(ex.getMessage());
     }
       
 }
}