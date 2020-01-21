# Auteur: ygatri
# Feature: Timeline
# Scénario: Modifier un statut
# Date de création: 30/09/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0002

Feature: Timeline

  Scenario: Modification d'un statut

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape 2 : Création statut

    When l utilisateur clique sur "Champ_Statut"
    And l utilisateur saisit "Ceci est un test automatisé qui vise à vérifier le fonctionnement correcte de la publication de statut" dans le champs "Champ_Input_Statut"
    And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline"
    #Timeline qui contient tous les utilisateurs du module connect
    And l utilisateur clique sur "Bouton_Publication_Statut"
    And wait 3000

      #Etape 3 : Modification statut

    And l utilisateur clique sur "Bouton_Menu_Modif_Supp_Statut"
    And l utilisateur clique sur "Bouton_Modif_Statut"
    And l utilisateur saisit "Modification statut" dans le champs "Champ_Input_Modification_Statut"
    And l utilisateur clique sur "Bouton_Publier_Statut"

      #Etape 4 : Verification modification statut

    Then verifier que la modification du statut est enregistrée

