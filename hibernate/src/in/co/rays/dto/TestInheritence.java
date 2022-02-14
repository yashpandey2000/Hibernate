package in.co.rays.dto;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestInheritence {
	
	public static void main(String[] args) {
		
		
		testpayment();
		
	}

	private static void testpayment() {
	
		
		
		Cheque ch = new Cheque();
		ch.setId(1);
		ch.setAmount(1200);
		ch.setCheckno(1234567);
		
		
		Credit cr = new Credit();
		cr.setId(2);
		cr.setAmount(1500);
		cr.setCctype("credit_card");
		
		
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		
		Session s = f.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(ch);
		s.save(cr);
		
		tx.commit();
		
		s.close();
	}
	

}
