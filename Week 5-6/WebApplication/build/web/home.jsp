<!DOCTYPE html>
<html>
   <head>
      <title>Home</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>
      <h2>Home Page</h2>
      <% System.out.printf("%s", request.getAttribute("sqlUsername")); %> is at home <%-- // fix this --%>
      <br><br>
      <form action="NewServlet">
         <input type="hidden" value="view" name="operation">
         <input type="submit" value="List Users"/>
      </form>
   </body>
</html>
