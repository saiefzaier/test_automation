# Auteur: htlili
# Feature: Référentiels
# Scénario: Création Etablissement
# Date de création: 28/11/2019


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0002

Feature: Référentiels

  Scenario: Création d'un établissement

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
    And l utilisateur saisit "SOCETAB01" dans le champs "Code_établissement"
    And l utilisateur saisit "Etablissement principal" dans le champs "Libellé_établissement"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_établissement"
    And l utilisateur selectionne "France" dans la liste deroulante "Pays_établissement"
    And l utilisateur selectionne "Paris" dans la liste deroulante "Ville_établissement"
    And l utilisateur saisit "15 Rue de la liberté" dans le champs "Adresse_Ajout_établissement"
    And l utilisateur selectionne "Société de service" dans la liste deroulante "Société_établissement"
    And l utilisateur clique sur "Etablissement_principal"
    And l utilisateur clique sur "Enregistrer_établissement"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

     # Etape 4 : Ajout d'un contact établissement
    When l utilisateur clique sur "Ajouter_contact_établissement"
    And l utilisateur saisit "Mariem Yahyaoui" dans le champs "Contact_établissement"
    And l utilisateur saisit "Comptable" dans le champs "Fonction_établissement"
    And l utilisateur saisit "0021671391000" dans le champs "Téléphone_contact_établissement"
    And l utilisateur clique sur "Valider_contact_établissement"
    And l utilisateur clique sur "JS_Sauvegarder_établissement"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 5 : Ajout des coordonnées bancaires de la société
    When l utilisateur clique sur "Ajouter_coordonnées_bancaires_établissement"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_coordonnées_établissement"
    And l utilisateur selectionne "Tunisie" dans la liste deroulante "Pays_coordonnées_établissement"
    And l utilisateur selectionne "Espèces" dans la liste deroulante "Mode_de_paiement_établissement"
    And l utilisateur selectionne "Dinar tunisien" dans la liste deroulante "Devise_de_paiement_établissement"
    And l utilisateur selectionne "BIAT" dans la liste deroulante "Libellé_banque_établissement"
    And l utilisateur selectionne "Agence Montplaisir" dans la liste deroulante "Libellé_agence_établissement"
    And l utilisateur saisit "12345678901234567890" dans le champs "RIB_établissement"
    And l utilisateur clique sur "Valider_coordonnées_bancaire_établissement"
    And l utilisateur clique sur "JS_Sauvegarder_établissement"
    Then vérifier que le message "Opération effectuée avec succès" s affiche



