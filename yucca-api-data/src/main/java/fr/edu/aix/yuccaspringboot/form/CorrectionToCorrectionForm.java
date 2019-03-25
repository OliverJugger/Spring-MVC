/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import org.springframework.stereotype.Component;

import fr.edu.aix.yuccaspringboot.domain.Correction;

import org.springframework.core.convert.converter.Converter;

/**
 * @author omignot
 *
 */
@Component
public class CorrectionToCorrectionForm implements Converter<Correction, CorrectionForm> {
	
    @Override
    public CorrectionForm convert(Correction correction) {
    	CorrectionForm correctionForm = new CorrectionForm();
    	correctionForm.setId(correction.getId());
    	correctionForm.setTitre(correction.getTitre());
    	correctionForm.setCodeProbleme(correction.getCodeProbleme());
    	correctionForm.setEtat(correction.getEtat());
    	correctionForm.setProbleme(correction.getProbleme());
    	correctionForm.setSolution(correction.getSolution());
    	correctionForm.setCommentaire(correction.getCommentaire());
    	correctionForm.setApplication(correction.getApplication());
    	correctionForm.setResponsable(correction.getResponsable());
    	correctionForm.setDateCreation(correction.getDateCreation());
    	correctionForm.setUtilisateurCreation(correction.getUtilisateurCreation());
    	correctionForm.setDateModification(correction.getDateModification());
    	correctionForm.setUtilisateurModification(correction.getUtilisateurModification());
        return correctionForm;
    }

}