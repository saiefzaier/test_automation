# Auteur: marwamaherssi
# Feature: Anniversaire
# Scénario: Anniversaire Personnel Widget
# Date de création: 20/02/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-ANNIVERSAIRE
#@ACCRETIO2-ANNIVERSAIRE-0005


Feature: Anniversaire Personnel

  Scenario: Anniversaire Personnel Widget

     #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    #Etape2 : L'admin va autorisé l'affichage de l'anniversaire personnel

     When l utilisateur clique sur "Bouton_Role_RH"
     And l utilisateur clique sur "Bouton_Menu_Etendu"
     And l utilisateur clique sur "Core_RH"
     And wait 3000
     And l utilisateur clique sur "Bouton_Configuration_Core"
     And wait 3000
     And l utilisateur clique sur "Bouton_Autres_Parametres"
     And wait 3000
     Then l administrateur va cocher le bouton d affichage de l anniversaire personnel
     And wait 3000
     And l utilisateur clique sur "Bouton_Autres_Parametres_Enregistrer"
     And wait 3000

     #Etape3 : Configurer l'anniversaire personnel de l'utilisateur

    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"
    And wait 3000
    And l utilisateur saisit "Gaston Boutot" dans le champs "Rechercher_Employe"
    And l utilisateur modifie la date de l anniversaire
   And wait 3000
   And l utilisateur clique sur "Bouton_Enregistrer_Modification"
   And verifier que la date d anniv perso a ete modifie
   And wait 3000

    #Etape4 : Le collaborateur va se connecter et cocher le bouton d'affichage de l anniversaire personnel

    And wait 3000
    And l utilisateur se deconnecte
    And l'utilisateur "gaston.boutot@yopmail.com" est connecté
    And l utilisateur clique sur "Bouton_Configuration"
    And l utilisateur clique sur "Bouton_Profil"
    And wait 3000
    And l utilisateur clique sur "Bouton_Afficher_AnniversairePersonnel"
    And wait 3000
    Then l utilisateur va cocher le bouton d affichage d anniversaire personnel
    When l utilisateur clique sur "Bouton_Configuration"
    And l utilisateur clique sur "Icone_Nom_Utilisateur"
    And wait 3000

    #Etape5 : Verifier que l'anniversaire personnel de l'utilisateur est afficher dans le widget

#    And l utilisateur se deconnecte
#    And l'utilisateur "responsable@yopmail.com" est connecté
    And l utilisateur clique sur "Bouton_Portal"
    And l utilisateur clique sur "Bouton_Anniversaire_Portal"
    And wait 3000
    Then verifier que l anniversaire personnel de l utilisateur est affiche

