package es.uc3m.tiw.domains;


import java.io.Serializable;
import java.util.Set;



/**
 * The persistent class for the users database table.
 * 
 */

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String surname;
	
	//Set<Address> address;
	private String address;

	private String alias;

	private String phone;

	private String email;

	private String password;

	public User() {
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias() { return this.alias; }

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
}