package fr.edu.aix.yuccaspringboot.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Repertoire;

public interface RepertoireRepository extends CrudRepository<Repertoire, Long>{

	List<Repertoire> findByVisible(char visible);

}
