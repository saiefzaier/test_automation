# Auteur: Saief Eddine Ezaier
# Feature: Gestion du personnel
# Scénario: Réactivation d' un collaborateur inactif
# Date de création: 29/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-GESTIONDUPERSONNEL
@ACCRETIO2-GESTIONDUPERSONNEL-008

Feature: Gestion du personnel

  Scenario: Réactivation d' un collaborateur inactif

   # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    # Etape 2 : Accès à l'espace RH

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"

    # Etape 3 : Réactiver le collaborateur inactif
    And l utilisateur clique sur "Filtre_Recherche_Collaborateur"
    And l utilisateur selectionne "Inactif" dans la liste deroulante "Statut_Filtre_Collaborateur"
    And l utilisateur clique sur "Recherche_Filtre_Collaborateur"
    And l utilisateur saisit "Collaborateur Inactif" dans le champs "Recherche_Collaborateur"
    And wait 2000
    And l utilisateur selectionne "Collaborateur Inactif" dans la liste "Liste_Collaborateurs"
    And  l utilisateur clique sur "Onglet_Dossier_Administratif"
    And  l utilisateur clique sur "Icone_Modifier_Entrées_Sorties"
    And  l utilisateur clique sur "Icone_Suppression_Date_Sortie"
    And  l utilisateur clique sur "JS_Icone_Suppression_Motif_Sortie"
    And l utilisateur clique sur "Valider_Entrées_Sorties"
    And l utilisateur clique sur "Bouton_Enregistrer_Modification"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And vérifier que l'utilisateur est actif
