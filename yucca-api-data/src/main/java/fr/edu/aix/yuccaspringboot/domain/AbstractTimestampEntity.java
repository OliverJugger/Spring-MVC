package fr.edu.aix.yuccaspringboot.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Mignot
 * 
 * Cette classe agit comme @Version de hibernate sans propagation 
 * des mises à jours à la modification des enfants/parents
 * à cause du @OneToMany ou du
 * @ManyToOne
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractTimestampEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Calendar dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_AT", nullable = false)
    private Calendar dateModification;

    @PrePersist
    protected void onCreate() {
    	dateModification = dateCreation = Calendar.getInstance();
    }

    @PreUpdate
    protected void onUpdate() {
    	dateModification = Calendar.getInstance();
    }
}