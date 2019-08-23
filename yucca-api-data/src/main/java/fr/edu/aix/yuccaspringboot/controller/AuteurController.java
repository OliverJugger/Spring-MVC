package fr.edu.aix.yuccaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Auteur;
import fr.edu.aix.yuccaspringboot.service.AuteurService;
import io.swagger.annotations.Api;

/**
 * @author jperona
 * Controller REST de la gestion des auteurs de Yucca
 */
@RestController
@Api(value = "Operations de gestion des auteurs")
@RequestMapping(value = "/auteur")
public class AuteurController {
	@Autowired
	public AuteurService auteurService;	

    @Autowired
    public void setDomaineService(AuteurService auteurService) {
        this.auteurService = auteurService;
    }
	
	@GetMapping(value = "")
    public ResponseEntity<Iterable<Auteur>> listDomaines(){
		return new ResponseEntity<>(auteurService.getAllAuteurs(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/actif/{actif}")
    public ResponseEntity<Iterable<Auteur>> getAuteursVisible(@PathVariable(value="actif", required = true) char actif){
		return new ResponseEntity<>(auteurService.getAuteursVisible(actif), HttpStatus.OK);
    }	
}
