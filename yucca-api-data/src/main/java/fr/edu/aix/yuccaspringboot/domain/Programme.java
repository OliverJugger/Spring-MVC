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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Programme extends AbstractEntity implements Serializable {
	
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
	
	@ManyToOne
	@JoinColumn(name = "ID_REPERTOIRE")
	private Repertoire repertoire;
	
	@ManyToOne
	@JoinColumn(name = "ID_DOMAINE")
	private Domaine domaine;
	
	@ManyToOne
	@JoinColumn(name = "ID_SOUS_DOMAINE")
	private SousDomaine sousDomaine;
	
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
