# Auteur: marwamaherssi
# Feature: Stockage
# Scénario: Verifier Avancement Pourcentage User
# Date de création: 10/12/2019

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-STOCKAGE
#@ACCRETIO2-STOCKAGE-0004


Feature: Stockage

  Scenario: Verifier Avancement Pourcentage User

      #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

     #Etape2 : Consulter l'espace de stockage disponible pour l'utilisateur

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Administration"
    And l utilisateur clique sur "Bouton_Configuration_Systeme"
    And l utilisateur clique sur "Bouton_Paramétre_Stockage"
    And l utilisateur clique sur "Bouton_Suivi_Stockage"
    Then verifier l'espace de stockage pour le user connecté

     #Etape3 : Publier une Image

    When l utilisateur clique sur "Bouton_Portal"
    And l utilisateur clique sur "Bouton_Image_Timeline"
    And l utilisateur upload photo dans la publication
    And l utilisateur saisit "Test automatisé publication image et verif de l'absence de la notification" dans le champs "Champ_Input_Statut_Image"
    And l utilisateur selectionne "liste_absent" dans la liste deroulante "Liste_Deroulante_Timeline"
    And l utilisateur clique sur "Bouton_Publication_Image"

     #Etape4 : Verifier que le pourcentage a changé

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Administration"
    And l utilisateur clique sur "Bouton_Configuration_Systeme"
    And l utilisateur clique sur "Bouton_Paramétre_Stockage"
    And l utilisateur clique sur "Bouton_Suivi_Stockage"
    Then verifier que l'espace de stockage pour le user a changé

