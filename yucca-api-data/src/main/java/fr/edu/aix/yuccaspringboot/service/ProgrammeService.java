package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.repository.ProgrammeRepository;

@Service
public class ProgrammeService {
	
	@Autowired
	public ProgrammeRepository programmeRepository;
	
	public Iterable<Programme> getAllProgrammes(){
        return programmeRepository.findAllByOrderByIdDesc();
    }    
    
    public Programme getProgramme(Long id) {        
        Optional<Programme> programme = programmeRepository.findById(id);
        if(programme.isPresent())
        	return programme.get();
        return null;
    }
    
    public Iterable<Programme> getProgrammes(Programme programme) {        
    	return programmeRepository.findByNomIgnoreCaseContainingAndCommentaireIgnoreCaseContainingAndTemporaireAndDomaine(programme.getNom(), programme.getCommentaire(), programme.getTemporaire(), programme.getDomaine());
    }
    
    public void saveProgramme(Programme programme) {
    	programmeRepository.save(programme);
    }
    
    public void deleteLiens(Long id) {
    	/*Programme programme =  this.getProgramme(id);
    	List<Correction> corrections = programme.getCorrections();
    	corrections.clear();
    	programme.setCorrections(corrections);
    	programmeRepository.save(programme);*/
    }

    public void deleteProgramme(Long id) {
    	programmeRepository.deleteById(id);
    }
}
