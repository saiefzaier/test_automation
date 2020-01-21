# Auteur: syrineLakhdhar
# Feature: ToutSavoir
# Scénario: Création d'un nouveau article
# Date de création: 05/12/2019


#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-HelpDesk
#@ACCRETIO2-HelpDesk-ToutSavoir
#@ACCRETIO2-HelpDesk-ToutSavoir-0001


  Feature: Tout Savoir

    Scenario: Création d'un nouveau article

      #Etape1 :  Connexion

      Given le navigateur est ouvert et la page d'acceuil est affichée
      And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape2 :  Ajouter article

      When l utilisateur clique sur "Bouton_HelpDesk_Portal"
      And l utilisateur clique sur "Bouton_ToutSavoir"
      And l utilisateur clique sur "Bouton_Ajouter_Article_ToutSavoir"

      #Etape3 : Remplir les champs d'un nouveau article

      When l utilisateur saisit "Nouveau article tout savoir" dans le champs "Titre_Article_ToutSavoir"
      And l utilisateur selectionne "Politique RH " dans la liste deroulante "Catégorie_Article_ToutSavoir"
      And l utilisateur saisit "C'est la description de l'article" dans le champs "Description_Article_ToutSavoir"
      And l utilisateur clique sur "Bouton_Ajout_Article_ToutSavoir"

      #Etape4 :  Vérification de la création d'un nouveau article tout savoir

      Then vérifier la création du nouveau Article Tout Savoir
