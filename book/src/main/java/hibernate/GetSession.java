package hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GetSession {
	public GetSession() {
		// TODO Auto-generated constructor stub
	}
	
	public org.hibernate.Session getsesson(){
		StandardServiceRegistry standarRegistry = 
				new StandardServiceRegistryBuilder().configure("springhibernate/hibernate.cfg.xml").build();
			Metadata mataData = new MetadataSources(standarRegistry).getMetadataBuilder().build();
			
			SessionFactory sessionFactory = mataData.getSessionFactoryBuilder().build();
			
			org.hibernate.Session session = sessionFactory.openSession();
			session=sessionFactory.openSession();
			session.beginTransaction();
		
		return session;
		
	}
}
