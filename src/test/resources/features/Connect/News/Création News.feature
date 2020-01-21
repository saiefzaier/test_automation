# Auteur: wboufade
# Feature: News
# Scénario: Création nouvelle news
# Date de création: 16/09/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-NEWS
@ACCRETIO2-NEWS-0001

Feature: News

  Scenario: Création nouvelle news

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    #Etape 2 : Changement de role

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Module_News"

    #Etape 3 : Ajout News

    And l utilisateur clique sur "Bouton_Ajout_News"
    And l utilisateur saisit "Test automatique création news" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'une news" dans le champs "Champ_Input_Texte_News"
    And l'utilisateur selectionne la date actuelle du champ date de publication
    And  l utilisateur upload "une image" dans le champs "Upload_Image_News"
    And wait 1000
    And l utilisateur clique sur "Bouton_Enregistrer_Redimensionner_Image"
    And wait 1000
    And l utilisateur clique sur "Bouton_Sauvegarde_Creation_News"
    And wait 1000

    #Etape 4 : Vérification de la création de la News

    Then vérifier que le message "succès" s affiche
    Then vérifier la création de la nouvelle news



