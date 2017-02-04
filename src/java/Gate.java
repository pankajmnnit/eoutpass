
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOSHI
 */
public class Gate  extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        int k=1;
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        String passno=request.getParameter("pass_no");
        try {  
            Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","");
        Statement stmt=conn.createStatement();  
        
        ResultSet rs=stmt.executeQuery("Select * from hostel.outpass_data where Outpass_No='"+passno+"'and Confirmation='Granted'"); 
    
       if (!rs.isBeforeFirst())
                {
                    out.println("<html><center><h1>OUTPASS NOT CONFIRMED BY WARDEN</h1></center></html>");
                }
       else
       {
        while (rs.next()){
        int id=rs.getInt("COER_ID");
        String name=rs.getString("NAME");
        String mb=rs.getString("Mob_No");
        String branch=rs.getString("Branch");
        String year=rs.getString("Year");
        String outpass=rs.getString("Outpass_No");
        int room=rs.getInt("Room_No");
        String in=rs.getString("TIME_IN");
        String ot=rs.getString("TIME_OUT");
        String date=rs.getString("DATE");
        int change=rs.getInt("Changed");
         session.setAttribute("myId",id);
         if(change==0)
         {
             k=0;
             break;
         }
         out.println("<html>\n" +
"<body>\n" +"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
"<br></br></br>\n" +
"<table border=\"1\" cellpadding=\"3\" cellspacing=\"3\"  bordercolor=\"#000000\"  width=\"200\" height=\"150\" >\n" +
"\n" +
"<caption><img src=\"pj.jpg\" width=\"500\" height=\"100\"></caption\n" +
"<caption>College Of Engineering Roorkee E-Outpass</caption>");
         out.println("<tr>\n" +
"<th>Outpass No:</th>\n" +
"<th>"+outpass+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Name:</th>\n" +
"<th>"+name+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>COER ID:</th>\n" +
"<th>"+id+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Year:</th>\n" +
"<th>"+year+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Hostel:</th>\n" +
"<th>AHB</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Room No</th>\n" +
"<th>"+room+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Time Out</th>\n" +
"<th>"+ot+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Time In</th>\n" +
"<th>"+in+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Branch:</th>\n" +
"<th>"+branch+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Mobile No:</th>\n" +
"<th>"+mb+"</th>\n" +
"</tr>\n" +
"<tr>\n" +
"<th>Date:</th>\n" +
"<th>"+date+"</th>\n" +
"</tr>\n" +
"<tr> \n" +
"<th colspan=\"2\">\n" +
"In case of any emergency inform on Tel:01332-279737,276797</th>\n" +
"</tr>\n" +
"\n" +
" <script type=\"text/javascript\">\n" +
"function callservlet() {\n" +
"\n" +
"  document.forms.xyz.submit();\n" +
"}\n" +
"</script>"+
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"<form name=\"xyz\" action=\"./update\" method=\"post\">"+
"</table>\n<input type=\"button\" value=\"Print this page\" onClick=\"window.print();callservlet()\">" +
"</body>\n" +
"\n" +
"</html>");
     } 
        }
       if(k==0)
       {
         out.println("you the have already printed the outpass");
       }
       
        }
        
        catch (Exception ex) {
            out.println(ex.getMessage());
        }
    }
    
    
    
}
