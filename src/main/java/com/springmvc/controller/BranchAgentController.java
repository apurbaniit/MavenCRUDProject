package com.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.model.AgentMaster;
import com.springmvc.model.BranchMaster;
import com.springmvc.model.Country;
import com.springmvc.service.agentService;
import com.springmvc.service.branchService;
import com.springmvc.service.countryService;

@Controller
public class BranchAgentController {

	@Autowired
	countryService countryService;
	
	@Autowired
	branchService branchService;
	
	@Autowired
	agentService agentService;

	// For Branch List details [statrtup page]
	@RequestMapping(value= {"/","/branchList"})
    public String branchDetails(Model model) {  
		List<AgentMaster> listOfAgents = agentService.getAllAgenets();
        model.addAttribute("agent",listOfAgents); 
        return "BranchList";
    }
	
	// Getting AddBranch.jsp page 
	@RequestMapping(value= "/branch")
	public String home(Model model) {
		List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("country",listOfCountries);    
		return "AddBranch";
	}

	// save branch details
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
    public String addBranch(HttpServletRequest re,@ModelAttribute("branchmaster") BranchMaster branchMaster,Model model) {  
		branchService.addBranch(re,branchMaster);
		return "redirect:/branchList";
    }
	
	// save branch details by branch Id
	@RequestMapping(value = "/getBranch/{id}", method = RequestMethod.GET)
    public String updateBranch(@PathVariable("id") long id,Model model) {
		List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("country",listOfCountries);    
        BranchMaster branchMaster=branchService.getByBranchId(id);
        model.addAttribute("branch",branchMaster); 
        return "UpdateBranch";
    }
	
	// update branch details
	@RequestMapping(value = "/updateBranch", method = RequestMethod.POST)
    public String updateBranch(HttpServletRequest re,@ModelAttribute("branchmaster") BranchMaster branchMaster,Model model) {  
        branchService.updateBranch(re,branchMaster);
		return "redirect:/branchList";
    }
	
	// delete agent details
	@RequestMapping(value = "/deleteAgent/{id}", method = RequestMethod.GET)
    public String deleteBranch(@PathVariable("id") long id,Model model) {
        agentService.deleteByAgentId(id);
		return "redirect:/branchList";
    }
	
	// Getting ViewBranch.jsp page
	@RequestMapping(value = "/viewBranch/{id}", method = RequestMethod.GET)
    public String viewBranch(@PathVariable("id") long id,Model model) {
		List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("country",listOfCountries);  
		BranchMaster branchMaster=branchService.getByBranchId(id);
        model.addAttribute("branch",branchMaster); 
        return "ViewBranch";
    }
	
	//Getting AddAgent.jsp page
	@RequestMapping(value= {"/agent"})
	public String addAgent(Model model) {
		List<BranchMaster> listOfBranches = branchService.getAllBranches();
        model.addAttribute("branch",listOfBranches);    
		return "AddAgent";
	}
	
	// save agentmaster deatails
	@RequestMapping(value = "/addAgent", method = RequestMethod.POST)
    public String addAgent(HttpServletRequest re,@ModelAttribute("agentmaster") AgentMaster agentMaster,Model model) {  
		System.out.println(re.getParameter("branchIDs"));
		if(!re.getParameter("branchIDs").isEmpty()) {
			String[] branchLst = re.getParameter("branchIDs").split(",");
			for(int i=0;i<branchLst.length;i++){
				agentService.addAgent(agentMaster,Long.valueOf(branchLst[i]));
			} 
			
		}
		return "redirect:/branchList";
    }
	
	// For check branch name exist or not
	@RequestMapping(value="/checkBranchNameDetails",method = RequestMethod.GET)
	public @ResponseBody String checkBranchNameDetails(HttpServletRequest re) throws IOException, RuntimeException
	{
		
		String str=branchService.getByBranchName(re.getParameter("branch_name"));
		return str;
			
	}

	// For check branch code exist or not
	@RequestMapping(value="/checkBranchCodeDetails",method = RequestMethod.GET)
	public @ResponseBody String checkBranchCodeDetails(HttpServletRequest re) throws IOException, RuntimeException
	{
		
		String str=branchService.getByBranchCode(re.getParameter("branch_code"));
		return str;
			
	}
	
	// For getting branch List after cancle button
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String addCountry(Model model) {  
		List<AgentMaster> listOfAgents = agentService.getAllAgenets();
        model.addAttribute("agent",listOfAgents); 
        return "BranchList";
    }
}
