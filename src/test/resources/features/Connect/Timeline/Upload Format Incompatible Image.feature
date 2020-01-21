# Auteur: marwamaherssi
# Feature: Timeline
# Scénario: Upload format incompatible image
# Date de création: 02/12/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0014

Feature: Timeline

  Scenario: Upload format incompatible image

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    #Etape 2 : Upload fichier

    And  l utilisateur upload "une vidéo" dans le champs "Champ_Input_Image_Publication"
    And wait 2000

    #Etape 3 : Vérifier que l'upload est possible

    Then vérifier que le message "Veuillez sélectionner un fichier de type image" s affiche

