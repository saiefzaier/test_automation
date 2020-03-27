# Auteur: marwamaherssi
# Feature: Enquete
# Scénario: Dupliquer enquete
# Date de création: 12/02/2020

@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-ENQUETE
@ACCRETIO2-ENQUETE-0013


Feature: Enquete

  Scenario: Dupliquer une enquete

 #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape2 : Ajouter une enquete

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Bouton_Module_Connect"
    And l utilisateur clique sur "Bouton_Enquete"

    #Etape3 : Remplir tous les champs d'une enquete

    When l utilisateur clique sur "Bouton_Ajouter_Enquete"
    And wait 3000
    And l utilisateur saisit "Enquete duplication" dans le champs "Libelle_Enquete_Creation"
    And l utilisateur selectionne la population "test population pour enquete" dans la liste des populations "Population_Enquete"
    #Timeline qui contient l'utilisateur connecté responsable@yopmail.com
    And l utilisateur saisit "reponse 1" dans le champs "Reponse_1_enquete"
    And l utilisateur saisit "reponse 2" dans le champs "Reponse_2_enquete"
    And l utilisateur saisit "Chapitre1" dans le champs "Axe_Enquete"
    And l utilisateur saisit "tester question" dans le champs "Question_Creation_Enquete"
    And l utilisateur clique sur "Bouton_Confirmer_Ajouter_Enquete"
    And   wait 3000

    #Etape4 : Dupliquer l'enquete

   When l utilisateur clique sur "Bouton_Dupliquer_Enquete"
    And l utilisateur modifie "Enquete duplication 2" dans le champs "Libelle_Enquete_Duplication"
    And l utilisateur clique sur "Bouton_Confirmer_Dupliquer_Enquete"

    #Etape 5 : Verifier que l'enquete a ete dupliquer

  Then verifier que l'enquete a ete duplique

