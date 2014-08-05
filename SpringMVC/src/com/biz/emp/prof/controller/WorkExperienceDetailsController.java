package com.biz.emp.prof.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.emp.prof.dao.WorkExperienceDetailsDao;
import com.biz.emp.prof.pojo.WorkExperienceDetailsPojo;



@Controller
public class WorkExperienceDetailsController {

	@RequestMapping("/workexperiencedetails.do")
	public String Work_Experience_Details(@RequestParam("emp_ID") String emp_ID,
		    @RequestParam("collegename") String collegename,
		    @RequestParam("universityname") String universityname,
		    @RequestParam("designation") String designation,
		    @RequestParam("startdate") String startdate,
		    @RequestParam("enddate") String enddate,
		    @RequestParam("yearofexperience") String yearofexperience)
	{
		System.out.println("inside controller");
		try
		{
			System.out.println("h1");
			
			//ArrayList<Object> al = new ArrayList<Object>();
		//	al = dd.selectData();
			
			WorkExperienceDetailsPojo d=new WorkExperienceDetailsPojo();
			WorkExperienceDetailsDao dd=new WorkExperienceDetailsDao();
			
			d.setEmp_ID(emp_ID);
			d.setCollegename(collegename);
			d.setUniversityname(universityname);
			d.setDesignation(designation);
			d.setStartdate(startdate);
			d.setEnddate(enddate);
			d.setYearofexperience(yearofexperience);
			
			dd.insertValues(d);
			
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
	                        
	                        return "Accounts_Details.jsp";
	                        
			}
	
}
