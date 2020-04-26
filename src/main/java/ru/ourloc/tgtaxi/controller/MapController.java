package ru.ourloc.tgtaxi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.ui.Model;

import ru.ourloc.tgtaxi.domain.City;
import ru.ourloc.tgtaxi.repos.CityRepo;
import ru.ourloc.tgtaxi.service.CityService;

@Controller
public class MapController {
	
	@Autowired
	CityService cityService;
	
	@Autowired
	CityRepo cityRepo;
	
	
//		@GetMapping("/geo")
		@RequestMapping(produces = "application/javascript", 
	    method = RequestMethod.GET,
	    value = "/geo.js")
		@ResponseBody
        public String map(Model model) throws JsonProcessingException {
    	
    	List<City> citys =  cityService.findAll();
    	 model.addAttribute("citys", citys);
    	 
//    	 for(City c : citys) {
//    		 System.out.println(c.getName());
//    	 }
    	 ObjectMapper mapper = new ObjectMapper();
         //Converting the Object to JSONString
         String jsonString = mapper.writeValueAsString(citys);
        // System.out.println(jsonString);
        
    	return jsonString;
    }

	    @GetMapping("/test")
	    public String greeting(Model model) throws JsonProcessingException {
	    	List<City> citys = cityService.findAll();
	    	model.addAttribute("citys", citys);
	    	 ObjectMapper mapper = new ObjectMapper();
	         String jsonCitys = mapper.writeValueAsString(citys);
	      	 model.addAttribute("jsoncitys", jsonCitys);

	         return "test";
	    }


		
}
