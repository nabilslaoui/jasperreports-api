package fr.nabilslaoui.enterprise.composition.domain.templates.rapport;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;

public class ActeTexte {

    private ActeTexte() {
        throw new IllegalStateException("Utility class");
    }

    private static final String ACTE_TEXTE_NAME = "acte_texte";

    private static final String SOUS_REPERTOIRE_ACTES = "acte/ACTE_TEXTE/";

    public static JasperTemplate getActeTexte() {
        return JasperTemplate.builder()
                .nomRapport(ACTE_TEXTE_NAME)
                .dossierRapport(SOUS_REPERTOIRE_ACTES)
                .build();

    }
}
