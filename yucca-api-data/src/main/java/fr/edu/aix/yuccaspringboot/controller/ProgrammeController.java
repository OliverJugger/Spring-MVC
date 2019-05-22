package fr.edu.aix.yuccaspringboot.controller;

import java.util.Calendar;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.form.ProgrammeForm;
import fr.edu.aix.yuccaspringboot.mapper.ProgrammeMapper;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;


/**
 * @author omignot
 * Avec interface Thymeleaf
 */
@Controller
@RequestMapping("/programme")
public class ProgrammeController {
	
	private ProgrammeService programmeService;	

	private	ProgrammeMapper mapper = Mappers.getMapper(ProgrammeMapper.class);

    @Autowired
    public void setProgrammeService(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }
    
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/programme/list";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public String listProgrammes(Model model){
        model.addAttribute("programmes", programmeService.getAllProgrammes());
        return "/programme/list";
    }

    @RequestMapping("/show/{id}")
    public String getProgramme(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("programme", programmeService.getProgramme(id));
        return "programme/show";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Programme programme = programmeService.getProgramme(id);
        ProgrammeForm programmeForm = mapper.programmeToProgrammeForm(programme);
        model.addAttribute("programmeForm", programmeForm);
        return "programme/programmeForm";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/add")
    public String addProgramme(Programme programme, Model model) {
    	programme.setDateCreation(Calendar.getInstance());
    	programme.setUtilisateurCreation("YUCCA-BACK");
    	programme.setUtilisateurModification("YUCCA-BACK");
    	programme.setIdDomaine(new Long(30));
    	programme.setIdDossier(new Long(50));
        programmeService.addProgramme(programme);
        return "redirect:/programme/list";
    }
    
    @RequestMapping("/new")
    public String newProgramme(Model model){
        model.addAttribute("programmeForm", new ProgrammeForm());
        return "programme/programmeForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProgramme(@PathVariable Long id) {
    	programmeService.deleteLiens(id);
    	programmeService.deleteProgramme(id);
    	return "redirect:/programme/list";
    }

}
