/**
 * 
 */
package fr.edu.aix.yuccaspringboot.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.domain.Version;
import fr.edu.aix.yuccaspringboot.form.CorrectionForm;
import fr.edu.aix.yuccaspringboot.form.VersionForm;
import fr.edu.aix.yuccaspringboot.form.VersionToVersionForm;
import fr.edu.aix.yuccaspringboot.service.CorrectionService;
import fr.edu.aix.yuccaspringboot.service.VersionService;

/**
 * @author omignot
 *
 */
@Controller
@RequestMapping("/version")
public class VersionController {
	
	private VersionService versionService;	
	private VersionToVersionForm versionToVersionForm;
	private CorrectionService correctionService;
	
	@Autowired
    public void setcorrectionService(CorrectionService correctionService) {
        this.correctionService = correctionService;
	}
	
	@Autowired
	public void setVersionToVersionForm(VersionToVersionForm versionToVersionForm) {
		this.versionToVersionForm = versionToVersionForm;
	}
	
	@Autowired
    public void setversionService(VersionService versionService) {
        this.versionService = versionService;
	}
	
	
	@RequestMapping("/")
    public String redirToList(){
        return "redirect:/version/list";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public String listProgrammes(Model model){
        model.addAttribute("versions", versionService.getAllVersions());
        return "/version/list";
    }
	
	@RequestMapping("/show/{id}")
    public String getVersion(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("version", versionService.getVersion(id));
        return "version/show";
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
    public String addVersion(Version version, Model model) {
		version.setDateCreation(Calendar.getInstance());
		version.setUtilisateurCreation("YUCCA-BACK");
		version.setUtilisateurModification("YUCCA-BACK");
		version.setEtat('A');
		version.setLibelle(version.getLibelle());
		versionService.addVersion(version);
        return "redirect:/version/list";
    }
	    
    @RequestMapping("/new")
    public String newVersion(Model model){
        model.addAttribute("versionForm", new VersionForm());
        model.addAttribute("corrections", correctionService.getAllCorrections());
        return "version/versionForm";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Version version = versionService.getVersion(id);
        VersionForm versionform = versionToVersionForm.convert(version);
        model.addAttribute("versionform", versionform);
        return "version/versionform";
    }	 
	 
	 @RequestMapping("/delete/{id}")
    public String deleteVersion(@PathVariable Long id) {
		 versionService.deleteLiens(id);
		 versionService.deleteVersion(id);
    	return "redirect:/version/list";
    }
}
