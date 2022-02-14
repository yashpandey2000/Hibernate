package in.co.rays.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class TestBid {
	
	public static void main(String[] args) {
		
		//testaddauction();
		
		//tesjoin();  //(eager fetching)
	}
	
	private static void tesjoin() {
		
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		
		Session s = f.openSession();
		
		AuctionItem item = (AuctionItem) s.get(AuctionItem.class, 1);
	
		Set bid = item.getBids();
		
		Iterator it = bid.iterator();
		
		while(it.hasNext()){
			
			item =  (AuctionItem) it.next();
			
			
			System.out.println(item.getDescription());
			//System.out.println(item.getBids());
		}
		
		s.close();
		
		
	}

	private static void testaddauction() {
		
		AuctionItem ai = new AuctionItem();
		ai.setDescription("IPHONE");
		
		Bids bd = new Bids();
	    bd.setAmount("1000");
	    
		
		Bids bd1 = new Bids();
		bd1.setAmount("2000");
		
		
		Bids bd2 = new Bids();
		bd2.setAmount("3000");
		
		 
		 
		Set<Bids> bids = new HashSet();
		bids.add(bd);
		bids.add(bd1);
		bids.add(bd2);
		
		ai.setBids(bids);
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(ai);
		
		tx.commit();
		s.close();
		
		System.out.println("Done");
		
	}

	
	
	
	
}
