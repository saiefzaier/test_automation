# Auteur : syrineLakhdhar
# Feature : Timeline
# Scénario : Publier un album
# Date de création : 02/12/2019

@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0009

  Feature: Timeline

    Scenario: Publier un album

       #Etape 1 : Connexion

      Given le navigateur est ouvert et la page d'acceuil est affichée
      And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape 2 : Création de la publication

      When l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline"
      #Timeline qui contient les utilisateurs du module connect
      And  l utilisateur upload "une image" dans le champs "Champ_Input_Album_Publication"
      And wait 5000
      And  l utilisateur upload "une image 2" dans le champs "Champ_Input_Album_Publication_Image_2"
      And wait 3000
      #Timeline qui contient tous les utilisateurs de la solution
      And l utilisateur clique sur "JS_Bouton_Publication_Album"
      And wait 5000

      #Etape 3 : Vérification de la création de la publication

      Then Vérifier que l album est publié