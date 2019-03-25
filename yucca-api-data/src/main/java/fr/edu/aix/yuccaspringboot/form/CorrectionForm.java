/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import java.util.Date;

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
	private Long application;
	private Long responsable;
	private char etat=' ';
	private Date dateCreation;
	private String utilisateurCreation;
	private Date dateModification;
	private String utilisateurModification;
	
}
