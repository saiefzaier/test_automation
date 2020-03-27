# Auteur: marwamaherssi
# Feature: Stockage
# Scénario: Impossible de voir le stockage d'un autre collaborateur dans son profil
# Date de création: 09/01/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-STOCKAGE
#@ACCRETIO2-STOCKAGE-0006


Feature: Stockage

  Scenario: Impossible de voir le stockage d'un autre collaborateur dans son profil

    #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

    #Etape 2 : Consulter le profile d'un autre collaborateur

    When l utilisateur selectionne "amal chograni" dans la liste "rechercher un profil"
    Then verifier que le user connecté ne peut pas voir le pourcentage de ce collaborateur

