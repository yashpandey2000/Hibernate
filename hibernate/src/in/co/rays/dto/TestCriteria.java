package in.co.rays.dto;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestCriteria {
	
	public static void main(String[] args) {
		

		//testcriteria();
		//testrestrictions();
		//testprojection();
		//testaggregatefninprojectons();
		// testORcond(); //prblm
	//	criteriaOthermethods();
	}
	
	private static void criteriaOthermethods() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Criteria cr = s.createCriteria(User.class);
		
	//cr.add(Restrictions.like("firstname", "yash"));
	//cr.addOrder(Order.asc("lastname"));
	//cr.addOrder(Order.desc("lastname"));
	
		
		
		ProjectionList p = Projections.projectionList();
		
		p.add(Projections.count("id")).add(Projections.groupProperty("id"));
	
		
		cr.setProjection(p);
	
		List l = cr.list();
		Iterator it = l.iterator();
		
		while(it.hasNext()){
			
		
			
		//	User in = (User) it.next();
			//Integer in = 	(Integer) it.next();
			//String in = (String) it.next();
			//System.out.println(in);
			

			//System.out.println(s1[1]);
			
		}
		
		s.close();
		
		
	}

	private static void testORcond() {
SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
	    Session s = factory.openSession();
		
		Criteria cr  = s.createCriteria(User.class);
	
		//ProjectionList p = Projections.projectionList();
		
		cr.add(Restrictions.or(Restrictions.eq("firstname", "yash"), Restrictions.or(Restrictions.like("lastname", "pandey"),Restrictions.eq("id", 2))));
		
		List l = cr.list();
		
		Iterator it = l.iterator();
		
		while(it.hasNext()){
	
			Object[]  s1 =   (Object[]) it.next();
			
			System.out.println(s1);
			
		}
		
		
		
	}

	private static void testaggregatefninprojectons() {
SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
	    Session s = factory.openSession();
		
		Criteria cr  = s.createCriteria(User.class);
		
		ProjectionList p = Projections.projectionList();
		
	//	p.add(Projections.count("id"));
	//	p.add(Projections.rowCount());
	//	p.add(Projections.groupProperty("firstname"));
	//  p.add(Projections.max("id"));
	//	p.add(Projections.min("id"));
	//	p.add(Projections.avg("id"));
		
		
		
		cr.setProjection(p);
		List l = cr.list();
		
		Iterator it = l.iterator();
		
		while(it.hasNext()){
		
		     // Integer in = 	(Integer) it.next();
			 //Double in = (Double) it.next();
			  //String in = (String) it.next();
			
		 //  System.out.println(in);
		}
	}

	private static void testprojection() {
		
SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
	    Session s = factory.openSession();
		
		Criteria cr  = s.createCriteria(User.class);
		
		ProjectionList p = Projections.projectionList();
		
		p.add(Projections.property("id"));
		p.add(Projections.property("firstname"));
		
		cr.setProjection(p);
		List l = cr.list();
		
		Iterator it = l.iterator();
		
		while(it.hasNext()){
			
			Object[] ob = (Object[]) it.next();
			System.out.println(ob[0]);
			System.out.println(ob[1]);
			
		}
	}

	private static void testrestrictions() {
		
SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
	    Session s = factory.openSession();
		
		Criteria cr  = s.createCriteria(User.class);
		
		cr.add(Restrictions.like("firstname", "yash"));
		cr.add(Restrictions.eq("id", 1));
		
		List l = cr.list();
		Iterator it = l.iterator();
		while(it.hasNext()){
			
			User u = (User) it.next();
			
			System.out.println(u.getFirstname());
			
			
		}
		
		
	}

	private static void testcriteria() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
	    Session s = factory.openSession();
	
	    
	    Criteria c = s.createCriteria(User.class);
	    
	   List l = c.list();
	   
	   Iterator it = l.iterator();
	   
	   while(it.hasNext()){
		   
		  User cc = (User) it.next();
		  
		  System.out.println(cc.getId()+"\t"+cc.getFirstname()+"\t"+cc.getLastname()+"\t"+cc.getUserid()+"\t"+cc.getPassword());
		
	   }
	    
		
	}


	
	

}
