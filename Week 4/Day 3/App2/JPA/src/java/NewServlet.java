import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jpa.Contacts;

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
      
      try {
         if ("insert".equals(request.getParameter("operation")))
         {/*
            String name = request.getParameter("name");
            int tel_number = Integer.parseInt(request.getParameter("tel_number"));
            
            try
            {
               stmt.executeUpdate("INSERT INTO `contacts` (name, tel_number)"
                  + "VALUES ('"+name+"', '"+tel_number+"');" );
            }
            catch (Exception e)
            {
               out.print("<br>An account with this phone number already exist.");
               out.println("<br><br>Operation failed.");
               return ;
            }
            */
         }
         else if ("view".equals(request.getParameter("operation")))
         {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<Contacts> findAllContacts = 
               entityManager.createQuery("SELECT contact FROM Contacts AS contact", Contacts.class);
            
            findAllContacts.getResultList().stream()
               .forEach((contact) ->
               {
                  out.printf("%s %d", contact.getName(), contact.getTelNumber());
               }
            );
            
            /*
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
            rs.close();*/
         }
         out.println("<br>Operation done successfully");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         out.println("<br><br>Operation failed.");
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