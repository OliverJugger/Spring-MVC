package fr.edu.aix.yuccaspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;


/**
 * @author omignot
 *
 */
@RestController
@RequestMapping("/programme")
public class ProgrammeController {
	
	private ProgrammeService programmeService;


    @Autowired
    public void setProgrammeService(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }
    
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/programme/list";
    }

	@RequestMapping(method=RequestMethod.GET, value="/list")
    public List<Programme> listProgrammes(){
        List<Programme> programmes = programmeService.getAllProgrammes();
        return programmes;
    }

    @RequestMapping(method=RequestMethod.GET, value="/show/{id}")
    public Programme getProgramme(@PathVariable(value="id", required = true) Long id){
    	Programme programme = programmeService.getProgramme(id);
        return programme;
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/edit/{id}")
    public boolean edit(@RequestBody Programme programme){
    	programmeService.addProgramme(programme);
        return true;
    }
    /*
    @RequestMapping(method=RequestMethod.POST, value="/add")
    public void addProgramme(@RequestBody Programme programme) {
        programmeService.addProgramme(programme);
    }*/

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public void deleteProgramme(@PathVariable Long id) {
    	programmeService.deleteProgramme(id);
    }

}
