/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Correction extends AbstractEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
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
	
	@ManyToOne
	@JoinColumn(name="ID_DOMAINE", nullable=false)
	private Domaine domaine;
	
	@ManyToOne
	@JoinColumn(name="ID_AUTEUR", nullable=false)
	private Auteur auteur;
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="LIEN_CORRECTION_PROGRAMME",
			joinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_PROGRAMME", referencedColumnName = "ID")
	)
	private List<Programme> programmes;*/
	
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
