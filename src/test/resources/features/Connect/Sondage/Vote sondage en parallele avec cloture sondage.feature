# Auteur: marwamaherssi
# Feature: Sondage
# Scénario: Impossible de voter dans un sondage stoppé un message d'erreur doit s'afficher
# Date de création: 09/01/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-SONDAGE
#@ACCRETIO2-SONDAGE-0010


Feature: Sondage

  Scenario: Impossible de voter dans un sondage stoppé

      #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

     #Etape2 : Ajouter un sondage

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Sondage"
    And l utilisateur clique sur "Bouton_Ajouter_Sondage"

    #Etape3 : Remplir tous les champs d'un sondage

    And l utilisateur saisit "Sondage stop" dans le champs "Question1_Creation_Sondage"
    And l utilisateur saisit "oui" dans le champs "Reponse_1_sondage"
    And l utilisateur saisit "non" dans le champs "Reponse_2_sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Ajout_Sondage"
    And   wait 3000

     #Etape4 : Lancer un sondage

    And l utilisateur clique sur "Bouton_Options_Sondage"
    And l utilisateur clique sur "Bouton_Lancer_Sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Lancer_Sondage"
    And   wait 3000

    #Etape5 : Se connecter au TNR avec un deuxiéme utilisateur et cliquer sur le sondage pour voter

    When l'utilisateur bascule vers la deuxième fenêtre
    And le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "gaston.boutot@yopmail.com" est connecté

    #Etape6 : Stopper le sondage à partir du premier compte

    When l'utilisateur bascule vers la première fenêtre
    And l utilisateur clique sur "Bouton_Options_Sondage"
    And l utilisateur clique sur "Bouton_Stopper_Sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Stop_Sondage"
    And wait 3000

    #Etape7 : Basculer vers le deuxième utilisateur , répondre au sondage et vérifier que le sondage est stoppé

    And l utilisateur clique sur Bouton_Sondage_Portail et verifie le chargement de la liste des sondages
    And l utilisateur clique sur "Bouton_Reponse_1_Sondage_Portail"
    And l utilisateur clique sur "Bouton_Voter_Sondage"
    Then verifier qu'un message d'erreur est affiché

    #Etape8 : Vérifier que le vote n'a pas été compté

    And l'utilisateur bascule vers la première fenêtre
    Then verifier que le vote de l'utilisateur n'a pas été compté

