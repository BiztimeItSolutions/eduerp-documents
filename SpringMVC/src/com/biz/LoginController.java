package com.biz;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller 
public class LoginController {
	@RequestMapping("/login1.do")
	public String logintask(@ModelAttribute LoginBean login, Model m1)
	{
		String uname=login.getUname();
		String pw=login.getPw();
		System.out.println(uname);
		System.out.println(pw);
		
		
		/*
		if("lara".equals(uname) && "rst".equals(pw))
		{
		m1.addAttribute("status", "Login Success!!!");
		//add db acccess 
		
		
		return "loginsuccess.jsp";
		}
		else
		{
			m1.addAttribute("status", "Login Unsuccess!!!");
			m1.addAttribute("uid",uname);
			return "Login1.jsp";
		}
		
		*/
		
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session s1 = sf.openSession();
		Transaction tx = null;
		int id;
		String fn,ln;
		boolean test=false;
		try{
	         tx = 	s1.beginTransaction();
	         List employees = s1.createQuery("FROM Book").list(); //HQL
	         for (Iterator iterator =employees.iterator(); iterator.hasNext();){
	        	 
	            Book b1= (Book) iterator.next(); 
	            id= b1.getId();
	            fn=b1.getFname();
	            ln=b1.getLname();

	            System.out.print("Id:"  +id); 
	            System.out.print("First Name: " + fn); 
	            System.out.print("  Last Name: " + ln); 
	            System.out.println(" Age: " + b1.getAge()); 
	           
	            
	            if(fn.equals(uname)&&ln.equals(pw))
	            {
	            	
	        		//add db acccess         		
	        		test=true;
	        		break;
	        		
	            }
	            
	            
	            
	            
	         }//for end
	         if(test==true)
	         {
	        	 m1.addAttribute("status", "Login Success!!!");
	        	
	        		return "loginsuccess.jsp";
	        		
	         }
	         else if(test==false)
	         {
	        	 m1.addAttribute("status", "Login Unsuccess!!!");
	    			m1.addAttribute("uid",uname);
	    			return "Login1.jsp";
	        	 
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
		
		return pw;
		
	
		
	}

}
