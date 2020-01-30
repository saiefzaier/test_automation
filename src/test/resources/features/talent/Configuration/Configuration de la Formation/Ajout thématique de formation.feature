# Auteur: Ons MANSOURI
# Feature: Configuration
# Scénario: Ajout thématique de formation
# Date de création: 12/12/2019


@ACCRETIO2
@ACCRETIO2-TALENT
@ACCRETIO2-CONFIGURATIONTALENT
@ACCRETIO2-CONFIGURATIONTALENT-0005

Feature: Configuration

  Scenario: Ajout thématique de formation

    #Etape 001: Connexion RH_Skills

    Given   le navigateur est ouvert et la page d'acceuil est affichée
      And   l'utilisateur "combes.caroline@YOPMAIL.COM" est connecté
     Then   le nom de l utilisateur "Caroline Combes" est affiche en haut a gauche

    #Etape 002: Acceder  au sous module configuration

      When l utilisateur clique sur "Bouton_Role_RH"
      And   l utilisateur clique sur "Bouton_Menu_Etendu"
      And   l utilisateur clique sur "Module_Talent"
      And   l utilisateur clique sur "Sous_module_Configuration_Talent"
      And   l utilisateur clique sur "Bouton_Formations_Talent"
      And   l utilisateur clique sur "Bouton_Formations_Thematique_Talent"

     #Ajout de la thématique

      #And   l utilisateur saisit "Test Ajout thématique Auto 1" dans le champs "Ajout_occurrence_thematique_conf"
      #And   l utilisateur clique sur "Ajouter_thematique_conf"
      And l utilisateur ajoute la thematique"Test Ajout thématique Auto 1"
      And wait 3000
      And   l utilisateur clique sur "Sauvegarder_thematique"
      Then   vérifier que le message "Opération effectuée avec succès" s affiche
      And   verifier que la thematique "Test Ajout thématique Auto 1" est dans la liste