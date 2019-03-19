package fr.edu.aix.yuccaspringboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.service.CorrectionService;

/**
 * @author omignot
 *
 */
@RestController
@RequestMapping("/correctionREST")
public class CorrectionRestController {
	
	@Autowired
	public CorrectionService correctionService;
	
	@RequestMapping("/")
    public List<Correction> getAllCorrections(){
        return correctionService.getAllCorrections();
    }
    
    @RequestMapping("/{id}")
    public Correction getCorrection(@PathVariable Long id) {
        return correctionService.getCorrection(id);
    }
    
    
    @RequestMapping(method=RequestMethod.POST, value="/")
    public void addCorrection(@RequestBody Correction Correction) {
    	correctionService.addCorrection(Correction);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public void updateCorrection(@RequestBody Correction correction, @PathVariable Long id) {
    	correctionService.updateCorrection(correction);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public void deleteCorrection(@PathVariable Long id) {
    	correctionService.deleteCorrection(id);
    }

}
