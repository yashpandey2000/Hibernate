package in.co.rays.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import in.co.rays.pojo.User;
import in.co.rays.util.Util;

public class EnableSecondLevelCache {
	
	public static void main(String[] args) throws Exception {
		
		testsecondlevelcache();
	}

	private static void testsecondlevelcache() throws Exception {
		
		SessionFactory sf = Util.getSessionFactory();
		
		Session s = sf.openSession();
		
		User u  = s.get(User.class,1);
		
		System.out.println(u.getId());
		System.out.println(u.getFirstname());
		System.out.println(u.getLastname());
		
		s.evict(u);
		//s.clear();
		//s.close();
		
        User u1  = s.get(User.class,1);
		
		System.out.println(u1.getId());
		System.out.println(u1.getFirstname());
		System.out.println(u1.getLastname());
		
		
		s.close();
	}

}
