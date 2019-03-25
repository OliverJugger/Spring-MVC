package fr.edu.aix.yuccaspringboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.form.CorrectionForm;
import fr.edu.aix.yuccaspringboot.form.CorrectionToCorrectionForm;
import fr.edu.aix.yuccaspringboot.service.CorrectionService;

/**
 * @author omignot
 * Avec interface Thymeleaf 
 */
@Controller
@RequestMapping("/correction")
public class CorrectionController {
	
	private CorrectionService correctionService;	
	private CorrectionToCorrectionForm correctionToCorrectionForm;
	
	@Autowired
    public void setCorrectionToCorrectionForm(CorrectionToCorrectionForm correctionToCorrectionForm) {
        this.correctionToCorrectionForm = correctionToCorrectionForm;
	}
	
	@Autowired
    public void setCorrectionService(CorrectionService correctionService) {
        this.correctionService = correctionService;
	}
	
	@RequestMapping("/")
    public String redirToList(){
        return "redirect:/correction/list";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public String listProgrammes(Model model){
        model.addAttribute("corrections", correctionService.getAllCorrections());
        return "/correction/list";
    }
	
	 @RequestMapping("/new")
	    public String newProgramme(Model model){
		 	model.addAttribute("correctionForm", new CorrectionForm());
	        return "correction/correctionForm";
	    }
	
	 @RequestMapping("/show/{id}")
    public String getProgramme(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("correction", correctionService.getCorrection(id));
        return "correction/show";
    }   
	 
	 @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Correction correction = correctionService.getCorrection(id);
        CorrectionForm correctionForm = correctionToCorrectionForm.convert(correction);
        model.addAttribute("correctionForm", correctionForm);
        return "correction/correctionForm";
    }
	 
	 @RequestMapping("/delete/{id}")
    public String deleteCorrection(@PathVariable Long id) {
		 correctionService.deleteLiens(id);
		 correctionService.deleteCorrection(id);
    	return "redirect:/correction/list";
    }
	 
	 @RequestMapping(value="/add",method=RequestMethod.POST)
	    public String addCorrection(Correction correction, Model model) {
			 correction.setEtat('O');
			 correction.setDateCreation(new Date());
			 correction.setUtilisateurCreation("YUCCA-BACK");
			 correction.setUtilisateurModification("YUCCA-BACK");
			 correction.setDateModification(new Date());
			 correction.setUtilisateurModification("YUCCA-BACK");
			 correction.setApplication(new Long(30));
			 correction.setResponsable(new Long(50));
			 correctionService.addCorrection(correction);
	        return "redirect:/correction/list";
	    }
}
