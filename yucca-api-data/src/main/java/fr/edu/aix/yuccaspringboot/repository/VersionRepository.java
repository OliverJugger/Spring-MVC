/**
 * 
 */
package fr.edu.aix.yuccaspringboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.edu.aix.yuccaspringboot.domain.Version;

/**
 * @author omignot
 *
 */
public interface VersionRepository extends CrudRepository<Version, Long>{
	
	List<Version> findAllByOrderByIdDesc();

}
