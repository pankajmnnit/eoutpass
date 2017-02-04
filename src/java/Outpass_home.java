/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JOSHI
 */
public class Outpass_home extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
          try{
              res.setContentType("text/html");  
        PrintWriter out = res.getWriter();  
          
          //String n=req.getParameter("uname");
        HttpSession session=req.getSession(false);
        String n=(String)session.getAttribute("uname");
        
        
            
   out.println("<!DOCTYPE html>\n" +
"<html lang='en'>\n" +
"<head>\n" +
"<center>\n" +
"<br>\n" +
"</br><head><h1>OUTPASS HOME</h1></head></center>\n" +
"    <meta charset=\"UTF-8\" /> \n" +
"	 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <title>\n" +
"       COER E-OUTPASS\n" +
"    </title>\n" +
"	<br></br>\n" +
"  \n" +
"  \n" +
"  \n" +
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"</head>\n" +
"<body>\n" +
" <h2>Welcome :"+n+"\n</h2><br></br><br></br>\n" +
"\n" +
"  <div class=\"pg\">\n" +
"  <div class=\"inset\">\n" +
"  \n" +
"  \n" +
"  \n" +
"   <form action=check method=post>\n" +
"\n" +
" \n" +
" <p class=\"p-container\"> <button  class=\"button button-primary\"type=submit name=reqout class=button button-block/>Request New Outpass</button></p>\n" +
" \n" +
" </form>\n" +
" \n" +
"  <br></br>\n" +
"  <br></br>\n" +
"  \n" +
"  \n" +
"    <form action=status method=post>\n" +
"\n" +
"  </br>\n" +
" \n" +
"  \n" +
"  <p class=\"p-container\"><button type=submit  class=\"button button-primary\" name=reqout class=button button-block/>Check outpass Status</button></p>\n" +
" \n" +
" </form>\n" +
"  <br></br>\n" +
"  <p class=\"p-container\">\n" +
"  <span><a href=\"signupform.html\"><font color=\"white\">Change Password</font></a></span>\n" +
"  <br></br></p>\n" +
"  </div>\n" +
"  </div>\n" +
"  \n" +
" \n" +
"  \n" +
"    \n" +
"  </p>\n" +
" \n" +
"\n" +
"\n" +
"</body>\n" +
"</html>");
   




         out.close(); 
          }
           catch(Exception e)
           {
               
    }  
          
        
        
        
        
        
        
        
        
    }

}
