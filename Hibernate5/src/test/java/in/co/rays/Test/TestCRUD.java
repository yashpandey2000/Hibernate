package in.co.rays.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.co.rays.pojo.User;
import in.co.rays.util.Util;

public class TestCRUD {
	
	public static void main(String[] args) throws Exception {
		
		testadd();
	//	testupdate();
	//	testdelete();
	//	testget();
		
	}

	private static void testget() throws Exception {
		
		SessionFactory sf = Util.getSessionFactory();
		Session s = sf.openSession();
		
		User u = s.get(User.class, 1);
		
		System.out.println(u.getId());	
		System.out.println(u.getFirstname());
		System.out.println(u.getLastname());
		
		
		s.close();
		Util.shutdown();
		
		
	}

	private static void testdelete() throws Exception {
		
		SessionFactory sf = Util.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		User u  = new User();
		u.setId(3);
		
		s.delete(u);
		
		tx.commit();
		
		s.close();
		Util.shutdown();
		
	}

	private static void testupdate() throws Exception {
		SessionFactory sf = Util.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		User u  = new User();
		u.setId(3);
		u.setFirstname("laksh");
		u.setLastname("dixit");
		
		s.update(u);
		
		tx.commit();
		
		s.close();
		Util.shutdown();
		
		
	}

	private static void testadd() throws Exception {

		SessionFactory sf = Util.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		User u = new User();
		u.setFirstname("laksh");
		u.setLastname("metha");
		
		s.save(u);
		
		tx.commit();
		
		s.close();
		Util.shutdown();
		
		
	}

}
