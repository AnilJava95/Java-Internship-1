<!DOCTYPE html>
<html>
   <head>
      <title>Registration</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>
      <h2>Registration Page</h2> <br>
      <form action="NewServlet">
         Username: <input type="text" name="username" /> <br/><br/>
         Password: <input type="text" name="password" /> <br/><br/>
         Admin:    <input type="checkbox" name="admin" value="true"> <br/><br/>
         <input type="hidden" value="insert" name="operation">
         <input type="submit" value="Sign Up"/>
      </form>
   </body>
</html>