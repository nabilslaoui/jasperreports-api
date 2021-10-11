package fr.nabilslaoui.enterprise.composition.domain.templates.rapport.refus;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;
import fr.nabilslaoui.enterprise.composition.domain.templates.rapport.commun.JasperTemplateUtil;

public class CarnCsPac01 {

    private CarnCsPac01() {
        throw new IllegalStateException("Utility class");
    }

	private static final String CARN_CSPAC_01_NAME = "Courrier_CARN_CSPAC_01";
	private static final String DOSSIER_RAPPORT = "courriers/CARN_CSPAC_01";

	public static JasperTemplate getCourrier() {
		return JasperTemplate.builder().nomRapport(CARN_CSPAC_01_NAME).dossierRapport(DOSSIER_RAPPORT)
				.sousRapports(JasperTemplateUtil.getCourrierTemplateSousRapports()).build();
	}
}
