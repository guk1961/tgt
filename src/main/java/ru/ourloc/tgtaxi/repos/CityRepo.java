package ru.ourloc.tgtaxi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ru.ourloc.tgtaxi.domain.City;

public interface CityRepo extends JpaRepository<City, Long>{

    City findByName(String name);
    
 
}

