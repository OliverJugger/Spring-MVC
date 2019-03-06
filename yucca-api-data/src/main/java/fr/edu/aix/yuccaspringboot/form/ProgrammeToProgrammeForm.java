/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import org.springframework.stereotype.Component;

import fr.edu.aix.yuccaspringboot.domain.Programme;

import org.springframework.core.convert.converter.Converter;

/**
 * @author omignot
 *
 */
@Component
public class ProgrammeToProgrammeForm implements Converter<Programme, ProgrammeForm> {
	
    @Override
    public ProgrammeForm convert(Programme programme) {
    	ProgrammeForm programmeForm = new ProgrammeForm();
    	programmeForm.setId(programme.getId());
    	programmeForm.setNom(programme.getNom());
    	programmeForm.setCommentaire(programme.getCommentaire());
    	programmeForm.setTemporaire(programme.getTemporaire());
    	programmeForm.setDateCreation(programme.getDateCreation());
    	programmeForm.setUtilisateurCreation(programme.getUtilisateurCreation());
        return programmeForm;
    }

}