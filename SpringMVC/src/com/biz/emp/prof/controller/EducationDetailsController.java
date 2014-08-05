package com.biz.emp.prof.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.emp.prof.dao.EducationDetailsDao;
import com.biz.emp.prof.dao.PersonalInformationsDao;
import com.biz.emp.prof.pojo.EducationDetailsPojo;
import com.biz.emp.prof.pojo.PersonalInformationsPojo;


@Controller
public class EducationDetailsController {

	@RequestMapping("/educationdetails.do")
	public String Personal_Informations(@RequestParam("emp_ID") String emp_ID,
		    @RequestParam("degreename") String degreename,
		    @RequestParam("universityname") String universityname,
		    @RequestParam("percentage") String percentage,
		    @RequestParam("yearofpassing") String yearofpassing,
		    @RequestParam("collegename") String collegename,
		    @RequestParam("educationtype") String educationtype,
		    @RequestParam("employeetype") String employeetype)
		   
{
		System.out.println("inside controller");
		try
		{
			System.out.println("h1");
			
			//ArrayList<Object> al = new ArrayList<Object>();
		//	al = dd.selectData();
			
			EducationDetailsPojo d=new EducationDetailsPojo();
			EducationDetailsDao dd=new EducationDetailsDao();
			
			d.setEmp_ID(emp_ID);
			d.setDegreename(degreename);
			d.setUniversityname(universityname);
			d.setPercentage(percentage);
			d.setYearofpassing(yearofpassing);
			d.setCollegename(collegename);
			d.setEducationtype(educationtype);
			d.setEmployeetype(employeetype);
			
			
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
                        
                        return "Designation_Details.jsp";
                        
		}
}
