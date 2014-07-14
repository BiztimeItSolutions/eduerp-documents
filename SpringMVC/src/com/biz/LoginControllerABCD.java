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
public class LoginControllerABCD {
	@RequestMapping("/login3.do")
	public String logintask(@ModelAttribute LoginBean login, Model m1)
	{
		String uname=login.getUname();
		String pw=login.getPw();
		System.out.println(uname);
		System.out.println(pw);
		
			
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session s1 = sf.openSession();
		Transaction tx = null;
		int id;
		String fn= "null",ln= "null";
		boolean test=false;
		 
		try{
			System.out.println("Fetching Records from DB");
	        List employees = s1.createQuery("select C.userid,C.password FROM Customertable C").list(); //HQL
	        System.out.println("Fetching Records from DB");
	        for(Iterator iterator =employees.iterator(); iterator.hasNext();){
	        	System.out.println("Fetching Records from DB");	 
	        	 Customertable b1= (Customertable) iterator.next(); 
	        	 System.out.println("Fetching Records from DB");
	            fn=b1.getUserid();
            ln=b1.getPassword();
			
			
			
           
                  
                    	
             
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
