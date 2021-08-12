

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class home
 */
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Userdao loginDao;

    /**
     * Default constructor. 
     */
    public home() {
        // TODO Auto-generated constructor stub
        loginDao = new Userdao();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		try {
            if (session == null || session.getAttribute("Username") == null || session.getAttribute("Username").equals("")|| session.getAttribute("type") == null || session.getAttribute("type").equals(""))
            {
            	response.sendRedirect("login");
            } else {
            		
            		if((int)session.getAttribute("type")==1)
            		{
            			response.setContentType("text/html");
            			
            			BufferedReader reader = new BufferedReader(new FileReader("/home/aurav/eclipse-workspace/firstweb/src/main/webapp/admin.jsp"));
            			StringBuilder stringBuilder = new StringBuilder();
            			String line = null;
            			String ls = System.getProperty("line.separator");
            			while ((line = reader.readLine()) != null) {
            				stringBuilder.append(line);
            				stringBuilder.append(ls);
            			}
            			// delete the last new line separator
            			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            			reader.close();
            			String content = stringBuilder.toString();
            			List<User> users=loginDao.getalluser();
            			String tab="<table class='table table-striped'>"
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
            			tab+="</tbody></table>";
            			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            			   LocalDateTime now = LocalDateTime.now().minus(24,ChronoUnit.YEARS);  
            			  
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
            		 		//System.out.println(depts);
            		 		     String dopt="";
            		 		for(Dept d :depts)
            		 		{
            		 			dopt+="<option value= '"+d.getName()+"'> "+d.getName()+"</option>";
            		 		}
            		 		
            		 		String tab1="<table class='table table-striped'>"
                					+ "<thead><h4><center>Dept details</center></h4><tr><th>Name</th></tr>"
                					+ "</thead><tbody>";
                			
                			for( Dept a : depts)
                			{
                				
                						tab1+="<tr><td>"+a.getName()+"</td><td><form action='viewdept' method='post'><input type='hidden' name='id' value='"+a.getName()+"'><input type='submit' placeholder='view' value='view'></form></td></tr>";
  
                				
                			}
                			tab1+="</tbody></table>";
                			

                			
                			String tab4="<table class='table table-striped'>"
                					+ "<thead><h4><center>Admin details</center></h4><tr><th>Firstname</th>"
                					+ "</tr>"
                					+ "</thead><tbody>";
                			
                			for( User a : users)
                			{
                				if(a.getType()==1)
                				{
                						tab4+="<tr><td>"+a.getName()+"</td></tr>";
                				}
                				
                			}
                			tab+="</tbody></table>";
                			

                			List<Report> rep=new ArrayList<Report>();
            		 		try (Session s = Client.getSessionFactory().openSession()) {
            		 			Transaction t=s.beginTransaction();
            		 			 CriteriaBuilder builder = s.getCriteriaBuilder();
            		 		    CriteriaQuery<Report> criteria = builder.createQuery(Report.class);
            		 		    criteria.from(Report.class);
            		 		   rep = s.createQuery(criteria).getResultList();
            		 			t.commit();
            		 			
            		 		     s.close();
            		 		}catch (Exception e)
            		 		{
            		 			e.printStackTrace();
            		 		}
                			String tab2="<table class='table table-striped'>"
                					+ "<thead><h4><center>Rl details</center><h4><tr><th>Id</th><th>Type</th><th>Description</th><th>Date</th><th>Department</th><th>Completed Status</th></tr>"
                					+ "</thead><tbody>";
                			List<Comments> com=new ArrayList<Comments>();
            		 		try (Session s = Client.getSessionFactory().openSession()) {
            		 			Transaction t=s.beginTransaction();
            		 			 CriteriaBuilder builder = s.getCriteriaBuilder();
            		 		    CriteriaQuery<Comments> criteria = builder.createQuery(Comments.class);
            		 		    criteria.from(Comments.class);
            		 		   com = s.createQuery(criteria).getResultList();
            		 			t.commit();
            		 			
            		 		     s.close();
            		 		}catch (Exception e)
            		 		{
            		 			e.printStackTrace();
            		 		}
            		 		
                			for( Report a : rep)
                			{
                				
                				boolean	set=true;
                				String tmp1=a.getDept();
                						if(a.getStatus()==false)
                						{
                							
                							for(User u:users)
                							{
                								if(u.getType()!=2)
                								{
                								
                								//System.out.println("dept val"+a.getDept());
                								
            
	                								String tmp2=u.getDept();
	                								//System.out.println(u);
	                								if(u.getDept()!=null)
	                								if(tmp2.equals(tmp1))
	                								{
	                									boolean lset=false;
	                									for(Comments c:com)
	                									{
	                										
	                										//System.out.println("checking '"+c.getEmp()+"' '"+u.getName()+"' '"+c.getRid()+"' '"+a.getId()+"'");
	                										//System.out.println((c.getEmp().equals(u.getName())&&(int)c.getRid()==(int)a.getId()));
	                										if(c.getEmp()==u.getId()&&(int)c.getRid()==(int)a.getId())
	                										{
	                											lset=true;
	                										}
	                									}
	                									//System.out.println(lset);
	                									if(lset==false)
	                									{
	                										set=false;
	                										
	                									}
	                								}
                								}
                							}
                					
                						}
                						
                						tab2+="<tr><td>"+a.getId()+"</td><td>"+a.getType()+"</td><td>"+a.getDes()+"</td><td>"+a.getDate()+"</td><td>"+a.getDept()+"</td><td>"+set+"</td><td><form method='post' action='viewcom'><input type='hidden' id='id' name ='id' value='"+ a.getId()+"'><input type='submit' value='View comments'></form></td></tr>";
                			}
                			tab2+="</tbody></table>";
                			
                			
                			
                			
                			
                			
                			
            			response.getWriter().println(content.replace("####replace admin here####", tab4).replace("####replace here####", tab).replace("####replace dept here####", tab1).replace("####replace rl here####", tab2).replace("#maxdate#", dtf.format(now)).replace("##replace with options##", dopt));
            			
            			//response.sendRedirect("admin.jsp");
            		}
            		else
            		{
            			response.setContentType("text/html");
            			String username=(String) session.getAttribute("Username");;
            			BufferedReader reader = new BufferedReader(new FileReader("/home/aurav/eclipse-workspace/firstweb/src/main/webapp/employee.jsp"));
            			StringBuilder stringBuilder = new StringBuilder();
            			String line = null;
            			String ls = System.getProperty("line.separator");
            			while ((line = reader.readLine()) != null) {
            				stringBuilder.append(line);
            				stringBuilder.append(ls);
            			}
            			// delete the last new line separator
            			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            			reader.close();
            			String content = stringBuilder.toString();
            			
            			Session s = Client.getSessionFactory().openSession();
                    	Transaction t=s.beginTransaction();
                    	

                    	User user = (User) s.createQuery("FROM User U WHERE U.Name = :userName").setParameter("userName", username)
            	                .uniqueResult();
            	        //System.out.println(user);
            	        
                    	t.commit();
                    	s.close();
                    	
            			List<Report> rep=new ArrayList<Report>();
        		 		s = Client.getSessionFactory().openSession();
        		 			t=s.beginTransaction();
        		 			rep =  s.createQuery("FROM Report U WHERE U.dept = :dept1").setParameter("dept1",user.getDept())
        	    	                .list();
        		 			t.commit();
        		 			
        		 		     s.close();
        		 		
            			String tab2="<table class='table table-striped'><thead><h4><center>Rl details</center><h4><tr><th>Id</th><th>Type</th><th>Description</th><th>Date</th><th>comment</th></tr></thead><tbody>";
            			
    					for( Report a : rep)
            			{
    						
    						 s= Client.getSessionFactory().openSession();
    		 			t=s.beginTransaction();
    		 			//System.out.println(user.getName()+a.getId());
    		 			List<Comments> coms = s.createQuery("FROM Comments U WHERE U.rid = :rid and U.emp= :emp ").setParameter("rid",(int)a.getId()).setParameter("emp",(int)user.getId())
    	    	                .list();
    		 			t.commit();
    		 			
    		 		     s.close();
    						
    		 		     System.out.println(coms);
    				        if(coms.size()==0)
            				
            						
            				tab2+="<tr><td>"+a.getId()+"</td><td>"+a.getType()+"</td><td>"+a.getDes()+"</td><td>"+a.getDate()+"</td><td><form method='post' action='comp'><input type='hidden' id='id' name ='id' value='"+ a.getId()+"'><input type='hidden' id='emp' name ='emp' value='"+ user.getId()+"'><input type='submit' value='add comment'></form></td></tr>";
    				        else
    				        {
    				        	String conten="";
    				        	for(Comments c:coms)
    				        	{
    				        		conten+=c.getContent();
    				        	}
    				        	tab2+="<tr><td>"+a.getId()+"</td><td>"+a.getType()+"</td><td>"+a.getDes()+"</td><td>"+a.getDate()+"</td><td>"+conten+"</td></tr>";
    				        }
            			}
            			tab2+="</tbody></table>";
            			
            			response.getWriter().println(content.replace("###replace here ###",tab2));
            		}
            	
            }
 }catch(Exception e)
{
	 e.printStackTrace();
}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
