# Auteur: Hafedh Tlili
# Feature: Onboarding
# Scénario: Modification du template Onboarding
# Date de création: 10/12/2019


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-ONBOARDING
@ACCRETIO2-ONBOARDING-002

Feature: Onboarding

  Scenario: Modification du template Onboarding

   # Etape 1 : Connexion
   Given le navigateur est ouvert et la page d'acceuil est affichée
   And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Onboarding"

    # Etape 3 : Modification du template
  When l utilisateur clique sur "Modifier_template_onboarding"
    And l utilisateur modifie "Template_Test_QA" dans le champs "Nom_du_template_onboarding_Modifie"
    And l utilisateur modifie "80" dans le champs "Durée_d_affichage_en_mois_onboarding_Modifié"
    And l utilisateur clique sur "Enregistrer_Ajout_Template_onboarding"
    Then vérifier que le message "Opération effectuée avec succès" s affiche
    And vérifier la modification du nom de l'onboarding








