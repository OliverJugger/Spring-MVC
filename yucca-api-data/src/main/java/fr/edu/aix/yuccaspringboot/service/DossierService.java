package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.Dossier;
import fr.edu.aix.yuccaspringboot.repository.DossierRepository;

@Service
public class DossierService {

	@Autowired
	public DossierRepository dossierRepository;
	
	public List<Dossier> getAllDossiers(){
		List<Dossier> dossiers = new ArrayList<>();
        dossierRepository.findAll().forEach(dossiers::add);
        return dossiers;
	}
	
	 public Dossier getDossier(Long id) {   
		 	Optional<Dossier> dossiers = dossierRepository.findById(id);
	        return dossiers.get();
    }
    
    public void addDossier(Dossier dossier) {
    	dossierRepository.save(dossier);
    }

    public void updateDossier(Dossier dossier) {
    	dossierRepository.save(dossier);
    }
    public void deleteDossier(Long id) {
    	dossierRepository.deleteById(id);
    }
}
