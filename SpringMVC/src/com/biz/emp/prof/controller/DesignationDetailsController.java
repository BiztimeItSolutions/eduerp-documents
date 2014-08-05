package com.biz.emp.prof.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.emp.prof.dao.DesignationDetailsDao;
import com.biz.emp.prof.pojo.DesignationDetailsPojo;

@Controller
public class DesignationDetailsController {
	
	@RequestMapping("/designationdetails.do")
	public String Designation_Details(@RequestParam("emp_ID") String emp_ID,
								    @RequestParam("designation") String designation,
								    @RequestParam("department") String department,
								    @RequestParam("doj") String doj)
	{
								   
		System.out.println("inside controller");
		try
		{
			System.out.println("h1");
			
			DesignationDetailsPojo d=new DesignationDetailsPojo();
			DesignationDetailsDao dd=new DesignationDetailsDao();
			d.setEmp_ID(emp_ID);
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
                        
                        return "Work_Experience_Details.jsp";
                        
		}

}
