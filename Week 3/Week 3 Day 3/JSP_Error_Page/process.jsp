<%-- 
    Document   : process
    Created on : 26-Jul-2017, 16:05:04
    Author     : Anil
--%>

<%@ page errorPage="error.jsp" %>  

<%
String num1 = request.getParameter("n1");  
String num2 = request.getParameter("n2");  

int a = Integer.parseInt(num1);  
int b = Integer.parseInt(num2);  
double c = (double)a / b;  
out.print("division of numbers is: " + c);  
%>
