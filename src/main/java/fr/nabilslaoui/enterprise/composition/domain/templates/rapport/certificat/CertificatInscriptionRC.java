package fr.nabilslaoui.enterprise.composition.domain.templates.rapport.certificat;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;
import fr.nabilslaoui.enterprise.composition.domain.templates.rapport.commun.JasperTemplateUtil;

public class CertificatInscriptionRC {

	private CertificatInscriptionRC() {
        throw new IllegalStateException("Utility class");
    }

	private static final String CERTIFICAT_INSCRIPTION_RC_NAME = "Courrier_CERTIFICAT_INSCRIPTION_RC";
	private static final String DOSSIER_RAPPORT = "courriers/CERTIFICAT_INSCRIPTION_RC";

	public static JasperTemplate getCourrier() {
		return JasperTemplate.builder().nomRapport(CERTIFICAT_INSCRIPTION_RC_NAME).dossierRapport(DOSSIER_RAPPORT)
				.sousRapports(JasperTemplateUtil.getCourrierTemplateSousRapports())
				.build();
	}
}
