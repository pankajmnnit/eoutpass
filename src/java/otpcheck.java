
 
import java.util.Date;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;



public class otpcheck extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
       String d=(String)session.getAttribute("Coery");
        String n=(String)session.getAttribute("uname");
         
     //  int user_id=Integer.parseInt(d);
     //   String f_name = request.getParameter("fname");
        String otp1 = request.getParameter("ottp");
        //String pass2 = request.getParameter("newpass");
      
        try { 
           Class.forName("com.mysql.jdbc.Driver");  
  
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
  

        Statement stmt=conn.createStatement();  
       
  
 
       ResultSet rs=stmt.executeQuery("Select Otp from hostel.hostel_table");  
        //HttpSession session=request.getSession(true);
        session.setAttribute("coer",d);
   
        
      
         while(rs.next())  {
         
         
         
         String otp2=rs.getString(1);
         
          
        
     if(otp1.equals(otp2)){
     
         
        
           
      session.setAttribute("Coery",d);
     session.setAttribute("uname",n);
  
     
      RequestDispatcher view = request.getRequestDispatcher("new_user.html");
   
      
       view.forward(request, response);
         }
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
"OTP DOES NOT MATCH PLEASE TRY AGAIN\n" +
"</h1>\n" +
"<h2><a href=\"index.html\">HOME</a></h2>\n" +
"</center\n" +
"</body>\n" +
"</html>");
         }
     }
     
 



conn.close(); 
}
  
 
        catch(Exception e) {
            System.out.println("Error");
        }
     
    }  
}

