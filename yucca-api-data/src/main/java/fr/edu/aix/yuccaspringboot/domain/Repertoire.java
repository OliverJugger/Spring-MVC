package fr.edu.aix.yuccaspringboot.domain;

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
@Table(name="REPERTOIRE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Repertoire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="CHEMIN")
	private String chemin;
	
	@Column(name="RACCOURCI_UNIX")
	private String raccourci_unix;
	
	@Column(name="VISIBLE")
	private char visible;
}
