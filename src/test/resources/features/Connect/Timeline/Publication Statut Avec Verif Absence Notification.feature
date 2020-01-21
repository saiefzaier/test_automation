# Auteur: marwamaherssi
# Feature: Timeline
# Scénario: Publication Statut Avec Verif Absence Notification
# Date de création: 05/12/2019



@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0007

Feature: Timeline

  Scenario: Publication Statut Avec Verif Absence Notification

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape 2 : Creation statut

    When l utilisateur clique sur "Champ_Statut"
    And l utilisateur saisit "Test automatisé publication statut et verif de l'absence de la notification" dans le champs "Champ_Input_Statut"
    And l utilisateur selectionne "Timeline restreinte Connect" dans la liste deroulante "Liste_Deroulante_Timeline"
    #Timeline qui ne contient pas l'utilisateur gaston.boutot@yopmail.com
    And l utilisateur clique sur "Bouton_Publication_Statut"
    And wait 3000
    Then verifier que le statut a etait publie

      #Etape 3 : Verifier la notification d'un autre compte et consulter la publication

    And l utilisateur se deconnecte
    And l'utilisateur "gaston.boutot@yopmail.com" est connecté
    Then verifier que la notification n existe pas et que l utilisateur ne peut pas afficher la publication
