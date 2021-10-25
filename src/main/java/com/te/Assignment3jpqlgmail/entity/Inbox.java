package com.te.Assignment3jpqlgmail.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQueries({
	@NamedNativeQuery(name="getAllInboxes",query = "select * from inbox where account_user_id=?")
})
public class Inbox implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int message_id;
	private String message;
	@ManyToOne(cascade = CascadeType.ALL)
	private Account account;
	
	public Inbox(String message, Account account) {
		this.message = message;
		this.account = account;
	}
	
	
}
