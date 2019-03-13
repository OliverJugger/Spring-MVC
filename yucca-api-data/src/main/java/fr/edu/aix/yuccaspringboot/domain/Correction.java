/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author omignot
 *
 */
@Entity
@Table(name="CORRECTION")
public class Correction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="PROBLEME")
	private String probleme;
	
	@Column(name="SOLUTION")
	private String solution;
	
	@Column(name="COMMENTAIRE")
	private String commentaire;
	
	@Column(name="ETAT")
	private char etat;
	
	@Column(name="CREATED_AT")
	private Date dateCreation;
	
	@Column(name="CUSER")
	private String utilisateurCreation;
	
	@Column(name="UPDATED_AT")
	private Date dateModification;
	
	@Column(name="MUSER")
	private String utilisateurModification;	
	
	@ManyToMany
	@JoinTable(
			name="LIEN_CORRECTION_PROGRAMME",
			joinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_PROGRAMME", referencedColumnName = "ID")
	)
	private List<Programme> programmes;
	
	@ManyToMany
	@JoinTable(
			name="LIEN_CORRECTION_VERSION",
			joinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_VERSION", referencedColumnName = "ID")
	)
	private List<Version> versions;
	
	public Correction() {
		
	}

	/**
	 * @param id
	 * @param titre
	 * @param probleme
	 * @param solution
	 * @param commentaire
	 * @param etat
	 * @param dateCreation
	 * @param utilisateurCreation
	 * @param dateModifcation
	 * @param utilisateurModifcation
	 * @param programmes
	 * @param versions
	 */
	public Correction(Long id, String titre, String probleme, String solution, String commentaire, char etat,
			Date dateCreation, String utilisateurCreation, Date dateModification, String utilisateurModification,
			List<Programme> programmes, List<Version> versions) {
		super();
		this.id = id;
		this.titre = titre;
		this.probleme = probleme;
		this.solution = solution;
		this.commentaire = commentaire;
		this.etat = etat;
		this.dateCreation = dateCreation;
		this.utilisateurCreation = utilisateurCreation;
		this.dateModification = dateModification;
		this.utilisateurModification = utilisateurModification;
		this.programmes = programmes;
		this.versions = versions;
	}



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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the probleme
	 */
	public String getProbleme() {
		return probleme;
	}

	/**
	 * @param probleme the probleme to set
	 */
	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}

	/**
	 * @return the solution
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(String solution) {
		this.solution = solution;
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
	 * @return the etat
	 */
	public char getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(char etat) {
		this.etat = etat;
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

	/**
	 * @return the dateModifcation
	 */
	public Date getDateModification() {
		return dateModification;
	}

	/**
	 * @param dateModifcation the dateModifcation to set
	 */
	public void setDateModifcation(Date dateModification) {
		this.dateModification = dateModification;
	}

	/**
	 * @return the utilisateurModifcation
	 */
	public String getUtilisateurModification() {
		return utilisateurModification;
	}

	/**
	 * @param utilisateurModifcation the utilisateurModifcation to set
	 */
	public void setUtilisateurModification(String utilisateurModification) {
		this.utilisateurModification = utilisateurModification;
	}

	/**
	 * @return the programmes
	 */
	public List<Programme> getProgrammes() {
		return programmes;
	}

	/**
	 * @param programmes the programmes to set
	 */
	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}

	/**
	 * @return the versions
	 */
	public List<Version> getVersions() {
		return versions;
	}

	/**
	 * @param versions the versions to set
	 */
	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

}
