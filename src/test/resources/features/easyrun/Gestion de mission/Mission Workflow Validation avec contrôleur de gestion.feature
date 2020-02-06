# Auteur: Manel Hachicha
# Feature: Mission Workflow Validation avec le contrôleur de gestion
# Scénario: Validation d'une demande de mission avec le workflow qui inclut le rôle contrôleur de gestion
# Date de création: 29/11/2019


@ACCRETIO2
@ACCRETIO2-EASYRUN
@ACCRETIO2-Mission
@ACCRETIO2-Mission-0001

Feature: Gestion de mission

  Scenario: Validation d'une demande de mission avec le workflow qui inclut le rôle contrôleur de gestion

    Given le navigateur est ouvert et la page d'acceuil est affichée

    #Etape 1 : Profil Rh-Création d'une devise
    And l'utilisateur "haf03.expert@gmail.com" est connecté
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Configuration"
    And l utilisateur clique sur "Onglet_Conversion"
    And l utilisateur clique sur "Bouton_Ajouter une devise de référence"
    And l utilisateur selectionne "EURO" dans la liste deroulante "Devise de référence"
    And l utilisateur clique sur "Bouton_Sauvegarder_Devise de référence"
    And vérifier que le message "Opération effectuée avec succès" s affiche
     #La devise de référence crée est ajoutée à la fin de la liste
    And l utilisateur clique sur "Ajouter_Dernière_ligne"
    And l utilisateur selectionne "Dinar tunisien" dans la liste deroulante "Devise"
    And l utilisateur saisit "02/12/2019" dans le champs "Date d'effet"
    And l utilisateur saisit "3.22" dans le champs "Taux de change"
    And l utilisateur clique sur "Bouton_Sauvegarder_Devise"

    #Etape 2 : Profil Rh-Paramétrage de gestion de mission afin d'inclure le contrôleur de gestion dans le workflow
    And l utilisateur clique sur "Onglet_Paramétrage de mission"
    And l'utilisateur vérifie que la valeur du champ "Validation des demandes de missions par le contrôleur de gestion" est "Oui"

    #Etape 3 : Profil Rh-Ajout de nature
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Configuration"
    And l utilisat#Etape 3 : Profil collaborateur-Ajout de missioneur clique sur "Onglet_Nature"
    And l utilisateur clique sur "Bouton_Ajouter_Nature"
    And la fenêtre Ajout d'une nature s'affiche à l'écran
    And l utilisateur saisit "Test de NDF" dans le champs "Code"
    And l utilisateur saisit "Test de NDF" dans le champs "Libellé"
    And l utilisateur selectionne "Divers" dans la liste deroulante "Catégorie"
    And l utilisateur clique sur "Bouton_Ajouter"
    And vérifier que le message "Opération effectuée avec succès" s affiche

     #Etape 4 : Profil collaborateur-Ajout de mission
    And l'utilisateur "haf01.collaborateur@gmail.com" est connecté
    And l utilisateur clique sur "Bouton_Ordre de mission"
    And l utilisateur clique sur "Bouton_Ajouter_une mission"
    And la fenêtre Ajout d'une mission s'affiche à l'écran
    And l utilisateur saisit "Mission France" dans le champs "Titre de mission"
    And l utilisateur selectionne "Dinar tunisien" dans la liste deroulante "Devise"
    And l utilisateur selectionne "Advyteam" dans la liste deroulante "Client"
    And l utilisateur saisit "02/12/2019" dans le champs "Date de début de la mission"
    And l utilisateur saisit "03/12/2019" dans le champs "Date de fin de la mission"
    And l utilisateur clique sur "Bouton_Enregistrer_Ajout de mission"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And l utilisateur clique sur "Mission ayant la dernière référence"
    And l utilisateur clique sur "Bouton_Ajouter_Destination"
    And l utilisateur selectionne "France" dans la liste deroulante "Pays"
    And l utilisateur selectionne "Paris" dans la liste deroulante "Ville"
    And l utilisateur saisit "02/12/2019" dans le champs "Date de début de la mission"
    And l utilisateur saisit "03/12/2019" dans le champs "Date de fin de la mission"
    And l utilisateur clique sur "Bouton_Ajouter_Depense"
    And l utilisateur selectionne "Test de NDF" dans la liste deroulante "Nature"
    And l utilisateur saisit "02/12/2019" dans le champs "Date"
    And l utilisateur saisit "100" dans le champs "Montant(TTC)"
    And l utilisateur selectionne "Espèces" dans la liste deroulante "Mode de paiement"
    And l utilisateur clique sur "Bouton_Enregistrer_Mission"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And l utilisateur clique sur "Bouton_Envoyer_Mission"
    And la fenêtre de confirmation de soumission de la mission s'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider_Envoi_Mission"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And vérifier que le statut de la demande de mission devient "En cours"

    #Etape 5 : Profil manager-Validation de mission
    And l'utilisateur "haf02.manager@gmail.com" est connecté
    And l'utilisateur reçoit une notification "a envoyé une demande de mission"
    And l utilisateur clique sur "Notification_a envoyé une demande de mission"
    And l utilisateur clique sur "Mission_Collaborateur_Référence"
    And l utilisateur clique sur "Bouton_Accepter"
    And la fenêtre de confirmation de la validation d'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And la mission est déplacée au niveau de la rubrique Historique et son statut devient Validée


    #Etape 5 : Profil Agent de voyage-Validation de mission
    #L'utilisateur doit avoir le rôle Agent de voyage
    And l'utilisateur "haf03.expert@gmail.com" est connecté
    And l'utilisateur reçoit une notification "a envoyé une demande de mission"
    And l utilisateur clique sur "Mission_Collaborateur_Référence"
    And l utilisateur clique sur "Bouton_Accepter"
    And la fenêtre de confirmation de la validation d'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And la mission est déplacée au niveau de la rubrique Historique et son statut devient Validée

    #Etape 6 : Profil Contrôleur de gestion-Validation de mission
    And l'utilisateur "haf04.ctrlgest@gmail.com" est connecté
    And l'utilisateur reçoit une notification "a envoyé une note mission"
    And l utilisateur clique sur "Mission_Collaborateur_Référence"
    And l utilisateur clique sur "Bouton_Accepter"
    And la fenêtre de confirmation de la validation d'affiche à l'écran
    And l utilisateur clique sur "Bouton_Valider"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And la mission est déplacée au niveau de la rubrique Historique et son statut devient Validée

    #Etape 7 : Profil collaborateur-Vérification de la validation de la mission
    And l'utilisateur "haf01.collaborateur@gmail.com" est connecté
    Then Vérifier que l'utilisateur reçoit une notification de la validation de la mission et que le statut de la mission devient Traitée
