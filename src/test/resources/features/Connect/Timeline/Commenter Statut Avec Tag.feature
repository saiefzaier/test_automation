# Auteur : syrineLakhdhar
# Feature : Timeline
# Scénario : Tag collaborateur dans un commentaire sur une publication
# Date de création : 01/11/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0001


Feature: Timeline

  Scenario: Ajout commentaire avec tag sur un statut

        #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

       #Etape 2 : Publication nouveau statut

    And l utilisateur clique sur "Champ_Statut"
    And l utilisateur saisit "Ceci est un test automatisé qui vise à vérifier le fonctionnement correcte du commentaire avec tag sur un statut" dans le champs "Champ_Input_Statut"
    And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline"
    #Timeline qui contient les utilisateurs du module connect
    And l utilisateur clique sur "Bouton_Publication_Statut"
    And wait 3000
      #Etape 3 : Ajout commentaire avec tag sur le statut
    
    When l utilisateur saisit "@Gilles Guimond" dans le champs "Champs_Input_Commentaire"
    And wait 5000
    And l utilisateur choisit le profil du tag du commentaire dans la liste
    And l utilisateur clique sur "JS_Bouton_Submit_Commentaire"

       #Etape 3 : Vérification ajout commentaire avec tag

    Then Vérifier que le tag est affiché correctement sous le statut