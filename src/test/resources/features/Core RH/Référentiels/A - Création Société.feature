# Auteur: htlili
# Feature: Référentiels
# Scénario: Création nouvelle Société
# Date de création: 28/11/2019


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0001

Feature: Référentiels

  Scenario: Création société

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
    And l utilisateur saisit "SOC02" dans le champs "Code_société"
    And l utilisateur saisit "Société de service" dans le champs "Libellé_société"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_société"
    And l utilisateur selectionne "Français" dans la liste deroulante "langue_officielle_société"
    And l utilisateur selectionne "Dinar tunisien" dans la liste deroulante "Devise_société"
    And l utilisateur saisit "15 Rue de la liberté" dans le champs "Adresse_société"
    And l utilisateur selectionne "France" dans la liste deroulante "Pays_société"
    And l utilisateur selectionne "Paris" dans la liste deroulante "Ville_société"
    And l utilisateur clique sur "Enregistrer_société"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 : Ajout du secteur d'activité et immatriculation
    When l utilisateur selectionne "Service" dans la liste deroulante "Secteur_société"
    And l utilisateur selectionne "Informatique" dans la liste deroulante "Activité_société"
    And l utilisateur selectionne "SARL" dans la liste deroulante "Statut_juridique_société"
    And l utilisateur saisit "SOCTN000000115" dans le champs "Immatriculation_société"
    And l utilisateur selectionne "Prestataires de services" dans la liste deroulante "Convention_collective_société"
    And l utilisateur saisit "SOCTN000000780" dans le champs "Affiliation_sécurité_sociale_société"
    And l utilisateur saisit "SOCREGTN000004" dans le champs "Registre_de_commerce_société"
    #And l utilisateur saisit "11147" dans le champs "Numéro_TVA_société"
    And l utilisateur clique sur "Sauvegarder_société"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 5 : Ajout d'un contact société
    When l utilisateur clique sur "Ajouter_contact_société"
    And l utilisateur clique sur "Externe"
    And l utilisateur saisit "Walid Sahli" dans le champs "Contact_société"
    And l utilisateur selectionne "Chef de projet" dans la liste deroulante "Fonction_société"
    And l utilisateur saisit "0021671381000" dans le champs "Téléphone_contact_société"
    And l utilisateur clique sur "Valider_contact_société"
    And l utilisateur clique sur "Sauvegarder_société"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 6 : Ajout des coordonnées bancaires de la société
    When l utilisateur clique sur "Ajouter_coordonnées_bancaires_société"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_coordonnées_société"
    And l utilisateur selectionne "Tunisie" dans la liste deroulante "Pays_coordonnées_société"
    And l utilisateur selectionne "Espèces" dans la liste deroulante "Mode_de_paiement_société"
    And l utilisateur selectionne "Dinar tunisien" dans la liste deroulante "Devise_de_paiement_société"
    And l utilisateur selectionne "BIAT" dans la liste deroulante "Libellé_banque_société"
    And l utilisateur selectionne "Agence Montplaisir" dans la liste deroulante "Libellé_agence_société"
    And l utilisateur saisit "12345678901234567892" dans le champs "RIB_société"
    And l utilisateur clique sur "Valider_coordonnées_bancaire_société"
    And l utilisateur clique sur "Sauvegarder_société"
    Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 7 : Ajout d'un véhicule de la société
    When l utilisateur clique sur "Véhicules_société"
    And l utilisateur clique sur "Ajouter_véhicule_société"
    And l utilisateur saisit "211 TU 2655" dans le champs "Immatriculation_véhicule_société"
    And l utilisateur selectionne "Audi" dans la liste deroulante "Marque_véhicule_société"
    And l utilisateur selectionne "A3" dans la liste deroulante "Modèle_véhicule_société"
    And l utilisateur selectionne "Opérationnel" dans la liste deroulante "Type_de_leasing_société"
    And l utilisateur selectionne "Hiver" dans la liste deroulante "Pneus_actuels_véhicule_société"
    And l utilisateur clique sur "Valider_véhicules_société"
    And l utilisateur clique sur "Sauvegarder_société"
    Then vérifier que le message "Opération effectuée avec succès" s affiche



