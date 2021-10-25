package com.te.Assignment3jpqlgmail.main;

import java.util.Scanner;

import com.te.Assignment3jpqlgmail.entity.Account;
import com.te.Assignment3jpqlgmail.service.GmailServiceImpl;
import com.te.Assignment3jpqlgmail.service.GmailServiceInter;

public class GmailApplication {
	private static boolean outerQuit;
	private static GmailServiceInter gmailServiceInter = new GmailServiceImpl() ;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while (!outerQuit) {
			System.out.println("Press 1 or press 2");
			String key = sc.next().toLowerCase().trim();
			switch (key) {
			case "1":
				System.out.println("Enter the email and password");
				String fromEmail=sc.next();
				String password=sc.next();
				
				while (gmailServiceInter.login(fromEmail, password)) {
					
					System.out.println("Press A or press B");
					String choose = sc.next().toUpperCase().trim();
					switch (choose) {
					case "A":
						System.out.println("Enter the email and message");
						String toEmail=sc.next();
						sc.nextLine();
						String msg=sc.nextLine();
						gmailServiceInter.compose(fromEmail,toEmail, msg);
						break;

					case "B":
						gmailServiceInter.showInbox(fromEmail);
						break;

					default:
						break;
					}
				}

				break;
			case "2":
				System.out.println("Enter the user name ,password and email");
				String userName=sc.next();
				String password1=sc.next();
				String email=sc.next();
				Account account=new Account(userName, password1, email);
				String saveEmail = gmailServiceInter.saveEmail(account);
				System.out.println(saveEmail);
				break;

			default:
				
				break;
			}

		}

	}
}
