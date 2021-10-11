package fr.nabilslaoui.enterprise.composition.domain.templates.rapport.certificat;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;
import fr.nabilslaoui.enterprise.composition.domain.templates.rapport.commun.JasperTemplateUtil;

public class CertificatSituation {

	private CertificatSituation() {
        throw new IllegalStateException("Utility class");
    }

	private static final String CERTIFICAT_SITUATION_NAME = "Courrier_CERTIFICAT_SITUATION";
	private static final String DOSSIER_RAPPORT = "courriers/CERTIFICAT_SITUATION";

	public static JasperTemplate getCourrier() {
		return JasperTemplate.builder().nomRapport(CERTIFICAT_SITUATION_NAME).dossierRapport(DOSSIER_RAPPORT)
				.sousRapports(JasperTemplateUtil.getCourrierTemplateSousRapports()).build();
	}
}
