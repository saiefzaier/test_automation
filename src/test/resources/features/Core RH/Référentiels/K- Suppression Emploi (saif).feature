# Auteur: Saief Eddine Ezaier
# Feature: Référentiels
# Scénario: Suppression d'un Emploi
# Date de création: 04/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0010

Feature: Référentiels

  Scenario: Suppression Emploi

    # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Emplois"

    # Etape 3 : Ajout d'un nouvel emploi
    When l utilisateur clique sur "Ajouter_un_emploi"
    And l utilisateur saisit "SOCEMP0S" dans le champs "Code_emploi"
    And l utilisateur saisit "Emploi A Supprimer" dans le champs "Libellé_emploi"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_emploi"
    # And l utilisateur selectionne "Actif" dans la liste deroulante "Statut_emploi"
    And l utilisateur clique sur "Enregistrer_Emploi"
    And vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 : Suppression d'un emploi
    And l utilisateur selectionne "Emploi A Supprimer" dans la liste "Liste_Emplois"
    And  l utilisateur clique sur "Bouton_Supprimer_Emploi"
    And  l utilisateur clique sur "Bouton_Confirmer_Suppression_Emploi"
    Then vérifier que le message "Opération effectuée avec succès" s affiche
