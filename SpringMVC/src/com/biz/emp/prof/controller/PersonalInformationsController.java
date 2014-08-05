package com.biz.emp.prof.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;



import com.biz.emp.prof.dao.PersonalInformationsDao;

import com.biz.emp.prof.pojo.PersonalInformationsPojo;


@Controller
public class PersonalInformationsController {

	
	@RequestMapping("/personal_information.do")
	public String Personal_Informations(@RequestParam("emp_ID") String emp_ID,
								    @RequestParam("first_name") String first_name,
								    @RequestParam("middle_name") String middle_name,
								    @RequestParam("last_name") String last_name,
								    @RequestParam("gender") String gender,
								    @RequestParam("address_line1") String address_line1,
								    @RequestParam("address_line2") String address_line2,
								    @RequestParam("city") String city,
								    @RequestParam("state") String state,
								    @RequestParam("country") String country,
								    @RequestParam("pincode") String pincode,
								    @RequestParam("email_ID") String email_ID,
								    @RequestParam("phone_number") String phone_number,
								    @RequestParam("dob") String dob,
								    @RequestParam("blood_group") String blood_group,
								    @RequestParam("marital_status") String marital_status,
								    @RequestParam("caste") String caste,
								    @RequestParam("nationality") String nationality,
								    @RequestParam("id_number") String id_number,
								    @RequestParam("pan_card_number") String pan_card_number,
								    @RequestParam("photo") String photo,
								    @RequestParam("parent_emp_id") String parent_emp_id,
								    @RequestParam("user_ID") String user_ID,
								    @RequestParam("password") String password)
								   
	{
	/*@RequestMapping("/personal_information.do")
	public String Personal_Informations(@ModelAttribute("Personal_InformationsPojo") Personal_InformationsPojo employee)
	
	{
		System.out.println("inside controller");
		try
		{
		
			System.out.println("inside controller try");
			
		//	Personal_InformationsPojo d=new Personal_InformationsPojo();
			Personal_InformationsDao dd=new Personal_InformationsDao();*/
		
		System.out.println("inside controller");
		try
		{
			System.out.println("h1");
			
			//ArrayList<Object> al = new ArrayList<Object>();
		//	al = dd.selectData();
			
			PersonalInformationsPojo d=new PersonalInformationsPojo();
			PersonalInformationsDao dd=new PersonalInformationsDao();
			
			d.setEmp_ID(emp_ID);
			d.setFirst_name(first_name);
			d.setMiddle_name(middle_name);
			d.setLast_name(last_name);
			d.setGender(gender);
			d.setAddress_line1(address_line1);
			d.setAddress_line2(address_line2);
			d.setCity(city);
			d.setState(state);
			d.setCountry(country);
			d.setPincode(pincode);
			d.setEmail_ID(email_ID);
			d.setPhone_number(phone_number);
			d.setDob(dob);
			d.setBlood_group(blood_group);
			d.setMarital_status(marital_status);
			d.setCaste(caste);
			d.setNationality(nationality);
			d.setId_number(id_number);
			d.setPan_card_number(pan_card_number);
			d.setParent_emp_id(parent_emp_id);
			d.setPhoto(photo);
			d.setUser_ID(user_ID);
			d.setPassword(password);
			
			
			dd.insertValues(d);
			
			
			System.out.println("h2");
			//dd.insertValues(employee);
			System.out.println("h3");
			
			
		}
	
		catch (SQLException e) 
		{     
			System.out.println(""+ e.getMessage());  
			
		}
		
	    finally
		{
	    	System.out.println("done");
		}

		System.out.println("h4");
                        
                        return "Education_Details.jsp";
                        
		}
	
}


	