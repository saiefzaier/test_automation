# Auteur: ygatri
# Feature: Timeline
# Scénario: Supprimer un statut
# Date de création: 30/09/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0013




Feature: Timeline

  Scenario: Suppression statut

         #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

         #Etape 2 : Publiation Statut

    And l utilisateur clique sur "Champ_Statut"
    And l utilisateur saisit "Ceci est un test automatisé qui vise à vérifier le fonctionnement correcte de la suppression statut" dans le champs "Champ_Input_Statut"
    And l utilisateur selectionne "Tous les utilisateurs Connect" dans la liste deroulante "Liste_Deroulante_Timeline"
    #Timeline qui contient tous les utilisateurs du module connect
    And l utilisateur clique sur "Bouton_Publication_Statut"
    And wait 2000
      #Etape 3 : Suppression Statut

    And l utilisateur clique sur "Bouton_Menu_Modif_Supp_Statut"
    And l utilisateur clique sur "Bouton_Supprimer_Statut"
    And l utilisateur clique sur "Bouton_Valider_Suppression_Statut"

        #Etape 4 : Vérification de la suppression d'un statut

    Then verifier que la suppression du statut a été effectuée