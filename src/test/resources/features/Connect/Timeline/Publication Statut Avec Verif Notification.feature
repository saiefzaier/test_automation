# Auteur: marwamaherssi
# Feature: Timeline
# Scénario: Publication nouveau statut
# Date de création: 04/12/2019



@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0008

Feature: Timeline

  Scenario: Publication nouveau statut avec verif notification

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape 2 : Creation statut

    When l utilisateur clique sur "Champ_Statut"
    And l utilisateur saisit "Test automatisé publication statut et verif de la notification" dans le champs "Champ_Input_Statut"
    And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline"
    #Timeline qui contient tous les utilisateurs de la solution
    And l utilisateur clique sur "Bouton_Publication_Statut"

      #Etape 3 : verifier la notification d'un autre compte et consulter la publication

   And l utilisateur se deconnecte
   And l'utilisateur "heloise.sciverit@yopmail.com" est connecté
   Then verifier que la notification existe et l'utilisateur peut afficher la publication
