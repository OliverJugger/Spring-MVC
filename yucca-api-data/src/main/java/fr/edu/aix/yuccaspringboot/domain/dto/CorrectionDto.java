package fr.edu.aix.yuccaspringboot.domain.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.util.StringUtils;

import fr.edu.aix.yuccaspringboot.domain.AbstractTimestampEntity;
import fr.edu.aix.yuccaspringboot.domain.Programme;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorrectionDto extends AbstractTimestampEntity {
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
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="LIEN_CORRECTION_VERSION",
			joinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_VERSION", referencedColumnName = "ID")
	)
	private List<Version> versions;
	*/
	
}
