package fr.edu.aix.yuccaspringboot.config.batch;

import org.springframework.batch.item.ItemProcessor;

import fr.edu.aix.yuccaspringboot.domain.Correction;

public class CorrectionItemProcessor implements ItemProcessor<Correction, Correction> {

    @Override
    public Correction process(final Correction correction) throws Exception {
    	/*
        final String titre = correction.getTitre();
        final String probleme = correction.getProbleme();
        final String solution = correction.getSolution();
        final String commentaire = correction.getCommentaire();
        final String codeProbleme = correction.getCodeProbleme();
        
        final char etat = " "+correction.getEtat();
        final String utilisateurCreation = correction.getUtilisateurCreation();
        final String utilisateurModification = correction.getUtilisateurModification();
        final String application = correction.getApplication().toString();
*/
        final Correction transformedCorrection = new Correction();
        transformedCorrection.setTitre("test");
        transformedCorrection.setProbleme("testProbleme");

        return transformedCorrection;
    }

}