# Auteur: ygtari
# Feature: Annonces
# Scénario: Suppression d'une annonce
# Date de création: 24/10/2019

@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-Annonces
@ACCRETIO2-Annonces-0003


Feature: Annonces

  Scenario: Suppression d'une annonce

    # Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    # Etape 2 : Changement de role

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Annonce"

     # Etape 3 : Ajout Annonce

    When l utilisateur clique sur "Bouton_Ajouter_Annonces"
    When l utilisateur saisit "Test Automatique Suppression Annonce" dans le champs "Input_Nom_Annonce"
    And l utilisateur selectionne "Vente" dans la liste deroulante "Liste_Deroulante_Type"
    And l utilisateur saisit "Ceci est un test automatique de la suppression d'une annonce" dans le champs "Input_Texte_Annonces_Creation"
    And  l utilisateur upload "une image" dans le champs "Upload_Image_Annonce"
    And l utilisateur clique sur "Bouton_Valider_Image"
    And l utilisateur clique sur "JS_Bouton_Valider_Ajouter_Annonces"
    And wait 2000

    # Etape 4 : Suppression annonce

    And L'utilisateur clique sur  supprimer Annonce
    And l utilisateur clique sur "JS_Bouton_Valider_Supprimer_Annonce"
    And wait 2000

    # Etape 5 : Vérification de la suppression de l'annonce

    Then vérifier la suppression de l'annonce

