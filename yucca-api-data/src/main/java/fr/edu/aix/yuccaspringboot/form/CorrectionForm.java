/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import java.util.Calendar;
import java.util.List;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.domain.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * @author omignot
 *
 */
@Getter
@Setter
public class CorrectionForm {

	private Long id;
	private String titre;
	private String codeProbleme;
	private String probleme;
	private String solution;
	private String commentaire;
	private char etat=' ';
	private Long application;
	private Long responsable;
	private String utilisateurCreation;
	private String utilisateurModification;
	private Calendar dateCreation;
	private Calendar dateModification;
	private List<Programme> programmes;
	private List<Version> versions;
	
}
