/**
 * 
 */
package fr.edu.aix.yuccaspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@Controller
@RequestMapping("/version")
public class VersionController {
	
	@Autowired
	private VersionService versionService;
	
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
    public String getProgramme(@PathVariable(value="id", required = true) Long id, Model model){
        model.addAttribute("version", versionService.getVersion(id));
        return "version/show";
    }   
	 
	 @RequestMapping("/delete/{id}")
    public String deleteVersion(@PathVariable Long id) {
		 versionService.deleteLiens(id);
		 versionService.deleteVersion(id);
    	return "redirect:/version/list";
    }
}
