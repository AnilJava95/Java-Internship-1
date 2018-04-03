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

//import javax.servlet.http.HttpSession;

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
            String username = request.getParameter("username");
            int password = Integer.parseInt(request.getParameter("password"));
            // String isAdmin2 = request.getParameter("admin"); // test line to see value of isAdmin
            // boolean isAdmin = Boolean.valueOf(request.getParameter("admin")); // test line to see value of isAdmin
            
            try
            {
               if (Boolean.valueOf(request.getParameter("admin")) == true)
               {
                  stmt.executeUpdate("INSERT INTO `users` (username, password, admin)"
                     + "VALUES ('"+username+"', '"+password+"', true);" );
               }
               else
               {
                  stmt.executeUpdate("INSERT INTO `users` (username, password, admin)"
                     + "VALUES ('"+username+"', '"+password+"', false);" );
               }   
            }
            catch (Exception e)
            {
               //System.out.println(e);
               System.err.println( e.getClass().getName()+": "+ e.getMessage() );
               out.print("An account with this username already exists.");
               out.println("<br>Operation failed.");
               return ;
            }
            
         }
         else if ("view".equals(request.getParameter("operation")))
         {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
            while ( rs.next() )
            {
               String username = rs.getString("username");
               String password = rs.getString("password");
               out.printf( "Userame = %s", username);
               out.printf( "<br>");
               out.printf( "Password = %15d", password );
               out.printf( "<br><br>");
               out.println("<br>");
            }
            rs.close();
         }
         else if ("login".equals(request.getParameter("operation")))
         {
          
            ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
            
            while ( rs.next() )
            {
               String sqlUsername = rs.getString("username");
               String testString = request.getParameter("username"); // test line
               if (sqlUsername.equals(request.getParameter("username")))
               {
                  String sqlPassword = rs.getString("password");
                  if (sqlPassword.equals(request.getParameter("password")))
                  {
                     //HttpSession session = request.getSession();
                     request.setAttribute(sqlUsername, sqlUsername);
                     response.sendRedirect("home.jsp");
                  }
                  else
                  {
                     System.out.println("Incorrect Username and Password");
                     System.out.println("Please enter correct username and Password");
                     response.sendRedirect("index.jsp");
                  }
               }
            }
            rs.close();
         }
         
         stmt.close();
         c.close();
         out.println("<br>Operation done successfully");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage());
         out.println("<br>Operation failed.");
      }
   }

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