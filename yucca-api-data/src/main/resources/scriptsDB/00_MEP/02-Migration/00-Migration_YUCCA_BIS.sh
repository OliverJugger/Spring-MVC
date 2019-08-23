#Ce script se situe sur mndiv2-2 dans db2data/db2dev/scripts/migration_yucca

echo "----------------------------"
echo "Debut export"
echo "----------------------------"

db2 connect to yucbase;

db2 export to /db2data/db2dev/scripts/migration_yucca/export/programme.del of del "SELECT PROGSER, ltrim(rtrim(NOM)), COMM, TEMPO, PROGDOM, IDDOSSIER from DB2INST1.PROGRAMME ORDER BY PROGSER ASC";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/correction.del of del "SELECT CORSER, ltrim(rtrim(CORFIC)), CORPB, CORSOL, CORMOD, ETAT, TAPSER, RESPSER, CORDAT from DB2INST1.CORRECTION ORDER BY CORSER ASC";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/version.del of del "SELECT VERID, VERLIB, ACTIVE from DB2INST1.VERSION ORDER BY VERID ASC";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/lien_correction_programme.del of del "SELECT CORSER, PROGSER from DB2INST1.CORPROG";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/lien_correction_version.del of del "SELECT CORSER, VERID from DB2INST1.CORVER";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/repertoire.del of del "SELECT DOSLIL, DOSNOM from DB2INST1.TDOSSIER";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/domaine.del of del "SELECT ltrim(rtrim(TAPAPP)), ltrim(rtrim(TAPLIB)), VISIBLE from DB2INST1.TAPPLI";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/sous_domaine.del of del "SELECT ltrim(rtrim(DOMCOU)), ltrim(rtrim(DOMLIB)), VISIBLE from DB2INST1.TDOMAINE";
db2 export to /db2data/db2dev/scripts/migration_yucca/export/auteur.del of del "SELECT RESPLIC, RESPLIL, RESPLA from DB2INST1.TRESP";

db2 connect reset;
db2 terminate;

echo "----------------------------"
echo "Fin export"
echo "----------------------------"

echo "----------------------------"
echo "Debut import"
echo "----------------------------"

iconv -f iso-8859-15 -t utf-8 export/programme.del > export/programmeUTF8.del
iconv -f iso-8859-15 -t utf-8 export/correction.del > export/correctionUTF8.del
iconv -f iso-8859-15 -t utf-8 export/version.del > export/versionUTF8.del
iconv -f iso-8859-15 -t utf-8 export/lien_correction_programme.del > export/lien_correction_programmeUTF8.del
iconv -f iso-8859-15 -t utf-8 export/lien_correction_version.del > export/lien_correction_versionUTF8.del
iconv -f iso-8859-15 -t utf-8 export/repertoire.del > export/repertoireUTF8.del
iconv -f iso-8859-15 -t utf-8 export/domaine.del > export/domaineUTF8.del
iconv -f iso-8859-15 -t utf-8 export/sous_domaine.del > export/sous_domaineUTF8.del
iconv -f iso-8859-15 -t utf-8 export/auteur.del > export/auteurUTF8.del

db2 connect to yucbase3;

db2 load from /db2data/db2dev/scripts/migration_yucca/export/programmeUTF8.del of del modified by delprioritychar "INSERT INTO YUCCA.PROGRAMME(ID, NOM, COMMENTAIRE, TEMPORAIRE, ID_SOUS_DOMAINE, ID_REPERTOIRE)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/correctionUTF8.del of del modified by delprioritychar "INSERT INTO YUCCA.CORRECTION(ID, TITRE, PROBLEME, SOLUTION, COMMENTAIRE, ETAT, ID_DOMAINE, ID_AUTEUR, CREATED_AT)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/versionUTF8.del of del modified by delprioritychar "INSERT INTO YUCCA.VERSION(ID, LIBELLE, ACTIVE)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/lien_correction_programmeUTF8.del of del "INSERT INTO YUCCA.LIEN_CORRECTION_PROGRAMME(ID_CORRECTION, ID_PROGRAMME)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/lien_correction_versionUTF8.del of del "INSERT INTO YUCCA.LIEN_CORRECTION_VERSION(ID_CORRECTION, ID_VERSION)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/repertoireUTF8.del of del "INSERT INTO YUCCA.REPERTOIRE(CHEMIN, RACCOURCI_UNIX)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/domaineUTF8.del of del "INSERT INTO YUCCA.DOMAINE(LIBELLE_COURT, LIBELLE_LONG, VISIBLE)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/sous_domaineUTF8.del of del "INSERT INTO YUCCA.SOUS_DOMAINE(LIBELLE_COURT, LIBELLE_LONG, VISIBLE)";
db2 load from /db2data/db2dev/scripts/migration_yucca/export/auteurUTF8.del of del "INSERT INTO YUCCA.AUTEUR(ALIAS, NOM, ACTIF)";