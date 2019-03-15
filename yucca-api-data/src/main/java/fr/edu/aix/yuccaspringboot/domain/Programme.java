/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain;

import java.util.Date;
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
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;

/**
 * @author omignot
 *
 */
@Entity
@Table(name="PROGRAMME")
public class Programme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="COMMENTAIRE")
	private String commentaire;
	
	@Column(name="TEMPORAIRE", nullable=false)
	private char temporaire;
	
	@Column(name="ID_DOMAINE", nullable=false)
	private Long idDomaine;
	
	@Column(name="ID_DOSSIER", nullable=false)
	private Long idDossier;
	
	@Column(name="CREATED_AT", nullable=false, updatable=false)
	private Date dateCreation;
	
	@Column(name="CUSER", nullable=false, updatable=false)
	private String utilisateurCreation;
	
	@Version
	@Column(name="UPDATED_AT", nullable=false)
	private Date dateModification;
	
	@Column(name="MUSER", nullable=false)
	private String utilisateurModification;	
	
	@ManyToMany(mappedBy = "programmes")
	private List<Correction> corrections;
	
	public Programme() {
	}

	/**
	 * @param id
	 * @param nom
	 * @param commentaire
	 * @param temporaire
	 * @param idDomaine
	 * @param idDossier
	 * @param dateCreation
	 * @param utilisateurCreation
	 * @param dateModification
	 * @param utilisateurModification
	 * @param corrections
	 */
	public Programme(Long id, String nom, String commentaire, char temporaire, Long idDomaine, Long idDossier,
			Date dateCreation, String utilisateurCreation, Date dateModification, String utilisateurModification,
			List<Correction> corrections) {
		super();
		this.id = id;
		this.nom = nom;
		this.commentaire = commentaire;
		this.temporaire = temporaire;
		this.idDomaine = idDomaine;
		this.idDossier = idDossier;
		this.dateCreation = dateCreation;
		this.utilisateurCreation = utilisateurCreation;
		this.dateModification = dateModification;
		this.utilisateurModification = utilisateurModification;
		this.corrections = corrections;
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
	 * @return the idDomaine
	 */
	public Long getIdDomaine() {
		return idDomaine;
	}

	/**
	 * @param idDomaine the idDomaine to set
	 */
	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}

	/**
	 * @return the idDossier
	 */
	public Long getIdDossier() {
		return idDossier;
	}

	/**
	 * @param idDossier the idDossier to set
	 */
	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
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
	 * @return the dateModification
	 */
	public Date getDateModification() {
		return dateModification;
	}

	/**
	 * @param dateModification the dateModification to set
	 */
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	/**
	 * @return the utilisateurModification
	 */
	public String getUtilisateurModification() {
		return utilisateurModification;
	}

	/**
	 * @param utilisateurModification the utilisateurModification to set
	 */
	public void setUtilisateurModification(String utilisateurModification) {
		this.utilisateurModification = utilisateurModification;
	}

	/**
	 * @return the corrections
	 */
	public List<Correction> getCorrections() {
		return corrections;
	}

	/**
	 * @param corrections the corrections to set
	 */
	public void setCorrections(List<Correction> corrections) {
		this.corrections = corrections;
	}	

}
