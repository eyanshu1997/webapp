

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class comp
 */
public class comp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public comp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String id = request.getParameter("id");
	        String emp = request.getParameter("emp");
	        Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String sdate = dateFormat.format(date);  
	        String dat= "<!DOCTYPE html>\n"
	        		+ "<html>\n"
	        		+ "<head>\n"
	        		+ "<meta charset=\"ISO-8859-1\">\n"
	        		+ "<title>Insert title here</title>\n"
	        		+ "<link rel=\"stylesheet\"\n"
	        		+ " href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n"
	        		+ " integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n"
	        		+ " crossorigin=\"anonymous\">\n"
	        		+ "</head>\n"
	        		+ "<body>\n"
	        		+ "            \n"
	        		+ " <div class=\"container col-md-8 col-md-offset-3\" style=\"overflow: auto\">\n"
	        		+ "  <h1>Add comment</h1>\n"
	        		+ "  <form action=\"addcom\" method=\"post\">\n"
	        		+ "   <div class=\"form-group\">\n"
	        		+ "    <label for=\"uname\">Comment:</label> <input type=\"text\"\n"
	        		+ "     class=\"form-control\" id=\"com\" placeholder=\"Comment\"\n"
	        		+ "     name=\"com\" required>\n"
	        		+ "   </div>\n"
	        		+ "     <input type=\"hidden\"\n"
	        		+ "     class=\"form-control\" id=\"user\" "
	        		+ "     name=\"user\" value="+emp+" required>\n"
	        		+ "     <input type=\"hidden\"\n"
	        		+ "     class=\"form-control\" id=\"rid\" "
	        		+ "     name=\"rid\" value=\""+id+"\" required>\n"
	        		+ "     <input type=\"hidden\"\n"
	        		+ "     class=\"form-control\" id=\"date\" "
	        		+ "     name=\"date\" value=\""+sdate+"\" required>\n"
	        		+ "   <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n"
	        		+ "  </form>\n"
	        		+ " </div>\n"
	        		+ "</body>\n"
	        		+ "</html>";
	        response.setContentType("text/html");
	        response.getWriter().println(dat);
	        
	}

}
