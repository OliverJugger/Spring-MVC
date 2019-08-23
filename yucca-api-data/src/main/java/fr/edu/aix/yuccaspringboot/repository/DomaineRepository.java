package fr.edu.aix.yuccaspringboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Domaine;

public interface DomaineRepository extends CrudRepository<Domaine, Long>{

	List<Domaine> findByVisible(char visible);

}
