# Auteur: Saief Eddine Ezaier
# Feature: Référentiels
# Scénario: Suppression d'une Société
# Date de création: 03/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0007


Feature: Référentiels

  Scenario: Suppression société

    # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Accès à l'espace RH
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Sociétés"



    # Etape 3 : Supprimer la société
    And l utilisateur selectionne "test_delete" dans la liste "Liste_Societe"
    And  l utilisateur clique sur "BoutonSupprimerSociete"
    And  l utilisateur clique sur "Bouton_Confirmer_Suppression_Societe"
    Then vérifier que le message "Opération effectuée avec succès" s affiche
