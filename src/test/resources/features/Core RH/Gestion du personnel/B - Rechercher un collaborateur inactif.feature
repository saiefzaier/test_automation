# Auteur: Saief Eddine Ezaier
# Feature: Gestion du personnel
# Scénario: Rechercher un collaborateur inactif
# Date de création: 27/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-GESTIONDUPERSONNEL
@ACCRETIO2-GESTIONDUPERSONNEL-007

Feature: Gestion du personnel

  Scenario: Rechercher un collaborateur inactif

   # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"

  # Etape 3 : Vérifier que le résultat de la recherche est KO
    And wait 5000
    And l utilisateur saisit "Collaborateur Inactif" dans le champs "Recherche_Collaborateur"
    And verifier que la recherche est KO

  # Etape 4 : Vérifier l'affichage du collaborateur dans la liste ( filtre incatif)
    And l utilisateur clique sur "Filtre_Recherche_Collaborateur"
    And l utilisateur selectionne "Inactif" dans la liste deroulante "Statut_Filtre_Collaborateur"
    And l utilisateur clique sur "Recherche_Filtre_Collaborateur"
    And l utilisateur saisit "Collaborateur Inactif" dans le champs "Recherche_Collaborateur"
    Then verifier la présence de "Collaborateur Inactif" dans la liste "Liste_Collaborateurs"



