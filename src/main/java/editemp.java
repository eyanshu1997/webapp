

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Servlet implementation class editemp
 */
public class editemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public editemp() {
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
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("DOB");
		String dept = request.getParameter("dept");
		String type="2";
		System.out.println(dob);
		String sel="";
		List<Dept> depts=new ArrayList<Dept>();
 		try (Session s = Client.getSessionFactory().openSession()) {
 			Transaction t=s.beginTransaction();
 			 CriteriaBuilder builder = s.getCriteriaBuilder();
 		    CriteriaQuery<Dept> criteria = builder.createQuery(Dept.class);
 		    criteria.from(Dept.class);
 		   depts = s.createQuery(criteria).getResultList();
 			t.commit();
 			
 		     s.close();
 		}catch (Exception e)
 		{
 			e.printStackTrace();
 		}
 		
 	    String dopt="<option value= '"+dept+"'> "+dept+"</option>";;
 		for(Dept d :depts)
 		{
 			if(!d.getName().equals(dept))
 			dopt+="<option value= '"+d.getName()+"'> "+d.getName()+"</option>";
 		}
 		
		String h="<html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.cs\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"> </head>	<body>";
		
		String form="<div class=\"container  col-md-4\" ><form action=\"addemp\" method=\"post\">"
				+ "   <div class=\"form-group\">"
				+ "    <label for=\"uname\">Name:</label> <input type=\"text\""
				+ "     class=\"form-control\" id=\"username\" placeholder=\""+name
				+ "\"     name=\"username\" required>"
				+ "    <label for=\"uname\">Lastname:</label> <input type=\"text\""
				+ "     class=\"form-control\" id=\"Lastname\" placeholder=\""+lname
				+ "\"     name=\"Lastname\" required>"
				+ "  <input type='hidden' id='type' value='2' >"
				+ "    <label for=\"uname\">Dept :</label> <select for=\"uname\" id=\"dept\" name=\"dept\"required>"
				+ "##replace with options##"
				+ "</select>"
				+ "    <label for=\"uname\">DOB:</label> <input type=\"date\""
				+ "     class=\"form-control\" id=\"DOB\" placeholder='"+dob.strip()+"'value='"+dob.strip()
				+ "' name=\"DOB\" max=\"#maxdate#\" required>\n"
				+ "     </div>"
				+ "   <button type=\"submit\" class=\"btn btn-primary\">Submit</button>"
				+ "  </form></div>";
		form=form.replace("##replace with options##", dopt);
		h+=form;
		h+="</body></html>";
		response.getWriter().println(h);
		response.setContentType("text/html");
		
	}

}
