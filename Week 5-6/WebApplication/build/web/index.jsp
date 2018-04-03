<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Login</title>
   </head>
   <body>
      <h2>Login Page</h2>
      <form action="NewServlet">
         Username: <input type="text" name="username" /><br/><br/>
         Password:  <input type="text" name="password" /><br/><br/>
         <input type="hidden" value="login" name="operation">
         <input type="submit" value="Login"/>
      </form>
   </body>
</html>