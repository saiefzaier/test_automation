# Auteur: Ons MANSOURI
# Feature: Configuration
# Scénario: Modification thématique de formation
# Date de création: 07/01/2020


@ACCRETIO2
@ACCRETIO2-TALENT
@ACCRETIO2-CONFIGURATION
@ACCRETIO2-CONFIGURATION-0008

Feature: Configuration

  Scenario: Modification thématique de formation

    #Etape 001: Connexion RH_Training

    Given   le navigateur est ouvert et la page d'acceuil est affichée
      And   l'utilisateur "combes.caroline@YOPMAIL.COM" est connecté
     Then   le nom de l utilisateur "Caroline Combes" est affiche en haut a gauche

    #Etape 002: Acceder  au sous module configuration

     When   l utilisateur clique sur "Bouton_menu_etendu"
      And   l utilisateur clique sur "Module_Talent"
      And   l utilisateur clique sur "Sous_module_Configuration"

    #Ajout de la thématique

      And   l utilisateur saisit "Test Ajout thématique Auto 2" dans le champs "Ajout_occurrence_thematique_conf"
      And   l utilisateur clique sur "Ajouter_thematique_conf"
      And   l utilisateur clique sur "Sauvegarder_thematique"
     Then   vérifier que le message "succès" s affiche
      And   verifier que la thematique "Test Ajout thématique Auto 2" est dans la liste

   #Modification de la thématique

     When   l utilisateur modifie "Test Ajout thématique Auto 2 modif" dans le champs "Test Ajout thématique Auto 2"
      And   l utilisateur clique sur "Sauvegarder_thematique"
     Then   vérifier que le message "succès" s affiche
      And   verifier que la thematique "Test Ajout thématique Auto 2 modif" est dans la liste