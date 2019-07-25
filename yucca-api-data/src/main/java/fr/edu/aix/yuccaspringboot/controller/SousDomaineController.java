package fr.edu.aix.yuccaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.edu.aix.yuccaspringboot.domain.SousDomaine;
import fr.edu.aix.yuccaspringboot.service.SousDomaineService;
import io.swagger.annotations.Api;

/**
 * @author omignot
 * Controller REST de la gestion des sous-domaines de Yucca
 */
@RestController
@Api(value = "Operations de gestion des domaines")
@RequestMapping(value = "/sousdomaine")
public class SousDomaineController {
	
	@Autowired
	public SousDomaineService sousDomaineService;	

    @Autowired
    public void setDomaineService(SousDomaineService sousDomaineService) {
        this.sousDomaineService = sousDomaineService;
    }
	
	@GetMapping(value = "")
    public ResponseEntity<Iterable<SousDomaine>> listDomaines(){
		return new ResponseEntity<>(sousDomaineService.getAllSousDomaines(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/visible/{visible}")
    public ResponseEntity<Iterable<SousDomaine>> getDomainesVisible(@PathVariable(value="visible", required = true) char visible){
		return new ResponseEntity<>(sousDomaineService.getSousDomainesVisible(visible), HttpStatus.OK);
    }	
}