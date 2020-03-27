# Auteur: marwamaherssi
# Feature: Stockage
# Scénario: Verifier Avancement Pourcentage User Profile Enrichi
# Date de création: 11/12/2019

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-STOCKAGE
#@ACCRETIO2-STOCKAGE-0005


Feature: Stockage

  Scenario: Verifier Avancement Pourcentage User Profile Enrichi

     #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

    #Etape2 : Consulter l'espace de stockage disponible pour l'utilisateur dans le profile enrichi et Publier une image

    When l utilisateur clique sur "Lien_Nom_Utilisateur"
    And l utilisateur verifie le stockage du user connecté
    And l utilisateur clique sur "Bouton_Publications_Profile_Enrichi"
    And wait 2000
    And l utilisateur clique sur "Bouton_Image_Timeline"
    And l utilisateur saisit "Test automatisé publication image et verif de la notification" dans le champs "Champ_Input_Statut_Image"
    And l utilisateur selectionne "Tous les utilisateurs" dans la liste deroulante "Liste_Deroulante_Timeline"
    And l utilisateur clique sur "Bouton_Publication_Image"
    Then verifier que l'image est publiée

    #Etape3 : Verifier que l'espace de stockage a changé

    Then verifier que l'espace de stockage pour le user a changé

