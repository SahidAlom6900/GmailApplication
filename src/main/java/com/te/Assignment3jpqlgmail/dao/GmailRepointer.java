package com.te.Assignment3jpqlgmail.dao;

import com.te.Assignment3jpqlgmail.entity.Account;

public interface GmailRepointer {
	String saveEmail(Account account);

	void compose(String fromEmail, String toEmail, String msg);

	void showInbox(String email);

	boolean login(String email, String password);
}
