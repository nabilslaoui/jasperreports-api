package fr.nabilslaoui.enterprise.composition.erreurs;

import fr.nabilslaoui.enterprise.commun.enums.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodeErreur implements ExceptionCode {

	// Erreurs techniques
	ERREUR_ANALYSE_JSON("TECH_17001", "Erreur lors de l'analyse des données JSON"),
	ERREUR_CHARGEMENT_SOUS_RAPPORT("TECH_17002", "Erreur lors du chargement du sous rapport"),
	ERREUR_CREATION_RAPPORT("TECH_17003", "Erreur lors de la création du rapport"),
	ERREUR_COMPILATION_RAPPORT("TECH_17004", "Erreur lors de la compilation du rapport"),
	ERREUR_RECUPERATION_RAPPORT("TECH_17005", "Erreur lors de la récupération du rapport : *[%s]*"),
	ERREUR_RECUPERATION_SOUS_RAPPORT("TECH_17006", "Erreur lors de la récupération du sous-rapport : *[%s]*");

	private final String code;

	private final String message;

	@Override
	public String toString() {
		return this.getCode().concat("-").concat(getMessage());
	}

}
