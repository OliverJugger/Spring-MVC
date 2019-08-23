package fr.edu.aix.yuccaspringboot.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.service.CorrectionService;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author omignot
 * Controller REST de la gestion des Corrections de Yucca
 */
@RestController
@Api(value = "Operations de gestion des corrections")
@RequestMapping(value = "/correction")
public class CorrectionController {
	
	private CorrectionService correctionService;	
	private ProgrammeService programmeService;

	//private CorrectionMapper mapper = Mappers.getMapper(CorrectionMapper.class);

	@Autowired
    public void setCorrectionService(CorrectionService correctionService) {
        this.correctionService = correctionService;
	}
	
	@Autowired
    public void setProgrammeService(ProgrammeService programmeService) {
        this.programmeService = programmeService;
	}
	
	@GetMapping(value="")
	@ApiOperation(value = "Retourne les données de toutes les corrections")
	public ResponseEntity<Iterable<Correction>> listCorrections(){		
        return new ResponseEntity<>(correctionService.getAllCorrections(), HttpStatus.OK);
    } 
	
	@GetMapping(value="/rechercher/{idCorrection}")
	@ApiOperation(value = "Retourne les données d'une correction")
	 public ResponseEntity<Correction> getCorrection(@PathVariable(value="idCorrection", required = true) Long id){
        Correction correction = correctionService.getCorrection(id);
        return new ResponseEntity<>(correction, HttpStatus.OK);
    } 

	/*@GetMapping(value="/{idCorrection}/listeProgrammes")	
	@ApiOperation(value = "Retourne la liste de tous les programmes d'une correction")
    public ResponseEntity<List<Programme>> getCorrectionlistProgrammes(@PathVariable(value="idCorrection", required = true) Long id){
        Correction correction = correctionService.getCorrection(id);
        List<Programme> programmesCorrection = correction.getProgrammes();
        return new ResponseEntity<>(programmesCorrection, HttpStatus.OK);
    }*/
	
	@PutMapping("/enregistrer")
	@ApiOperation(value = "Met à jour une correction")
    public ResponseEntity<Correction> updateCorrection(@RequestBody @Valid final Correction correction){
		 	 
		 if(correction.getId() != null) {
			 correctionService.updateCorrection(correction);
		 } else {
			 correctionService.addCorrection(correction);
		 }
        return new ResponseEntity<>(correction, HttpStatus.CREATED);
    }
	
	@PostMapping("/enregistrer")
	@ApiOperation(value = "Enregistre ou met à jour une correction")
    public ResponseEntity<Correction> addCorrection(@RequestBody @Valid final Correction correction){
		 
		 if(correction.getId() != null) {
			 correctionService.updateCorrection(correction);
		 } else {
			 System.out.println("Correction a ajouter : "  + correction.getTitre());
			 correction.setUtilisateurCreation("YUCCA-BACK");
			 correction.setUtilisateurModification("YUCCA-BACK");			 
			 correctionService.addCorrection(correction);
		 }
        return new ResponseEntity<>(correction, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/supprimmer/{idCorrection}")
	@ApiOperation(value = "Supprime une correction")
    public ResponseEntity<?> deleteCorrection(@PathVariable(value="idCorrection") Long idCorrection) {
		 correctionService.deleteCorrection(idCorrection);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	/**
	 *  Fonction de suppression de liaison dans table LIEN_CORRECTION_PROGRAMME
	 * @param idCorrection
	 * @param idProgramme
	 * @param model
	 * @return la page de la correction dont la liaison au programme vient d'être supprimé
	 */
	/*@DeleteMapping("/{idCorrection}/supprimer_programme/{idProgramme}")
	@ApiOperation(value = "Supprime un programme d'une correction")
    public ResponseEntity<?> deleteProgrammeCorrection(@PathVariable(value="idCorrection") Long idCorrection, @PathVariable(value="idProgramme") Long idProgramme) {
		 correctionService.deleteProgrammeCorrection(idCorrection, idProgramme);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
	
	/**
	 *  Fonction d'ajout de liaison dans table LIEN_CORRECTION_PROGRAMME
	 * @param idCorrection
	 * @param idProgramme
	 * @param model
	 * @return la page de la correction dont la liaison au programme vient d'être créée
	 */
	/*@GetMapping(value = "/{idCorrection}/ajouter_programme/{idProgramme}")
	@ApiOperation(value = "Ajout un programme à une correction")
    public ResponseEntity<?> addProgrammeCorrection(@PathVariable(value="idCorrection") Long idCorrection, @PathVariable(value="idProgramme") Long idProgramme) {
		 correctionService.addProgrammeCorrection(idCorrection, idProgramme);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
	
	
	@GetMapping(value = "/exporter/{idCorrection}")
	@ApiOperation(value = "Exporte une correction")
	public ResponseEntity<?> exporterCorrection(@PathVariable(value="idCorrection") Long idCorrection, Model model) throws IOException {
		 correctionService.exporterCorrection(idCorrection);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
