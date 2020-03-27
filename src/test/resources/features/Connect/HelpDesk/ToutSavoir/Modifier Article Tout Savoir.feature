# Auteur: marwamaherssi
# Feature: ToutSavoir
# Scénario: Modifier article tout savoir
# Date de création: 30/01/2020

#@ACCRETIO2
#@ACCRETIO2-CONNECT
#@ACCRETIO2-HelpDesk
#@ACCRETIO2-HelpDesk-ToutSavoir-0003


Feature: Tout Savoir

  Scenario: Modification d'un article tout savoir

      #Etape1 :  Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "responsable@yopmail.com" est connecté

      #Etape2 :  Ajouter article

    When l utilisateur clique sur "Bouton_HelpDesk_Portal"
    And l utilisateur clique sur "Bouton_ToutSavoir"
    And l utilisateur clique sur "Bouton_Ajouter_Article_ToutSavoir"

      #Etape3 : Remplir les champs d'un nouveau article

    When l utilisateur saisit "Article tout savoir" dans le champs "Titre_Article_ToutSavoir"
    And l utilisateur selectionne "Politique RH" dans la liste deroulante "Catégorie_Article_ToutSavoir"
    And l utilisateur saisit "C'est la description de l'article" dans le champs "Description_Article_ToutSavoir"
    And l utilisateur clique sur "Bouton_Ajout_Article_ToutSavoir"

    #Etape4 :  Vérification de la création d'un nouveau article tout savoir

    Then vérifier la création du nouveau Article Tout Savoir

    #Etape5 : Modification de l'article tout savoir

   And l utilisateur clique sur "Bouton_Titre_Premier_Article"
   And l utilisateur clique sur "Bouton_Modifier_Titre_Article"
   And l utilisateur modifie "Article tout savoir modifié" dans le champs "Titre_Article_ToutSavoir"
   And l utilisateur clique sur "Bouton_Valider_Modifier_Titre_Article"
   Then verifier que le titre a ete modifie
   And l utilisateur clique sur "Bouton_Modifier_categorie"
   And l utilisateur selectionne "Conventions" dans la liste deroulante "Catégorie_Article_ToutSavoir"
   And l utilisateur clique sur "Bouton_Valider_Modifier_Catégorie"
   Then verifier que la categorie a ete modifie
   And l utilisateur clique sur "Bouton_Modifier_Description"
   And l utilisateur modifie "C'est la description de l'article" dans le champs "Description_Article_ToutSavoir"
   And l utilisateur clique sur "Bouton_Valider_Modifier_Description"
   Then verifier que la description a ete modifie

