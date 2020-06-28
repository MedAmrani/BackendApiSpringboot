package org.lsi.controller;


import java.util.List;

import org.lsi.model.Donation;
import org.lsi.service.IDonationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DonationController {
	
	@Autowired
	IDonationMetier donationMetier;
	
	@RequestMapping(value = "/Donation", method = RequestMethod.POST)
	public Donation create(@RequestBody Donation donation) {
		return donationMetier.create(donation);
	}	
	
	@RequestMapping(value = "/donations", method = RequestMethod.GET)
	public List<Donation> getAll() {
		// TODO Auto-generated method stub
	 return donationMetier.getAll();
	}
	
	

}
