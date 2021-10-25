package com.te.Assignment3jpqlgmail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.te.Assignment3jpqlgmail.conn.HibernateConnection;
import com.te.Assignment3jpqlgmail.entity.Account;
import com.te.Assignment3jpqlgmail.entity.Inbox;

public class GmailRepoImpl implements GmailRepointer {
	
	
		EntityManager manager = HibernateConnection.getEntityManager();
	

	@Override
	public String saveEmail(Account account) {
		manager.getTransaction().begin();
		manager.persist(account);
		manager.getTransaction().commit();
		return account.getUser_name();
	}

	@Override
	public void showInbox(String email) {
		String findByEmail="from Account where email=:email";
		Query queryAcc = manager.createQuery(findByEmail).setParameter("email", email);
		Account account = (Account) queryAcc.getSingleResult();
		String findAllInboxes="from Inbox where account=:account";
		Query queryInbox = manager.createQuery(findAllInboxes).setParameter("account", account);
		List<Inbox> list = queryInbox.getResultList();
		list.forEach(i->System.out.println(i));
	}


	@Override
	public boolean login(String email, String password) {
		String findByEmail="from Account where email=:email and password=:password";
		Query query = manager.createQuery(findByEmail).setParameter("email", email).setParameter("password", password);
		Object result = query.getSingleResult();
		if(result!=null)
			return true;
		return false;
	}


	@Override
	public void compose(String fromEmail, String toEmail, String msg) {
		String findByEmail="from Account where email=:email";
		Query query1 = manager.createQuery(findByEmail).setParameter("email", toEmail);
		Account toaAccount = (Account) query1.getSingleResult();
		if(toaAccount!=null) {
			manager.getTransaction().begin();
			manager.persist(new Inbox(msg, toaAccount));
			manager.getTransaction().commit();
		}
	}



}
