package in.co.rays.dto;

import java.util.Set;

public class AuctionItem {
	
	public int id;
	
	public Set<Bids> bids;
	
	public String Description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Bids> getBids() {
		return bids;
	}

	public void setBids(Set<Bids> bids) {
		this.bids = bids;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	

}
