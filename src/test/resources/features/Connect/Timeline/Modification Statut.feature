# Auteur: ygatri
# Feature: Timeline
# Scénario: Modifier un statut
# Date de création: 30/09/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0002

Feature: Timeline : Modification d'un statut

  Scenario: Modification d'un statut

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

      #Etape 2 : Création statut

    When l utilisateur clique sur le bouton "Champ_Statut"
    And l utilisateur saisit "Ceci est un test automatisé qui vise à vérifier le fonctionnement correcte de la publication de statut" dans le champs "Champ_Input_Statut"
    And l utilisateur selectionne "Tous les utilisateurs" dans la liste deroulante "Liste_Deroulante_Timeline"
    And l utilisateur clique sur le bouton "Bouton_Publication_Statut"
    And wait 3000

      #Etape 3 : Modification statut

    And l utilisateur clique sur le bouton "Bouton_Menu_Modif_Supp_Statut"
    And l utilisateur clique sur le bouton "Bouton_Modif_Statut"
    And l utilisateur saisit "Modification statut" dans le champs "Champ_Input_Modification_Statut"
    And l utilisateur clique sur le bouton "Bouton_Publier_Statut"

      #Etape 4 : Verification modification statut

    Then verifier que la modification du statut est enregistrée

