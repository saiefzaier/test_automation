# Auteur: Ons MANSOURI
# Feature: Configuration
# Scénario: Suppression de classification de competences deja affectee
# Date de création: 07/01/2020


#@ACCRETIO2
#@ACCRETIO2-TALENT
#@ACCRETIO2-CONFIGURATIONTALENT
#@ACCRETIO2-CONFIGURATIONTALENT-0006

Feature: Configuration

  Scenario: Suppression de classification de competences deja affectee

    #Etape 001: Connexion RH_Skills

    Given   le navigateur est ouvert et la page d'acceuil est affichée
      And   l'utilisateur "combes.caroline@YOPMAIL.COM" est connecté
     Then   le nom de l utilisateur "Caroline Combes" est affiche en haut a gauche

    #Etape 002: Acceder  au sous module configuration

    When l utilisateur clique sur "Bouton_Role_RH"
    And   l utilisateur clique sur "Bouton_Menu_Etendu"
    And   l utilisateur clique sur "Module_Talent"
    And   l utilisateur clique sur "Sous_module_Configuration_Talent"


    #Suppression de classification de competences

      And   l utilisateur clique sur "Classification_conf"
      And   l utilisateur clique sur "Options_grades"
      And   l utilisateur clique sur "Supprimer_option_grades"
      And   l utilisateur clique sur "Sauvegarder_classification"
     Then   vérifier que le message "impossible" s affiche
     When   l utilisateur clique sur "Annuler_classification"
     Then   verifier que la classification grades est toujours dans la liste
