

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class viewcom
 */
public class viewcom extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public viewcom() {
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
		 Session s = Client.getSessionFactory().openSession();
     	Transaction t=s.beginTransaction();
     	

     	List<Comments> coms =  s.createQuery("FROM Comments U WHERE U.rid = :userName").setParameter("userName", Integer.valueOf(id))
	                .list();
	        //System.out.println(user);
	        
     	t.commit();
     	s.close();
     	response.setContentType("text/html");
     	String tab2="<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\"><link rel=\"stylesheet\"\n"
				+ " href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n"
				+ " integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\n"
				+ " crossorigin=\"anonymous\">"
				+ "<title>Insert title here</title>"
				+ "</head>"
				+ "<body>"+"<table class='table table-striped'><thead><h4><center>Comment details</center><h4><tr><th>Id</th><th>Rid</th><th>Comment</th><th>Employee</th></tr></thead><tbody>";
		
     	for (Comments c: coms)
     	{
     			tab2+="<tr><td>"+c.getId()+"</td><td>"+c.getRid()+"</td><td>"+c.getContent()+"</td><td>"+c.getEmp()+"</td></tr>";
     			
     	}
     	if(coms.size()==0)
     		tab2+="no comments";
     	tab2+="</tbody></table></body></html>";
     	response.getWriter().println(tab2);
	}

}
