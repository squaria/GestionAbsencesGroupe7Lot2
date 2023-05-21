INSERT INTO LOT2_Groupe(grp_id, grp_numero, grp_capaciteMax)
VALUES (1,1,30);

INSERT INTO LOT2_Groupe(grp_id, grp_numero, grp_capaciteMax)
VALUES (2,2,35);

INSERT INTO LOT2_Groupe(grp_id, grp_numero, grp_capaciteMax)
VALUES (3,3,37);

INSERT INTO LOT2_Filiere(fil_id, fil_nom)
VALUES (1,'Classique');

INSERT INTO LOT2_Filiere(fil_id, fil_nom)
VALUES (2,'Apprentissage');

INSERT INTO LOT2_Gestionnaire(gest_id, gest_nom, gest_prenom, gest_email, gest_pwd)
VALUES (1, 'root', 'root', 'root@root.rt', 'root123');

INSERT INTO LOT2_Gestionnaire(gest_id, gest_nom, gest_prenom, gest_email, gest_pwd)
VALUES (2, 'root1', 'root', 'gi@', '23');

INSERT INTO LOT2_Professeur(prof_id, prof_nom, prof_prenom, prof_email, prof_pwd, prof_numTelephone)
VALUES (1, 'JOJO', 'Taro', 'cd@', '14', '+33 7 66 66 66 66');

INSERT INTO LOT2_Professeur(prof_id, prof_nom, prof_prenom, prof_email, prof_pwd, prof_numTelephone)
VALUES (2, 'OKI', 'Nawa', 'prof1@esig.fr', '1234', '+33 7 34 22 22 22');

INSERT INTO LOT2_Etudiant(etu_id, etu_nom, etu_prenom, etu_email, etu_pwd, etu_grp_id, etu_fil_id)
VALUES (1, 'BLABLA', 'Mowe', 'etu1@esig.fr', '4321', 1, 1);

INSERT INTO LOT2_Etudiant(etu_id, etu_nom, etu_prenom, etu_email, etu_pwd, etu_grp_id, etu_fil_id)
VALUES (2, 'DER', 'ze', 'ok@', '12', 1, 1);

INSERT INTO LOT2_Administratif(admin_id, admin_nom, admin_prenom, admin_email, admin_pwd)
VALUES (1, 'MARCHANT', 'Note', 'admin1@esig.fr', '6789');

INSERT INTO LOT2_Administratif(admin_id, admin_nom, admin_prenom, admin_email, admin_pwd)
VALUES (2, 'ft', 'ze', 'ze@', '45');

INSERT INTO LOT2_Cours(cours_id, cours_nom, cours_prof_id, cours_nbHeuresAmphi, cours_nbHeuresTD, cours_nbHeuresTP, cours_nbHeuresExamen)
VALUES (1, 'Japonais S6', 1, 1.1, 2.2, 3.3, 4.4);

INSERT INTO LOT2_Cours(cours_id, cours_nom, cours_prof_id, cours_nbHeuresAmphi, cours_nbHeuresTD, cours_nbHeuresTP, cours_nbHeuresExamen)
VALUES (2, 'testcr', 1, 1.1, 2.52, 3.33, 4.4);

INSERT INTO LOT2_Absence(abs_id, abs_date, abs_nbHeures, abs_cours_id, abs_type, abs_justificatif, abs_valideeAdmin)
VALUES (1, '10/10/2019', 3.5, 1, 'Classique', '', '');

INSERT INTO LOT2_Absence(abs_id, abs_date, abs_nbHeures, abs_cours_id, abs_type, abs_justificatif, abs_valideeAdmin)
VALUES (2, '12/10/2019', 1.5, 1, 'Physique', '', '');

INSERT INTO LOT2_Absence(abs_id, abs_date, abs_nbHeures, abs_cours_id, abs_type, abs_justificatif, abs_valideeAdmin)
VALUES (3, '01/04/2023', 2, 1, 'Professeur', '', '');

INSERT INTO LOT2_Absence(abs_id, abs_date, abs_nbHeures, abs_cours_id, abs_type, abs_justificatif, abs_valideeAdmin)
VALUES (4, '07/03/2018', 4, 1, 'Physique', '', '');

INSERT INTO LOT2_Absence(abs_id, abs_date, abs_nbHeures, abs_cours_id, abs_type, abs_justificatif, abs_valideeAdmin)
VALUES (5, '03/11/2020', 2.75, 2, 'Classique', '', '');


INSERT INTO LOT2_AbsenceParEtudiant(abs_id, etu_id)
VALUES (1, 2);

INSERT INTO LOT2_AbsenceParEtudiant(abs_id, etu_id)
VALUES (2, 1);

INSERT INTO LOT2_AbsenceParEtudiant(abs_id, etu_id)
VALUES (5, 1);

INSERT INTO LOT2_AbsenceParEtudiant(abs_id, etu_id)
VALUES (4, 2);

INSERT INTO LOT2_AbsenceParEnseignant(abs_id, prof_id) 
VALUES (3, 1);

INSERT INTO LOT2_AbsencePhysique(absPhys_id, absPhys_dateDebut, absPhys_dateFin, absPhys_justificatif, absPhys_valideeAdmin)
VALUES (1, '03/11/2022', '03/07/2023', '', '');

INSERT INTO LOT2_AbsencePhysiqueParEtudiant(absPhys_id, etu_id)
VALUES (1, 1);

INSERT INTO LOT2_PlanningGroupe(cours_id, grp_id, plan_date, plan_heureDebut, plan_heureFin, plan_lienVisio)
VALUES (1, 1, '01/04/2023', 8.5, 10.5, '');

INSERT INTO LOT2_PlanningGroupe(cours_id, grp_id, plan_date, plan_heureDebut, plan_heureFin, plan_lienVisio)
VALUES (2, 1, '07/12/2022', 8.5, 10.5, '');

INSERT INTO LOT2_PlanningGroupe(cours_id, grp_id, plan_date, plan_heureDebut, plan_heureFin, plan_lienVisio)
VALUES (1, 2, '08/12/2022', 12.5, 13.5, '');

INSERT INTO LOT2_PlanningGroupe(cours_id, grp_id, plan_date, plan_heureDebut, plan_heureFin, plan_lienVisio)
VALUES (1, 3, '10/12/2022', 15.5, 16.5, '');

SELECT *
FROM Lot2_Cours;

SELECT *
FROM Lot2_Professeur
ORDER BY prof_id ASC;

SELECT *
FROM Lot2_Groupe;

SELECT *
FROM Lot2_Absence;

SELECT *
FROM Lot2_Etudiant;

SELECT *
FROM Lot2_Note;

SELECT *
FROM Lot2_AbsenceParEtudiant;


SELECT *
FROM Lot2_AbsencePhysique;

SELECT *
FROM Lot2_AbsencePhysiqueParEtudiant;

/* 0 : etu, 1 : prof, 2: admin, 3: gest */

/* https://test.ok */