# Auteur : syrineLakhdhar
# Feature : Timeline
# Scénario : Publication nouveau statut avec un tag
# Date de création : 01/11/2019

@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-TIMELINE
@ACCRETIO2-TIMELINE-0005

Feature: Timeline : Publication nouveau statut avec Tag

  Scenario: Publication nouveau statut avec Tag

         #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

           #Etape 2 : Creation statut avec tag

    When l utilisateur clique sur le bouton "Champ_Statut"
    And l utilisateur saisit "@Responsable Prod. MT" dans le champs "Champ_Input_Statut"
    And l utilisateur choisit le profil du tag du statut dans la liste
    And l utilisateur selectionne "Tous les utilisateurs" dans la liste deroulante "Liste_Deroulante_Timeline"
    And l utilisateur clique sur le bouton "Bouton_Publication_Statut"

           #Etape 3 : verfication création statut avec tag

    Then Vérifier que le statut est publié et que le tag est affiché