package fr.edu.aix.yuccaspringboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Auteur;

public interface AuteurRepository extends CrudRepository<Auteur, Long> {
	List<Auteur> findByActif(char actif);
}
