# Auteur: Hafedh Tlili
# Feature: Référentiels
# Scénario: Création Poste
# Date de création: 04/11/2019


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0005

Feature: Référentiels

  Scenario: Création Poste

    # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Postes"

    # Etape 3 : Ajout d'un nouveau poste
    When l utilisateur clique sur "Ajouter_un_poste"
    And l utilisateur saisit "SOCPOS01" dans le champs "Code_poste"
    And l utilisateur saisit "Poste 1" dans le champs "Libellé_poste"
    And l utilisateur saisit "01/01/2019" dans le champs "Date_d_effet_poste"
    # And l utilisateur selectionne "Actif" dans la liste deroulante "Statut_poste"
    #And l utilisateur selectionne "Entité 1" dans la liste deroulante "Entite_organisationnelle_poste"
    And l utilisateur selectionne "Emploi1" dans la liste deroulante "Emploi_poste"
    And l utilisateur clique sur "Enregistrer_Poste"
    And vérifier que le message "Opération effectuée avec succès" s affiche

    # Etape 4 : Ajout d'une compétence
    When l utilisateur clique sur "Exigences_Poste"
    And wait 2000
    And l utilisateur clique sur "Ajouter_competence_Poste"
    And l utilisateur selectionne "Change Management" dans la liste deroulante "Compétence_poste"
    And l utilisateur selectionne "3" dans la liste deroulante "Niveau_compétence_poste"
    And l utilisateur selectionne "Requise" dans la liste deroulante "Importance_compétence_poste"
    And l utilisateur clique sur "Aquise_dans_le_travail"
    And l utilisateur clique sur "Valider_competence_Poste"
    And l utilisateur clique sur "Sauvegarder_Poste"

    # Etape 5 : Ajout d'une langue
    When l utilisateur clique sur "Ajouter_langue_Poste"
    And l utilisateur selectionne "Français" dans la liste deroulante "Langue_poste"
    And l utilisateur selectionne "Confirmé" dans la liste deroulante "Niveau_langue_poste"
    And l utilisateur selectionne "Requise" dans la liste deroulante "Importance_langue_poste"
    And l utilisateur clique sur "Valider_langue_Poste"
    And l utilisateur clique sur "Sauvegarder_Poste"

    # Etape 6 : Ajout d'une habilitation
    When l utilisateur clique sur "Ajouter_habilitation_Poste"
    And l utilisateur selectionne "Permis de conduire" dans la liste deroulante "Type_habilitation_poste"
    And l utilisateur selectionne "Permis A" dans la liste deroulante "Modèle_habilitation_poste"
    And l utilisateur selectionne "Préférée" dans la liste deroulante "Importance_habilitation_poste"
    And l utilisateur clique sur "Valider_habilitation_Poste"

     # Etape 7 : Ajout d'un diplôme
    When l utilisateur clique sur "Ajouter_diplome_Poste"
    And l utilisateur selectionne "Ingénieur" dans la liste deroulante "Diplôme_poste"
    And l utilisateur selectionne "Informatique" dans la liste deroulante "Discipline_diplôme_poste"
    And l utilisateur selectionne "Préférée" dans la liste deroulante "Importance_diplôme_poste"
    And l utilisateur clique sur "Valider_diplome_Poste"

     # Etape 8 : Ajout d'une expérience professionnelle
    When l utilisateur clique sur "Ajouter_experience_Poste"
    And l utilisateur saisit "Ingénieur de test junior" dans le champs "Emploi_expérience_poste"
    And l utilisateur selectionne "Service" dans la liste deroulante "Secteur_expérience_poste"
    And l utilisateur saisit "2" dans le champs "Années_d_expérience_poste"
    And l utilisateur selectionne "Requise" dans la liste deroulante "Importance_expérience_poste"
    And l utilisateur clique sur "Valider_annees_experience_poste"

    # Etape 9 : Validation finale
    And l utilisateur clique sur "Sauvegarder_Poste"
    Then vérifier que le message "Opération effectuée avec succès" s affiche


