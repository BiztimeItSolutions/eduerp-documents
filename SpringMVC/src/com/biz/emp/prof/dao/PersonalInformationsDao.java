package com.biz.emp.prof.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.biz.emp.prof.pojo.PersonalInformationsPojo;

import com.biz.emp.prof.interfaces.IPersonalInformations;
public class PersonalInformationsDao {

	
//	@Override
	public void insertValues(Object o) throws SQLException {
		// TODO Auto-generated method stub
//ItemBean IB=(ItemBean)o;
		PersonalInformationsPojo db=(PersonalInformationsPojo)o;
		System.out.println("iside insert dao");
		//CityBean CB=(CityBean)o;
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		System.out.println(0);
		
		SessionFactory sf = conf.buildSessionFactory();
		Session s1 = sf.openSession();
		s1.beginTransaction();
		
		System.out.println(1);		
		/*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(db);
		session.getTransaction().commit();
		session.close();*/
		
s1.save(db);
		
		s1.getTransaction().commit();
		s1.flush();
		s1.close();
		System.out.println("done insert");
			}
}
