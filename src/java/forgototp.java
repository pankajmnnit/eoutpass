
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
 import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.io.*;
import java.security.SecureRandom;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;



public class forgototp extends HttpServlet {
     public static final String ACCOUNT_SID = "ACfb8f75f68278a098cf7b5dc2fb532844";
  public static final String AUTH_TOKEN = "48b233815c39eea809f950fda975cf6b";
  

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
         String AB = "9876543210";
   String CD="0123456789";
   SecureRandom rnd = new SecureRandom();

   StringBuilder sb = new StringBuilder(4);
   for( int i = 0; i < 1; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 for( int i = 0; i < 2; i++ ) 
      sb.append( CD.charAt( rnd.nextInt(CD.length()) ) );
 for( int i = 0; i < 1; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
 
    
   String ott=sb.toString();
        String uid = request.getParameter("id");
       long user_id=Integer.parseInt(uid);
       
       
    
 
int flag=0;
    
        try { 
           Class.forName("com.mysql.jdbc.Driver");  
  
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
  

        Statement stmt=conn.createStatement();  
       
  
 
       ResultSet rs=stmt.executeQuery("Select COER_ID,Mob_No,DOB,Name,Password from hostel.hostel_table");  
        HttpSession session=request.getSession(true); 
        session.setAttribute("coer",uid);
   
              

      
         while(rs.next())  {
         
         long coer=rs.getInt(1);
         String Coer_id=String.valueOf(coer);
         String mob=rs.getString(2);
        
         
         String d1=rs.getString(3);
         String n=rs.getString(4);
         String pass=rs.getString(5);
          
          
     if((user_id==coer)){
     
         flag=1;
         if(pass!=null){
         mob="+91"+""+mob;
         out.println(mob);
      session.setAttribute("Coery",Coer_id);
     session.setAttribute("uname",n);
  
   PreparedStatement stm=conn.prepareStatement("UPDATE hostel.hostel_table SET Otp=? WHERE COER_ID=?"); 
   stm.setString(1,ott);
    stm.setLong(2,user_id);
    
     int k=stm.executeUpdate();
     if(k!=0){
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber(""+mob) ,//Reciever phone no.
        new PhoneNumber("+16574441194"), //sender phone 
        "E-Outpass@COER:Your One Time Password (OTP) is  :  "+ott).create();
      RequestDispatcher view = request.getRequestDispatcher("signupotp.html");
   
      
       view.forward(request, response);
         }
     else{
     out.println("Internal Error");
     }}
         else{
                   out.println("<html>\n" +
"<body>\n" +
"<br></br>\n" +
"     <br></br> <br></br>\n" +
"     <br></br>\n" +
"	   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<center>\n" +
"<h1>\n" +
"YOU ARE NOT REGISTERED YET\n" +
"</h1>\n" +
"<h2><a href=\"index.html\">HOME</a></h2>\n" +
"</center\n" +
"</body>\n" +
"</html>");
         }
     }}
     
 


if(flag==0){
                       out.println("<html>\n" +
"<body>\n" +
"<br></br>\n" +
"     <br></br> <br></br>\n" +
"     <br></br>\n" +
"	   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<center>\n" +
"<h1>\n" +
"PLEASE ENTER VALID ENTRIES\n" +
"</h1>\n" +
"<h2><a href=\"index.html\">HOME</a></h2>\n" +
"</center\n" +
"</body>\n" +
"</html>");
}
conn.close(); 
}
  
 
        catch(Exception e) {
            System.out.println("Error");
        }
     
    }  
}
