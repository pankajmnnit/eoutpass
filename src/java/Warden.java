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

public class Warden extends HttpServlet {

    
  int counter=0;
    int temp=0;
    for(int i=0;i<10;i++);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
              {
                  response.setContentType("text/html");
        PrintWriter out=response.getWriter();
     try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
            Statement stmt = con.createStatement(); 
            
            
             ResultSet rs=stmt.executeQuery("select COER_ID,Name,Room_No,Branch,Year,Date,Place,OutpassReason from hostel.outpass_data where Confirmation='pending' ");
             if (!rs.isBeforeFirst())
             {
                 counter=1;
                 out.println("<html><body bgcolor='#0097A7'><br></br><br></br><br></br><center><h1>NO OUTPASS FILLED BY STUDENTS</h1></center></body></html>");
                 
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
