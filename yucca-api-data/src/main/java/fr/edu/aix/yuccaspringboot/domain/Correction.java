/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain;

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

import org.springframework.util.StringUtils;

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
public class Correction extends AbstractTimestampEntity{
	
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
	
	@Column(name="CUSER", nullable=false, updatable=false)
	private String utilisateurCreation;
	
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
	
	public Correction (String titre, String probleme) {
		this.titre = titre;
		this.probleme = probleme;
	}
	
	public String getTypeProbleme(String code) throws Exception {
		String type="";
		if(StringUtils.isEmpty(code)) {
			if (code.contains("PAMCO")) {
				type="Jira";
			} else {
				try {
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
		if(StringUtils.isEmpty(code)) {
			if (code.contains("PAMCO")) {
				lien="https://sirhmen.atlassian.net/browse/" + code;
			} else {
				try {
					
					lien = "http://sesam.in.ac-toulouse.fr/appli/sesam/view.php?id=" + code.toString();
				} catch(NumberFormatException e) {
					throw new Exception ("code invalide");
				}
			}
		}
		return lien;
	}

}
