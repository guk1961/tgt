package ru.ourloc.tgtaxi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.ourloc.tgtaxi.domain.Ourloc;

public interface OurlocRepo extends JpaRepository<Ourloc, Long>{  
 
}

