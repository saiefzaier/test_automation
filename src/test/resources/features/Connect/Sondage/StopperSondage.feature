# Auteur: marwamaherssi
# Feature: Sondage
# Scénario: Stopper sondage
# Date de création: 05/11/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-SONDAGE
@ACCRETIO2-SONDAGE-0005

 Feature: Sondage

  Scenario: Stopper un sondage

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

    #Etape5 : Stopper un sondage

    And l utilisateur clique sur "Bouton_Options_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Stopper_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Confirmer_Stop_Sondage"
    And   wait 3000


    #Etape6 : Confirmer que le sondage n'est plus affiché

    And l utilisateur clique sur "Bouton_Portal"
    And l utilisateur clique sur Bouton_Sondage_Portail et verifie le chargement de la liste des sondages
    Then vérifier que le sondage n'est pas affiché
