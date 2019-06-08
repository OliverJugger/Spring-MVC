package fr.edu.aix.yuccaspringboot.controller;

import java.util.Calendar;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.mapper.ProgrammeMapper;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;


/**
 * @author omignot
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
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public String listProgrammes(){
        return "/programme/list";
    }

    @RequestMapping("/show/{id}")
    public String getProgramme(@PathVariable(value="id", required = true) Long id){
        return "programme/show";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id){
        return "programme/programmeForm";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/add")
    public String addProgramme(Programme programme) {
    	programme.setDateCreation(Calendar.getInstance());
    	programme.setUtilisateurCreation("YUCCA-BACK");
    	programme.setUtilisateurModification("YUCCA-BACK");
    	programme.setIdDomaine(new Long(30));
    	programme.setIdDossier(new Long(50));
        programmeService.addProgramme(programme);
        return "redirect:/programme/list";
    }
    
    @RequestMapping("/new")
    public String newProgramme(){
        //model.addAttribute("programmeForm", new ProgrammeForm());
        return "programme/programmeForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProgramme(@PathVariable Long id) {
    	programmeService.deleteLiens(id);
    	programmeService.deleteProgramme(id);
    	return "redirect:/programme/list";
    }

}
