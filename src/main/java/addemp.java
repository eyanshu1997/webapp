

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addemp
 */
public class addemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Userdao loginDao;

    /**
     * Default constructor. 
     */
    public addemp() {
        // TODO Auto-generated constructor stub
    	  loginDao = new Userdao();
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
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Lastname = request.getParameter("Lastname");
        String type = request.getParameter("type");
        String DOB = request.getParameter("DOB");
        String Dept = request.getParameter("dept");
        System.out.println(Lastname);
        User u2= new User();
        u2.setName(username);
        u2.setDept(Dept);
        u2.setDOB(DOB);
        u2.setLName(Lastname);
        u2.setPassword(password);
        u2.setType(Integer.parseInt(type));
        loginDao.saveUser(u2);
        response.getWriter().append("user saved");
        response.sendRedirect("home");
	}

}
