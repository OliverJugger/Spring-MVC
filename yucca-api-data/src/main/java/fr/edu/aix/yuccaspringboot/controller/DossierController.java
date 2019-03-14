package fr.edu.aix.yuccaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.edu.aix.yuccaspringboot.service.DossierService;

/**
 * @author omignot
 * Avec interface Thymeleaf 
 */
@Controller
@RequestMapping("/dossier")
public class DossierController {
	
	@Autowired
	public DossierService dossierService;
	
	@RequestMapping("/")
    public String redirToList(){
        return "redirect:/dossier/list";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public String listDossiers(Model model){
        model.addAttribute("dossiers", dossierService.getAllDossiers());
        return "/dossier/list";
    }
	
	 @RequestMapping("/show/{id}")
    public String getDossier(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("correction", dossierService.getDossier(id));
        return "dossier/show";
    }   
	 
	 @RequestMapping("/delete/{id}")
    public String deleteDossier(@PathVariable Long id) {    	
		 dossierService.deleteDossier(id);
    	return "redirect:/correction/list";
    }
}
