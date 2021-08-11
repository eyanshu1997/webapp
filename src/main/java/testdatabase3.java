

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.build.AllowSysOut;


public class testdatabase3 {
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
            	s = Client.getSessionFactory().openSession() ;
	 			t=s.beginTransaction();
	 			List<Comments> coms = s.createQuery("FROM Comments U WHERE U.rid = :rid and U.emp= :emp ").setParameter("rid",8).setParameter("emp","emp4")
    	                .list();
	 			
    	        System.out.println(coms);

    	        
    	        	if(coms.size()==0)
    	        		System.out.println("empty");
    	       for(Comments com:coms)
    	       {
    	    	   System.out.println(com.getContent());
    	       }
            	t.commit();
            	s.close();
            	
            	System.out.println("done");
     
            	
            	
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
       
	}
}