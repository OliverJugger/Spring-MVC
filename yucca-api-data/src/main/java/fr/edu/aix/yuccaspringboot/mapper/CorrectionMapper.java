package fr.edu.aix.yuccaspringboot.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.edu.aix.yuccaspringboot.domain.Correction;
import fr.edu.aix.yuccaspringboot.domain.dto.CorrectionDto;
import fr.edu.aix.yuccaspringboot.form.CorrectionForm;

/**
 * Mapper Mapstruct permettant de transformer une Correction en CorrectionDto et vice versa
 * @author omignot
 *
 */
@Mapper
public interface CorrectionMapper {
	
	CorrectionMapper INSTANCE = Mappers.getMapper(CorrectionMapper.class);
	
	CorrectionForm correctionToCorrectionForm(Correction correction);
	CorrectionDto correctionToCorrectionDto(Correction correction);
	Correction correctionDtoToCorrection(CorrectionDto correction);
}
