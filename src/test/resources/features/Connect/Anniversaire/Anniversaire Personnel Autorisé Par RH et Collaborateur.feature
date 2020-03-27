# Auteur: marwamaherssi
# Feature: Anniversaire
# Scénario: Anniversaire Personnel Autorise Par RH et collaborateur
# Date de création: 04/02/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-ANNIVERSAIRE
#@ACCRETIO2-ANNIVERSAIRE-0003


Feature: Anniversaire

  Scenario: Anniversaire Personnel Autorise Par RH et collaborateur

     #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

    #Etape2 : L'admin va autorisé l'affichage de l'anniversaire personnel

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Bouton_Configuration_Core"
    And wait 3000
    And l utilisateur clique sur "Bouton_Autres_Parametres"
    And wait 3000
    Then l administrateur va cocher le bouton d affichage de l anniversaire personnel
    And wait 3000
    And l utilisateur clique sur "Bouton_Autres_Parametres_Enregistrer"
    And wait 3000

    #Etape3 : Le collaborateur va se connecter et cocher le bouton d'affichage de l anniversaire personnel

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

    #Etape4 : Verifier que la date d'anniversaire personnel est affichée et qu'elle est la meme dans la gestion des employées

    Then verifier que l anniversaire est affiché dans le profil enrichi
    And l utilisateur se deconnecte
    And l'utilisateur "responsable@yopmail.com" est connecté
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"
    And l utilisateur saisit "Gaston Boutot" dans le champs "Rechercher_Employe"
    And wait 5000
    Then verifier que la date d anniversaire personnel est la meme dans la gestion du personnel
