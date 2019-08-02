package fr.edu.aix.yuccaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.Domaine;
import fr.edu.aix.yuccaspringboot.domain.Repertoire;
import fr.edu.aix.yuccaspringboot.service.DomaineService;
import fr.edu.aix.yuccaspringboot.service.RepertoireService;
import io.swagger.annotations.Api;

/**
 * @author omignot
 * Controller REST de la gestion des domaines de Yucca
 */
@RestController
@Api(value = "Operations de gestion des domaines")
@RequestMapping(value = "/domaine")
public class DomaineController {
	
	@Autowired
	public DomaineService domaineService;	

    @Autowired
    public void setDomaineService(DomaineService domaineService) {
        this.domaineService = domaineService;
    }
	
	@GetMapping(value = "")
    public ResponseEntity<Iterable<Domaine>> listDomaines(){
		return new ResponseEntity<>(domaineService.getAllDomaines(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/visible/{visible}")
    public ResponseEntity<Iterable<Domaine>> getDomainesVisible(@PathVariable(value="visible", required = true) char visible){
		return new ResponseEntity<>(domaineService.getDomainesVisible(visible), HttpStatus.OK);
    }	
}