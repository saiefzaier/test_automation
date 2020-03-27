# Auteur: Saief Eddine Ezaier
# Feature: Référentiels
# Scénario: Suppression d'un Etablissement
# Date de création: 04/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0008

Feature: Référentiels

  Scenario: Suppression d'un établissement

     # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Etablissements"

    # Etape 3 : Ajout d'un établissemnet
    When l utilisateur clique sur "Ajouter_un_établissement"
    And l utilisateur saisit "SOCETAB02" dans le champs "Code_établissement"
    And l utilisateur saisit "Etablissement a supprimer" dans le champs "Libellé_établissement"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_établissement"
    And l utilisateur selectionne "France" dans la liste deroulante "Pays_établissement"
    And l utilisateur selectionne "Paris" dans la liste deroulante "Ville_établissement"
    And l utilisateur saisit "15 Rue de la liberté" dans le champs "Adresse_Ajout_établissement"
    And l utilisateur selectionne "Delfingen QA" dans la liste deroulante "Société_établissement"
    And l utilisateur clique sur "Enregistrer_établissement"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 : Suppression d'un établissement
    And l utilisateur selectionne "Etablissement a supprimer" dans la liste "Liste_Etablissement"
    And  l utilisateur clique sur "Bouton_Supprimer_Etablissement"
    And  l utilisateur clique sur "Bouton_Confirmer_Suppression_Etablissement"
    Then vérifier que le message "Opération effectuée avec succès" s affiche
