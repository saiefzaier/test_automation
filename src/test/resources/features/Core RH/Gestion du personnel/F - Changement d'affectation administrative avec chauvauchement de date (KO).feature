# Auteur: Saief Eddine Ezaier
# Feature: Gestion du personnel
# Scénario: Changement d'affectation administrative (KO)
# Date de création: 24/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-GESTIONDUPERSONNEL
@ACCRETIO2-GESTIONDUPERSONNEL-005

Feature: Gestion du personnel

  Scenario: Changement d'affectation administrative (KO)

     # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    # Etape 2 : Accès à l'espace RH

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"


  # Etape 4 : Changement d'affectation
    And l utilisateur saisit "Collaborateur Affectation" dans le champs "Recherche_Collaborateur"
    And wait 2000
    And l utilisateur selectionne "Collaborateur Affectation" dans la liste "Liste_Collaborateurs"
    And  l utilisateur clique sur "Onglet_Dossier_Administratif"
    And l utilisateur clique sur "Bouton_Ajouter_Affectation"
    And l utilisateur saisit "01/01/2020" dans le champs "Date_Debut_Affectation"
    And l utilisateur selectionne "DFG_Service Industriel" dans la liste deroulante "Entité_Affectation"
    And l utilisateur selectionne "DFG_Responsable marketing" dans la liste deroulante "Poste_Affectation"
    And l utilisateur clique sur "Bouton_Valider_Affectation"
    And l utilisateur clique sur "Bouton_Enregistrer_Modification"
    And vérifier que le message "La date de début de l'affectation doit être supérieure à la date de fin de l'affectation précédente" s affiche


