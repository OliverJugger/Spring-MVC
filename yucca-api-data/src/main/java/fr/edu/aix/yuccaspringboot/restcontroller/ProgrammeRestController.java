package fr.edu.aix.yuccaspringboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.form.ProgrammeForm;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;


/**
 * @author omignot
 *
 */
@RestController
@RequestMapping("/programmeREST")
public class ProgrammeRestController {
	
	private ProgrammeService programmeService;

    @Autowired
    public void setProgrammeService(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }
    
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/programme/list";
    }
	
	/** 
	 * Avec interface Thymeleaf 
	 * @param model
	 * @return
	 */
	@RequestMapping( method=RequestMethod.GET, value="/list")
    public String listProgrammes(Model model){
        model.addAttribute("programmes", programmeService.getAllProgrammes());
        return "/programme/list";
    }

    /** 
     * Avec interface Thymeleaf 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method=RequestMethod.GET, value="/show/{id}")
    public String getProgramme(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("programme", programmeService.getProgramme(id));
        return "programme/show";
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
