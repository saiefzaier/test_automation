# Auteur: Manel Hachicha
# Feature: NDF Workflow Validation avec le contrôleur de gestion
# Scénario: Validation d'une note de frais avec le workflow qui inclut le rôle contrôleur de gestion
# Date de création: 08/11/2019


@ACCRETIO2
@ACCRETIO2-EASYRUN
@ACCRETIO2-NDF
@ACCRETIO2-NDF-0001

Feature: NDF

  Scenario: Validation d'une note de frais avec le workflow qui inclut le rôle contrôleur de gestion

    Given le navigateur est ouvert et la page d'acceuil est affichée

    #Etape 1 : Profil Rh-Création d'une nature
    And l'utilisateur "haf03.expert@gmail.com" est connecté
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Configuration"
    And l utilisateur clique sur "Onglet_Nature"
    And l utilisateur clique sur "Bouton_Ajouter_Nature"
    And la fenêtre Ajout d'une nature s'affiche à l'écran
    And l utilisateur saisit "Test de NDF" dans le champs "Code"
    And l utilisateur saisit "Test de NDF" dans le champs "Libellé"
    And l utilisateur selectionne "Divers" dans la liste deroulante "Catégorie"
    And l utilisateur clique sur "Bouton_Ajouter"
    And vérifier que le message "Opération effectuée avec succés" s affiche

    #Etape 2 : Profil Rh-Paramétrage de note de frais afin d'inclure le contrôleur de gestion dans le workflow
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Notes de frais"
    And l utilisateur clique sur "Onglet_Paramétrage"
    And l'utilisateur sélectionne la valeur "Oui" au niveau du champ "Validation des notes de frais par le contrôleur de gestion
    And l utilisateur clique sur "Bouton_Enregistrer"
    And vérifier que le message "Opération effectuée avec succés" s affiche

    #Etape 3 : Profil collaborateur-Ajout de NDF
    And l'utilisateur "haf01.collaborateur@gmail.com" est connecté
    And l utilisateur clique sur "Bouton_Mes notes de frais"
    And l utilisateur clique sur "Bouton_Ajouter_Note de frais"
    And la fenêtre Ajout d'une note de frais s'affiche à l'écran
    And l utilisateur saisit "NDF" dans le champs "Note"
    And l utilisateur saisit "08/11/2019" dans le champs "Date"
    And l utilisateur clique sur "Bouton_Ajouter"
    And vérifier que le message "Opération effectuée avec succés" s affiche
    And l utilisateur clique sur "NDF ayant la dernière référence"
    And l utilisateur clique sur "Bouton_Ajouter_Dépense"
    And la fenêtre d'ajout de dépense s'affiche à l'écran
    And l utilisateur selectionne "Test De NDF" dans la liste deroulante "Nature"
    And l utilisateur saisit "08/11/2019" dans le champs "Date"
    And l utilisateur saisit "100" dans le champs "Montant(TTC)"
    And l utilisateur selectionne "Espèces" dans la liste deroulante "Mode de paiement"
    And l utilisateur clique sur "Bouton_Ajouter"
    And vérifier que le message "Opération effectuée avec succés" s affiche
    And l utilisateur clique sur "Bouton_Envoyer_NDF"
    And la fenêtre de confirmation de soumission de la NDF s'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider"
    And vérifier que le message "Opération effectuée avec succés" s affiche
    And la référence de NDF est crée et le statut de la NDF devient En cours

    #Etape 4 : Profil manager-Validation de NDF
    And l'utilisateur "haf02.manager@gmail.com" est connecté
    And l'utilisateur reçoit une notification "a envoyé une note de frais"
    And l utilisateur clique sur "Notification_a envoyé une note de frais"
    And l utilisateur clique sur "NDF_Collaborateur_Référence"
    And l utilisateur clique sur "Bouton_Accepter"
    And la fenêtre de confirmation de la validation d'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider"
    And vérifier que le message "Opération effectuée avec succés" s affiche
    And la NDF est déplacée au niveau de la rubrique Historique et son statut devient Validée


    #Etape 5 : Profil Contrôleur de gestion-Validation de NDF
    And l'utilisateur "haf04.ctrlgest@gmail.com" est connecté
    And l'utilisateur reçoit une notification "a envoyé une note de frais"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Notes de frais"
    And l utilisateur clique sur "NDF_Collaborateur_Référence"
    And l utilisateur clique sur "Bouton_Accepter"
    And la fenêtre de confirmation de la validation d'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider"
    And vérifier que le message "Opération effectuée avec succés" s affiche
    And la NDF est déplacée au niveau de la rubrique Historique et son statut devient Contrôlée

    #Etape 6 : Profil Financier-Validation de NDF
    And l'utilisateur "haf05.finance@gmail.com" est connecté
    And l'utilisateur reçoit une notification "a envoyé une note de frais"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Notes de frais"
    And l utilisateur clique sur "NDF_Collaborateur_Référence"
    And l utilisateur clique sur "Bouton_Accepter"
    And la fenêtre de confirmation de la validation d'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider"
    And vérifier que le message "Opération effectuée avec succés" s affiche
    And la NDF est déplacée au niveau de la rubrique Historique et son statut devient Payée

    #Etape 7 : Profil collaborateur-Vérification de la validation de la NDF
    And l'utilisateur "haf01.collaborateur@gmail.com" est connecté
    Then Vérifier que l'utilisateur reçoit une notification de la validation de la NDF et que le statut de la NDF devient Payée




