# Auteur: htlili
# Feature: Référentiels
# Scénario: Création Entité orgaisationnelle fille
# Date de création: 11/12/2019


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0006

Feature: Référentiels

  Scenario: Création Entité organisationnelle fille

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
    And l utilisateur saisit "SOCEO02" dans le champs "Code_EO"
    And l utilisateur saisit "Entité 2" dans le champs "Libellé_EO"
    And l utilisateur saisit "02/01/2019" dans le champs "Date_d_effet_EO"
    # And l utilisateur selectionne "Actif" dans la liste deroulante "Statut_EO"
    And l utilisateur selectionne "Société de service" dans la liste deroulante "Société_EO"
    And l utilisateur selectionne "Direction" dans la liste deroulante "Type_EO"
    And l utilisateur clique sur "Enregistrer_EO"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 : Ajout d'un responsable de l'entité
    When l utilisateur clique sur "Ajouter_responsable_EO"
    And l utilisateur saisit "03/01/2019" dans le champs "Date_de_début_responsable_EO"
    And l utilisateur selectionne "Admin Accretio" dans la liste deroulante "Responsable_EO"
    And l utilisateur clique sur "Valider_Responsable_EO"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

     # Etape 5 : Ajout d'une entité mère
    When l utilisateur clique sur "Ajouter_Entité_mère"
    And l utilisateur selectionne "Entité 1" dans la liste deroulante "Entité_mère_EO"
    And l utilisateur saisit "03/02/2019" dans le champs "Date_de_début_Entité_mère"
    And l utilisateur clique sur "Valider_Entité_mère"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 6 : Ajout d'une adresse EO
    When l utilisateur saisit "9 Avenue des martyres" dans le champs "Adresse_EO"
    And l utilisateur selectionne "France" dans la liste deroulante "Pays_EO"
    And l utilisateur selectionne "Paris" dans la liste deroulante "Ville_EO"
    And l utilisateur selectionne "75001" dans la liste deroulante "Code_postal_EO"
    And l utilisateur clique sur "Sauvegarder_EO"
    Then vérifier que le message "Opération effectuée avec succès" s affiche


