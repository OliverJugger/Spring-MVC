package fr.edu.aix.yuccaspringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.edu.aix.yuccaspringboot.domain.Auteur;
import fr.edu.aix.yuccaspringboot.repository.AuteurRepository;

@Service
public class AuteurService {
	
	@Autowired
	public AuteurRepository auteurRepository;
	
	public List<Auteur> getAllAuteurs(){
		List<Auteur> auteurs = new ArrayList<>();
		auteurRepository.findAll().forEach(auteurs::add);
        return auteurs;
	}
	
	public List<Auteur> getAuteursVisible(char actif){
		List<Auteur> auteurs = new ArrayList<>();
		auteurRepository.findByActif(actif).forEach(auteurs::add);
        return auteurs;
	}
}
