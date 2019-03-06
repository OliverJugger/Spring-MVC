package fr.edu.aix.yuccaspringboot.repository;
import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Dossier;

public interface DossierRepository extends CrudRepository<Dossier, Long>{

}
