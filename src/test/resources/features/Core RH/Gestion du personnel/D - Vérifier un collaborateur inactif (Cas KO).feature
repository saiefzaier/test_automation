# Auteur: Saief Eddine Ezaier
# Feature: Gestion du personnel
# Scénario: Vérifier un collaborateur inactif (Cas KO)
# Date de création: 29/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-GESTIONDUPERSONNEL
@ACCRETIO2-GESTIONDUPERSONNEL-009

Feature: Gestion du personnel

  Scenario: Vérifier un collaborateur inactif (Cas KO)

     # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"

    # Etape 3 : Acèes au tableau Entrées/Sorties
    And l utilisateur saisit "Collaborateur Inactif" dans le champs "Recherche_Collaborateur"
    And wait 2000
    And l utilisateur selectionne "Collaborateur Inactif" dans la liste "Liste_Collaborateurs"
    And  l utilisateur clique sur "Onglet_Dossier_Administratif"
    And  l utilisateur clique sur "Icone_Modifier_Entrées_Sorties"

    # Etape 4 : Vérifier l affichage du message d erreur  sous le champs Date de sortie
    And l utilisateur choisit une date de sortie inférieure a la date d'embauche
    And Vérifier l affichage du message d erreur "La date de sortie doit être supérieure à la date d'entrée" sous le champs Date de sortie
    And l utilisateur choisit une date de sortie égale a la date d'embauche
    And Vérifier l affichage du message d erreur "La date de sortie doit être supérieure à la date d'entrée" sous le champs Date de sortie


