# Auteur: marwamaherssi
# Feature: Enquete
# Scénario: Modification enquete
# Date de création: 08/11/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-ENQUETE
@ACCRETIO2-ENQUETE-0002

Feature: Enquete

  Scenario: Modification d'une enquete

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
    And l utilisateur saisit "Enquete" dans le champs "Libelle_Enquete_Creation"
    And l utilisateur selectionne la population "test population pour enquete" dans la liste des populations "Population_Enquete"
    #Timeline qui contient l'utilisateur connecté responsable@yopmail.com
    And l utilisateur saisit "reponse 1" dans le champs "Reponse_1_enquete"
    And l utilisateur saisit "reponse 2" dans le champs "Reponse_2_enquete"
    And l utilisateur saisit "Chapitre1" dans le champs "Axe_Enquete"
    And l utilisateur saisit "tester question" dans le champs "Question_Creation_Enquete"
    And l utilisateur clique sur "Bouton_Confirmer_Ajouter_Enquete"
    And   wait 3000

    #Etape4 : Modifier une enquete et confirmer la modification

    And l utilisateur clique sur "Bouton_Modifier_Enquete"
    And l utilisateur modifie "Enquete_modifié" dans le champs "Libelle_Enquete_Modification"
    And l utilisateur selectionne la population "modification population sur enquete" dans la liste des populations "Population_Enquete"
    #Timeline qui contient l'utilisateur heloise.sciverit@yopmail.com
    And l utilisateur modifie "reponse 1 oui" dans le champs "Reponse_1_enquete"
    And l utilisateur modifie "reponse 2 non" dans le champs "Reponse_2_enquete"
    And l utilisateur modifie "chapitre1 modifié" dans le champs "Axe_Enquete"
    And l utilisateur modifie "tester question vérifié" dans le champs "Question_Creation_Enquete"
    And l utilisateur clique sur "Bouton_Confirmer_Modifier_Enquete"
    And   wait 3000
    And l utilisateur clique sur "Bouton_Lancer_Enquete"
    And l utilisateur clique sur "Bouton_Confirmer_Lancer_Enquete"
    And   wait 3000


      #Etape5 : Vérifier que la mise à jour de l'enquete a été effectuée avec succés

    And l utilisateur se deconnecte
    And l'utilisateur "heloise.sciverit@yopmail.com" est connecté
    And l utilisateur clique sur Bouton_Enquete_Portail et verifie le chargement de la liste des enquetes
    Then vérifier que l'enquete a été modifié correctement
