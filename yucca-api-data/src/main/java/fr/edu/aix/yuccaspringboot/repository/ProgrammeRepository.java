package fr.edu.aix.yuccaspringboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Domaine;
import fr.edu.aix.yuccaspringboot.domain.Programme;

public interface ProgrammeRepository extends CrudRepository<Programme, Long>{
	
	List<Programme> findByNomIgnoreCaseContaining(String nom);
	
	List<Programme> findAllByOrderByIdDesc();
	
	List<Programme> findByNomIgnoreCaseContainingAndCommentaireIgnoreCaseContainingAndTemporaireAndDomaine(String nom, String commentaire, char temporaire, Domaine domaine);
	

}
