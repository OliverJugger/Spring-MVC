package fr.edu.aix.yuccaspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Version;
import fr.edu.aix.yuccaspringboot.service.VersionService;


/**
 * @author omignot
 *
 */
@RestController
@RequestMapping("/version")
public class VersionController {
	
	private VersionService versionService;

    @Autowired
    public void setVersionService(VersionService versionService) {
        this.versionService = versionService;
    }
    
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/version/list";
    }
    
	@RequestMapping( method=RequestMethod.GET, value="/list")
    public List<Version> listProgrammes(){
        return versionService.getAllVersions();
    }

    @RequestMapping(method=RequestMethod.GET, value="/show/{id}")
    public Version getProgramme(@PathVariable(value="id", required = true) Long id){
        return versionService.getVersion(id);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/edit/{id}")
    public boolean edit(@RequestBody Version version){
       return true;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/add")
    public void addProgramme(@RequestBody Version version) {
        versionService.addVersion(version);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public void deleteProgramme(@PathVariable Long id) {
    	versionService.deleteVersion(id);
    }

}
