# Auteur: Ons MANSOURI
# Feature: Configuration
# Scénario: Ajout classification de compétences
# Date de création: 10/12/2019


@ACCRETIO2
@ACCRETIO2-TALENT
@ACCRETIO2-CONFIGURATION
@ACCRETIO2-CONFIGURATION-0002

Feature: Configuration
  Scenario: Ajout de niveau de compétences
    #Etape 001: Connexion RH_Skills
    Given   le navigateur est ouvert et la page d'acceuil est affichée
      And   l'utilisateur "saianbu@YOPMAIL.COM" est connecté
     Then   le nom de l utilisateur "Sai ANBU" est affiche en haut a gauche
    #Etape 002: Acceder  au sous module configuration
     When   l utilisateur clique sur "Bouton_menu_etendu"
      And   l utilisateur clique sur "Module_Talent"
      And   l utilisateur clique sur "Sous_module_Configuration"
    #Ajout de la classification
      And   l utilisateur clique sur "Classification_conf"
      And   l utilisateur clique sur "Ajouter_classification"
      And   l utilisateur saisit "Ajout Classification Test auto 1" dans le champs "Libelle_Classif_ajout"
      And   l utilisateur selectionne "Communication" dans la liste deroulante "Classification_parent"
      And   l utilisateur selectionne "Chiffre" dans la liste deroulante "Chiffre_ajout_classification"
      And   l utilisateur selectionne "Coefficient" dans la liste deroulante "Coefficient_ajout_classification"
      And   l utilisateur clique sur "Valider_ajout_classification"
      And   l utilisateur clique sur "Enregistrer_ajout_classification"
     Then   vérifier que le message "succès" s affiche
      And   verifier que le dernier libelle "Ajout Classification Test auto 1"
      And   verifier que la derniere classification parent "Communication"
      And   verifier que la derniere echelle "Chiffre"