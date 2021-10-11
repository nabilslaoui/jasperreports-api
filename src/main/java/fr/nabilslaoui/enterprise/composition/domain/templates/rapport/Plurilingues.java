package fr.nabilslaoui.enterprise.composition.domain.templates.rapport;

import fr.nabilslaoui.enterprise.composition.domain.templates.JasperSousRapport;
import fr.nabilslaoui.enterprise.composition.domain.templates.JasperTemplate;

import java.util.List;

public class Plurilingues {

    private Plurilingues() {
        throw new IllegalStateException("Utility class");
    }

    // ACTE_NAISSANCE
    private static final String EXTRAIT_PLURILINGUE_ACTE_DE_NAISSANCE_RECTO_NAME = "R_Extrait_plurilingue_acte_de_naissance";
    private static final String EXTRAIT_PLURILINGUE_ACTE_DE_NAISSANCE_VERSO_NAME = "SR_VERSO_Extrait_plurilingue_acte_de_naissance";

    // ACTE_DECES
    private static final String EXTRAIT_PLURILINGUE_ACTE_DE_DECES_RECTO_NAME = "R_Extrait_plurilingue_acte_de_deces";
    private static final String EXTRAIT_PLURILINGUE_ACTE_DE_DECES_VERSO_NAME = "SR_VERSO_Extrait_plurilingue_acte_de_deces";

    // ACTE_MARIAGE
    private static final String EXTRAIT_PLURILINGUE_ACTE_DE_MARIAGE_RECTO_NAME = "R_Extrait_plurilingue_acte_de_mariage";
    private static final String EXTRAIT_PLURILINGUE_ACTE_DE_MARIAGE_VERSO_NAME = "SR_VERSO_Extrait_plurilingue_acte_de_mariage";

    private static final String SUB_REPORT_PARAMETRE_PLURILINGUE_NAME = "plurilingueSubreport";


    private static final String SOUS_REPERTOIRE_ACTE_NAISSANCE= "plurilingue/ACTE_NAISSANCE/";
    private static final String SOUS_REPERTOIRE_ACTE_MARIAGE= "plurilingue/ACTE_MARIAGE/";
    private static final String SOUS_REPERTOIRE_ACTE_DECES= "plurilingue/ACTE_DECES/";

    public static JasperTemplate getActeNaissance() {
        return JasperTemplate.builder()
                .nomRapport(EXTRAIT_PLURILINGUE_ACTE_DE_NAISSANCE_RECTO_NAME)
                .dossierRapport(SOUS_REPERTOIRE_ACTE_NAISSANCE)
                .sousRapports(List.of(
                        JasperSousRapport.builder()
                            .nomSousRapport(EXTRAIT_PLURILINGUE_ACTE_DE_NAISSANCE_VERSO_NAME)
                            .parametre(SUB_REPORT_PARAMETRE_PLURILINGUE_NAME)
                            .dossierRapport(SOUS_REPERTOIRE_ACTE_NAISSANCE)
                                .build()
                        ))
                .build();

    }

    public static JasperTemplate getActeMariage() {
        return JasperTemplate.builder()
                .nomRapport(EXTRAIT_PLURILINGUE_ACTE_DE_MARIAGE_RECTO_NAME)
                .dossierRapport(SOUS_REPERTOIRE_ACTE_MARIAGE)
                .sousRapports(List.of(
                        JasperSousRapport.builder()
                                .nomSousRapport(EXTRAIT_PLURILINGUE_ACTE_DE_MARIAGE_VERSO_NAME)
                                .parametre(SUB_REPORT_PARAMETRE_PLURILINGUE_NAME)
                                .dossierRapport(SOUS_REPERTOIRE_ACTE_MARIAGE)
                                .build()
                ))
                .build();

    }

    public static JasperTemplate getActeDeces() {
        return JasperTemplate.builder()
                .nomRapport(EXTRAIT_PLURILINGUE_ACTE_DE_DECES_RECTO_NAME)
                .dossierRapport(SOUS_REPERTOIRE_ACTE_DECES)
                .sousRapports(List.of(
                        JasperSousRapport.builder()
                                .nomSousRapport(EXTRAIT_PLURILINGUE_ACTE_DE_DECES_VERSO_NAME)
                                .parametre(SUB_REPORT_PARAMETRE_PLURILINGUE_NAME)
                                .dossierRapport(SOUS_REPERTOIRE_ACTE_DECES)
                                .build()
                ))
                .build();

    }
}
