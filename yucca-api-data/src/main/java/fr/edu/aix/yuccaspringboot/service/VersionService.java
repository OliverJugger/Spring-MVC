/**
 * 
 */
package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.domain.Version;
import fr.edu.aix.yuccaspringboot.repository.VersionRepository;

/**
 * @author omignot
 *
 */
@Service
public class VersionService {
	
	@Autowired
	private VersionRepository versionRepository;
	
	public List<Version> getAllVersions(){
        List<Version> versions = new ArrayList<>();
        versionRepository.findAll().forEach(versions::add);
        return versions;
    }    
    
    public Version getVersion(Long id) { 
    	Optional<Version> version = versionRepository.findById(id);
        return version.get();
    }
    
    public void addVersion(Version programme) {
    	versionRepository.save(programme);
    }

    public void updateVersion(Version programme) {
    	versionRepository.save(programme);
    }
    
    public void deleteLiens(Long id) {
    	Version version =  this.getVersion(id);
    	List<Correction> corrections = version.getCorrections();
    	corrections.clear();
    	version.setCorrections(corrections);
    	
    	versionRepository.save(version);
    }

    public void deleteVersion(Long id) {
    	versionRepository.deleteById(id);
    }

	public void deleteVersionCorrection(Long idVersion, Long idCorrection) {
		Version version = versionRepository.findById(idVersion).get();
    	List<Correction> corrections = version.getCorrections();
    	boolean found = false;
    	int size = corrections.size();
    	int i = 0;
    	while (i<size || !found) {
    		if(corrections.get(i).getId() == idCorrection) {
    			corrections.remove(corrections.get(i));
    			found = true;
    		}
    		i++;
    	}    	
    	version.setCorrections(corrections);
    	versionRepository.save(version);
    }

}
