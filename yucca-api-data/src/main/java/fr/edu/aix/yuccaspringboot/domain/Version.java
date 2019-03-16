/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Date dateModifcation;
	
	@Column(name="MUSER")
	private String utilisateurModifcation;
	
	@ManyToMany(fetch = FetchType.EAGER)
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
	 * @param dateModifcation
	 * @param utilisateurModifcation
	 * @param corrections
	 */
	public Version(Long id, String libelle, char etat, Date dateCreation, String utilisateurCreation,
			Date dateModifcation, String utilisateurModifcation, List<Correction> corrections) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.etat = etat;
		this.dateCreation = dateCreation;
		this.utilisateurCreation = utilisateurCreation;
		this.dateModifcation = dateModifcation;
		this.utilisateurModifcation = utilisateurModifcation;
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
	 * @return the dateModifcation
	 */
	public Date getDateModifcation() {
		return dateModifcation;
	}

	/**
	 * @param dateModifcation the dateModifcation to set
	 */
	public void setDateModifcation(Date dateModifcation) {
		this.dateModifcation = dateModifcation;
	}

	/**
	 * @return the utilisateurModifcation
	 */
	public String getUtilisateurModifcation() {
		return utilisateurModifcation;
	}

	/**
	 * @param utilisateurModifcation the utilisateurModifcation to set
	 */
	public void setUtilisateurModifcation(String utilisateurModifcation) {
		this.utilisateurModifcation = utilisateurModifcation;
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
