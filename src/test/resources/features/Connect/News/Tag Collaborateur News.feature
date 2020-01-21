# Auteur : syrineLakhdhar
# Feature : News
# Scénario : Tag collaborateur dans le corps d'une news
# Date de création : 01/11/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-NEWS
@ACCRETIO2-NEWS-0005


Feature: News

  Scenario: Tag d'un collaborateur dans le corps d'une news

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
    And l utilisateur saisit "Test automatique création news avec tag " dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "@Gaston Boutot" dans le champs "Champ_Input_Texte_News"
    And l utilisateur choisit le profil du tag dans le corps de la News
    And l'utilisateur selectionne la date actuelle du champ date de publication
    And  l utilisateur upload "une image" dans le champs "Upload_Image_News"
    And wait 1000
    And l utilisateur clique sur "Bouton_Enregistrer_Redimensionner_Image"
    And wait 1000
    And l utilisateur clique sur "Bouton_Sauvegarde_Creation_News"

    #Etape 4 : Vérification

    Then vérifier que le tag est affiché correctement dans la News ajoutée