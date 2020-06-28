package org.lsi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lsi.model.Donation;
import org.lsi.model.Project;
import org.lsi.model.UserInfo;
import org.lsi.repository.DonationRepository;
import org.lsi.repository.ProjectRepository;
import org.lsi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.server.Client;

@Service
public class DonationMetierImpl implements IDonationMetier{
	
	@Autowired
	DonationRepository donationRepository; 
	
	@Autowired
	UserInfoRepository clientRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	

	@Override
	public Donation create(Donation donation) {
		//long projectid, Double amount, long clientid
		// TODO Auto-generated method stub
		Project p = projectRepository.findById(donation.getProject().getId()).orElse(null);
		UserInfo c = clientRepository.findById(donation.getUserInfo().getId()).orElse(null);
		Donation d = new Donation();
		d.setDate(new Date());
		d.setAmount(donation.getAmount());
		d.setUserInfo(c);
		d.setProject(p);
		donationRepository.save(d);
		p.setReachedAmount(p.getReachedAmount()+donation.getAmount());
		projectRepository.save(p);
		 
		return d;
		
		
	}
	
	@Override
	public List<Donation> getAll() {
		List<Donation> Donation = new ArrayList<>();
		donationRepository.findAll().forEach(Donation::add);
		return Donation;
	}

	@Override
	public Donation get(Long id) {
		return donationRepository.findById(id).get();
	}

	

	@Override
	public Donation update(Long id, Donation res) {
		res.setId(id);
		return donationRepository.save(res);
	}

	@Override
	public void delete(Long id) {
		donationRepository.deleteById(id);
		
	}

}
