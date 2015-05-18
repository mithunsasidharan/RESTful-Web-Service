package com.rest.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	private static final List<Company> companies = new ArrayList<Company>();
	private static final String DEFAULT_HEADQUARTERS =  "Unknown";

	@RequestMapping(value ="/company", method=RequestMethod.POST)
	public @ResponseBody String createCompany(@RequestParam("companyName") final String companyName, 
			@RequestParam("employeeStrength") long employeeStrength, @RequestParam("foundingYear") int foundingYear,
			@RequestParam(required = false) final String headquarters) {

		String headQuarter = headquarters==null ? DEFAULT_HEADQUARTERS: headquarters;
		Company company = new Company(companyName, employeeStrength, foundingYear, headQuarter);
		companies.add(company);
		return "Company has been created !!";
	}

	@RequestMapping(value ="/company/{companyName}", method=RequestMethod.GET)
	public @ResponseBody Company getUser(@PathVariable("companyName") String companyName) {
		for(Company company : companies)  
			if(company.getCompanyName().equalsIgnoreCase(companyName)) { 
				return company;
			}
		return null;
	}
}

