# Auteur: Ons MANSOURI
# Feature: Configuration
# Scénario: Ajout niveau de compétences
# Date de création: 05/12/2019


#@ACCRETIO2
#@ACCRETIO2-TALENT
#@ACCRETIO2-CONFIGURATIONTALENT
#@ACCRETIO2-CONFIGURATIONTALENT-0001

Feature: Configuration

 Scenario: Ajout de niveau de compétences

    #Etape 001: Connexion RH_Skills

    Given   le navigateur est ouvert et la page d'acceuil est affichée
      And   l'utilisateur "combes.caroline@YOPMAIL.COM" est connecté
     Then   le nom de l utilisateur "Caroline Combes" est affiche en haut a gauche

    #Etape 002: Acceder  au sous module configuration

      When l utilisateur clique sur "Bouton_Role_RH"
      And   l utilisateur clique sur "Bouton_Menu_Etendu"
      And   l utilisateur clique sur "Module_Talent"
      And   l utilisateur clique sur "Sous_module_Configuration_Talent"
      And wait 5000

    #Ajout du niveau de compétences

      And   l utilisateur clique sur "Niveau_de_compétences_conf"
      And   l utilisateur clique sur "Ajouter_niv_comp"
      And   l utilisateur saisit "Niveau competence test auto 1" dans le champs "Libelle_niv_comp"
      And   l utilisateur saisit "Test Ajout Automatique" dans le champs "Description_ajout_niv_comp"
      And   l utilisateur saisit "Niveau 1" dans le champs "Libelle1_ajout_niv_comp"
      And   l utilisateur saisit "10" dans le champs "Valeur1_ajout_niv_comp"
      And   l utilisateur choisit la couleur noir
      And   l utilisateur saisit "Test Ajout Automatique" dans le champs "Description1_ajout_niv_comp"
      And   l utilisateur clique sur "Valider_ajout_niv_comp"
      And   l utilisateur clique sur "Sauvegarder_niv_comp"

    #Vérification de l ajout du niveau de compétences

     Then   vérifier que le message "succès" s affiche
      And   verifier que le dernier libelle est "Niveau competence test auto 1"
      And   verifier que le nombre d'etoile est "5"
