package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.CoursePojo;


@Controller
public class CourseController {
	@RequestMapping("/course.do")
	public String Course(@RequestParam("courseid") String Course_ID,
			@RequestParam("coursename") String Course_Name,
			@RequestParam("coursetype") String Course_Type,Model m1)
{
		
		
		System.out.println(Course_ID);
		System.out.println(Course_Name);
		System.out.println(Course_Type);
		
		
		
		//adding hibernate code
		
		CoursePojo c1 = new CoursePojo();
		System.out.println("h1");
		//b1.setAuthor("tan");
		c1.setCourse_ID(Course_ID);
		c1.setCourse_Name(Course_Name);
		c1.setCourse_Type(Course_Type);
		
		System.out.println("h2");
		
		Configuration conf = new Configuration();
		System.out.println("h2.1");
		conf.configure();
		System.out.println("h3");
		SessionFactory sf = conf.buildSessionFactory();
		Session s1 = sf.openSession();
		//
		System.out.println("h4");
		//
		s1.beginTransaction();
		s1.save(c1);
		System.out.println("h5");
		s1.getTransaction().commit();
		System.out.println("h6");
		s1.flush();
		s1.close();
		System.out.println("done");
		
		
		m1.addAttribute("msg", "successful registration");
		m1.addAttribute("fn",Course_ID );
		m1.addAttribute("ln",Course_Name );
		m1.addAttribute("age", Course_Type);
		
		return "Course.jsp";
		
	}
	

}
