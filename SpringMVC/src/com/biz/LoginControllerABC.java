package com.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller 
public class LoginControllerABC {
	@RequestMapping("/login2.do")
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
		String fn= "null",ln= "null";
		boolean test=false;
		 
		try{
			
	        // List employees = s1.createQuery("select C.userid,C.password FROM Customertable C").list(); //HQL
	        // (Iterator iterator =employees.iterator(); iterator.hasNext();){
	        	 
	        	// Customertable b1= (Customertable) iterator.next(); 
//	        	 Customertable b1=null;
//	            fn=b1.getUserid();
//	            ln=b1.getPassword();
			System.out.println("Fetching Records from DB");
			
			tx = 	s1.beginTransaction();
			 Query qry = s1.createQuery("select c.userid,c.password FROM Customertable c");    
	         List cntctList = qry.list();          
	         Customertable[] c2 = (Customertable[]) cntctList.toArray();
	         int len=c2.length;
	     	System.out.println("length"+len);
           
                    for(int i=0; i<len; i++)
                          {
                    	
                    	System.out.println("inside for::"+i);
                    	Customertable cntct = (Customertable)c2[i]; 
                fn=cntct.getUserid();
                ln=cntct.getPassword();
	            System.out.print("user Name: " + fn); 
	            System.out.print(" password: " + ln); 
	        
	           
	         
		             
		           
		            
	            
	            if(fn.equals(uname)&&ln.equals(pw))
	            {
	            	
	        		//add db acccess         		
	        		test=true;
	        		break;
	        		
	            }
	            
	            
	            
	            
	         }//for end
	         if(test==true)
	         {
	        	 m1.addAttribute("status", "Login Successfulll!!!");
	        	
	        		return "loginsuccess.jsp";
	        		
	         }
	         else if(test==false)
	         {
	        	 m1.addAttribute("status", "Login Unsuccessfulll!!!");
	    			m1.addAttribute("uid",uname);
	    			return "Login1.jsp";
	        	 
	         }
	         tx.commit(); 
	  
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
		catch(ClassCastException e){
			 e.printStackTrace(); 
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			 e.printStackTrace(); 
		}
		finally {
	    	  s1.flush();
				s1.close();
	      }
		
		
		
		System.out.println("done");
		
		return pw;
		
	
		
	}

}
