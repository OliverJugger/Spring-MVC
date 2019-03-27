package fr.edu.aix.yuccaspringboot.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import fr.edu.aix.yuccaspringboot.domain.Correction;

public class CorrectionConsoleWriter implements ItemWriter<Correction> {
	
	private StringBuilder sb = new StringBuilder();

	public void clear() {
		sb = new StringBuilder();
	}
	
	public void flush() {
		System.out.print(sb);
		sb = new StringBuilder();
	}
	
	@Override
	public void write(List<? extends Correction> corrections) throws Exception {
		for (Correction correction : corrections)
			sb.append(correction.toString()+"n");		
	}
}
