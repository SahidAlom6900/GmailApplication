package com.te.Assignment3jpqlgmail.service;

import com.te.Assignment3jpqlgmail.dao.GmailRepoImpl;
import com.te.Assignment3jpqlgmail.dao.GmailRepointer;
import com.te.Assignment3jpqlgmail.entity.Account;

public class GmailServiceImpl implements GmailServiceInter {
	private static GmailRepointer gmailRepointer= new GmailRepoImpl();

	@Override
	public String saveEmail(Account account) {
		if (account == null) {
			return null;
		}
		return gmailRepointer.saveEmail(account);
	}

	@Override
	public void showInbox(String email) {
		if(email!=null) {
			gmailRepointer.showInbox(email);
		}
	}

	@Override
	public boolean login(String email, String password) {
		if(email==null || password==null) {
			return false;
		}
		return gmailRepointer.login(email, password);
	}

	@Override
	public void compose(String fromEmail, String toEmail, String msg) {
		if(toEmail!=null) {
			gmailRepointer.compose(fromEmail, toEmail, msg);
		}
	}
	
	

}
