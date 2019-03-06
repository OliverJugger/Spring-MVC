/**
 * 
 */
package fr.edu.aix.yuccaspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Version;

/**
 * @author omignot
 *
 */
public interface VersionRepository extends CrudRepository<Version, Long>{

}
