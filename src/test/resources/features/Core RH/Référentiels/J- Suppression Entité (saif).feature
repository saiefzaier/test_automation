# Auteur: Saief Eddine Ezaier
# Feature: Référentiels
# Scénario: Suppression d'une Entité
# Date de création: 04/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0009

Feature: Référentiels

  Scenario: Suppression Entité organisationnelle

    # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And  l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Entités_organisationnelles"

    # Etape 3 : Ajout d'une entité organisationnelle
    When l utilisateur clique sur "Ajouter_une_EO"
    And l utilisateur saisit "SOCEO0S" dans le champs "Code_EO"
    And l utilisateur saisit "Entité A Supprimer" dans le champs "Libellé_EO"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_EO"
    # And l utilisateur selectionne "Actif" dans la liste deroulante "Statut_EO"
    And l utilisateur selectionne "Delfingen QA" dans la liste deroulante "Société_EO"
    And l utilisateur selectionne "Direction" dans la liste deroulante "Type_EO"
    And l utilisateur clique sur "Enregistrer_EO"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 Suppression d'une entité organisationelle
    And l utilisateur selectionne "Entité A Supprimer" dans la liste "Liste_Entités"
    And  l utilisateur clique sur "Bouton_Supprimer_Entité"
    And  l utilisateur clique sur "Bouton_Confirmer_Suppression_Entité"
    Then vérifier que le message "Opération effectuée avec succès" s affiche
