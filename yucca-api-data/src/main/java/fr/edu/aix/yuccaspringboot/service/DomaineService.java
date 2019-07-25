package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.Domaine;
import fr.edu.aix.yuccaspringboot.domain.Repertoire;
import fr.edu.aix.yuccaspringboot.repository.DomaineRepository;
import fr.edu.aix.yuccaspringboot.repository.RepertoireRepository;

@Service
public class DomaineService {

	@Autowired
	public DomaineRepository domaineRepository;
	
	public List<Domaine> getDomainesVisible(char visible){
		List<Domaine> domaines = new ArrayList<>();
		domaineRepository.findByVisible(visible).forEach(domaines::add);
        return domaines;
	}
	
	public List<Domaine> getAllDomaines(){
		List<Domaine> domaines = new ArrayList<>();
		domaineRepository.findAll().forEach(domaines::add);
        return domaines;
	}
	
	 public Domaine getDomaine(Long id) {   
		 	Optional<Domaine> domaine = domaineRepository.findById(id);
	        return domaine.get();
    }
    
    public void addDomaine(Domaine domaine) {
    	domaineRepository.save(domaine);
    }

    public void updateDomaine(Domaine domaine) {
    	domaineRepository.save(domaine);
    }
    public void deleteDomaine(Long id) {
    	domaineRepository.deleteById(id);
    }
}
