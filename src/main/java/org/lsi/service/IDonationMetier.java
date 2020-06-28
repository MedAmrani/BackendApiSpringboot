package org.lsi.service;

import java.util.List;

import org.lsi.model.Donation;



public interface IDonationMetier {
//	public boolean verser(String code, double solde, Long codeEmp);
//	public boolean retirer(String code, double montant, Long codeEmp);
//	public boolean virement(String cpte1, String cpte2, double solde, Long codeEmp);
//	public PageDonation getDonations(String projectid, int page, int size);
//	public boolean donate(long  projectid , Double amount, long clientid );
	public List<Donation> getAll() ;
	public Donation get(Long id);
	public Donation create(Donation donation);
	public Donation update(Long id, Donation d);
	public void delete(Long id) ;
	
}
