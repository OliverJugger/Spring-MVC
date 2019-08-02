package fr.edu.aix.yuccaspringboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import fr.edu.aix.yuccaspringboot.domain.Programme;

public interface ProgrammeRepository extends CrudRepository<Programme, Long>{
	
	List<Programme> findAllByOrderByIdDesc();

}
