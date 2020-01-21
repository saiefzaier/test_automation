# Auteur: Hafedh Tlili
# Feature: Onboarding
# Scénario: Modification du template Onboarding
# Date de création: 10/12/2019


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-ONBOARDING
@ACCRETIO2-ONBOARDING-003

Feature: Onboarding

  Scenario: Suppression du template Onboarding

   # Etape 1 : Connexion
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Onboarding"
    And l utilisateur clique sur "Template_Test_QA"

    # Etape 3 : suppression du template Onboarding
    When l utilisateur clique sur "Supprimer_template_onboarding"
    And l utilisateur clique sur "Valider_suppression_onboarding"
    Then vérifier que le message "Opération effectuée avec succès" s affiche


