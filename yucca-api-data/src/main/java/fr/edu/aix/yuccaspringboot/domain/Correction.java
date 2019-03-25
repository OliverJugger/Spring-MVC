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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author omignot
 *
 */
@Entity
@Table(name="CORRECTION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Correction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="CODE_PROBLEME")
	private String codeProbleme;
	
	@Column(name="PROBLEME")
	private String probleme;
	
	@Column(name="SOLUTION")
	private String solution;
	
	@Column(name="COMMENTAIRE")
	private String commentaire;
	
	@Column(name="ETAT", nullable=false)
	private char etat;
	
	@Column(name="ID_APPLICATION", nullable=false)
	private Long application;
	
	@Column(name="ID_RESPONSABLE", nullable=false)
	private Long responsable;
	
	@Column(name="CREATED_AT", nullable=false, updatable=false)
	private Date dateCreation;
	
	@Column(name="CUSER", nullable=false, updatable=false)
	private String utilisateurCreation;
	
	@Column(name="UPDATED_AT", nullable=false)
	private Date dateModification;
	
	@Column(name="MUSER", nullable=false)
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
	
	public String getTypeProbleme(String code) throws Exception {
		String type="";
		if(code != null && !code.isEmpty()) {
			if (code.contains("PAMCO")) {
				type="Jira";
			} else {
				try {
					int test = Integer.parseInt(code);
					type = "Sesame";
				} catch(NumberFormatException e) {
					throw new Exception ("code invalide");
				}
			}
		}
		return type;
	}
	
	public String getLienProbleme(String code) throws Exception {
		String lien="";
		if(code != null && !code.isEmpty()) {
			if (code.contains("PAMCO")) {
				lien="https://sirhmen.atlassian.net/browse/" + code;
			} else {
				try {
					int test = Integer.parseInt(code);
					lien = "http://sesam.in.ac-toulouse.fr/appli/sesam/view.php?id=" + code;
				} catch(NumberFormatException e) {
					throw new Exception ("code invalide");
				}
			}
		}
		return lien;
	}

}
