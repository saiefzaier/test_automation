# Auteur: marwamaherssi
# Feature: Stockage
# Scénario: Verifier Config Par Filtre
# Date de création: 09/12/2019

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-STOCKAGE
#@ACCRETIO2-STOCKAGE-0003


Feature: Stockage

  Scenario: Verifier Config Par Filtre

      #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté

     #Etape2 : Accéder au paramétrages de stockage

    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Administration"
    And l utilisateur clique sur "Bouton_Paramétre_Stockage"
    And l utilisateur clique sur "Bouton_Configuration_Stockage"

     #Etape3 : Accéder au paramétrages de stockage et sélectionner les personnes concernées

    When l utilisateur clique sur "Bouton_Filtre_Stockage"
    And l utilisateur saisit "" dans le champs "filtre_stockage_nom"
    And l utilisateur selectionne la premiere personne
    And l utilisateur saisit "" dans le champs "filtre_stockage_societe"
    And l utilisateur selectionne la premiere personne
    Then verifier que les deux personnes sont encore sélectionnées

     #Etape4 : Configurer le stockage

    And l utilisateur clique sur "Bouton_Editer_Stockage_User"
    And l utilisateur selectionne "Mo" dans la liste deroulante "Unités_User"
    And l utilisateur saisit "200" dans le champs "Champ_Stockage_User"
    And l utilisateur clique sur "Bouton_Valider_Stockage_User"
    And l utilisateur clique sur "Bouton_Valider_Stockage"

     #Etape5 : Verifier que la modification du stockage a été effectué avec succés

    Then verifier que le message de succés et afficher
    When filtre de stockage est affiché
    And  l utilisateur saisit "" dans le champs "filtre_stockage_nom"
    Then verifier que la modification a été effectuée avec succées
    And l utilisateur saisit "" dans le champs "filtre_stockage_societe"
    Then verifier que la modification a été effectuée avec succées

    