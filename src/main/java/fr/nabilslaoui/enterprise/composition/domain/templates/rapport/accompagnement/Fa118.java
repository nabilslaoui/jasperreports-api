package fr.nabilslaoui.enterprise.composition.domain.templates.rapport.accompagnement;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;
import fr.nabilslaoui.enterprise.composition.domain.templates.rapport.commun.JasperTemplateUtil;

public class Fa118 {

    private Fa118() {
        throw new IllegalStateException("Utility class");
    }

    // FA118
    private static final String EXTRAIT_PLURILINGUE_COURRIER_118_RECTO_NAME = "R_Courrier_CA_118";

	private static final String SOUS_REPERTOIRE_COURRIERS = "courriers/CA118/";

    public static JasperTemplate getCourrier() {
		return JasperTemplateUtil.buildCourrierAvecEnteteSignatureEtPiedPage(
				EXTRAIT_PLURILINGUE_COURRIER_118_RECTO_NAME, SOUS_REPERTOIRE_COURRIERS);
    }

}
