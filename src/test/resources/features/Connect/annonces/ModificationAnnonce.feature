# Auteur: ygtari
# Feature: Annonces
# Scénario: Modification d'une annonce
# Date de création: 24/10/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-Annonces
@ACCRETIO2-Annonces-0002


Feature: Annonces

  Scenario: Modification annonce

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
    And l utilisateur saisit "Test Automatique Modification Annonce" dans le champs "Input_Nom_Annonce"
    And l utilisateur selectionne "Vente" dans la liste deroulante "Liste_Deroulante_Type"
    And l utilisateur saisit "Annonce" dans le champs "Input_Texte_Annonces_Creation"
    And  l utilisateur upload "une image" dans le champs "Upload_Image_Annonce"
    And l utilisateur clique sur "Bouton_Valider_Image"
    And l utilisateur clique sur "JS_Bouton_Valider_Ajouter_Annonces"
    And vérifier la création de la nouvelle annonce


    # Etape 4 : Modification annonce

    And l utilisateur clique sur "Bouton_Modifier_Annonce"
    And l utilisateur saisit "_Modification" dans le champs "Input_Texte_Annonces_Modification"
    And l utilisateur clique sur "JS_Bouton_Valider_Ajouter_Annonces"
    And wait 3000

    # Etape 5 : Vérification de la modification

    And l'utilisateur rafraichit la page
    Then vérifier la modification de l'annonce




