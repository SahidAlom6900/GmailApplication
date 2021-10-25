package com.te.Assignment3jpqlgmail.service;

import com.te.Assignment3jpqlgmail.entity.Account;

public interface GmailServiceInter {
	String saveEmail(Account account);

	void compose(String fromEmail,String toEmail, String msg);

	void showInbox(String email);

	boolean login(String email, String password);
}
