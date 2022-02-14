package in.co.rays.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEmp {

	public static void main(String[] args) {

		testemp();
	}

	private static void testemp() {

		

		Address add = new Address();
		add.setCity("indore");
		add.setState("mp");
		
		Employee emp = new Employee();
		emp.setFirstname("yash");
		emp.setLastname("pandey");
		
		emp.setEmpadd(add);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(emp);
		//s.save(add);
		tx.commit();
		s.close();

		System.out.println("Done");

	}

}
