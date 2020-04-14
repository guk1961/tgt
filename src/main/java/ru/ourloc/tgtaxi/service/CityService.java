package ru.ourloc.tgtaxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.ourloc.tgtaxi.domain.City;
import ru.ourloc.tgtaxi.repos.CityRepo;

@Service
public class CityService {
	
	@Autowired
	CityRepo cityRepo;
	
	   public List<City> findAll(){
		   return cityRepo.findAll();
		   
	   }

	   public City findByCityname(String name){
		   return cityRepo.findByCityname(name);		   
	   }

}
