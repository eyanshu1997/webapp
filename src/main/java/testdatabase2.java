
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.build.AllowSysOut;

public class testdatabase2 {
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

            	
            	
            	s.createNativeQuery("drop table Comments").executeUpdate();
            	//s.save(s1);
            	t.commit();
            	s.close();
            	
            	
            	s = sessionFactory.openSession();
            	t=s.beginTransaction();
            	s.createNativeQuery("drop table Report").executeUpdate();
            	//s.save(s1);
            	t.commit();
            	s.close();
            	
            	s = sessionFactory.openSession();
            	t=s.beginTransaction();
            	s.createNativeQuery("drop table Dept").executeUpdate();
            	//s.save(s1);
            	t.commit();
            	s.close();
            	
            	s = sessionFactory.openSession();
            	t=s.beginTransaction();
            	s.createNativeQuery("drop table User").executeUpdate();
            	//s.save(s1);
            	t.commit();
            	s.close();
            	
            	
            	s = sessionFactory.openSession();
            	t=s.beginTransaction();
     
            	
            	
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
       
	}
}
