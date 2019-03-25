/**
 * 
 */
package fr.edu.aix.yuccaspringboot.form;

import org.springframework.stereotype.Component;

import fr.edu.aix.yuccaspringboot.domain.Version;

import org.springframework.core.convert.converter.Converter;

/**
 * @author omignot
 *
 */
@Component
public class VersionToVersionForm implements Converter<Version, VersionForm> {
	
    @Override
    public VersionForm convert(Version version) {
    	VersionForm versionForm = new VersionForm();
    	versionForm.setId(version.getId());
    	versionForm.setLibelle(version.getLibelle());
    	versionForm.setEtat(version.getEtat());
    	versionForm.setDateCreation(version.getDateCreation());
    	versionForm.setUtilisateurCreation(version.getUtilisateurCreation());
    	versionForm.setDateModification(version.getDateModification());
    	versionForm.setUtilisateurModification(version.getUtilisateurModification());
        return versionForm;
    }

}