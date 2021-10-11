package fr.nabilslaoui.enterprise.composition.adapters.jasperreport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import fr.nabilslaoui.enterprise.commun.exceptions.TechnicalException;
import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;
import fr.nabilslaoui.enterprise.composition.erreurs.CodeErreur;
import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
@NoArgsConstructor
public class JasperReportAdapter {

	public ByteArrayOutputStream getPdfOutputStream(final String jsonData,
													final JasperTemplate jasperTemplate,
													final String version,
													final Map<String, Object> parameters) {
		Objects.requireNonNull(jsonData, "Les données json sont obligatoires");
		Objects.requireNonNull(jasperTemplate, "Un template Jasper est obligatoire");
		Objects.requireNonNull(version, "Un numéro de version est obligatoire");

		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			JsonDataSource jsonDataSource = new JsonDataSource(new ByteArrayInputStream(jsonData.getBytes()));

			final HashMap<String, Object> allParameters = new HashMap<>();

			if (jasperTemplate.getSousRapports() != null) {
				// Récupération des sous rapports
				jasperTemplate.getSousRapports().forEach(sousRapportTemplate -> {
					try {
						allParameters.put(sousRapportTemplate.getParametre(),
								JRLoader.loadObject(sousRapportTemplate.getReportRessource(version)));
					} catch (final JRException e) {
						throw new TechnicalException(CodeErreur.ERREUR_CHARGEMENT_SOUS_RAPPORT,e);
					}
				});
			}

			// Autres paramètres
			if (parameters != null) {
				allParameters.putAll(parameters);
			}

			// Rapport principal
			InputStream template = jasperTemplate.getReportRessource(version);
			final JasperPrint jasperPrint = JasperFillManager
					.fillReport((JasperReport) JRLoader.loadObject(template), allParameters, jsonDataSource);

			JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
		} catch (final JRException e1) {
			throw new TechnicalException(CodeErreur.ERREUR_CREATION_RAPPORT, e1);
		}
		return byteArrayOutputStream;
	}

}
