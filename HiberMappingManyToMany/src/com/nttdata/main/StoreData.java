package com.nttdata.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.nttdata.domain.Delegate;
import com.nttdata.domain.Event;
public class StoreData {  
public static void main(String[] args) {  
	

	Configuration configuration = new Configuration();
	configuration.configure();
    final ServiceRegistry serviceRegistry=  new StandardServiceRegistryBuilder()
	.applySettings(configuration.getProperties()).build();

    final SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    Session session =sessionFactory.openSession();
    Transaction t=session.beginTransaction();  
      
    Event e1=new Event();
    e1.setEventName("java");
    
    Event e2=new Event();
    e2.setEventName("web");
    
    Event e3=new Event();
    e3.setEventName("advJava");
    
    Delegate d1=new Delegate();
    d1.setDelegateName("Alex");
    
    Delegate d2=new Delegate();
    d2.setDelegateName("Bob");
  
    Delegate d3=new Delegate();
    d3.setDelegateName("Zia");
    
    e1.getDelegates().add(d1);
    e1.getDelegates().add(d2);
    
    e2.getDelegates().add(d1);
    e2.getDelegates().add(d3);
    
    e3.getDelegates().add(d2);
    e3.getDelegates().add(d3);
    session.save(d1);
    session.save(d2);
    session.save(d3);
    
    session.save(e1);
    session.save(e2);
    session.save(e3);
    t.commit();  
    session.close();  
    System.out.println("success");  
}  
}  