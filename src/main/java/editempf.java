

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
 * Servlet implementation class editempf
 */
public class editempf extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public editempf() {
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
		Long id = Long.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String dept = request.getParameter("dept");
		String type="2";
		System.out.println(dob);
		String sel="";
 		
 		Session s = Client.getSessionFactory().openSession();
    	Transaction t=s.beginTransaction();
    	

    	 s.createQuery("update User set Name= :name, LName= :lname, DOB= :dob, Dept= :dept where id=:i").setParameter("i", id)
                .setParameter("lname", lname).setParameter("dept", dept).setParameter("dob", dob).setParameter("name", name).executeUpdate();
        //System.out.println(user);
        
    	t.commit();
    	s.close();
    	response.sendRedirect("home");
    	
	}

}
