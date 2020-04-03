# Auteur: Saief Eddine Ezaier
# Feature: Gestion du personnel
# Scénario: Affectation D'un véhicule
# Date de création: 11/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-GESTIONDUPERSONNEL
@ACCRETIO2-GESTIONDUPERSONNEL-003

Feature: Gestion du personnel

  Scenario: Affectation d'un véhicule non autorisé

     # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    # Etape 2 : Accès à l'espace RH

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"




    # Etape 5 : Affectation du véhicule
    And l utilisateur saisit "Collaborateur Véhicule Non Autorisé" dans le champs "Recherche_Collaborateur"
    And wait 2000
    And l utilisateur selectionne "Collaborateur Véhicule Non Autorisé" dans la liste "Liste_Collaborateurs"
    And l utilisateur clique sur "Onglet_Rénumération"
    And l utilisateur clique sur "Bouton_Ajouter_Affectation_Véhicule"
    And l utilisateur selectionne "200 TU 2200" dans la liste deroulante "Liste_Immatriculation"
    And l utilisateur saisit "01/03/2020" dans le champs "Début_Usage_Véhicule"
    And wait 5000
    And l utilisateur saisit "01/04/2020" dans le champs "Fin_Usage_Véhicule"
    And l utilisateur clique sur "Bouton_Valider_Affecatation_Véhicule"
    And l utilisateur clique sur "Bouton_Enregistrer_Modification"
    And vérifier que le message "Le véhicule est affecté à cette date/\n" s affiche








