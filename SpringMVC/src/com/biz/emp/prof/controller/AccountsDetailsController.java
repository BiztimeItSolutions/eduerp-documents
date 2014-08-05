package com.biz.emp.prof.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.emp.prof.dao.AccountsDetailsDao;
import com.biz.emp.prof.pojo.AccountsDetailsPojo;

@Controller
public class AccountsDetailsController {
	
	@RequestMapping("/accountsdetails.do")
	public String Accounts_Details(@RequestParam("emp_ID") String emp_ID,
								    @RequestParam("bankname") String bankname,
								    @RequestParam("accountnumber") String accountnumber,
								    @RequestParam("ifsccode") String ifsccode,
								    @RequestParam("accounttype") String accounttype,
								    @RequestParam("branchname") String branchname)
	{
		System.out.println("inside controller");
		try
		{
			System.out.println("h1");
			
			AccountsDetailsPojo acdetails=new AccountsDetailsPojo();
			AccountsDetailsDao acdetailsdao=new AccountsDetailsDao();
			
			acdetails.setEmp_ID(emp_ID);
			acdetails.setBankname(bankname);
			acdetails.setAccountnumber(accountnumber);
			acdetails.setIfsccode(ifsccode);
			acdetails.setAccounttype(accounttype);
			acdetails.setBranchname(branchname);
			
			acdetailsdao.insertValues(acdetails);
			
			
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
                        
                        return "Successemployee.jsp";
                        
		}
		
		
		
}
								
								    

