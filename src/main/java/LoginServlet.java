

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
    private static boolean firstrun=true;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
    	if(firstrun==true)
    	{
    		testdatabase.main(null);
    		firstrun=false;
    	}
        loginDao = new Userdao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int typ=authenticate(request, response);
            if(typ==0)
            {
            	response.setContentType("text/html");
            	response.getWriter().println("login failed.<br><br><br><a href ='login.jsp'>login again</a>");
            }
            else
            {
            	 HttpSession session=request.getSession();  
            	 String username = request.getParameter("username");
                 session.setAttribute("Username",username);  
                 session.setAttribute("type",typ);
                 response.sendRedirect("home");
            	
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
