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
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAPU"); // Creating entity manager factory
      EntityManager entityManager = entityManagerFactory.createEntityManager(); // Creating entity manager
      
      // Creating a query with entity methods. write "entityManeger." to see methods
      TypedQuery<Contacts> findAllContacts = entityManager.createQuery("SELECT contact FROM Contacts AS contact", Contacts.class);
      
      // Servlet code
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      try {
         out.print("Opened database successfully<br><br><br>");
         
         if ("view".equals(request.getParameter("operation")))
         {
            out.print("Contacts table of test Database:<br><br>");
            out.printf("%s%s%n", "Contact name", "Contact tel number<br>");
            
            // Executing a quesry with no parameters. If you want to add parameters use queryname.setParameter
            findAllContacts.getResultList().stream().forEach((contact) ->
               {
                  out.printf("%s__________%d<br>", contact.getName(), contact.getTelNumber());
               }
            );
         }
         
         entityManager.close();
         out.println("<br><br>Operation done successully");
         
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