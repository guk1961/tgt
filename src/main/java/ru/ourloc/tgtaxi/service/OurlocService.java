package ru.ourloc.tgtaxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.ourloc.tgtaxi.domain.Ourloc;
import ru.ourloc.tgtaxi.repos.OurlocRepo;

@Service
public class OurlocService {

	 @Autowired
	 private OurlocRepo ourlocRepo;
	 
	 
	 public void addOurloc(String tgmessage) {
		 
		 Ourloc ourloc = new Ourloc(tgmessage);
		 ourlocRepo.save(ourloc);
		 
	    }
	 
}
