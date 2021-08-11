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
try{  
	  
    response.setContentType("text/html");  
      
    if(request.getSession(false)!=null)
    {
    	session.removeAttribute("Username");
    	session.removeAttribute("type");
    	session.invalidate();
    	response.sendRedirect("login");
    }

    

            }catch(Exception e){System.out.println(e);}  
%>

</body>
</html>