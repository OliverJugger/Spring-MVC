package fr.edu.aix.yuccaspringboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOSSIER")
public class Dossier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="CHEMIN")
	private String chemin;
	
	@Column(name="RACCOURCI_UNIX")
	private String raccourci;
	
	public Dossier() {
		
	}	

	/**
	 * @param id
	 * @param nom
	 * @param chemin
	 * @param raccourci
	 */
	public Dossier(Long id, String nom, String chemin, String raccourci) {
		super();
		this.id = id;
		this.nom = nom;
		this.chemin = chemin;
		this.raccourci = raccourci;
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
	 * @return the chemin
	 */
	public String getChemin() {
		return chemin;
	}

	/**
	 * @param chemin the chemin to set
	 */
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	/**
	 * @return the raccourci
	 */
	public String getRaccourci() {
		return raccourci;
	}

	/**
	 * @param raccourci the raccourci to set
	 */
	public void setRaccourci(String raccourci) {
		this.raccourci = raccourci;
	}
	
	
	
}
