# Auteur: wboufade
# Feature: News
# Scénario: Suppression News
# Date de création: 23/09/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-NEWS
@ACCRETIO2-NEWS-0002

Feature: News

  Scenario: Suppression News

    #Etape 1 : Connexion :

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    # Etape 2 : Changement de role

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Module_News"

    # Etape 3 : Changement de role

    And l utilisateur clique sur "Bouton_Ajout_News"
    And l utilisateur saisit "Test automatique suppression news" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique d'ajout puis de suppression d'une news" dans le champs "Champ_Input_Texte_News"
    And l'utilisateur selectionne la date actuelle du champ date de publication
    And  l utilisateur upload "une image" dans le champs "Upload_Image_News"
    And wait 1000
    And l utilisateur clique sur "Bouton_Enregistrer_Redimensionner_Image"
    And wait 1000
    And l utilisateur clique sur "Bouton_Sauvegarde_Creation_News"
    And wait 5000

    # Etape 4 : Suppression News

    When l utilisateur clique sur "JS_Bouton_Supprimer_News"
    And l utilisateur clique sur "Bouton_Validation_Suppression_News"
    And wait 3000
    Then vérifier la suppression de la News




