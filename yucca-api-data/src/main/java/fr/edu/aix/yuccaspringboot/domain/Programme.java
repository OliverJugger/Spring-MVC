/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="PROGRAMME")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Programme extends AbstractTimestampEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="ID_PROGRAMME")
	private Long idProgramme;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="COMMENTAIRE")
	private String commentaire;
	
	@Column(name="TEMPORAIRE", nullable=false)
	private char temporaire;
	
	@Column(name="ID_REPERTOIRE", nullable=false)
	private Long idRepertoire;
	
	@Column(name="ID_DOMAINE", nullable=false)
	private Long idDomaine;
	
	@Column(name="ID_SOUS_DOMAINE", nullable=false)
	private Long idSousDomaine;
	
	@Column(name="CUSER", nullable=false, updatable=false)
	private String utilisateurCreation;
	
	@Column(name="MUSER", nullable=false)
	private String utilisateurModification;	
	
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="LIEN_CORRECTION_PROGRAMME",
			joinColumns=@JoinColumn(name="ID_PROGRAMME", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID")
	)
	private List<Correction> corrections;
	*/
}
