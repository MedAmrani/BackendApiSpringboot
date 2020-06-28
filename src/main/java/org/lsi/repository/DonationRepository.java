package org.lsi.repository;


import org.lsi.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long>{
	
}
