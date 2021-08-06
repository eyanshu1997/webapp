<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
        try {
            if (request.getSession(false) == null || session.getAttribute("Username") == null || session.getAttribute("Username").equals(""))
            {
            	response.sendRedirect("login");
            } else {
    %>
    Welcome to
    <%out.print(session.getAttribute("Username"));
    
            }
        } catch (Exception e) {
			e.printStackTrace();
        }
    %>
    
 <div align="center">
  <h1>You have logged successfully</h1>
  
  <br>
  <br>
  <br>
  <br>
  <a href ="logout.jsp">logout</a>
 </div>

</body>
</html>