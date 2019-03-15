package fr.edu.aix.yuccaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.domain.Version;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;


/**
 * @author omignot
 *
 */
@RestController
@RequestMapping("/version")
public class VersionController {
	
	private ProgrammeService versionService;

    @Autowired
    public void setProgrammeService(ProgrammeService versionService) {
        this.versionService = versionService;
    }
    
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/version/list";
    }
	
	/** 
	 * Avec interface Thymeleaf 
	 * @param model
	 * @return
	 */
	@RequestMapping( method=RequestMethod.GET, value="/list")
    public String listProgrammes(Model model){
        model.addAttribute("versions", versionService.getAllProgrammes());
        return "/version/list";
    }

    /** 
     * Avec interface Thymeleaf 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method=RequestMethod.GET, value="/show/{id}")
    public String getProgramme(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("version", versionService.getProgramme(id));
        return "version/show";
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/edit/{id}")
    public boolean edit(@RequestBody Version version){
       return true;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/add")
    public void addProgramme(@RequestBody Programme version) {
        versionService.addProgramme(version);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public void deleteProgramme(@PathVariable Long id) {
    	versionService.deleteProgramme(id);
    }

}
