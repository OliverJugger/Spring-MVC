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
public class ProgrammeForm {

	private Long id;
	private String nom;
	private String commentaire;
	private char temporaire;
	private Date dateCreation;
	private String utilisateurCreation;
	
}
