package com.biz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManagerBook {
	public static void main(String[] args) {
		Book b1 = new Book();
		//b1.setAuthor("tan");
		b1.setFname("Sandeep");
		b1.setLname("Kumar");
		b1.setAge(1);
		
		
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session s1 = sf.openSession();
		s1.beginTransaction();
		s1.save(b1);
		s1.getTransaction().commit();
		s1.flush();
		s1.close();
		System.out.println("done");
	}
}
