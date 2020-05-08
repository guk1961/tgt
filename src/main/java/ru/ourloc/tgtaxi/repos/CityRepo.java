package ru.ourloc.tgtaxi.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.ourloc.tgtaxi.domain.City;
import ru.ourloc.tgtaxi.domain.User;
import ru.ourloc.tgtaxi.domain.dto.MessageDto;

public interface CityRepo extends JpaRepository<City, Long>{

    City findByName(String name);
    
    @Query(value = "SELECT u FROM City u WHERE Upper(u.name) LIKE :cityname")
    List<City> findByCity(@Param("cityname") String cityname);
 
}

