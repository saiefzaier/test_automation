# Auteur: marwamaherssi
# Feature: Ideation
# Scénario: Verifier qu'un collaborateur hors timeline ne peut pas visualiser cette idéation
# Date de création: 08/01/2020



#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-IDEATION
#@ACCRETIO2-IDEATION-0002


  Feature: Ideation

    Scenario: Verif Collaborateur Hors Timeline Idéation

       #Etape 1 : Connexion

      Given le navigateur est ouvert et la page d'acceuil est affichée
      And l'utilisateur "resp-RH@mail.com" est connecté

      #Etape 2 : Création de l'idée

      And l utilisateur clique sur "Widget_Idéation"
      And l utilisateur clique sur "Proposer_une_idée"
      And l utilisateur selectionne "Entreprise" dans la liste deroulante "Liste_Deroulante_Catégorie_Idée"
      And l utilisateur saisit "C'est un test automatique de l'ajout d'une idée" dans le champs "Libellé_Création_Idée"
      And l utilisateur selectionne "Tous les utilisateurs" dans la liste deroulante "Liste_Deroulante_Timeline_Création_Idéation"
      And l utilisateur saisit "Ceci est la description de l'idée" dans le champs "Description_Création_Idée"
      And l utilisateur clique sur "Bouton_Sauvegarde_Creation_Idéation"
      And wait 1000

     #Etape 3 : Vérification de la création de l'idée

      Then vérifier que le message "succès" s affiche
      Then vérifier que l'idée est crée

     #Etape 4 : Se connecter avec un utilisateur hors timeline et vérifier que l'idéation crée n'est pas affichée

      And l utilisateur se deconnecte
      And l'utilisateur "amal.chograni@yopmail.com" est connecté
      And l utilisateur clique sur "Widget_Idéation"
      Then verifier que l'idéation crée n'est pas affichée


