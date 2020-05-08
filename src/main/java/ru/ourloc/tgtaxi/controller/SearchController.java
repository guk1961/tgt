package ru.ourloc.tgtaxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.ourloc.tgtaxi.domain.City;
import ru.ourloc.tgtaxi.repos.CityRepo;
import ru.ourloc.tgtaxi.service.CityService;

@RestController
public class SearchController {

	@Autowired
	CityService cityService;
	
	@Autowired
	CityRepo cityRepo;
	
	@GetMapping("/geo.js")
    public List<City> map(Model model) {
	
	List<City> citys =  cityService.findAll();
	 model.addAttribute("citys", citys);
    
	return citys;
}

	@PostMapping("/search")
    public List<City> search(@RequestParam String cityname, Model model) {
    	List<City> citys = cityService.findByCityFilter(cityname);
    	model.addAttribute("citys", citys);
    	System.out.println(cityname);
         return citys;
    }
}
