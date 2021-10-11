package fr.nabilslaoui.enterprise.composition.domain.templates;

import fr.nabilslaoui.enterprise.commun.exceptions.BusinessException;
import fr.nabilslaoui.enterprise.composition.erreurs.CodeErreur;
import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;
import java.util.List;

@Builder
@Getter
public class JasperTemplate {

    private final String nomRapport;

    private final String dossierRapport;

    private final List<JasperSousRapport> sousRapports;

    public String getRapportURI(String version) {
        return "reports/" + dossierRapport + "/"
                + nomRapport + "_v" + version + ".jasper";
    }

    public InputStream getReportRessource(String version) {
        String uri = getRapportURI(version);
        InputStream jasperTemplate = this.getClass().getClassLoader().getResourceAsStream(uri);
        if (jasperTemplate != null) {
            return jasperTemplate;
        }
        throw new BusinessException(CodeErreur.ERREUR_RECUPERATION_RAPPORT, uri);

    }

}
