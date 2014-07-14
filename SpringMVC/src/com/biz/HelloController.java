package com.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String sayHello()
	{
		System.out.println("from SayHello");
		return "success.jsp";
	}
	
	
	@RequestMapping("/hello1.do")
	public String sayHelloAgain()
	{
		System.out.println("from SayHelloAgain");
		return "success.jsp";
	}
	
	@RequestMapping("/hello3.do")
	public String test1(Model m1)
	{
		m1.addAttribute("msg", "Spring Tech");
		
		return "testsuccess.jsp";
		
		
	}

	/*
	@RequestMapping("/login.do")
	public String authenticate(@RequestParam("username") String uid,@RequestParam("password") String password, Model m1)
		
		{
		
		System.out.println(uid);
		System.out.println(password);
		
		if("lara".equals(uid) && "rst".equals(password))
		{
		m1.addAttribute("status", "Login Success!!!");
		//add db acccess 
		
		return "loginsuccess.jsp";
		}
		else
		{
			m1.addAttribute("status", "Login Unsuccess!!!");
			m1.addAttribute("uid",uid);
			return "Login.jsp";
		}
		
		
	}
	
*/
	
	@RequestMapping("/reg.do")
	public String dothereg(@RequestParam("fname") String fn,@RequestParam("lname") String ln,@RequestParam("age") int age, @RequestParam("skills") String[] sk, Model m1 )
	{
		System.out.println(fn);
		System.out.println(ln);
		System.out.println(age);
		System.out.println(Arrays.toString(sk));
		
		
		//adding hibernate code
		
		Book b1 = new Book();
		//b1.setAuthor("tan");
		b1.setFname(fn);
		b1.setLname(ln);
		b1.setAge(age);
		
		
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session s1 = sf.openSession();
		//
	
		//
		s1.beginTransaction();
		s1.save(b1);
		s1.getTransaction().commit();
		s1.flush();
		s1.close();
		System.out.println("done");
		
		
		m1.addAttribute("msg", "successful registration");
		m1.addAttribute("fn", fn);
		m1.addAttribute("ln", ln);
		m1.addAttribute("age", age);
		
		return "regsuccess.jsp";
		
	}
	
	
	
	

}

