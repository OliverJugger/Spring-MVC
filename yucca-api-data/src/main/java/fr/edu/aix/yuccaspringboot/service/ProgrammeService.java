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
	
	public List<Programme> getAllProgrammes(){
        List<Programme> programmes = new ArrayList<Programme>();
        programmeRepository.findAllByOrderByIdDesc().forEach(programmes::add);
        return programmes;
    }    
    
    public Programme getProgramme(Long id) {        
        Optional<Programme> programme = programmeRepository.findById(id);
        return programme.get();
    }
    
    public void addProgramme(Programme programme) {
    	programmeRepository.save(programme);
    }

    public void updateProgramme(Programme programme) {
    	programmeRepository.save(programme);
    }
    
    public void deleteLiens(Long id) {
    	Programme programme =  this.getProgramme(id);
    	//List<Correction> corrections = programme.getCorrections();
    	//corrections.clear();
    	//programme.setCorrections(corrections);
    	programmeRepository.save(programme);
    }

    public void deleteProgramme(Long id) {
    	programmeRepository.deleteById(id);
    }
}
