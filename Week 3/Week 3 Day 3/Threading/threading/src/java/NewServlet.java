/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anil
 */
public class NewServlet extends HttpServlet {
   
   private static int balance = 1000;
   private static Object lock;

   /**
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
    * methods.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
         /* TODO output your page here. You may use following sample code. */
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet NewServlet</title>");         
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
      }
   }
   
   public void init() 
      throws ServletException
   {
      System.out.println("NewServlet");
   }
   
   public void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException
   {
      response.setContentType("text/plain");
      PrintWriter out = response.getWriter();
		
      String errorString = "";
      
      if("withdraw".equals(request.getParameter("action")))
      {
         errorString = withdraw(Integer.parseInt(request.getParameter("amount")));
      }
      else if ("deposit".equals(request.getParameter("action")))
      {
         errorString = deposit(Integer.parseInt(request.getParameter("amount")));
      }
      
      out.print(errorString);
      out.print("Balance is: " + balance);
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

   public static String withdraw(int withdrawAmount)
   {
      synchronized(lock) { // Sync causes nullPointerException
         if (withdrawAmount <= 0)
         {
            return "Withdraw amount must be positive.\n";
         }
         else if ((balance - withdrawAmount) < 0)
         {
            return "Not enough money in balance.\n";
         }
         else
         {
            try
            {
               Thread.sleep(5000);
            } catch (InterruptedException ex)
            {
               Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            balance -= withdrawAmount;
         }
      }
      return "";
   }
   
   public static String deposit(int depositAmount)
   {
      if (depositAmount <= 0)
      {
         return "Deposit amount must be positive.\n";
      }
      else
      {
         balance += depositAmount;
      }
      
      return "";
   }
}
