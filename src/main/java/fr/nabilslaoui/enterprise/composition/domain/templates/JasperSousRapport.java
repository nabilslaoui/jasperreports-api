package fr.nabilslaoui.enterprise.composition.domain.templates;

import java.io.InputStream;

import fr.nabilslaoui.enterprise.commun.exceptions.BusinessException;
import fr.nabilslaoui.enterprise.composition.erreurs.CodeErreur;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class JasperSousRapport {

    private String nomSousRapport;

    private String dossierRapport;

    private String parametre;

	public String getSousRapportURI(String version) {
        return "reports/" + dossierRapport + "/"
				+ nomSousRapport + "_v" + version + ".jasper";
    }

	public InputStream getReportRessource(String version) {
		String uri = getSousRapportURI(version);
        InputStream jasperTemplate = this.getClass().getClassLoader().getResourceAsStream(uri);
        if (jasperTemplate != null) {
            return jasperTemplate;
        }
        throw new BusinessException(CodeErreur.ERREUR_RECUPERATION_SOUS_RAPPORT, uri);
    }

}
