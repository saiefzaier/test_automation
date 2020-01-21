# Auteur: marwamaherssi
# Feature: Ideation
# Scénario: Supprimer Idéation
# Date de création: 08/01/2020



@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-IDEATION
@ACCRETIO2-IDEATION-0002


  Feature: Ideation

    Scenario: Supprimer Ideation

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
      And l utilisateur saisit "C'est un test automatique de la suppression d'une idée" dans le champs "Libelle_Creation_Idee"
      And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline_Creation_Ideation"
      And l utilisateur saisit "Ceci est la description de l'idée pour la suppression" dans le champs "Description_Creation_Idee"
      And l utilisateur clique sur "Bouton_Sauvegarde_Creation_Ideation"
      Then vérifier que l idée est crée

      #Etape 3 : Supprimer l'idée

      When l utilisateur clique sur "JS_Bouton_Supprimer_Ideation"
      And wait 2000
      And l utilisateur clique sur "Confirmer_Suppression_Ideation"


      #Etape 4 : Confirmer que l'idée est supprimer

     Then verifier que l idée n est plus affichée



