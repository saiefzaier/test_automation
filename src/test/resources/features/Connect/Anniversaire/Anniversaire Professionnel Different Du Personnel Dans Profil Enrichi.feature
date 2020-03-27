# Auteur: marwamaherssi
# Feature: Anniversaire
# Scénario: Anniversaire Professionnel Different Du Personnel Dans Profil Enrichi
# Date de création: 05/02/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-ANNIVERSAIRE
#@ACCRETIO2-ANNIVERSAIRE-0004


Feature: Anniversaire

  Scenario: Anniversaire Professionel Different Du Personnel Dans Profil Enrichi

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
    Then l administrateur va cocher le bouton d affichage de l anniversaire professionnel
    And wait 3000
    And l utilisateur clique sur "Bouton_Autres_Parametres_Enregistrer"
    And wait 3000

    #Etape3 : Verifier que l'anniversaire professionnel est le meme dans la gestion du personnel

    When l utilisateur clique sur "Bouton_Menu_Etendu"
    And wait 3000
    And l utilisateur clique sur "Core_RH"
    And l utilisateur clique sur "Gestion_du_personnel"
    And wait 3000
    And l utilisateur saisit "Gaston Boutot" dans le champs "Rechercher_Employe"
    And l utilisateur clique sur "Dossier_administratif_collaborateur"
    And l utilisateur verifie la date d'anniversaire professionnel

   #Etape4 :  # Le collaborateur va se connecter et verifier que les deux anniversaires affichés sont differents

    And l utilisateur se deconnecte
    And l'utilisateur "gaston.boutot@yopmail.com" est connecté
    And l utilisateur clique sur "Icone_Nom_Utilisateur"
    And wait 3000
    Then verifier que la date danniversaire professionnel est la meme
