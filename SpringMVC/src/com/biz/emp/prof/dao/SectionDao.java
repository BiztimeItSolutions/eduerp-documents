package com.biz.emp.prof.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.biz.emp.prof.interfaces.ISection;
import com.biz.emp.prof.pojo.SectionPojo;

public class SectionDao implements ISection{
	
	@Override
	public void insertValues(Object o) throws SQLException {
		// TODO Auto-generated method stub
//ItemBean IB=(ItemBean)o;
		SectionPojo db=(SectionPojo)o;
		System.out.println("iside insert dao");
		//CityBean CB=(CityBean)o;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(db);
		session.getTransaction().commit();
		session.close();
			}
	
	
	
	public ArrayList<Object> selectData() throws SQLException {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from sectiondummy");
		query.setCacheable(true);
		//Query query=session.createQuery("select * from GANGADHAR.CITY");
		List<SectionPojo> list=(ArrayList)query.list();
		ArrayList<Object> al = new ArrayList<Object>(list);
		
		session.close();
		return al;
	}
	
	
	
	@Override
	public void updateSection(Object o,String columnName,int value)throws SQLException{
		
		SectionPojo db=(SectionPojo)o;
		System.out.println("inside update dao");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql= "update sectiondummy set Name='"+db.getName()+"',Active='"+db.getActive()+"',Deleted='"+db.getDeleted()+"',Effective_date='"+db.getEffective_Date()+"',Expiry_Date='"+db.getExpiry_Date()+"',Version='"+db.getVersion()+"',Created_By='"+db.getCreated_By()+"',Created_On='"+db.getCreated_On()+"',Modified_By='"+db.getModified_By()+"',Modified_On='"+db.getModified_On()+"',Version='"+db.getVersion()+"' where "+ columnName+"='"+value+"'";
		
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setCacheable(true);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();

	}
	
}
