package fr.edu.aix.yuccaspringboot.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;

import fr.edu.aix.yuccaspringboot.domain.Correction;

public class FileUtil {
	
	@Value("${application.export.dossier}")
	private String nomDossier;//= "C:/yucca/export/";
	
	@Value("${application.export.fichier.prefixe}")
	private String prefixeNomFichier;// = "CR";
	
	public void writeCorrectionToFile(Correction correction) throws IOException {
		String nomFichier = prefixeNomFichier + Long.toString(correction.getId());
		FileOutputStream fos = new FileOutputStream(nomDossier + nomFichier);		
		OutputStreamWriter writer =  new OutputStreamWriter(fos, StandardCharsets.UTF_8);
	    
		String contenu = correction.getProbleme() + correction.getSolution();
	    writer.write(contenu);
	    writer.close();
	}			    
}