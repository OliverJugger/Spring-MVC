package fr.edu.aix.yuccaspringboot.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.edu.aix.yuccaspringboot.domain.Programme;
import fr.edu.aix.yuccaspringboot.domain.dto.ProgrammeDto;
import fr.edu.aix.yuccaspringboot.form.ProgrammeForm;

/**
 * Mapper Mapstruct permettant de transformer un Programme en ProgrammeDto et vice versa
 * @author omignot
 *
 */
@Mapper
public interface ProgrammeMapper {
	
	ProgrammeMapper INSTANCE = Mappers.getMapper(ProgrammeMapper.class);
	
	ProgrammeForm programmeToProgrammeForm(Programme programme);
	ProgrammeDto programmeToProgrammeDto(Programme programme);
	Programme programmeDtoToProgramme(ProgrammeDto programmeDto);

}
