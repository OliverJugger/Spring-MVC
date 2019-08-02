package fr.edu.aix.yuccaspringboot.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.domain.Programme;

public interface CorrectionRepository extends CrudRepository<Correction, Long> {
	
	List<Correction> findAllByOrderByIdDesc();

}
