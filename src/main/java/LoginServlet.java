

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Userdao loginDao;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        loginDao = new Userdao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            if(authenticate(request, response)==0)
            {
            	response.setContentType("text/html");
            	response.getWriter().println("login failed.<br><br><br><a href ='login.jsp'>login again</a>");
            }
            else
            {
            	 HttpSession session=request.getSession();  
            	 String username = request.getParameter("username");
                 session.setAttribute("Username",username);  
            	RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            	dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	private int authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");

		        return (loginDao.validate(username, password));
		       
		    }

}
