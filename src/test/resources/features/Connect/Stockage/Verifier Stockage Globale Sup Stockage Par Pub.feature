# Auteur: marwamaherssi
# Feature: Stockage
# Scénario: Verifier Stockage Globale Sup Stockage Par Pub
# Date de création: 09/12/2019

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-STOCKAGE
#@ACCRETIO2-STOCKAGE-0001


Feature: Stockage

  Scenario: Verifier Stockage Globale Sup Stockage Par Pub

      #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

     #Etape2 : Accéder au paramétrages de stockage

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Administration"
    And l utilisateur clique sur "Bouton_Configuration_Systeme"
    And l utilisateur clique sur "Bouton_Paramétre_Stockage"
    And l utilisateur clique sur "Bouton_Configuration_Stockage"

     #Etape3 : Configurer le paramétrage de stockage

    When l utilisateur saisit "10" dans le champs "Champ_Stockage_Globale"
    And l utilisateur selectionne "Ko" dans la liste deroulante "Unités_Globale"
    And l utilisateur saisit "10" dans le champs "Champ_Stockage_Publication"
    And l utilisateur selectionne "Go" dans la liste deroulante "Unités_Publication"
    And l utilisateur clique sur "Bouton_Valider_Stockage"

    #Etape4 : Verifier que la configuration est impossible

    Then verifier qu'un message d'erreur s'affiche


