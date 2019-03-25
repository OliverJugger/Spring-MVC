/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain;

import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author omignot
 *
 */
@Entity
@Table(name="PROGRAMME")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Programme extends AbstractTimestampEntity{
	
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
	
	@Column(name="CUSER", nullable=false, updatable=false)
	private String utilisateurCreation;
	
	@Column(name="MUSER", nullable=false)
	private String utilisateurModification;	
	
	@ManyToMany
	@JoinTable(
			name="LIEN_CORRECTION_PROGRAMME",
			joinColumns=@JoinColumn(name="ID_PROGRAMME", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID")
	)
	private List<Correction> corrections;
}
