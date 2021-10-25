package com.te.Assignment3jpqlgmail.conn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConnection {
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateJPADemo");
	private static final EntityManager manager = factory.createEntityManager();
	private static FileInputStream inputStream;
	private static Properties properties;

	public Properties getProp() throws IOException {
		inputStream = new FileInputStream("");
		properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

	public static EntityManager getEntityManager() {
		return manager;
	}

	public static void closeProp() {
		if (inputStream != null) {
			try {
				inputStream.close();
				properties.clear();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConn() {
		try {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
