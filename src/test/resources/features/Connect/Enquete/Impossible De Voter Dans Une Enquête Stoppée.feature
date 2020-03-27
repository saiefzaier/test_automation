# Auteur: marwamaherssi
# Feature: Enquête
# Scénario: Impossible de voter dans une enquête stoppée , un message d'erreur doit s'afficher
# Date de création: 10/01/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-ENQUETE
#@ACCRETIO2-ENQUETE-0010


Feature: Enquete

  Scenario: Voter enquete

 #Etape1 : Se connecter au TNR

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté
