# Auteur: marwamaherssi
# Feature: Anniversaire
# Scénario: Anniversaire Professionnel Widget
# Date de création: 27/02/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-ANNIVERSAIRE
#@ACCRETIO2-ANNIVERSAIRE-0006



Feature: Anniversaire Professionnel

  Scenario: Anniversaire Professionnel Widget

     #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    #Etape2 : L'admin va autorisé l'affichage de l'anniversaire professionnel

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Bouton_Configuration_Core"
    And wait 3000
    And l utilisateur clique sur "Bouton_Autres_Parametres"
    Then l administrateur va cocher le bouton d affichage de l anniversaire professionnel
    And l utilisateur clique sur "Bouton_Autres_Parametres_Enregistrer"

     #Etape3 : Configurer l'anniversaire professionnel de l'utilisateur

    When l utilisateur clique sur "Bouton_Menu_Etendu"
    And wait 3000
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"
    And wait 6000
    And l utilisateur saisit "Gaston Boutot" dans le champs "Rechercher_Employe"
    And l utilisateur clique sur "Dossier_administratif_collaborateur"
    And l utilisateur clique sur "Bouton_Modifier_Entree_Sortie"
    And l utilisateur modifie la date de l anniversaire professionnel
    And l utilisateur clique sur "Bouton_Valider_Modification_Entree_Sortie"
    And wait 3000
    And l utilisateur clique sur "Bouton_Enregistrer_Modification"
   And verifier que la date d anniv pro a ete modifie
    And wait 3000

    #Etape4 :  Verifier que l'anniversaire professionnel de l'utilisateur est afficher dans le widget

    And l utilisateur clique sur "Bouton_Portal"
    And wait 3000
    And l utilisateur clique sur "Bouton_Anniversaire_Portal"
    And wait 3000
    Then verifier que l anniversaire professionnel de l utilisateur est affiche



