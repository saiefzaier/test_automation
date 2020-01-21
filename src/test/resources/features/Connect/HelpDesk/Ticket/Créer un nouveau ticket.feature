# Feature: Ticket
# Scénario: Création d'un nouveau ticket
# Date de création: 05/12/2019


#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-HelpDesk
#@ACCRETIO2-HelpDesk-Ticket
#@ACCRETIO2-HelpDesk-Ticket-0001

  Feature: Ticket

    Scenario: Création d'un nouveau ticket

    #Etape1 :  Connexion

      Given le navigateur est ouvert et la page d'acceuil est affichée
      And l'utilisateur "responsable@yopmail.com" est connecté

     #Etape2 :  Ajouter un ticket
      When l utilisateur clique sur "Bouton_HelpDesk_Portal"
      And l utilisateur clique sur "Bouton_Ticket"
      And l utilisateur clique sur "Bouton_Ajouter_Ticket"

     #Etape3 : Remplir les champs d'un nouveau ticket

      When l utilisateur saisit "Nouveau ticket" dans le champs "Titre_Ticket"
      And l utilisateur saisit "C'est la desription du nouveau ticket" dans le champs "Description_Ticket"
      And l utilisateur selectionne "Documents administratifs" dans la liste deroulante "Catégorie_Ticket"
      And l utilisateur selectionne "Mutuelle" dans la liste deroulante "Type_Catégorie_Ticket"
      And l utilisateur selectionne "Basse" dans la liste deroulante "Priorité_Ticket"
      And l utilisateur clique sur "Bouton_Ajout_Ticket"

     #Etape4 : Vérification de la création d'un nouveau ticket

      Then vérifier la création du nouveau ticket

