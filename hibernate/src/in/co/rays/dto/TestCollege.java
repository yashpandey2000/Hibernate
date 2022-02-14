package in.co.rays.dto;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.w3c.dom.ls.LSInput;

public class TestCollege {
	
	public static void main(String[] args) {
		
		//testadd();
		//testjoins();
		//testorderby();
		//testaggregate();
		
		
	}

		private static void testaggregate() {
		
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
			
		    Session s = factory.openSession();
		
		    
		    Query q = s.createQuery("select count(*) from College");
		    
		    List l = q.list();
		    

		    	
		    Integer row = (Integer) l.get(0);
			  System.out.println(row);
		
		    
		    
		    s.close();
		    
		    
	}

	private static void testorderby() {
		
		  SessionFactory factory = new Configuration().configure().buildSessionFactory();
			
		    Session s = factory.openSession();
		
		    Query q = s.createQuery("from College where college_name like '%s' order by college_name");
		    
		    
		    List l = q.list();
		    
		    Iterator it = l.iterator();
		    
		    
		    while(it.hasNext()){
		    	
		    	String fn = (String) it.next();
				
		    	
		    	System.out.println(fn);
		    }
		    
		    
		    s.close();
		    
		
	}

	private static void testjoins() {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
    Session s = factory.openSession();
	
    Query q = s.createQuery("select   u.id , u.firstname , u.lastname , c.college_id , c.college_name   from  College c , User u where u.id = c.college_id");
    
    List l = q.list();
    
    Iterator it = l.iterator();
    
    while(it.hasNext()){
    	
    	Object[] u =(Object[]) it.next();
		
		
		
		System.out.println(u[0]+" \t "+u[1] + " \t "+u[2]+" \t "+u[3]+" \t "+u[4]);
	
    }
    
    
    s.close();
		
	}

	
	
	private static void testadd() {
		
		College college = new College();
		
		college.setCollege_id(3);
		college.setCollege_name("prestige");
		college.setCollege_address("mumbai");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(college);
		
		tx.commit();
		
		s.close();
		
		System.out.println("inserted");
	}
	

}
