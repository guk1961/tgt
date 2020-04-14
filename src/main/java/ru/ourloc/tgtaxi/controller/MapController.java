package ru.ourloc.tgtaxi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import ru.ourloc.tgtaxi.repos.CityRepo;
import ru.ourloc.tgtaxi.service.CityService;

@Controller
public class MapController {
	
	@Autowired
	CityService cityService;
	
	@Autowired
	CityRepo cityRepo;
	
	
    @GetMapping("/map")
    public String map(Model model) {
    	
    	 model.addAttribute("citys", cityService.findAll());
        
    	return "map";
    }


}
