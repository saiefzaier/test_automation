# Auteur : syrineLakhdhar
# Feature : Timeline
# Scénario : Publier une vidéo
# Date de création : 02/12/2019

@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0012

  Feature: Timeline

    Scenario: Publier une vidéo

      #Etape 1 : Connexion

      Given le navigateur est ouvert et la page d'acceuil est affichée
      And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape 2 : Publication de la vidéo


      #Timeline qui contient tous les utilisateurs de la solution
      When  l utilisateur upload "une vidéo" dans le champs "Champ_Input_Video_Publication"
      And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline_Video"
      And l utilisateur saisit "Test automatisé publication video" dans le champs "Champ_Input_Statut_Video"
      And l utilisateur clique sur "Bouton_Publication_Video"
      And wait 3000

      #Etape 3 : Vérification de la publication

      Then Vérifier que la vidéo est publiée