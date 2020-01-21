# Auteur: Ons MANSOURI
# Feature: Configuration
# Scénario: Suppression thématique de formation
# Date de création: 08/01/2020


@ACCRETIO2
@ACCRETIO2-TALENT
@ACCRETIO2-CONFIGURATION
@ACCRETIO2-CONFIGURATION-0009

Feature: Configuration

 Scenario: Suppression thématique de formation

    #Etape 001: Connexion RH_Training

    Given   le navigateur est ouvert et la page d'acceuil est affichée
      And   l'utilisateur "combes.caroline@YOPMAIL.COM" est connecté
     Then   le nom de l utilisateur "Caroline Combes" est affiche en haut a gauche

    #Etape 002: Acceder  au sous module configuration

     When   l utilisateur clique sur "Bouton_menu_etendu"
      And   l utilisateur clique sur "Module_Talent"
      And   l utilisateur clique sur "Sous_module_Configuration"

    #Ajout de la thématique

      And   l utilisateur saisit "Test Ajout thématique Auto 3" dans le champs "Ajout_occurrence_thematique_conf"
      And   l utilisateur clique sur "Ajouter_thematique_conf"
      And   l utilisateur clique sur "Sauvegarder_thematique"
     Then   vérifier que le message "succès" s affiche
      And   verifier que la thematique "Test Ajout thématique Auto 3" est dans la liste
   #Suppression de la thématique
     When   l utilisateur clique sur "Supprimer_Test_Ajout_thématique_Auto_3"
      And   l utilisateur clique sur "Sauvegarder_thematique"
     Then   vérifier que le message "succès" s affiche
      And   verifier que la thematique "Test Ajout thématique Auto 3" n est plus dans la liste