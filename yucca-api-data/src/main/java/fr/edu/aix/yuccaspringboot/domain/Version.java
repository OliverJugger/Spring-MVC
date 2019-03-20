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
@Table(name="VERSION")
public class Version {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="LIBELLE")
	private String libelle;
	
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
			name="LIEN_CORRECTION_VERSION",
			joinColumns=@JoinColumn(name="ID_VERSION", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID")
	)
	private List<Correction> corrections;

	public Version() {
		
	}	

	/**
	 * @param id
	 * @param libelle
	 * @param etat
	 * @param dateCreation
	 * @param utilisateurCreation
	 * @param dateModification
	 * @param utilisateurModification
	 * @param corrections
	 */
	public Version(Long id, String libelle, char etat, Date dateCreation, String utilisateurCreation,
			Date dateModification, String utilisateurModification, List<Correction> corrections) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.etat = etat;
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	public String getUtilisateurModifcation() {
		return utilisateurModification;
	}

	/**
	 * @param utilisateurModification the utilisateurModification to set
	 */
	public void setUtilisateurModifcation(String utilisateurModification) {
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
