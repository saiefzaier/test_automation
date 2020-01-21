# Auteur: Hafedh Tlili
# Feature: Gestion du personnel
# Scénario: Embauche d'un employé Collaborateur
# Date de création: 04/11/2019


#@ACCRETIO2
#@ACCRETIO2-CORERH
#@ACCRETIO2-GESTIONDUPERSONNEL
#@ACCRETIO2-GESTIONDUPERSONNEL-001

Feature: Gestion du personnel

  Scenario: Embauche d'un employé Collaborateur

     # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

    # Etape 2 : Accès à l'espace RH

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"

    # Etape 3 : Embauche d'un nouveau collaborateur
    ## Première popup d'embauche ##
    When l utilisateur clique sur "Ajouter_collaborateur"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_entrée_collaborateur"
    And l utilisateur selectionne "Interne" dans la liste deroulante "Type_collaborateur"
    And l utilisateur saisit "SOC00300" dans le champs "Matricule_collaborateur"
    And l utilisateur selectionne "M." dans la liste deroulante "Qualité_collaborateur"
    And l utilisateur saisit "Tounsi" dans le champs "Nom_collaborateur"
    And l utilisateur saisit "Ahmed" dans le champs "Prénom_collaborateur"
    And l utilisateur saisit "15/11/1984" dans le champs "Date_de_naissance_collaborateur"
    And l utilisateur selectionne "Tunisie" dans la liste deroulante "Pays_de_naissance_collaborateur"
    And l utilisateur selectionne "Célibataire" dans la liste deroulante "Situation_familiale_collaborateur"

    ## Deuxième popup d'embauche ##
    And  l utilisateur clique sur "Continuer"
    And l utilisateur selectionne "Embauche" dans la liste deroulante "Motif_d_entrée_collaborateur"
    And l utilisateur selectionne "Advyteam Global 3" dans la liste deroulante "Société_collaborateur"
    And l utilisateur selectionne "etblissement" dans la liste deroulante "Etablissement_collaborateur"
    And l utilisateur selectionne "Direction générale" dans la liste deroulante "Entité_organisationnelle_collaborateur"
    And l utilisateur selectionne "Ingénieur R&D" dans la liste deroulante "Emploi_collaborateur"
    And l utilisateur selectionne "test" dans la liste deroulante "Poste_collaborateur"
    And l utilisateur selectionne "CDI" dans la liste deroulante "Type_du_contrat_collaborateur"
    #And l utilisateur saisit "01/01/2019" dans le champs "Date de début du contrat"
    And l utilisateur clique sur "Enregistrer_Collaborateur"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And wait 8000

    # Etape 4 : Ajout de l'adresse mail
    And l utilisateur saisit "ahmed.tounsi@yopmail.com" dans le champs "Email_collaborateur"
    And l utilisateur clique sur "Sauvegarder_Collaborateur"
    And vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 5 : Ajout d'un cycle de travail
    #When l utilisateur clique sur "Dossier_administratif_collaborateur"
    #And l utilisateur clique sur "Ajouter_un_cycle_de_travail_collaborateur"
    #And l utilisateur selectionne "C2" dans la liste deroulante "Cycle_de_travail_collaborateur"
    #Pour les deux étapes suivantes, ils remplacent le choix dans la liste déroulante "première semaine collaborateur" qui ne fonctionne plus correctement comme liste déroulante
    #And wait 2000
    #And l utilisateur clique sur "Première_semaine_collaborateur"
    #And wait 2000
    #And l utilisateur saisit "S2" dans le champs "Première_semaine_collaborateur_IL"
    #And l utilisateur clique sur "Première_semaine_collaborateur_CL"
    # Step remplacée par les deux steps précédents And l utilisateur selectionne "S2" dans la liste deroulante "Première_semaine_collaborateur"
    #And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_collaborateur"
    #And l utilisateur clique sur "Valider_cycle_de_travail_collaborateur"
    #And wait 8000
    #And l utilisateur clique sur "Sauvegarder_Collaborateur"
    #Then vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 6 : Ajout d'un salaire
    When l utilisateur clique sur "Rémunération_collaborateur"
    And l utilisateur clique sur "Ajouter_un_salaire_collaborateur"
    And wait 2000
    And l utilisateur selectionne "Dinar tunisien" dans la liste deroulante "Devise_collaborateur"
    And wait 2000
    And l utilisateur saisit "1100" dans le champs "Montant_collaborateur"
    And wait 2000
    And l utilisateur saisit "01/01/2019" dans le champs "Date_de_début_collaborateur"
    And wait 2000
    And l utilisateur clique sur "Valider_salaire_collaborateur"
    And wait 8000
    And l utilisateur clique sur "Sauvegarder_Collaborateur"
    Then vérifier que le message "Opération effectuée avec succès" s affiche
    And wait 2000


