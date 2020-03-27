# Auteur: Saief Eddine Ezaier
# Feature: Référentiels
# Scénario: Création Poste
# Date de création: 04/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0011

Feature: Référentiels

  Scenario: Suppression Poste

    # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Postes"

    # Etape 3 : Ajout d'un nouveau poste
    When l utilisateur clique sur "Ajouter_un_poste"
    And l utilisateur saisit "SOCPOS0S" dans le champs "Code_poste"
    And l utilisateur saisit "Poste a supprimer" dans le champs "Libellé_poste"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_poste"
    # And l utilisateur selectionne "Actif" dans la liste deroulante "Statut_poste"
    #And l utilisateur selectionne "Entité 1" dans la liste deroulante "Entite_organisationnelle_poste"
    And l utilisateur selectionne "DFG_Direction" dans la liste deroulante "Emploi_poste"
    And l utilisateur clique sur "Enregistrer_Poste"
    And vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 : Suppression du poste
    And l utilisateur selectionne "Poste a supprimer" dans la liste "Liste_Postes"
    And  l utilisateur clique sur "Bouton_Supprimer_Poste"
    And  l utilisateur clique sur "Bouton_Confirmer_Suppression_Poste"
    Then vérifier que le message "Opération effectuée avec succès" s affiche