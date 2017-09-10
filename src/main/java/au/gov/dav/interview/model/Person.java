package au.gov.dav.interview.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Person {
	private int id;
	private String name;
	private String email;
	private String phone;
	private Set<Claim> claims;
	
	public Person() {
	}
	
	public Person(String name, String email, String phone, Set<Claim> claims) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.claims = claims;
	}

	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the claims
	 */
	@OneToMany(mappedBy = "person",  cascade = CascadeType.ALL)
	@JsonManagedReference
	public Set<Claim> getClaims() {
		return claims;
	}

	/**
	 * @param claims the claims to set
	 */
	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}
	
}
