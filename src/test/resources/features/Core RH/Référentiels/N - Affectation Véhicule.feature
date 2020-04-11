# Auteur: Saief Eddine Ezaier
# Feature: Gestion du personnel
# Scénario: Affectation D'un véhicule
# Date de création: 11/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-GESTIONDUPERSONNEL
@ACCRETIO2-GESTIONDUPERSONNEL-002

Feature: Gestion du personnel

  Scenario: Affectation d'un véhicule

     # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

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
    And l utilisateur saisit "SOC00V" dans le champs "Matricule_collaborateur"
    And l utilisateur selectionne "Monsieur" dans la liste deroulante "Qualité_collaborateur"
    And l utilisateur saisit "Véhicule" dans le champs "Nom_collaborateur"
    And l utilisateur saisit "Collaborateur" dans le champs "Prénom_collaborateur"
    And l utilisateur saisit "15/11/1984" dans le champs "Date_de_naissance_collaborateur"
    And l utilisateur selectionne "Angola" dans la liste deroulante "Pays_de_naissance_collaborateur"
    And l utilisateur selectionne "Célibataire" dans la liste deroulante "Situation_familiale_collaborateur"

    ## Deuxième popup d'embauche ##
    And  l utilisateur clique sur "Continuer"
    And l utilisateur selectionne "Embauche" dans la liste deroulante "Motif_d_entrée_collaborateur"
    And l utilisateur selectionne "Delfingen QA" dans la liste deroulante "Société_collaborateur"
    And l utilisateur selectionne "DFG_Siège social" dans la liste deroulante "Etablissement_collaborateur"
    And l utilisateur selectionne "DFG_Direction générale" dans la liste deroulante "Entité_organisationnelle_collaborateur"
    And l utilisateur selectionne "DFG_Direction" dans la liste deroulante "Emploi_collaborateur"
    And l utilisateur selectionne "DFG_Responsable recrutement" dans la liste deroulante "Poste_collaborateur"
    And l utilisateur selectionne "Contrat à durée indéterminée" dans la liste deroulante "Type_du_contrat_collaborateur"
# #   And l utilisateur saisit "01/01/2019" dans le champs "Date de début du contrat"
    And l utilisateur clique sur "Enregistrer_Collaborateur"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And wait 8000
    And l'utilisateur rafraichit la page

    # Etape 5 : Affectation du véhicule
    And l utilisateur saisit "Collaborateur Véhicule" dans le champs "Recherche_Collaborateur"
    And wait 2000
    And l utilisateur selectionne "Collaborateur Véhicule" dans la liste "Liste_Collaborateurs"
    And l utilisateur clique sur "Onglet_Rénumération"
    And wait 2000
    And l utilisateur clique sur "Bouton_Ajouter_Affectation_Véhicule"
    And wait 2000
    And l utilisateur selectionne "200 TU 2200" dans la liste deroulante "Liste_Immatriculation"
    And wait 3000
    And l utilisateur saisit "02/03/2020" dans le champs "Début_Usage_Véhicule"
    And wait 5000
    And l utilisateur saisit "15/03/2020" dans le champs "Fin_Usage_Véhicule"
    And wait 2000
    And l utilisateur clique sur "Bouton_Valider_Affecatation_Véhicule"
    And wait 3000
    And l utilisateur clique sur "Bouton_Enregistrer_Modification"
    And vérifier que le message "Opération effectuée avec succès" s affiche






