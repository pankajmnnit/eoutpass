/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.text.DateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;
import static java.lang.System.exit;
import java.security.SecureRandom;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Legen
 */
public class Myservlet extends HttpServlet
{
 protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
 {
   String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   String CD="0123456789";
   SecureRandom rnd = new SecureRandom();

   StringBuilder sb = new StringBuilder(7);
   for( int i = 0; i < 2; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 for( int i = 0; i < 2; i++ ) 
      sb.append( CD.charAt( rnd.nextInt(CD.length()) ) );
 for( int i = 0; i < 3; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 
    
   String outpass=sb.toString(); 
      HttpSession session=request.getSession(false); 
    
     PrintWriter out=response.getWriter();
    int c=(Integer)session.getAttribute("id");
   
   
    
     
     
    // int sid=Integer.parseInt(id);
//String sid=request.getParameter("id");
String reason=request.getParameter("userReason");
String place=request.getParameter("userPlace");
String time1=request.getParameter("userTimein");
String time2=request.getParameter("userTimeout");
try{
        
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
     Date date = new Date();
    Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
   // PreparedStatement pr=conn.prepareStatement("INSERT INTO sed.joshi VALUES (?,'roorkee'',)");
    PreparedStatement pr=conn.prepareStatement("INSERT INTO hostel.outpass_data VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
    
    pr.setInt(1,c);
    
    pr.setString(2,(String)session.getAttribute("uname"));
     
    pr.setString(3,(String)session.getAttribute("fnam"));
    pr.setString(4,(String)session.getAttribute("mb"));
   
    pr.setString(5,(String)session.getAttribute("branch"));
    pr.setInt(6,(Integer)session.getAttribute("year"));
      pr.setString(7,outpass);
    pr.setInt(8,(Integer)session.getAttribute("room"));
   // pr.setTime(8,time.valueOf("12:00:00"));
   // pr.setTime(9,time.valueOf("20:00:00"));
    pr.setString(9,time1);
    pr.setString(10,time2);
    pr.setString(11,reason);
    pr.setString(12,"pending");
  
   
    pr.setString(13,dateFormat.format(tomorrow));
   // pr.setDate(13,java.sql.Date.valueOf("2014/11/22"));
    pr.setString(14,place);
    pr.setInt(15,0);
    int k=pr.executeUpdate();
    conn.close();
    if(k!=0)
    {
        //out.println("successful");
        out.println("<html><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />"
                + "<br></br><br></br><br></br><center><h1>SUBMISSION SUCCESSFULL <br></br>YOU WILL RECEIVE MSG AFTER YOUR OUTPASS REQUEST IS CONFIRMED<br></br><br></br><center><a href=\"index.html\" style=\"\">Back </a></center></h1></center></body></html>");
    }
    else{
        out.println("unsuccessful");
    }
}
 catch(Exception e) {
         out.println(e.getMessage());
        }
}
}
