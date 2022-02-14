package in.co.rays.Test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import in.co.rays.pojo.User;
import in.co.rays.util.Util;

public class TestCriteria {
	
	public static void main(String[] args) throws Exception {
		
		
		//testcriteriaquery();
		wantselecteddata();
		
		//  testnamedquery();
		
	}

	private static void testnamedquery() throws Exception {
		
		SessionFactory sf = Util.getSessionFactory();
		Session s = sf.openSession();
		
		Query q = s.createNamedQuery("alluser");
		
		List<User> u = q.getResultList();
		
		for (User u1 : u) {
			
			System.out.println(u1.getId());
			System.out.println(u1.getFirstname());
			System.out.println(u1.getLastname());
		}
		
		s.close();
		
	}

	private static void wantselecteddata() throws Exception {
		
		
		SessionFactory sf = Util.getSessionFactory();
		
		Session s = sf.openSession();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<User> root = query.from(User.class);
		
	//	query.multiselect(root.get("first_name"),root.get("id"),root.get("last_name"));
		
		query.multiselect(root.get("firstname"));
		
		Query q = s.createQuery(query);
		
		List<String> l = q.getResultList();
		
		Iterator it = l.iterator();
		while(it.hasNext()){
		
			User u  = (User) it.next();
			
		//String u = 	(String) it.next();
		
		//System.out.println(u.getId());
		System.out.println(u.getFirstname());
		//System.out.println(u.getLastname());	
			
		}
		
		
		
	}

	private static void testcriteriaquery() throws Exception {
		
		SessionFactory sf = Util.getSessionFactory();
		
		Session s = sf.openSession();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		
		// query.select(root);    //to get all record  from table
		
	    // query.select(root).where(builder.equal(root.get("id"), 1));  //to get record on the basis of id
	     
		
		
	     Query q = s.createQuery(query);
		
		List<User> l = q.getResultList();
		
		Iterator it = l.iterator();
		while(it.hasNext()){
		
		User u = (User) it.next();
		
		System.out.println(u.getId());
		System.out.println(u.getFirstname());
		System.out.println(u.getLastname());	
			
		}
	
	}

}
