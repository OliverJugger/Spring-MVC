/**
 * 
 */
package fr.edu.aix.yuccaspringboot.domain.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author omignot
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProgrammeDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
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
	
	@Column(name="ID_REPERTOIRE", nullable=false)
	private Long idRepertoire;
	
	@Column(name="ID_DOMAINE", nullable=false)
	private Long idDomaine;
	
	@Column(name="ID_SOUS_DOMAINE", nullable=false)
	private Long idSousDomaine;
	
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
