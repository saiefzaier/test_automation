# Auteur: syrineLakhdhar
# Feature: Sondage
# Scénario: Création sondage avec date de fin
# Date de création: 05/12/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-SONDAGE
@ACCRETIO2-SONDAGE-0007

Feature: Sondage

  Scenario: Création d'un sondage avec une date de fin

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

      #Etape3 : Remplir les champs d'un sondage

    And l utilisateur saisit "Sondage avec date de fin" dans le champs "Question1_Creation_Sondage"
    And l utilisateur saisit "oui" dans le champs "Reponse_1_sondage"
    And l utilisateur saisit "non" dans le champs "Reponse_2_sondage"
    And l utilisateur saisit la date de fin du sondage
    And l utilisateur modifie "24" dans le champs "Champ_Heure_Fin_Sondage"
    And l utilisateur clique sur "Bouton_Confirmer_Ajout_Sondage"
    And   wait 3000

      #Etape4 : Lancer sondage

    And l utilisateur clique sur "Bouton_Options_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Lancer_Sondage"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Confirmer_Lancer_Sondage"
    And   wait 3000

      #Etape5 : Accéder au sondage crée

    And l utilisateur clique sur "Bouton_Portal"
    And l utilisateur clique sur Bouton_Sondage_Portail et verifie le chargement de la liste des sondages

      #Etape6 : Vérifcation du compteur des jours restants

    Then vérifier que le nombre affiché correspond au nombre de jours restants

