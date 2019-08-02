package fr.edu.aix.yuccaspringboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import fr.edu.aix.yuccaspringboot.domain.SousDomaine;

public interface SousDomaineRepository extends CrudRepository<SousDomaine, Long>{

	List<SousDomaine> findByVisible(char visible);

}
