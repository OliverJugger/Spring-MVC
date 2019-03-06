/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import java.util.Date;

/**
 * @author omignot
 *
 */
public class ProgrammeForm {

	private Long id;
	private String nom;
	private String commentaire;
	private char temporaire;
	private Date dateCreation;
	private String utilisateurCreation;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}
	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	/**
	 * @return the temporaire
	 */
	public char getTemporaire() {
		return temporaire;
	}
	/**
	 * @param temporaire the temporaire to set
	 */
	public void setTemporaire(char temporaire) {
		this.temporaire = temporaire;
	}
	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the utilisateurCreation
	 */
	public String getUtilisateurCreation() {
		return utilisateurCreation;
	}
	/**
	 * @param utilisateurCreation the utilisateurCreation to set
	 */
	public void setUtilisateurCreation(String utilisateurCreation) {
		this.utilisateurCreation = utilisateurCreation;
	}
	
	
	
}
