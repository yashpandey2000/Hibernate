package in.co.rays.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="user")
@Cache(region="personcache" , usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="alluser" , query="from User")
public class User {
	
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment" , strategy="increment")
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
    public User(){}

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
    
    
	
	
}
