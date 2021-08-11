
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class Userdao {
	 public void saveUser(User user) {
	        Transaction transaction = null;
	        try (Session session = Client.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(user);
	            // commit transaction
	            transaction.commit();
	            session.close();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	               
	            }
	            e.printStackTrace();
	        }
	    }
	 	public List<User> getalluser()
	 	{
	 		List<User> users=new ArrayList<User>();
	 		try (Session session = Client.getSessionFactory().openSession()) {
	 			Transaction t=session.beginTransaction();
	 			 CriteriaBuilder builder = session.getCriteriaBuilder();
	 		    CriteriaQuery<User> criteria = builder.createQuery(User.class);
	 		    criteria.from(User.class);
	 		     users = session.createQuery(criteria).getResultList();
	 			t.commit();
	 			session.close();
	 			
	 		}catch (Exception e) {
	 			 e.printStackTrace();
	 		}
	 		return users;
	 	}
	    public int validate(String userName, String password) {
int re=0;
	        Transaction transaction = null;
	        User user = null;
	        try (Session session = Client.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            System.out.println("reached here");
	            user = (User) session.createQuery("FROM User U WHERE U.Name = :userName").setParameter("userName", userName)
	                .uniqueResult();
	            	System.out.println(user);
	            if (user != null && user.getPassword().equals(password)) {	     
	                 re=user.getType();
	            }
	            // commit transaction
	            transaction.commit();
	            session.close();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return re;
	    }
}
