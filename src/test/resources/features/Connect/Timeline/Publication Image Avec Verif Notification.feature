# Auteur: marwamaherssi
# Feature: Timeline
# Scénario: Publication Image Avec Verif Notification
# Date de création: 05/12/2019



@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0004

Feature: Timeline

  Scenario: Publication Image Avec Verif Notification

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape 2 : Creation statut avec image

    When  l utilisateur upload "une image" dans le champs "Champ_Input_Image_Publication"
    And l utilisateur saisit "Test automatisé publication image et verif de la notification" dans le champs "Champ_Input_Statut_Image"
    And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline_Image"
    #Timeline qui contient tous les utilisateurs de la solution
    And l utilisateur clique sur "Bouton_Publication_Image"
    And wait 5000
    Then verifier que l image a etait publie

      #Etape 3 : verifier la notification d'un autre compte et consulter la publication

    And l utilisateur se deconnecte
    And l'utilisateur "gilles.guimond@yopmail.com" est connecté
    Then verifier que la notification existe et l'utilisateur peut afficher la publication image

