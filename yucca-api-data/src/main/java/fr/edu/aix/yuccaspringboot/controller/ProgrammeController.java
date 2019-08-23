package fr.edu.aix.yuccaspringboot.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author omignot
 * Controller REST de la gestion des Programmes de Yucca
 */
@RestController
@Api(value = "Operations de gestion des programmes")
@RequestMapping(value = "/programme")
public class ProgrammeController {
	
	private ProgrammeService programmeService;	

	//private	ProgrammeMapper mapper = Mappers.getMapper(ProgrammeMapper.class);

    @Autowired
    public void setProgrammeService(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }
	
	@GetMapping(value = "")
    public ResponseEntity<Iterable<Programme>> listProgrammes(){
		return new ResponseEntity<>(programmeService.getAllProgrammes(), HttpStatus.OK);
    }

    @PostMapping("/rechercher")
	@ApiOperation(value = "Recherche une liste de programmes à partir d'un programme")
    public ResponseEntity<Iterable<Programme>> getProgrammes(@RequestBody @Valid final Programme programme){
    	ResponseEntity<Iterable<Programme>> response = new ResponseEntity<>(programmeService.getProgrammes(programme), HttpStatus.OK);
    	return response;
    }

    @PostMapping("/enregistrer")
	@ApiOperation(value = "Enregistre ou met à jour un programme")
    public ResponseEntity<Programme> addProgramme(@RequestBody @Valid final Programme programme){
    	
    	programme.setUtilisateurCreation("YUCCA-BACK");
    	programme.setUtilisateurModification("YUCCA-BACK");
    	
        programmeService.saveProgramme(programme);   
        return new ResponseEntity<>(programme, HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> deleteProgramme(@PathVariable Long id) {
    	programmeService.deleteLiens(id);
    	programmeService.deleteProgramme(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
