package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.Repertoire;
import fr.edu.aix.yuccaspringboot.repository.RepertoireRepository;

@Service
public class RepertoireService {

	@Autowired
	public RepertoireRepository repertoireRepository;
	
	public List<Repertoire> getRepertoiresVisible(char visible){
		List<Repertoire> repertoires = new ArrayList<>();
		repertoireRepository.findByVisible(visible).forEach(repertoires::add);
        return repertoires;
	}
	
	public List<Repertoire> getAllRepertoires(){
		List<Repertoire> repertoires = new ArrayList<>();
		repertoireRepository.findAll().forEach(repertoires::add);
        return repertoires;
	}
	
	 public Repertoire getRepertoire(Long id) {   
		 	Optional<Repertoire> repertoires = repertoireRepository.findById(id);
	        return repertoires.get();
    }
    
    public void addDossier(Repertoire repertoires) {
    	repertoireRepository.save(repertoires);
    }

    public void updateDossier(Repertoire repertoires) {
    	repertoireRepository.save(repertoires);
    }
    public void deleteDossier(Long id) {
    	repertoireRepository.deleteById(id);
    }
}
