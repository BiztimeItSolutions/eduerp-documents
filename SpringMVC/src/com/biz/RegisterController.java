package com.biz;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RegisterController {
	
	@RequestMapping("/reg1.do")
	public String dothereg(@RequestParam("name") String name,
			@RequestParam("userid") String userid,
			@RequestParam("password") String password, 
			@RequestParam("company") String company,
			@RequestParam("region") String region,
			@RequestParam("sector") String sector,
			@RequestParam("country") String country,
			@RequestParam("city") String city,
			@RequestParam("pincode") int pincode,
			@RequestParam("streetname") String streetname,
			@RequestParam("phoneno") int phoneno,
			@RequestParam("emailid") String emailid,Model m1 )
	{
		
		
		System.out.println(name);
		System.out.println(userid);
		System.out.println(password);
		
		
		
		//adding hibernate code
		
		Customertable c1 = new Customertable ();
		//b1.setAuthor("tan");
		c1.setCity(city);
		c1.setCompany(company);
		c1.setCountry(country);
		c1.setEmailid(emailid);
		c1.setName(name);
		c1.setPassword(password);
		c1.setPhoneno(phoneno);
		c1.setPincode(pincode);
		c1.setRegion(region);
		c1.setSector(sector);
		c1.setStreetname(streetname);
		c1.setUserid(userid);
		
		
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session s1 = sf.openSession();
		//
	
		//
		s1.beginTransaction();
		s1.save(c1);
		s1.getTransaction().commit();
		s1.flush();
		s1.close();
		System.out.println("done");
		
		
		m1.addAttribute("msg", "successful registration");
		m1.addAttribute("fn", userid);
		m1.addAttribute("ln", password);
		m1.addAttribute("age", name);
		
		return "regsuccess.jsp";
		
	}
	
	

}
