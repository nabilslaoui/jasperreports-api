package fr.nabilslaoui.enterprise.composition.domain.templates.rapport.commun;

import java.util.List;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperSousRapport;
import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;

public class JasperTemplateUtil {
	private JasperTemplateUtil() {
		// nothing
	}

	public static final String COURRIER_HEADER_NAME = "SR_Courrier_entete";
	public static final String COURRIER_FOOTER_NAME = "SR_Courrier_pied_de_page";
	public static final String COURRIER_SIGNATURE_NAME = "SR_Courrier_signature";

	public static final String SUB_REPORT_PARAMETRE_HEADER = "headerSubReport";
	public static final String SUB_REPORT_PARAMETRE_FOOTER = "footerSubReport";
	public static final String SUB_REPORT_PARAMETRE_SIGNATURE = "courrierSignatureSubReport";

	private static final String DOSSIER_SOUS_RAPPORT = "courriers/sousRapports";

	public static JasperTemplate buildCourrierAvecEnteteSignatureEtPiedPage(String nomRapport, String courrierPath) {
        return JasperTemplate.builder()
                .nomRapport(nomRapport)
                .dossierRapport(courrierPath)
				.sousRapports(List.of(
						buildSousRapport(JasperTemplateUtil.COURRIER_HEADER_NAME,
								JasperTemplateUtil.SUB_REPORT_PARAMETRE_HEADER, courrierPath),
						buildSousRapport(JasperTemplateUtil.COURRIER_FOOTER_NAME,
								JasperTemplateUtil.SUB_REPORT_PARAMETRE_FOOTER, courrierPath),
						buildSousRapport(JasperTemplateUtil.COURRIER_SIGNATURE_NAME,
								JasperTemplateUtil.SUB_REPORT_PARAMETRE_SIGNATURE, courrierPath)
                        ))
                .build();
		
	}

	private static JasperSousRapport buildSousRapport(String type, String parametre, String path) {
		return JasperSousRapport.builder().nomSousRapport(type).parametre(parametre).dossierRapport(path).build();
	}

	public static List<JasperSousRapport> getCourrierTemplateSousRapports() {
		return List.of(
				JasperSousRapport.builder().nomSousRapport(JasperTemplateUtil.COURRIER_HEADER_NAME)
				.parametre(JasperTemplateUtil.SUB_REPORT_PARAMETRE_HEADER)
				.dossierRapport(DOSSIER_SOUS_RAPPORT).build(),
		JasperSousRapport.builder().nomSousRapport(JasperTemplateUtil.COURRIER_FOOTER_NAME)
				.parametre(JasperTemplateUtil.SUB_REPORT_PARAMETRE_FOOTER)
				.dossierRapport(DOSSIER_SOUS_RAPPORT).build(),
		JasperSousRapport.builder().nomSousRapport(JasperTemplateUtil.COURRIER_SIGNATURE_NAME)
				.parametre(JasperTemplateUtil.SUB_REPORT_PARAMETRE_SIGNATURE)
						.dossierRapport(DOSSIER_SOUS_RAPPORT).build());
	}
}
