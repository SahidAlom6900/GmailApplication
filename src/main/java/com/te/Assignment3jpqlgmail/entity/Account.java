package com.te.Assignment3jpqlgmail.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String user_name;
	private String password;
	private String email;
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
//	private List<Inbox> inbox;
	
	public Account(String user_name, String password, String email) {
		this.user_name = user_name;
		this.password = password;
		this.email = email;
	}
	
}
