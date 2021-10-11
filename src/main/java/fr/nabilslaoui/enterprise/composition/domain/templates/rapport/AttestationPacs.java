package fr.nabilslaoui.enterprise.composition.domain.templates.rapport;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;
import fr.nabilslaoui.enterprise.composition.domain.templates.rapport.commun.JasperTemplateUtil;

public class AttestationPacs {

	private AttestationPacs() {
        throw new IllegalStateException("Utility class");
    }

	private static final String CERTIFICAT_SITUATION_NAME = "ATTESTATION_PACS";
	private static final String DOSSIER_RAPPORT = "courriers/ATTESTATION_PACS";

	public static JasperTemplate getCourrier() {
		return JasperTemplate.builder().nomRapport(CERTIFICAT_SITUATION_NAME).dossierRapport(DOSSIER_RAPPORT)
				.sousRapports(JasperTemplateUtil.getCourrierTemplateSousRapports()).build();
	}
}
