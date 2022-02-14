package in.co.rays.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestUser {
	
	public static void main(String[] args) {
		
	//	testadd();
	//	testupdate();
	//	testdelete();
	//	testget();
	//  testlist();
	//	testhql1();  // to show single data
	//	testhql2();  // to show multiple data
	 //   testmerge();
		
		
		//testnamedquery();
	}

	

	private static void testnamedquery() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Query q = s.getNamedQuery("alluser");
		
		List<User> u = q.list();
		
		Iterator it = u.iterator();
				while(it.hasNext()){
					User pojo = (User) it.next();
					System.out.println(pojo.getId());
					System.out.println(pojo.getFirstname());
					System.out.println(pojo.getLastname());
					System.out.println(pojo.getUserid());
					System.out.println(pojo.getPassword());
					
				}
				
				s.close();
		
	}



	private static void testmerge() {
		
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		User pojo = (User) s.get(User.class, 1);
	
		System.out.println(pojo.getFirstname());
		
		s.close();
		
		pojo.setFirstname("harsh");
		
		Session s1 = factory.openSession();
		
		User u1 = (User) s1.get(User.class, 1);
		
		Transaction tx = s1.beginTransaction();
		
		s1.merge(pojo);
		
		tx.commit();
		
		s1.close();
		
	}



	private static void testhql2() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Query q = s.createQuery("select u.id , u.firstname , u.lastname from User u");
		
		List<User> l = q.list();
		
		Iterator it = l.iterator();
		
		while(it.hasNext()){
			
			Object[] u =(Object[]) it.next();
			
			
			
			System.out.println(u[0]);
			System.out.println(u[1]);
			System.out.println(u[2]);
			
		}
		
		
		
		
		
		
		
	}

	private static void testhql1() {
		
SessionFactory factory = new Configuration().configure().buildSessionFactory();

Session s = factory.openSession();
		
Query q = s.createQuery("select u.id from User u");		
		
List<User> l = q.list();

Iterator it = l.iterator();

while(it.hasNext()){
	
	int id = (Integer)it.next();
	//String fn = (String) it.next();
	
	System.out.println(id);
	//System.out.println(fn);
	
}
				
	s.close();		
		
	}

	private static void testlist() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Query q = s.createQuery("from User");     //here class name came (from ___class name only__)
		
		List<User> l = q.list();
		
		Iterator it = l.iterator();
		
		User pojo;
		
		while(it.hasNext()){
			
			 pojo = (User) it.next();
			
			System.out.println(pojo.getId());
			System.out.println(pojo.getFirstname());
			System.out.println(pojo.getLastname());
			System.out.println(pojo.getUserid());
			System.out.println(pojo.getPassword());
			
			
		}
		s.close();
	
	}

	private static void testget() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		User pojo = (User) s.get(User.class, 2);
		
		System.out.println(pojo.getId());
		System.out.println(pojo.getFirstname());
		System.out.println(pojo.getLastname());
		System.out.println(pojo.getUserid());
		System.out.println(pojo.getPassword());
		
		s.evict(pojo);
	   //s.clear();                 //this 3 methods are used here to see the concept on first level cache as weel as second level in hibernate
		//s.close();
		
        User pojo1 = (User) s.get(User.class, 2);
		
		System.out.println(pojo.getId());
		System.out.println(pojo.getFirstname());
		System.out.println(pojo.getLastname());
		System.out.println(pojo.getUserid());
		System.out.println(pojo.getPassword());
		
		s.close();
	}

	private static void testdelete() {
		
     User pojo = new User();
		
		pojo.setId(3);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.delete(pojo);
		tx.commit();
		s.close();
		System.out.println("deleted");
		
	}

	private static void testupdate() {
		
		User pojo = new User();
		
		pojo.setId(1);
		pojo.setFirstname("yash");
		pojo.setLastname("pandey");
		pojo.setUserid("yashpandey2000@gmail.com");
		pojo.setPassword("Yash@2000");
		
		
SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.update(pojo);
		
		tx.commit();
		s.close();
		
		System.out.println("updated");
		
	
		
	}

	private static void testadd(){
		
		User pojo = new User();
		
		pojo.setFirstname("neha");
		pojo.setLastname("sisodiya");
		pojo.setUserid("neha123@gmail.com");
		pojo.setPassword("neha@223");
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(pojo);
		
		tx.commit();
		s.close();
		
		System.out.println("inserted");
		
	}
	

}
