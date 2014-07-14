package com.biz;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManagerBookRetrieve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
				
				
				
				Configuration conf = new Configuration();
				conf.configure();
				SessionFactory sf = conf.buildSessionFactory();
				Session s1 = sf.openSession();
			
				
				//
				
				Transaction tx = null;
				try{
			         tx = 	s1.beginTransaction();
			         List employees = s1.createQuery("FROM Book").list(); 
			         for (Iterator iterator =employees.iterator(); iterator.hasNext();){
			            Book b1= (Book) iterator.next(); 
			            System.out.print("Id:"  + b1.getId()); 
			            System.out.print("First Name: " + b1.getFname()); 
			            System.out.print("  Last Name: " + b1.getLname()); 
			            System.out.println(" Age: " + b1.getAge()); 
			         }
			         tx.commit();
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			    	  s1.flush();
						s1.close();
			      }
				
				
				
				System.out.println("done");
		
		


	}

}
