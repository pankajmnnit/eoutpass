/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOSHI
 */

public class Prev_record extends HttpServlet {

    
  int counter=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
              {
                  response.setContentType("text/html");
        PrintWriter out=response.getWriter();
     try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
            Statement stmt = con.createStatement(); 
            
            
             ResultSet rs=stmt.executeQuery("select COER_ID,Name,Room_No,Branch,Year,Date,Place,OutpassReason from hostel.records");
             if (!rs.isBeforeFirst())
             {
                 counter=1;
                 out.println("<html>\n" +
"<body>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
" <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
" <br></br>\n" +
" <br></br>\n" +
" <br></br>\n" +
" <br></br>\n" +
" <center><h1>No Record Avilable Till Now</h1></center>\n" +
"</body>\n" +
"</html>");
                 
             }
            if(counter==0)
                {
             String str="<form action=\"./ab\" method=\"post\"><table border=3 \"><tr><th>COER ID</th><th>Name</th><th>Room No</th><th>Branch</th><th>Year</th><th>Date</th><th>Place</th><th>Reason</th><th>Permission</th></tr>";
              while(rs.next())
              {
                  
                  String p=rs.getString(1);
                  str +="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td><input type=\"checkbox\" name=\"action\" value=\""+p+"\"/>&nbsp;</td></tr>";
                  
               
              }
              str +="</table><input type=\"submit\" value=\"    SUBMIT     \"></form>";  
              out.println(str);
              con.close();
             
     }
     }
     catch(Exception e)
     {
        out.println(e.getMessage()); 
     }
     }
}
