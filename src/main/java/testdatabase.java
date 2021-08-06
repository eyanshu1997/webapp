
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class testdatabase {
	static SessionFactory sessionFactory;
	public static void main(String[] args) {
        if (sessionFactory == null) {
            try {
            	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            	Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            	sessionFactory= metaData.getSessionFactoryBuilder().build();
            	System.out.println("created session");
            	Session s = sessionFactory.openSession();
            	Transaction t=s.beginTransaction();
            	User s1=new User ();
            	s1.setId(1);
            	s1.setName("eya");
            	s1.setPassword("123");
            	s1.setType(1);
            	s.save(s1);
            	t.commit();
            	s.close();
            	s = sessionFactory.openSession();
            	t=s.beginTransaction();
            	
            	User user = (User) s.createQuery("FROM User U WHERE U.name = :userName").setParameter("userName", "eya")
    	                .uniqueResult();
    	        System.out.println(user);
            	t.commit();
            	s.close();
    	            	
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
       
	}
}
