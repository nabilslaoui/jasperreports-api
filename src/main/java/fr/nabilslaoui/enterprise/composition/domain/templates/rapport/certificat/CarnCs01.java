package fr.nabilslaoui.enterprise.composition.domain.templates.rapport.certificat;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;
import fr.nabilslaoui.enterprise.composition.domain.templates.rapport.commun.JasperTemplateUtil;

public class CarnCs01 {

	private CarnCs01() {
        throw new IllegalStateException("Utility class");
    }

	private static final String CARN_CS_01_NAME = "Courrier_CARN_CS_01";
	private static final String DOSSIER_RAPPORT = "courriers/CARN_CS_01";

	public static JasperTemplate getCourrier() {
		return JasperTemplate.builder().nomRapport(CARN_CS_01_NAME).dossierRapport(DOSSIER_RAPPORT)
				.sousRapports(JasperTemplateUtil.getCourrierTemplateSousRapports()).build();
	}
}
