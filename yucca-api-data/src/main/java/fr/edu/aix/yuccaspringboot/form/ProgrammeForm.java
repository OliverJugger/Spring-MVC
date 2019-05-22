/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import java.util.Calendar;
import java.util.List;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import lombok.Getter;
import lombok.Setter;

/**
 * @author omignot
 *
 */
@Getter
@Setter
public class ProgrammeForm {

	private Long id;
	private String nom;
	private String commentaire;
	private char temporaire;
	private Long idDomaine;
	private Long idDossier;
	private String utilisateurCreation;
	private Calendar dateCreation;
	private Calendar dateModification;
	private List<Correction> corrections;
	
}
