# Auteur: Ons MANSOURI
# Feature: Recrutement
# Scénario: Demande de recrutement par Manager avec rejet Sup N+1
# Date de création: 11/11/2019


#@ACCRETIO2
#@ACCRETIO2-TALENT
#@ACCRETIO2-RECRUTEMENT
#@ACCRETIO2-RECRUTEMENT-0002

  Feature: Recrutement

   Scenario: Demande de recrutement par manager avec rejet Sup N+1

     #Etape 001: Connexion manager
    Given   le navigateur est ouvert et la page d'acceuil est affichée
      And   l'utilisateur "Leblanc.Matt@YOPMAIL.COM" est connecté
     Then   le nom de l utilisateur "Matt Leblanc" est affiche en haut a gauche

     #Etape 002: Acceder  a la page Demandes de recrutement espace manager
     When   l utilisateur clique sur "Mon_Equipe"
      And   wait 2000
     When   l utilisateur clique sur "Demande_De_Recrutement"
      And   wait 2000

     #Etape 003: Lancer la demande de recrutement par le manager

        #Bouton ajouter une demande en haut a gauche#
     When   l utilisateur clique sur "Ajout_Demande_rec_mgr"
      And   wait 2000
      And   l utilisateur saisit "Test automatique 1" dans le champs "Intitule_dmd_rec_mgr"
      And   l utilisateur saisit "2" dans le champs "Effectif_a_couvrir_dmd_rec_mgr"
      And   l utilisateur selectionne "Interne" dans la liste deroulante "Cible_dmd_rec_mgr"
      And   l utilisateur selectionne "Externe" dans la liste deroulante "Cible_dmd_rec_mgr"
      And   l utilisateur selectionne "Paris" dans la liste deroulante "Lieu_dmd_rec_mgr"
      And   l utilisateur selectionne "CDI" dans la liste deroulante "Contrat_dmd_rec_mgr"
      And   l utilisateur selectionne "DFG_Ingénieur" dans la liste deroulante "Emploi_associe_dmd_rec_mgr"
      And   l utilisateur selectionne "DFG_Responsable unité de production" dans la liste deroulante "Poste_associe dmd_rec_mgr"
      And   l utilisateur saisit "Mission Test automatique 1" dans le champs "Mission_dmd_rec_mgr"
      And   l utilisateur saisit "Profil Test automatique 1" dans le champs "Profil_Atouts_dmd_rec_mgr"
      And   l utilisateur saisit "Justification Test automatique 1" dans le champs "Justification_dmd_rec_mgr"

      And   le manager clique pour ajouter_des_fichiers_demande_rec

      And   l utilisateur selectionne "Euro" dans la liste deroulante "Devise_dmd_rec_mgr"
      And   l utilisateur saisit "2000" dans le champs "Salaire_dmd_rec_mgr"
     Then   verifier que le salaire_annuel_demande_rec est 2000
     When   l utilisateur saisit "1000" dans le champs "Bonus_dmd_rec_mgr"
     Then   verifier que le salaire annuel_demande_rec est 22000
     When   l utilisateur saisit "1500" dans le champs "Autres_dmd_rec_mgr"
     Then   verifier que le salaire annuel_demande_rec est 23500
     When   l utilisateur clique sur "Budgetise_dmd_rec_mgr"
      And   l utilisateur saisit "24000" dans le champs "Budget_dmd_rec_mgr"
     Then   verifier que le montant_demande_rec 500 s affiche a droite
     When   l utilisateur clique sur "Envoyer_dmd_rec_mgr"
      And   wait 2000

     #Etape 004: Verification de la demande lancee par le manager par lui meme

        #Verification des champs dans la liste affichee dans le sous module#
     Then   verifier que le premier libelle_demandes_rec_mgr "Test automatique 1"
      And   verifier que la premiere date de creation_demandes_rec_mgr aujourd hui
      And   verifier que le premier status_demandes_rec_mgr 'Orange' et l intitule "En cours"
      And   verifier que la premiere ligne de l effectif a couvrir_demandes_rec_mgr 2
      And   verifier que le premier lieu_demandes_rec_mgr est "Paris"
      And   verifier que la premiere ligne de publiee_demandes_rec_mgr n est pas cochee

        #Verification des champs dans le modal voir historique : bouton fleche dans la colonne Actions#
     When   l utilisateur clique sur "Voir_historique_dmd_rec_mgr"
     Then   verifier que l initiateur_voir_hist_mgr "Matt Leblanc"
      And   verifier que la date de debut_voir_hist_mgr aujourd hui
      And   verifier que le premier validateur_voir_hist_mgr "Raphaëlle Bruneau"
      And   verifier que la premiere date de debut_voir_hist_mgr aujourd hui
      And   verifier que la premiere date de fin_voir_hist_mgr vide
      And   verifier que la premiere decision_voir_hist_mgr vide
      And   verifier que le premier commentaire_voir_hist_mgr vide
     When   l utilisateur clique sur "Fermer_voir_hist_dmd_rec_mgr"

     #Etape 005: Deconnexion
      And   l utilisateur se deconnecte

     #Etape 006: Connexion avec le profil RH
     When   l'utilisateur "Dupont.Cedric@yopmail.com" est connecté
     Then   le nom de l utilisateur "Cédric Dupont" est affiche en haut a gauche

     #Etape 007: Acceder au menu recrutement par le profil RH
     When   l'utilisateur clique sur espace-RH
      And   l utilisateur clique sur "Bouton_menu_etendu"
      And   l utilisateur clique sur "Module_Talent"
      And   l utilisateur clique sur "Sous_module_Recrutement"

     #Etape 008: Verification de la demande de recrutement du manager par le profil RH

        #Verification des champs dans la liste affichee dans le sous module#
     Then   verifier que le premier libelle_offres_rec_HR "Test automatique 1"
      And   verifier que la premiere date de creation_offres_rec_HR aujourd hui
      And   verifier que le premier status_offres_rec_HR 'Orange' et l intitule "En cours"
      And   verifier que le premier initiateur_offres_rec_HR "Matt Leblanc"
      And   verifier que le premier responsable de recrutement_offres_rec_HR vide
      And   verifier que la premiere ligne de candidature_offres_rec_HR 0
      And   verifier que la premiere ligne de l effectif a couvrir_offres_rec_HR 2
      And   verifier que le premier lieu_offres_rec_HR "Paris"
      And   verifier que la premiere ligne de publiee_offres_rec_HR n est pas cochee

        #Verification des champs dans la liste voir historique : bouton fleche dans la colonne Actions#
     When   l utilisateur clique sur "Voir_historique_dmd_rec_HR"
     Then   verifier que l initiateur_voir_hist_HR "Matt Leblanc"
      And   verifier que la date de debut_voir_hist_HR aujourd hui
      And   verifier que le premier validateur_voir_hist_HR "Raphaëlle Bruneau"
      And   verifier que la premiere date de debut_voir_hist_HR aujourd hui
      And   verifier que la premiere date de fin_voir_hist_HR vide
      And   verifier que la premiere decision_voir_hist_HR vide
      And   verifier que le premier commentaire_voir_hist_HR vide
     When   l utilisateur clique sur "Fermer_voir_hist_dmd_rec_HR"

     #Etape 009: Deconnexion
      And   l utilisateur se deconnecte

     #Etape 010: Connexion avec le profil N+1 du manager
     When   l'utilisateur "Bruneau.Raphaelle@yopmail.com" est connecté
     Then   le nom de l utilisateur "Raphaëlle Bruneau" est affiche en haut a gauche

     #Etape 011: Acceder au menu recrutement avec le profil N+1
     When   l utilisateur clique sur "Icone_notifications"
      And   le superieur clique sur la notification de validation_demande_rec

     #Etape 012: Verification de la demande de recrutement par N+1
      And   l utilisateur clique sur "A_valider_liste_dmd_rec_mgr"
      And   wait 2000
     Then   verifier que le premier libelle_valid_rec_sup "Test automatique 1"
      And   verifier que la premiere date de creation_valid_rec_sup aujourd hui
      And   verifier que le premier status_valid_rec_sup 'Orange' et l intitule "En cours"
      And   verifier que la premiere ligne de l effectif a couvrir_valid_rec_sup "2"
      And   verifier que le premier lieu_valid_rec_sup "Paris"

        #Verification des champs dans la liste voir historique pour N+1 : bouton fleche dans la colonne Actions#
     When   l utilisateur clique sur "Voir_historique_dmd_rec_sup"
     Then   verifier que l initiateur_voir_hist_sup "Matt Leblanc"
      And   verifier que la date de debut_voir_hist_sup aujourd hui
      And   verifier que le premier validateur_voir_hist_sup "Raphaëlle Bruneau"
      And   verifier que la premiere date de debut_voir_hist_sup aujourd hui
      And   verifier que la premiere date de fin_voir_hist_sup vide
      And   verifier que la premiere decision_voir_hist_sup vide
      And   verifier que le premier commentaire_voir_hist_sup vide
     When   l utilisateur clique sur "Fermer_hist_dmd_rec_sup"

        #Verification des champs dans le modal visualiser le resultat : bouton stylo dans la colonne Actions#
      And   l utilisateur clique sur "Resultat_Validation_dmd_rec_sup"
     Then   verifier que l intitule_rec_valid_sup "Test automatique 1"
      And   verifier que l effectif a couvrir_rec_valid_sup 2
      And   verifier que la cible_rec_valid_sup "Interne" et "Externe"
      And   verifier que le contrat_rec_valid_sup "CDI"
      And   verifier que l emploi associe_rec_valid_sup "DFG_Ingénieur"
      And   verifier que le poste associe_rec_valid_sup "DFG_Responsable unité de production"
      And   verifier que le champs mission_rec_valid_sup "Mission Test automatique"
      And   verifier que le champs profil atouts_rec_valid_sup "Profil Test automatique"
      And   verifier que le champs justification de la demande_rec_valid_sup "Justification Test automatique"
      And   verifier que la devise_rec_valid_sup "Euro"
      And   verifier que le champs salaire_rec_valid_sup 2000
      And   verifier que le champs bonus_rec_valid_sup 1000
      And   verifier que le champs autres_rec_valid_sup 1500
      And   verifier que le salaire annuel_rec_valid_sup 23500
      And   verifier que la case budgetise_rec_valid_sup coche
      And   verifier que le budget_rec_valid_sup 24000
      And   verifier que le montant_rec_valid_sup 500 s affiche a droite

     #Etape 013: Rejet de la demande de recrutement par N+1
     When   l utilisateur saisit "Rejet N+1" dans le champs "Commentaire_dmd_rec_sup"
      And   l utilisateur selectionne "Rejeter_dmd_rec_sup" dans la liste deroulante "Validation_dmd_rec_sup"
      And   l utilisateur clique sur "Envoyer_dmd_rec_sup"
      And   l utilisateur clique sur "Valider_pop_up_rec_rej_mgr"
      And   wait 2000
     Then   verifier que le permier libelle_valid_rec_sup n est pas "Test automatique 1"

     #Etape 014: Deconnexion
     When   l utilisateur se deconnecte

     #Etape 015: Connexion avec le profil RH
      And   l'utilisateur "Dupont.Cedric@yopmail.com" est connecté
     Then   le nom de l utilisateur "Cédric Dupont" est affiche en haut a gauche

     #Etape 016: Acceder au menu recrutement par le profil RH
     When   l'utilisateur clique sur espace-RH
      And   l utilisateur clique sur "Bouton_menu_etendu"
      And   l utilisateur clique sur "Module_Talent"
      And   l utilisateur clique sur "Sous_module_Recrutement"

     #Etape 017: Verification de la demande de recrutement par le role RH
     Then   verifier que le premier libelle_offres_rec_HR "Test automatique 1"
      And   verifier que la premiere date de creation_offres_rec_HR aujourd hui
      And   verifier que le premier status_offres_rec_HR 'rouge' et l intitule "Rejetée"
      And   verifier que le premier initiateur_offres_rec_HR "Matt Leblanc"
      And   verifier que le premier responsable de recrutement_offres_rec_HR vide
      And   verifier que la premiere ligne de candidature_offres_rec_HR "0"
      And   verifier que la premiere ligne de l effectif a couvrir_offres_rec_HR "2"
      And   verifier que le premier lieu_offres_rec_HR "Paris"
      And   verifier que la premiere ligne de publiee_offres_rec_HR n est pas cochee

         #Verification des champs dans la liste voir historique : bouton fleche dans la colonne Actions#
     When   l utilisateur clique sur "Voir_historique_dmd_rec_HR"
     Then   verifier que l initiateur_voir_hist_HR "Matt Leblanc"
      And   verifier que la date de debut_voir_hist_HR aujourd hui
      And   verifier que le premier validateur_voir_hist_HR "Raphaëlle Bruneau"
      And   verifier que la premiere date de debut_voir_hist_HR aujourd hui
      And   verifier que la premiere date de fin_voir_hist_HR aujourd hui
      And   verifier que la premiere decision_voir_hist_HR "Rejetée" et la couleur est rouge
      And   verifier que le premier commentaire_voir_hist_HR "Rejet N+1"
      And   verifier qu il n y pas de second validateur_voir_hist_HR
     When   l utilisateur clique sur "Fermer_voir_hist_dmd_rec_HR"

     #Etape 018: Deconnexion
      And   l utilisateur se deconnecte

     #Etape 019: Connexion avec le profil manager
     When   l'utilisateur "Leblanc.Matt@yopmail.com" est connecté
     Then   le nom de l utilisateur "Matt Leblanc" est affiche en haut a gauche

     #Etape 020: Verification de la reception de la notification de rejet RH par le manager
     When   l utilisateur clique sur "Icone_notifications"
      And   l utilisateur clique sur la notification de rejet de la demande de recrutement
     Then   verifier que le premier libelle dans la liste "Test automatique"
      And   verifier que la premiere date de creation dans la liste aujourd hui
      And   verifier que le premier status dans la liste 'rouge' et l intitule "Rejetée"
      And   verifier que la premiere ligne de l effectif a couvrir dans la liste "2"
      And   verifier que le premier lieu dans la liste est "Paris"
      And   verifier que la premiere ligne de publiee n est pas cochee

        #Verification des champs dans le modal voir historique : bouton fleche dans la colonne Actions#
     When   l utilisateur clique sur "Voir_historique_dmd_rec_mgr"
     Then   verifier que l initiateur_voir_hist_mgr "Matt Leblanc"
      And   verifier que la date de debut_voir_hist_mgr aujourd hui
      And   verifier que la date de fin_voir_hist_mgr aujourd hui
      And   verifier que le premier validateur_voir_hist_mgr "Raphaëlle Bruneau"
      And   verifier que la premiere date de debut_voir_hist_mgr aujourd hui
      And   verifier que la premiere date de fin_voir_hist_mgr aujourd hui
      And   verifier que la premiere decision_voir_hist_mgr "Rejetée" et la couleur est rouge
      And   verifier que le premier commentaire_voir_hist_mgr "Rejet N+1"
      And   verifier qu il n y pas de second validateur_voir_hist_mgr
     When   l utilisateur clique sur "Fermer_voir_hist_dmd_rec_mgr"
