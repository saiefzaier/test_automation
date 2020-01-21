# Auteur : syrineLakhdhar
# Feature : Ideation
# Scénario : Créer une idée
# Date de création : 04/11/2019
# Date de modification : 02/12/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-IDEATION
@ACCRETIO2-IDEATION-0001


Feature: Ideation

  Scenario: Créer une idée

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    #Etape 2 : Création de l'idée

    And l utilisateur attend l'apparition du Widget_Ideation
    And l utilisateur clique sur "Widget_Ideation"
    And wait 2000
    And l utilisateur clique sur "Proposer_une_idee"
    And wait 3000
    And l utilisateur selectionne "Entreprise" dans la liste deroulante "Liste_Deroulante_Categorie_Idee"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'une idée" dans le champs "Libelle_Creation_Idee"
    And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline_Creation_Ideation"
    And l utilisateur saisit "Ceci est la description de l'idée" dans le champs "Description_Creation_Idee"
    And l utilisateur clique sur "Bouton_Sauvegarde_Creation_Ideation"


    #Etape 3 : Vérification de la création de l'idée
    #Then vérifier que le message "succès" s affiche
    Then vérifier que l idée est crée