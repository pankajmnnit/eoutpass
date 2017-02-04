/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JOSHI
 */
public class Action_Warden extends HttpServlet {

     public static final String ACCOUNT_SID = "ACfb8f75f68278a098cf7b5dc2fb532844";
  public static final String AUTH_TOKEN = "48b233815c39eea809f950fda975cf6b";
   
   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession(false);
      
       
        PrintWriter out=response.getWriter();
        
        String[] checkedIds = request.getParameterValues("action");
         
         int j=checkedIds.length;
       try{ 
         Class.forName("com.mysql.jdbc.Driver");  
  
          int counter=0;  

       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
  
       Statement stmt=conn.createStatement();  
       ResultSet rs=stmt.executeQuery("Select COER_ID from hostel.outpass_data"); 
       
       
       while(rs.next())
       {
           
           counter++;
           
       }
       
       
       String Num=null;
       String pass=null;
       //out.println(counter);
       //out.println("id is "+checkedIds[1]);
       
       for(int i=0;i<counter;i++)
       {
          String str= checkedIds[i];
          PreparedStatement pr=conn.prepareStatement("UPDATE outpass_data SET Confirmation=(?),Changed=(?) WHERE COER_ID=(?)");
          pr.setString(1,"Granted");
          pr.setInt(2,1);
          pr.setString(3,str);
         pr.executeUpdate();
         int d=Integer.parseInt(str);
         
         ResultSet r=stmt.executeQuery("Select Mob_No,Outpass_No from outpass_data WHERE COER_ID="+d); 
         while (r.next())
         {
               Num=r.getString(1);
               pass=r.getString(2);
         }
         Num="+91"+""+Num;
           Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber(""+Num) ,//Reciever phone no.
        new PhoneNumber("+16574441194"), //sender phone 
        "E-Outpass@COER:Your Outpass Has Been Confirmed.Your Outpass No Is"+pass).create();  
       }
       out.println("<html><body><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
" <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />"
               + "<center><h1><a href=\"warden_login.html\">HOME</a></h1></center></body></html>");
       }
        catch(Exception e)
        {
            out.println(e.getMessage());
        }   
}
}