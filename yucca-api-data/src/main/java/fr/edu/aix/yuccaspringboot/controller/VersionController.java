/**
 * 
 */
package fr.edu.aix.yuccaspringboot.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.domain.Version;
import fr.edu.aix.yuccaspringboot.form.VersionForm;
import fr.edu.aix.yuccaspringboot.form.VersionToVersionForm;
import fr.edu.aix.yuccaspringboot.service.CorrectionService;
import fr.edu.aix.yuccaspringboot.service.VersionService;
import io.swagger.annotations.ApiOperation;

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
	
	@GetMapping(value="/listerVersions")
	@ApiOperation(value = "Retourne les données de toutes les versions")
	public ResponseEntity<List<Version>> listeVersions(){
		List<Version> versions = versionService.getAllVersions();
        return new ResponseEntity<>(versions, HttpStatus.OK);
	}
	
	@GetMapping(value = "/rechercher/{id}")
    public ResponseEntity<Version> getVersion(@PathVariable(value="id", required = true) Long id){
        Version version = versionService.getVersion(id);
        return new ResponseEntity<>(version, HttpStatus.OK);
    }
	
	@PostMapping(value="/enregistrer")
	@ApiOperation(value = "Enregistre ou met à jour une version")
    public ResponseEntity<Version> addVersion(@RequestBody @Valid final Version version){
		version.setDateCreation(Calendar.getInstance());
		version.setUtilisateurCreation("YUCCA-BACK");
		version.setUtilisateurModification("YUCCA-BACK");
		version.setEtat('A');
		version.setLibelle(version.getLibelle());
		versionService.addVersion(version);
		return new ResponseEntity<>(version, HttpStatus.CREATED);
    }
	 
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVersion(@PathVariable Long id) {
		 versionService.deleteLiens(id);
		 versionService.deleteVersion(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	 
	 /**
	 *  Fonction de suppression de liaison dans table LIEN_CORRECTION_VERSION
	 * @param idCorrection
	 * @param idVersion
	 * @param model
	 * @return la page de la version dont la liaison a la correction vient d'être supprimé
	 */
	@DeleteMapping("/{idVersion}/correction/delete/{idCorrection}")
    public ResponseEntity<?> deleteCorrection(@PathVariable(value="idVersion") Long idVersion, @PathVariable(value="idCorrection") Long idCorrection) {
		 versionService.deleteVersionCorrection(idVersion, idCorrection);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
