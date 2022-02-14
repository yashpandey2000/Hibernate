package in.co.rays.dto;

public class Employee {
	
	public int id;
	
	public String firstname;
	public String lastname;
	
	       Address empadd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getEmpadd() {
		return empadd;
	}

	public void setEmpadd(Address empadd) {
		this.empadd = empadd;
	}
	  
	  

}
