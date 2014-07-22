package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.dao.SectionDao;
import com.pojo.SectionPojo;
import com.interfaces.ISection;

@Controller
public class SectionController {
	

	@RequestMapping("/Section.do")
	public String Section(@RequestParam("Section_ID") int section_ID,
								    @RequestParam("Name") String name,
								    @RequestParam("Active") String active,
								    @RequestParam("Deleted") String deleted,
								    @RequestParam("Effective_Date") String effective_Date,
								    @RequestParam("Expiry_Date") String expiry_Date,
								    @RequestParam("Version") String version,
								    @RequestParam("Created_By") String created_By,
								    @RequestParam("Created_On") String created_On,
								    @RequestParam("Modified_By") String modified_By,
								    @RequestParam("Modified_On") String modified_On)
	{
		try
		{
		
			
			
			SectionPojo d=new SectionPojo();
			SectionDao dd=new SectionDao();
			
			System.out.println("h1");
			
			ArrayList<Object> al = new ArrayList<Object>();
			al = dd.selectData();
			
			
			d.setSection_ID(section_ID);
			d.setName(name);
			d.setActive(active);
			d.setDeleted(deleted);
			d.setEffective_Date(effective_Date);
			d.setExpiry_Date(expiry_Date);
			d.setVersion(version);
			d.setCreated_By(created_By);
			d.setCreated_On(created_On);
			d.setModified_By(modified_By);
			d.setModified_On(modified_On);
			
			System.out.println("h2");
			dd.insertValues(d);
			System.out.println("h3");
			dd.updateSection(d, "Section_ID", section_ID);
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
                        
                        return "Section.jsp";
                        
		}
	
	
	/*	@RequestMapping("/Section.do")
	public String SectionUpdate(@RequestParam("Section_ID") int section_ID,
			
			
			
		    @RequestParam("Name") String name,
		    @RequestParam("Active") String active,
		    @RequestParam("Deleted") String deleted,
		    @RequestParam("Effective_Date") String effective_Date,
		    @RequestParam("Expiry_Date") String expiry_Date,
		    @RequestParam("Version") String version,
		    @RequestParam("Created_By") String created_By,
		    @RequestParam("Created_On") String created_On,
		    @RequestParam("Modified_By") String modified_By,
		    @RequestParam("Modified_On") String modified_On){
	    try
	    {
	    	SectionPojo d=new SectionPojo();
			SectionDao dd=new SectionDao();
			
			System.out.println("h1");
			
			d.setSection_ID(section_ID);
			d.setName(name);
			d.setActive(active);
			d.setDeleted(deleted);
			d.setEffective_Date(effective_Date);
			d.setExpiry_Date(expiry_Date);
			d.setVersion(version);
			d.setCreated_By(created_By);
			d.setCreated_On(created_On);
			d.setModified_By(modified_By);
			d.setModified_On(modified_On);
			
			System.out.println("h2");
	        
	        dd.updateSection(d, "Section_ID", section_ID);
	    }
	     catch (SQLException e) 
			{     
				System.out.println(""+ e.getMessage());  
				
			}
			
		    finally
			{
		    	System.out.println("done");
			}

	    return "Section.jsp";
	}



/*	@RequestMapping("/Section.do")
	public String DisableDistributor(@RequestParam("email") String[] email1,
	                                 Model m)
	{
	    
	    System.out.print("Before in control");
		try
		{
	            
	            for(int i=0; i<email1.length; i++)
	            {
	                String email=email1[i];
	            
	            //System.out.print("Inside controller");
	            DistributorDao dd=new DistributorDao();
	            dd.DeleteDistributor("email", email);
	            dd.DeleteIndent("did", email);
	            System.out.println("After in control");
	            }
		}
	        catch (SQLException e) 
		{     
			System.out.println(""+ e.getMessage());  
			
		}
		
	        finally
	        {
	              System.out.println("done");
	        }
		return "Distrideleted.jsp";
	}*/
}
