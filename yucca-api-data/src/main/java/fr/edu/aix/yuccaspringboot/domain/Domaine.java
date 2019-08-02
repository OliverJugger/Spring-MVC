package fr.edu.aix.yuccaspringboot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

@Entity
@Table(name="DOMAINE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domaine implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="LIBELLE_COURT")
	private String libelleCourt;
	
	@Column(name="LIBELLE_LONG")
	private String libelleLong;
	
	@Column(name="VISIBLE")
	private char visible;
}
