package fr.edu.aix.yuccaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.edu.aix.yuccaspringboot.service.CorrectionService;

/**
 * @author omignot
 * Avec interface Thymeleaf 
 */
@Controller
@RequestMapping("/correction")
public class CorrectionController {
	
	@Autowired
	public CorrectionService correctionService;
	
	@RequestMapping("/")
    public String redirToList(){
        return "redirect:/correction/list";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public String listProgrammes(Model model){
        model.addAttribute("corrections", correctionService.getAllCorrections());
        return "/correction/list";
    }
	
	 @RequestMapping("/show/{id}")
    public String getProgramme(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("correction", correctionService.getCorrection(id));
        return "correction/show";
    }   
	 
	 @RequestMapping("/delete/{id}")
    public String deleteCorrection(@PathVariable Long id) {
		 correctionService.deleteLiens(id);
		 correctionService.deleteCorrection(id);
    	return "redirect:/correction/list";
    }
}
