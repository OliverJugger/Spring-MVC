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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author omignot
 *
 */
@Entity
@Table(name="VERSION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Version extends AbstractTimestampEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="LIBELLE")
	private String libelle;
	
	@Column(name="ETAT")
	private char etat;
	
	@Column(name="CUSER")
	private String utilisateurCreation;
	
	@Column(name="MUSER")
	private String utilisateurModification;
	
	@ManyToMany
	@JoinTable(
			name="LIEN_CORRECTION_VERSION",
			joinColumns=@JoinColumn(name="ID_VERSION", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(name="ID_CORRECTION", referencedColumnName = "ID")
	)
	private List<Correction> corrections;
}
