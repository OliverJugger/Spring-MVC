package fr.edu.aix.yuccaspringboot.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.form.ProgrammeForm;

/**
 * Mapper Mapstruct permettant de transformer un Programme en ProgrammeForm et vice versa
 * @author omignot
 *
 */
@Mapper
public interface ProgrammeMapper {
	
	ProgrammeMapper INSTANCE = Mappers.getMapper(ProgrammeMapper.class);
	
	ProgrammeForm programmeToProgrammeForm(Programme programme);

}
