# Auteur: marwamaherssi
# Feature: Sondage
# Scénario: Voter Sondage
# Date de création: 03/12/2019

@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-SONDAGE
@ACCRETIO2-SONDAGE-0008


Feature: Sondage

  Scenario: Voter Sondage

      #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

      #Etape2 : Ajouter un sondage

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Sondage"
    And l utilisateur clique sur "Bouton_Ajouter_Sondage"
    And   wait 3000

      #Etape3 : Remplir tous les champs d'un sondage

    And l utilisateur saisit "Sondage Voter" dans le champs "Question1_Creation_Sondage"
    And l utilisateur saisit "oui" dans le champs "Reponse_1_sondage"
    And l utilisateur saisit "non" dans le champs "Reponse_2_sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Ajout_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Options_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Lancer_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Confirmer_Lancer_Sondage"
    And   wait 3000

    #Etape4 : Répondre au sondage crée

    When l utilisateur clique sur "Bouton_Portal"
    And l utilisateur clique sur Bouton_Sondage_Portail et verifie le chargement de la liste des sondages
    And l utilisateur clique sur "Bouton_Reponse_1_Sondage_Portail"
    And l utilisateur clique sur "Bouton_Voter_Sondage"

    #Etape5 : Verifier que la réponse a été compté

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Sondage"
    Then verifier que le vote a été compté




