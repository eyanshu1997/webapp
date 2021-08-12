

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class viewdept
 */
public class viewdept extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public viewdept() {
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
		List<User> users=new ArrayList<User>();
 		Session s = Client.getSessionFactory().openSession();
 			Transaction t=s.beginTransaction();
 			System.out.println(id);
		users=s.createQuery("FROM User U WHERE U.Dept = :dept1").setParameter("dept1",id)
        .list();
		t.commit();
			
	     s.close();
	     String tab="";
		if(users.size()==0)
		{
			tab+="<html><body>no users </body></html>";
		}
		else
		{
		tab+="<html><body><table class='table table-striped'>"
				+ "<thead><h4><center>Employees details</center><h4><tr><th>Firstname</th>"
				+ "<th>Lastname</th>"
				+ "<th>Dept</th>"
				+ "<th>DOB</th><th>options</th></tr>"
				+ "</thead><tbody>";
		
		for( User a : users)
		{
			if(a.getType()==2)
			{
					tab+="<tr><td>"+a.getName()+"</td><td>"+a.getLName()+"</td><td>"+a.getDept()+"</td><td>"+a.getDOB()+"</td><td><form method=\"post\" action='delemp'><input type=\"hidden\" name =\"id\" id=\"id\"value="+a.getId()+"><input type=\"submit\" value=\"delete\" placeholder=\"delete\"></form><form method='post' action='editemp'><input type=\"hidden\" name ='id' id='id' value=\""+a.getId()+"\"><input type=\"hidden\" id=\"name\" name='name' value=\""+a.getName()+"\"><input type=\"hidden\" name='lname'  id=\"lname\" value=\""+a.getLName()+"\"><input type=\"hidden\" name= 'pass' id=\"pass\" value=\""+a.getPassword()+"\"><input type=\"hidden\" name='dept'  id=\"dept\" value=\""+a.getDept()+"\"><input type=\"hidden\" name='DOB' id=\"DOB\" value=\""+a.getDOB()+"\"><input type=\"submit\" value=\"edit\" placeholder=\"edit\"></form></td></tr>";
			}
			
		}
		tab+="</tbody></table><center><a href='home'>go back</a></center></body></html>";
		}
		response.getWriter().println(tab);
		response.setContentType("text/html");
	}

}
