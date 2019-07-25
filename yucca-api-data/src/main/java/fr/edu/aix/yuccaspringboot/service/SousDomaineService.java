package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.SousDomaine;
import fr.edu.aix.yuccaspringboot.repository.SousDomaineRepository;

@Service
public class SousDomaineService {

	@Autowired
	public SousDomaineRepository sousDomaineRepository;
	
	public List<SousDomaine> getSousDomainesVisible(char visible){
		List<SousDomaine> sousDomaines = new ArrayList<>();
		sousDomaineRepository.findByVisible(visible).forEach(sousDomaines::add);
        return sousDomaines;
	}
	
	public List<SousDomaine> getAllSousDomaines(){
		List<SousDomaine> sousDomaines = new ArrayList<>();
		sousDomaineRepository.findAll().forEach(sousDomaines::add);
        return sousDomaines;
	}
	
	 public SousDomaine getSousDomaine(Long id) {   
		 	Optional<SousDomaine> sousDomaines = sousDomaineRepository.findById(id);
	        return sousDomaines.get();
    }
    
    public void addSousDomaine(SousDomaine sousDomaines) {
    	sousDomaineRepository.save(sousDomaines);
    }

    public void updateSousDomaine(SousDomaine sousDomaines) {
    	sousDomaineRepository.save(sousDomaines);
    }
    public void deleteSousDomaine(Long id) {
    	sousDomaineRepository.deleteById(id);
    }
}
