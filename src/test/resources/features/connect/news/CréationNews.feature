# Auteur: wboufade
# Feature: News
# Scénario: Création nouvelle news
# Date de création: 16/09/2019


@ACCRETIO2
@ACCRETIO2-CONNECT
@ACCRETIO2-NEWS
@ACCRETIO2-NEWS-0001

Feature: News

  Scenario: Création nouvelle news
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "resp-RH@mail.com" est connecté
    When l'utilisateur clique sur espace-RH
    And l'utilisateur clique sur le module Connect
    And l'utilisateur clique sur News
    And L'utilisateur clique sur  ajouter News
    Then le modal création News s'affiche
    When L'utilisateur rempli les champs
    And L'utilisateur clique sur sauvegarder
    Then vérifier la création de la nouvelle news




