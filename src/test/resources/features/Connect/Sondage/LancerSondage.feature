# Auteur: marwamaherssi
# Feature: Sondage
# Scénario: Lancer sondage
# Date de création: 05/11/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-SONDAGE
@ACCRETIO2-SONDAGE-0004

Feature: Sondage

  Scenario: Lancer un Sondage

       #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

      #Etape2 : Ajouter un sondage

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Connect"
    And l utilisateur clique sur "Bouton_Sondage"
    And l utilisateur clique sur "Bouton_Ajouter_Sondage"

      #Etape3 : Remplir tous les champs d'un sondage

    When le modal création Sondage s'affiche
    And l utilisateur saisit "sondage 3" dans le champs "Question1"
    And l utilisateur saisit "oui 3" dans le champs "Reponse_1_sondage"
    And l utilisateur saisit "non 3" dans le champs "Réponse_2_sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Ajout_Sondage"


     #Etape4 : Lancer un sondage

    And l utilisateur clique sur "Bouton_Options_Sondage"
    And l utilisateur clique sur "Bouton_Lancer_Sondage"
    When le modal lancer Sondage s'affiche
    And l utilisateur clique sur "Bouton_Confirmer_Lancer_Sondage"

    #Etape5 : Confirmer que le sondage est affiché

    And l utilisateur clique sur "Bouton_Portail"
    And l utilisateur clique sur "Bouton_Sondage_Portail"
    Then verifier que le sondage est affiché



