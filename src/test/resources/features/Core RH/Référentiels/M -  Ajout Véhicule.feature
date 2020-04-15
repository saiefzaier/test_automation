# Auteur: Saief Eddine Ezaier
# Feature: Référentiels
# Scénario: Ajout Véhicule
# Date de création: 04/03/2020


@ACCRETIO2
@ACCRETIO2-CORERH
@ACCRETIO2-REFERENTIELS
@ACCRETIO2-REFERENTIELS-0012


Feature: Référentiels


  Scenario: Ajout Véhicule

    # Etape 1 : Connexion :
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin@accretio.io" est connecté

    # Etape 2 : Ajout marque
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Configuration_Core_RH"
    And wait 2000
    And l utilisateur selectionne "Collection" dans la liste "Liste_Configuration"
    And wait 3000
    And l utilisateur selectionne "Marque de véhicule" dans la liste "Liste_Collections"
    And wait 3000
    And l utilisateur saisit "ford" dans le champs "Code_Marque"
    And wait 3000
    And l utilisateur saisit "Ford" dans l'input "Marque"
    And wait 3000
    And l utilisateur clique sur "Bouton_Ajout_Marque"
    And wait 3000
    And l utilisateur clique sur "Bouton_Enregistrer_Marque"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And wait 3000

     # Etape 3 : Ajout modèle
    And l utilisateur selectionne "Modèle de véhicule" dans la liste "Liste_Collections"
    And wait 3000
    And l utilisateur clique sur "Bouton_Ajouter_Modèle"
    And wait 3000
    And l utilisateur saisit "003" dans le champs "Code_Modèle"
    And wait 2000
    And l utilisateur saisit "Focus" dans le champs "Libellé_Modèle"
    And wait 3000
    And l utilisateur selectionne "Ford" dans la liste deroulante "Liste_Marques"
    And wait 3000
    And l utilisateur clique sur "Bouton_Valider_Modèle"
    And wait 3000
    And l utilisateur clique sur "Bouton_Enregistrer_Modéle"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And wait 3000

    # Etape 4 : Accès à l'espace RH
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Référentiels"
    And l utilisateur clique sur "Sociétés"
    And wait 3000

    # Etape 5 Ajout de véhicule

    And l utilisateur selectionne "Delfingen QA" dans la liste "Liste_Societe"
    And wait 2000
    And l utilisateur clique sur "Onglet_Véhicules"
    And wait 2000
    And l utilisateur clique sur "Bouton_Ajouter_Véhicule"
    And wait 3000
    And l utilisateur saisit "200 TU 2200" dans le champs "Immatriculation_Véhicule"
    And wait 3000
    And l utilisateur selectionne "Ford" dans la liste deroulante "Marque_Véhicule"
    And wait 3000
    And l utilisateur selectionne "Focus" dans la liste deroulante "Modèle_Véhicule"
    And wait 3000
    And l utilisateur selectionne "Financier" dans la liste deroulante "Type_Leasing_Véhicule"
    And l utilisateur selectionne "Hiver" dans la liste deroulante "Pneus_Véhicule"
    And wait 3000
    And l utilisateur clique sur "Bouton_Valider_Ajout_Véhicule"
    And wait 3000
    And l utilisateur clique sur "Bouton_Enregistrer_Ajout_Véhicule"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And wait 2000
    Then l utilisateur ferme la fenetre du navigateur