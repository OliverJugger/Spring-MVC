/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import java.util.Calendar;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author omignot
 *
 */
@Getter
@Setter
public class VersionForm {

	private Long id;
	private String libelle;
	private char etat=' ';
	private Calendar dateCreation;
	private String utilisateurCreation;
	private Calendar dateModification;
	private String utilisateurModification;
	
}
