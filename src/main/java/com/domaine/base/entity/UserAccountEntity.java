package com.domaine.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "users")
public class UserAccountEntity {
	
	@Id
	@Column( length = 200)
	private String email ; 
	@Column ( name = "password", length = 200, nullable = false)
	private String password ;
	
	
	public UserAccountEntity() {
		super();
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	} 
	
	

}
