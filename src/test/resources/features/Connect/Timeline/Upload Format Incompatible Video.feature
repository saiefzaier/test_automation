# Auteur: marwamaherssi
# Feature: Timeline
# Scénario: Upload format incompatible video
# Date de création: 02/12/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0006

Feature: Timeline

  Scenario: Upload format incompatible video

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

    #Etape 2 : Upload fichier

    When l utilisateur clique sur "Bouton_video"
    And  l utilisateur upload une photo
    And wait 1000

    #Etape 3 : Vérifier que l'upload est impossible

   Then  verifier que l'upload est impossible

