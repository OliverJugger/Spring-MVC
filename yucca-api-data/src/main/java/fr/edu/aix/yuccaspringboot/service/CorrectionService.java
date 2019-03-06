package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.domain.Version;
import fr.edu.aix.yuccaspringboot.repository.CorrectionRepository;

@Service
public class CorrectionService {

	@Autowired
	public CorrectionRepository correctionRepository;
	
	public List<Correction> getAllCorrections(){
		List<Correction> corrections = new ArrayList<>();
        correctionRepository.findAll().forEach(corrections::add);
        return corrections;
	}
	
	public List<Programme> getAllProgrammes(Long id){
        List<Programme> programmes = new ArrayList<>();
        correctionRepository.findByProgrammesId(id).forEach(programmes::add);
        return programmes;
    }

	
	 public Correction getCorrection(Long id) {   
		 	Optional<Correction> corrections = correctionRepository.findById(id);
	        return corrections.get();
    }
    
    public void addCorrection(Correction correction) {
    	correctionRepository.save(correction);
    }

    public void updateCorrection(Correction correction) {
    	correctionRepository.save(correction);
    }
    
    public void deleteLiens(Long id) {
    	Correction correction =  this.getCorrection(id);
    	List<Programme> programmes = correction.getProgrammes();
    	programmes.clear();
    	correction.setProgrammes(programmes);
    	
    	List<Version> versions = correction.getVersions();
    	versions.clear();
    	correction.setVersions(versions);
    	
    	correctionRepository.save(correction);
    }
    
    public void deleteCorrection(Long id) {
    	correctionRepository.deleteById(id);
    }
}
