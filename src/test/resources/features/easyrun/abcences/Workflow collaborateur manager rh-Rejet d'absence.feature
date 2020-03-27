# Auteur: Manel Hachicha
# Feature: Workflow collaborateur manager rh-Rejet d'une demande d'absence
# Scénario: Rejet d'une demande d'absence au workflow collaborateur manager rh
# Date de création: 01/11/2019


@ACCRETIO2
@ACCRETIO2-EASYRUN
@ACCRETIO2-ABSENCES
@ACCRETIO2-ABSENCES-0006

Feature: Absences

  Scenario: Rejet d'une demande d'absence au workflow collaborateur manager rh
    Given le navigateur est ouvert et la page d'acceuil est affichée
   #Etape 1 : Ajout de cycle de travail qui considére que les samedi et dimanche ne sont pas travaillés
    And l'utilisateur "duval.jules@yopmail.com" est connecté
    When l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Administration"
    And l utilisateur clique sur "Sous_Module_Gestion_des_calendriers"
    And l utilisateur clique sur "Onglet_Jours_fériés"
    And l utilisateur clique sur "Bouton_Ajouter_Calendrier"
    And l utilisateur saisit "CAtype" dans le champs "Code_Ajout_Calendrier"
    And l utilisateur saisit "CAtype" dans le champs "Libellé_Ajout_Calendrier"
    And l utilisateur clique sur "Bouton_Valider_Ajout_Calendrier"
    And l utilisateur clique sur "Bouton_Affectation_Population_Calendrier"
    And l utilisateur clique sur "Bouton_Ajout_Affectation_Population_Calendrier"
    And l utilisateur saisit "01/01/2020" dans le champs "Date_d_effet_Affectation_Population_Calendrier"
    And l utilisateur selectionne la population "Cosette Berger" dans la liste des populations "Population_Affectation_Population_Calendrier"
    And l utilisateur clique sur "Valider_Affectation_Population_Calendrier"
    And l utilisateur clique sur "Onglet_Journée_type"
    And l utilisateur clique sur "Bouton_Ajouter_Journée_type"
    And l utilisateur saisit "Jtype" dans le champs "Code_Ajout_Journée_type"
    And l utilisateur saisit "Jtype" dans le champs "Libellé_Ajout_Journée_type"
    And l utilisateur selectionne "Durée" dans la liste deroulante "Type_Ajout_Journée_type"
    And l utilisateur saisit "08" dans le champs "Nombre_Heures_Ajout_Journée_Type"
    And l utilisateur saisit "00" dans le champs "Nombre_Minutes_Ajout_Journée_Type"
    And l'utilisateur vérifie que le statut de la journée type est Actif
    And l utilisateur clique sur "Bouton_Valider_Ajout_Journée_type"
    And l utilisateur clique sur "Onglet_Semaine_type"
    And l utilisateur clique sur "Bouton_Ajouter_Semaine_type"
    And l utilisateur saisit "Stype" dans le champs "Code_Ajout_Semaine_type"
    And l utilisateur saisit "Stype" dans le champs "Libellé_Ajout_Semaine_type"
   #Sélection des jours de repos
    And l utilisateur clique sur "Case_Samedi_Ajout_Semaine_Type"
    And l utilisateur clique sur "Case_Dimanche_Ajout_Semaine_Type"
    And l utilisateur selectionne "Samedi" dans la liste deroulante "Jour_ouvrable_Ajout_Semaine_Type"
    And l utilisateur clique sur "Bouton_Valider_Ajout_Semaine_type"
    And l utilisateur clique sur "Onglet_Cycles_de_travail"
    And l utilisateur clique sur "Bouton_Ajouter_Cycles_de_travail"
    And l utilisateur saisit "CType" dans le champs "Code_Ajout_Cycle_de_travail"
    And l utilisateur saisit "Ctype" dans le champs "Libellé_Ajout_Cycle_de_travail"
    And l'utilisateur vérifie que le statut du cycle de travail est Actif
    And l utilisateur selectionne "Stype" dans la liste "Semaines_types_Ajout_Cycle_de_travail"
    And l utilisateur clique sur "Bouton_Valider_Ajout_Cycle_de_travail"
    And l utilisateur clique sur "Bouton_Affectation_Population_Cycles_de_travail"
    And l utilisateur clique sur "Bouton_Ajout_Affectation_Population_Cycle_de_travail"
    And l utilisateur saisit "01/12/2019" dans le champs "Date_d_effet_Affectation_Population_Cycle_de_travail"
    And l utilisateur selectionne "Stype" dans la liste deroulante "Premiere_semaine_Affectation_Popultaion_Cycle_de_travail"
    And l utilisateur selectionne la population "Cosette Berger" dans la liste des populations "Population_Affectation_Population_Cycle_de_travail"
    And l utilisateur clique sur "Valider_Affectation_Population_Cycle_de_travail"

    #Etape 2 : Profil Rh-Paramétrage de configuration

    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Absences"
    And l utilisateur clique sur "Onglet_Paramétrage"
    And l utilisateur clique sur "Rubrique_Configuration"
    And l utilisateur vérifie que "Champ_Demande_d_absence_par_le_manager" a la valeur "Oui"
    And l utilisateur vérifie que "Champ_Le_backup_est_obligatoire" a la valeur "Non"
    And l utilisateur vérifie que "Champ_Ajout_du_champs_backup" a la valeur "Non"
    And l utilisateur vérifie que "Champ_Affichage_de_tous_les_managers" a la valeur "Oui"
    And l utilisateur vérifie que "Champ_Validation de la demande d'absence par la RH" a la valeur "Oui"

      #Etape 3 : Profil Rh-Création de règle d'acquisition

    And l utilisateur clique sur "Rubrique_Règles_d_acqusition"
    And l utilisateur clique sur "Ajouter_Règle_d_aquisition"
    And l utilisateur saisit "CP" dans le champs "Code_Ajout_Règle_d_aquisition"
    And l utilisateur saisit "Congé Payé" dans le champs "Libellé_Ajout_Règle_d_aquisition"
    And l utilisateur selectionne "Jour" dans la liste deroulante "Type_Ajout_Règle_Unité_d_acquisition"
    And l utilisateur clique sur "Jour_Debut_Ajout_Regle_d_aquisition"
    And l utilisateur selectionne "01" dans la liste "Début_d_acquisition_Jour_Ajout_Règle"
    And l utilisateur clique sur "Mois_Debut_Ajout_Regle_d_aquisition"
    And l utilisateur selectionne "01" dans la liste "Début_d_acquisition_Mois_Ajout_Règle"
    And l utilisateur saisit "1" dans le champs "Durée_d_acquisition_Année_Ajout_Règle"
    And l utilisateur saisit "12" dans le champs "Durée_d_acquisition_Mois_Ajout_Règle"
    And l utilisateur selectionne "Mensuel" dans la liste deroulante "Type_d_acquisition_Ajout_Règle"
    And l utilisateur saisit "22" dans le champs "Acquis_de_base_Ajout_Règle"
    And l utilisateur saisit "1" dans le champs "Unité_de_décrémentation_Ajout_Règle"
    And l utilisateur selectionne "Fin de période" dans la liste deroulante "Mise_à_disposition_Ajout_Règle"
    And l utilisateur saisit "0" dans le champs "Première_consommation_après_mois_Ajout_Règle"
    And l utilisateur selectionne "à 0,01 près" dans la liste deroulante "Voisinage_Ajout_Règle"
    And l utilisateur selectionne "La plus proche" dans la liste deroulante "Valeur_Ajout_Règle"
    And l utilisateur clique sur "Bouton_Valider_Ajout_Règle"
    And vérifier que le message "Opération effectuée avec succès" s affiche

    #Etape 4 : Profil Rh-Création du motif d'absence renfermant le processus de validation "Validation N+1 et Rh" selectionné au niveau du motif d'absence

    And l utilisateur clique sur "Rubrique_Motifs_absence"
    And l utilisateur clique sur "Ajouter_motif"
    And l utilisateur saisit "CPW2" dans le champs "Code_Ajout_Motif_Abcences"
    And l utilisateur saisit "Congés Payés Workflow2" dans le champs "Libellé_Ajout_Motif_Abcences"
    And l utilisateur selectionne "Règle" dans la liste deroulante "Type_Ajout_Motif_Abcences"
    And l utilisateur selectionne "Role utilisateur" dans la liste deroulante "Utilisé_par_Ajout_Motif_Abcences"
    And l utilisateur selectionne "Groupement par défaut" dans la liste deroulante "Groupement_de_motifs_Ajout_Motif_Abcences"
    And l utilisateur selectionne "Validation N+1 et Rh" dans la liste deroulante "Processus_de_validation_Ajout_Motif_Abcences"
     # Case Visible à cocher
    #And l utilisateur clique sur "Case_Visible"
    And l utilisateur clique sur "Bouton_Ajouter_Motif_Abcences"
    And l utilisateur clique sur "Bouton_Affectation_Population"
    And l utilisateur clique sur "Bouton_Ajout_Affectation_Population_Motif_Abcence"
    And l utilisateur saisit "01/11/2019" dans le champs "Date_d_effet_Affectation_Population_Motif_Abcence"
    And l utilisateur selectionne "Cosette Berger" dans la liste deroulante "Population_Affectation_Population_Motif_Abcence"
    And l utilisateur selectionne "Congé Payé" dans la liste deroulante "Règle_Affectation_Population_Motif_Abcence"
    And l utilisateur selectionne "Jours ouvrés" dans la liste deroulante "Type_du_calendrier_Affectation_Population_Motif_Abcence"
    And l utilisateur clique sur "Bouton_Valider_affectation"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And l utilisateur se deconnecte

    #Etape 5 : Profil collaborateur-Ajout de demande d'absence
    And l'utilisateur "berger.cosette@yopmail.com" est connecté
    And l utilisateur clique sur "Bouton_Mes_Absences"
    # Cliquer sur une journée libre représentée par une case blanche au niveau du calendrier
    And l utilisateur selectionne une case de journée libre dans le calendrier
    And l utilisateur selectionne "Congés Payés Workflow2" dans la liste deroulante "Motif_d_absence_Ajout_Demande_Absence_Collaborateur"
    # And l utilisateur selectionne "Mehrez Somrani" dans la liste deroulante "Backup_Ajout_Demande_Absence_Collaborateur"
    And l'utilisateur upload un justificatif
    And l utilisateur clique sur "Bouton_Envoyer_Ajout_Demande_Absence_Collaborateur"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And vérifier que le statut de la demande devient En cours
    And l utilisateur se deconnecte

    #Etape 6 : Profil manager-Validation de demande d'absence
    And l'utilisateur "marcil.valentine@yopmail.com" est connecté
    And l utilisateur clique sur "Mon_Equipe"
    And l utilisateur clique sur "Bouton_Absences"
    And l utilisateur clique sur "Bouton_Accepter_Demande_Absence_Manager"
    And vérifier que le titre du modal est "Confirmation de la validation" et le texte du corps du modal est "Voulez vous vraiment valider cette demande ?"
    And l utilisateur clique sur "JS_Bouton_Valider_Acceptation"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And l utilisateur se deconnecte

    #Etape 7 : Profil rh-Rejet de demande d'absence
    And l'utilisateur "duval.jules@yopmail.com" est connecté
    And l utilisateur clique sur "Bouton_Role_RH"
    And l utilisateur clique sur "Bouton_Menu_Etendu"
    And l utilisateur clique sur "Module_Easyrun"
    And l utilisateur clique sur "Sous_Module_Absences"
    And l utilisateur clique sur "Onglet_Suivi des absences"
    And l utilisateur clique sur "Référence_Absence"
    And l utilisateur clique sur "Bouton_Rejeter_Demande_Absence"
    And la fenêtre de confirmation de rejet de la demande d'absence s'affiche à l'écran
    And l utilisateur saisit "Rejet" dans le champs "Commentaire"
    And l utilisateur clique sur "Bouton_Valider_rejet"
    And vérifier que le message "Opération effectuée avec succès" s affiche
    And Vérifier que la demande d'absence est déplacée au niveau de la rubrique Historique et que son statut devient Rejetée
    And l utilisateur se deconnecte

   #Etape 8 : Profil collaborateur-Vérification du rejet de la demande d'absence
    And l'utilisateur "berger.cosette@yopmail.com" est connecté
    Then Vérifier que l utilisateur reçoit une notification "Votre demande d'absence a été rejetée" et que le statut de la demande d absence devient Rejetée et que la demande d absence ne s affiche pas dans le calendrier

