package fr.edu.aix.yuccaspringboot.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import fr.edu.aix.yuccaspringboot.domain.Correction;

public class CorrectionReader implements ItemReader<Correction> {

	@Override
	public Correction read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
