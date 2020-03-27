# Auteur: Saief Eddine Ezaier
# Feature: Référentiels
# Scénario: Suppression d'une Société
# Date de création: 03/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0007


Feature: Référentiels

  Scenario: Suppression société

    # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Sociétés"

    # Etape 3 : Ajout d'une nouvelle société
    When l utilisateur clique sur "Ajouter_une_société"
    And l utilisateur saisit "SOC03" dans le champs "Code_société"
    And l utilisateur saisit "Société a supprimer" dans le champs "Libellé_société"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_société"
    And l utilisateur selectionne "Français" dans la liste deroulante "langue_officielle_société"
    And l utilisateur selectionne "Dinar tunisien" dans la liste deroulante "Devise_société"
    And l utilisateur saisit "15 Rue de la liberté" dans le champs "Adresse_société"
    And l utilisateur selectionne "France" dans la liste deroulante "Pays_société"
    And l utilisateur selectionne "Paris" dans la liste deroulante "Ville_société"
    And l utilisateur clique sur "Enregistrer_société"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 : Supprimer la société
    And l utilisateur selectionne "Société a supprimer" dans la liste "Liste_Societe"
    And  l utilisateur clique sur "BoutonSupprimerSociete"
    And  l utilisateur clique sur "Bouton_Confirmer_Suppression_Societe"
    Then vérifier que le message "Opération effectuée avec succès" s affiche
