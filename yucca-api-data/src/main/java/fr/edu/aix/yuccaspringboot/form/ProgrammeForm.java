/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import java.util.Calendar;

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
	private Calendar dateCreation;
	private String utilisateurCreation;
	
}
