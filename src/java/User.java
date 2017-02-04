 
import java.util.Date;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;



public class User extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
        String d=(String)session.getAttribute("Coery");
         String n=(String)session.getAttribute("uname");
         
       int user_id=Integer.parseInt(d);
        
        String pass1 = request.getParameter("pass");
        String pass2 = request.getParameter("newpass");
        int p1=Integer.parseInt(pass1);
        int p2=Integer.parseInt(pass2);
        
int flag=0;
        if(p1==p2){
        try { 
           Class.forName("com.mysql.jdbc.Driver");  
  

       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
  

       PreparedStatement stmt=conn.prepareStatement("UPDATE hostel.hostel_table SET Password=? WHERE COER_ID=?  ");  
   
    stmt.setString(1,pass1);
    stmt.setInt(2,user_id);
    
     int k=stmt.executeUpdate();
     if(k!=0){
    
        //String n=(String)session.getAttribute("uname");
      
         
    out.println("<html>\n" +
"<body>\n" +
"<br></br>\n" +
"     <br></br> <br></br>\n" +
"     <br></br>\n" +
"	   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<center>\n" +
"<h1>\n" +
"YOUR ACCOUNT HAS BEEN CREATED LOGIN TO YOUR ACCOUNT\n" +
"</h1>\n" +
"<h2><a href=\"index.html\">HOME</a></h2>\n" +
"</center\n" +
"</body>\n" +
"</html>");
    }
  else
  out.println("Please enter correct entries");
      
        
   conn.close(); 
           }
  
 
        catch(Exception e) {
            System.out.println("Error");
        }
}
else
out.println("Please enter password correctly in both coloumns");
     
    }
}
