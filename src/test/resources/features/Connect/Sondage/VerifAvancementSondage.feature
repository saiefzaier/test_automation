# Auteur: marwamaherssi
# Feature: Sondage
# Scénario: Verifier l'avancement du sondage en ajoutant une population bien précise
# Date de création: 31/01/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-SONDAGE
#@ACCRETIO2-SONDAGE-0011


Feature: Sondage

  Scenario: Verif Avancement Sondage

      #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape2 : Ajouter un sondage

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Sondage"
    And l utilisateur clique sur "Bouton_Ajouter_Sondage"
    And   wait 3000

      #Etape3 : Remplir tous les champs d'un sondage

    And l utilisateur saisit "Sondage Avancement" dans le champs "Question1_Creation_Sondage"
    And l utilisateur saisit "oui" dans le champs "Reponse_1_sondage"
    And l utilisateur saisit "non" dans le champs "Reponse_2_sondage"
    And l utilisateur selectionne la population "Population pour Connect" dans la liste des populations "Sondage_Population"
    And l utilisateur clique sur "Bouton_Confirmer_Ajout_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Options_Sondage"
    And   wait 3000

     #Etape4 : Lancer le sondage

    And l utilisateur clique sur "Bouton_Lancer_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Confirmer_Lancer_Sondage"
    And   wait 2000

    #Etape5 : Répondre au sondage crée

    When l utilisateur clique sur "Bouton_Portal"
    And l utilisateur clique sur Bouton_Sondage_Portail et verifie le chargement de la liste des sondages
    And l utilisateur clique sur "Bouton_Reponse_1_Sondage_Portail"
    And l utilisateur clique sur "Bouton_Voter_Sondage"

    #Etape6 : Vérifier que l'avancement du sondage est 50%

    And  l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Sondage"
    And   wait 3000
    Then verifier que l avancement du sondage est egale a 50%

    #Etape7 : Se connecter avec le deuxieme collaborateur et voter

    And l utilisateur se deconnecte
    And l'utilisateur "gaston.boutot@yopmail.com" est connecté
    And l utilisateur clique sur Bouton_Sondage_Portail et verifie le chargement de la liste des sondages
    And l utilisateur clique sur "Bouton_Reponse_1_Sondage_Portail"
    And l utilisateur clique sur "Bouton_Voter_Sondage"

    #Etape8 : Verifier que l avancement est egale a 100%

    And l utilisateur se deconnecte
    And l'utilisateur "responsable@yopmail.com" est connecté
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Sondage"
    Then verifier que l avancement du sondage est egale a 100%


