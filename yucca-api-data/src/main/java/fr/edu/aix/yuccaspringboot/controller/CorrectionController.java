package fr.edu.aix.yuccaspringboot.controller;

import java.io.IOException;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.form.CorrectionForm;
import fr.edu.aix.yuccaspringboot.mapper.CorrectionMapper;
import fr.edu.aix.yuccaspringboot.service.CorrectionService;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;

/**
 * @author omignot
 */
@RestController
@RequestMapping("/correction")
public class CorrectionController {
	
	private CorrectionService correctionService;	
	private ProgrammeService programmeService;

	@Autowired
    public void setCorrectionService(CorrectionService correctionService) {
        this.correctionService = correctionService;
	}
	
	@Autowired
    public void setProgrammeService(ProgrammeService programmeService) {
        this.programmeService = programmeService;
	}
	
	@RequestMapping("/")
    public String redirToList(){
        return "redirect:/correction/list";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public List<Correction> listProgrammes(){
        return correctionService.getAllCorrections();
    }
	
	@RequestMapping("/new")
    public String newProgramme(){
        return "correction/correctionForm";
    }
	
	@RequestMapping("/show/{id}")
    public Correction getProgramme(@PathVariable(value="id", required = true) Long id){
        //programmeService.getAllProgrammes());
        return  correctionService.getCorrection(id);
    }   
	 
	@RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id){
        Correction correction = correctionService.getCorrection(id);
        return "correction/correctionForm";
    }
	 
	@RequestMapping(value="/add",method=RequestMethod.POST)
    public String addCorrection(Correction correction) {
		 correction.setEtat('O');
		 correction.setUtilisateurCreation("YUCCA-BACK");
		 correction.setUtilisateurModification("YUCCA-BACK");
		 correction.setApplication(new Long(30));
		 correction.setResponsable(new Long(50));
		 if(correction.getId() != null) {
			 correctionService.updateCorrection(correction);
		 } else {
			 correctionService.addCorrection(correction);
		 }
        return "redirect:/correction/list";
    }
	
	/**
	 *  Fonction de suppression de liaison dans table LIEN_CORRECTION_PROGRAMME
	 * @param idCorrection
	 * @param idProgramme
	 * @param model
	 * @return la page de la correction dont la liaison au programme vient d'être supprimé
	 */
	@RequestMapping("/{idCorrection}/programme/delete/{idProgramme}")
    public String deleteProgrammeCorrection(@PathVariable(value="idCorrection") Long idCorrection, @PathVariable(value="idProgramme") Long idProgramme) {
		 correctionService.deleteProgrammeCorrection(idCorrection, idProgramme);
    	return "redirect:/correction/show/" + idCorrection;
    }
	
	/**
	 *  Fonction d'ajout de liaison dans table LIEN_CORRECTION_PROGRAMME
	 * @param idCorrection
	 * @param idProgramme
	 * @param model
	 * @return la page de la correction dont la liaison au programme vient d'être créée
	 */
	@RequestMapping("/{idCorrection}/programme/add/{idProgramme}")
    public String addProgrammeCorrection(@PathVariable(value="idCorrection") Long idCorrection, @PathVariable(value="idProgramme") Long idProgramme) {
		 correctionService.addProgrammeCorrection(idCorrection, idProgramme);
    	return "redirect:/correction/show/" + idCorrection;
    }
	
	
	@RequestMapping("/exporter/{idCorrection}")
	public String exporterCorrection(@PathVariable(value="idCorrection") Long idCorrection) throws IOException {
		 correctionService.exporterCorrection(idCorrection);
		 return "redirect:/correction/show/" + idCorrection;
	}
}
