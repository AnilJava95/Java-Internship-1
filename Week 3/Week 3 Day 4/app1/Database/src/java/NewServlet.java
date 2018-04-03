import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

   /**
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
    * methods.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs[[[[[
    */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
   {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("com.mysql.jdbc.Driver");
         c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
            "root", "");
         System.out.println("Opened database successfully");
      
         stmt = c.createStatement();
         
         if ("insert".equals(request.getParameter("operation")))
         {
            String name = request.getParameter("name");
            int tel_number = Integer.parseInt(request.getParameter("tel_number"));
            
            try
            {
               stmt.executeUpdate("INSERT INTO `contacts` (name, tel_number)"
                  + "VALUES ('"+name+"', '"+tel_number+"');" );
            }
            catch (Exception e)
            {
               out.print("An account with this phone number already exist.");
               out.println("<br>Operation failed.");
               return ;
            }
            
         }
         else if ("view".equals(request.getParameter("operation")))
         {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM contacts;" );
            while ( rs.next() )
            {
               String name = rs.getString("name");
               int telNumber = Integer.parseInt(rs.getString("tel_number"));
               out.printf( "Name = %s", name);
               out.printf( "<br>");
               out.printf( "Tel Number = %15d", telNumber );
               out.printf( "<br><br>");
               out.println("<br>");
            }
            rs.close();
         }
         stmt.close();
         c.close();
         out.println("<br>Operation done successfully");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         out.println("<br>Operation failed.");
      }
   }
      
      /*out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet NewServlet</title>");         
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");*/

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   /**
    * Handles the HTTP <code>GET</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      processRequest(request, response);
   }

   /**
    * Handles the HTTP <code>POST</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      processRequest(request, response);
   }

   /**
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>
}