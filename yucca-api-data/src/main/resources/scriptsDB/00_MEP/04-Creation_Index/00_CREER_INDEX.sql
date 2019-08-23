-- ============ CREATION DES INDEX

-- LES INDEX SUR LES CLEFS PRIMAIRES SONT GENEREES AUTOMATIQUEMENT
-- Pour l'historisation des versions, le libellé sera important est beaucoup sollicité

CREATE INDEX YUCCA."VERSION_INDEX"
ON YUCCA.VERSION(LIBELLE)
	
-- En cas de besoin : DROP INDEX YUCCA."VERSION_INDEX"

