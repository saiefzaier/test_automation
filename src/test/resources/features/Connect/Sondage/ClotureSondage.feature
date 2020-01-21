# Auteur: marwamaherssi
# Feature: Sondage
# Scénario: Cloture sondage
# Date de création: 12/11/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-SONDAGE
@ACCRETIO2-SONDAGE-0006

Feature: Sondage

  Scenario: Cloture d'un sondage

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

    And l utilisateur saisit "Sondage Cloture" dans le champs "Question1_Creation_Sondage"
    And l utilisateur saisit "oui" dans le champs "Reponse_1_sondage"
    And l utilisateur saisit "non" dans le champs "Reponse_2_sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Ajout_Sondage"
    And   wait 2000
    And l utilisateur clique sur "Bouton_Options_Sondage"
    And l utilisateur clique sur "Bouton_Lancer_Sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Lancer_Sondage"
    And   wait 5000

    #Etape4 : Cloturer un sondage

    And l utilisateur clique sur "Bouton_Options_Sondage"
    And l utilisateur clique sur "Bouton_Cloturer_Sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Cloture_Sondage"
    And wait 5000


    #Etape5 : Vérifier que la cloture du sondage a été effectuée avec succés

   Then verifier que le sondage ne peut plus etre lancer ou stopper