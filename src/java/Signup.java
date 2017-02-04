/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOSHI
 */
@WebServlet(urlPatterns = {"/reg"})
public class Signup extends HttpServlet {

   
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException 
    {
         
        
        
        
        PrintWriter out=res.getWriter();
          String d=(String)req.getParameter("userId");
         int id= Integer.parseInt(d);
        String password=req.getParameter("userPass");
        
        
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
            Statement stmt = con.createStatement(); 
            HttpSession session=req.getSession();
           res.setContentType("text/HTML");
            
         ResultSet rs=stmt.executeQuery("select * from hostel.hostel_table");
         
         while(rs.next())  {
         int coer_id=rs.getInt("COER_ID");
         String pass=rs.getString("Password");
         String name=rs.getString("Name");
        String fname=rs.getString("F_Name");
         String branch=rs.getString("Branch");
         int room=rs.getInt("Room_No");
         int yr=rs.getInt("Year");
         String mb=rs.getString("Mob_No");
         
         //creating form that have invisible textfield  
         //out.print("<a href='Student?uname="+name+"'>visit</a>");
         //res.sendRedirect("s2?user_name="+name+"");
         
          //out.print("<a href='s2?uname="+name+"'>visit</a>");  
           
         
          if((id==coer_id)&&(password.equals(pass))){
              session.setAttribute("uname",name);
              session.setAttribute("id",coer_id);
              session.setAttribute("fnam",fname);
              session.setAttribute("branch",branch);
              session.setAttribute("room",room);
              session.setAttribute("year",yr);
              session.setAttribute("mb",mb);
             RequestDispatcher rd = req.getRequestDispatcher("/s2");
             rd.forward(req, res);
             
          }
          else {
            out.println("<font color='red'><center><h1>WRONG PASSWORD</h1></center></font>");  
          }
           
          /*
             */ 
            }
            
      out.close();
        }
        catch(Exception e)
        {
         out.println(e.getMessage());
        
    }
            
            
    
        
        
    }


}
