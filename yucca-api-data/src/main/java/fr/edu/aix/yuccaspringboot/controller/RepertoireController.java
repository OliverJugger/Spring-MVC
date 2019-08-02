package fr.edu.aix.yuccaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.domain.Repertoire;
import fr.edu.aix.yuccaspringboot.service.ProgrammeService;
import fr.edu.aix.yuccaspringboot.service.RepertoireService;
import io.swagger.annotations.Api;

/**
 * @author omignot
 * Controller REST de la gestion des Repertoires de Yucca
 */
@RestController
@Api(value = "Operations de gestion des repertoires")
@RequestMapping(value = "/repertoire")
public class RepertoireController {
	
	@Autowired
	public RepertoireService repertoireService;	

    @Autowired
    public void setRepertoireService(RepertoireService repertoireService) {
        this.repertoireService = repertoireService;
    }
	
	@GetMapping(value = "")
    public ResponseEntity<Iterable<Repertoire>> listRepertoires(){
		return new ResponseEntity<>(repertoireService.getAllRepertoires(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/visible/{visible}")
    public ResponseEntity<Iterable<Repertoire>> getRepertoiresVisible(@PathVariable(value="visible", required = true) char visible){
		return new ResponseEntity<>(repertoireService.getRepertoiresVisible(visible), HttpStatus.OK);
    }	
	
}
