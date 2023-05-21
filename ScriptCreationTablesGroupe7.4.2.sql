DROP TABLE Lot2_Note;
DROP TABLE Lot2_PlanningGroupe;
DROP TABLE Lot2_AbsenceParEnseignant;
DROP TABLE Lot2_AbsenceParEtudiant;
DROP TABLE Lot2_AbsencePhysiqueParEtudiant;
DROP TABLE Lot2_AbsencePhysique;
DROP TABLE Lot2_Absence;
DROP TABLE Lot2_Cours;
DROP TABLE Lot2_Etudiant;
DROP TABLE Lot2_Gestionnaire;
DROP TABLE Lot2_Administratif;
DROP TABLE Lot2_Professeur;
DROP TABLE Lot2_Filiere;
DROP TABLE Lot2_Groupe;

CREATE TABLE Lot2_Groupe ( 
    grp_id INTEGER PRIMARY KEY, 
    grp_numero INTEGER NOT NULL UNIQUE,
	grp_capaciteMax INTEGER NOT NULL
);

CREATE TABLE Lot2_Filiere ( 
    fil_id INTEGER PRIMARY KEY, 
    fil_nom VARCHAR2(30) NOT NULL UNIQUE
);

CREATE TABLE Lot2_Professeur ( 
    prof_id INTEGER PRIMARY KEY, 
    prof_nom VARCHAR2(30) NOT NULL, 
    prof_prenom VARCHAR2(30) NOT NULL, 
    prof_pwd VARCHAR2(50) NOT NULL, 
	prof_email VARCHAR2(50) NOT NULL,
    prof_numTelephone VARCHAR2(30) NOT NULL, 
	CONSTRAINT UN_prof1 UNIQUE(prof_nom, prof_prenom, prof_numTelephone, prof_email)
); 

CREATE TABLE Lot2_Administratif ( 
    admin_id INTEGER PRIMARY KEY, 
    admin_nom VARCHAR2(30) NOT NULL, 
    admin_prenom VARCHAR2(30) NOT NULL, 
    admin_pwd VARCHAR2(50) NOT NULL, 
    admin_email VARCHAR2(50) NOT NULL,
	CONSTRAINT UN_admin1 UNIQUE(admin_nom, admin_prenom, admin_email)
); 

CREATE TABLE Lot2_Gestionnaire ( 
    gest_id INTEGER PRIMARY KEY, 
    gest_nom VARCHAR2(30) NOT NULL, 
    gest_prenom VARCHAR2(30) NOT NULL, 
    gest_pwd VARCHAR2(50) NOT NULL, 
    gest_email VARCHAR2(50) NOT NULL,
	CONSTRAINT UN_gest1 UNIQUE(gest_nom, gest_prenom, gest_email)
); 

CREATE TABLE Lot2_Etudiant (
    etu_id INTEGER PRIMARY KEY,
    etu_nom VARCHAR2(30) NOT NULL,
    etu_prenom VARCHAR2(30) NOT NULL,
    etu_pwd VARCHAR2(50) NOT NULL,
    etu_email VARCHAR2(50) NOT NULL,
	etu_grp_id INTEGER NOT NULL,
	etu_fil_id INTEGER NOT NULL,
	CONSTRAINT FK_etu_grp_id FOREIGN KEY (etu_grp_id) REFERENCES Lot2_Groupe(grp_id) ON DELETE SET NULL,
	CONSTRAINT FK_etu_fil_id FOREIGN KEY (etu_fil_id) REFERENCES Lot2_Filiere(fil_id) ON DELETE SET NULL,
	CONSTRAINT UN_etu1 UNIQUE(etu_nom, etu_prenom, etu_email)
); 



CREATE TABLE Lot2_Cours ( 
    cours_id INTEGER PRIMARY KEY, 
    cours_nom VARCHAR2(30) NOT NULL, 
    cours_prof_id INTEGER NOT NULL,
	cours_nbHeuresAmphi FLOAT, 
	cours_nbHeuresTD FLOAT, 
	cours_nbHeuresTP FLOAT, 
	cours_nbHeuresExamen FLOAT,
    CONSTRAINT FK_cours_prof_id FOREIGN KEY (cours_prof_id) REFERENCES Lot2_Professeur(prof_id) ON DELETE CASCADE
); 

CREATE TABLE Lot2_Absence (
    abs_id INTEGER PRIMARY KEY,
    abs_date DATE NOT NULL,
	abs_nbHeures FLOAT NOT NULL,
    abs_cours_id INTEGER NOT NULL,
	abs_type VARCHAR2(30),
    abs_justificatif VARCHAR2(200),
	abs_valideeAdmin VARCHAR2(20),
    CONSTRAINT fk_abs_cours_id FOREIGN KEY (abs_cours_id) REFERENCES Lot2_Cours(cours_id) ON DELETE CASCADE 
); 

CREATE TABLE Lot2_AbsencePhysique (
    absPhys_id INTEGER PRIMARY KEY,
    absPhys_dateDebut DATE NOT NULL,
	absPhys_dateFin DATE NOT NULL,
    absPhys_justificatif VARCHAR2(200),
	absPhys_valideeAdmin VARCHAR2(20)
); 

CREATE TABLE Lot2_AbsencePhysiqueParEtudiant (
	absPhys_id INTEGER, 
    etu_id INTEGER, 
	CONSTRAINT PK_AbsencePhysiqueParEtudiant PRIMARY KEY(absPhys_id, etu_id),
    CONSTRAINT FK_absPhys_id FOREIGN KEY (absPhys_id) REFERENCES Lot2_AbsencePhysique(absPhys_id) ON DELETE CASCADE,
	CONSTRAINT FK_etu_id2 FOREIGN KEY (etu_id) REFERENCES Lot2_Etudiant(etu_id) ON DELETE CASCADE
);

CREATE TABLE Lot2_AbsenceParEtudiant (
	abs_id INTEGER, 
    etu_id INTEGER, 
	CONSTRAINT PK_AbsenceParEtudiant PRIMARY KEY(abs_id, etu_id),
    CONSTRAINT FK_abs_id FOREIGN KEY (abs_id) REFERENCES Lot2_Absence(abs_id) ON DELETE CASCADE,
	CONSTRAINT FK_etu_id FOREIGN KEY (etu_id) REFERENCES Lot2_Etudiant(etu_id) ON DELETE CASCADE
);

CREATE TABLE Lot2_AbsenceParEnseignant ( 
    abs_id INTEGER,  
    prof_id INTEGER,  
    CONSTRAINT PK_AbsenceParEnseignant PRIMARY KEY(abs_id, prof_id), 
    CONSTRAINT FK_abs_id2 FOREIGN KEY (abs_id) REFERENCES Lot2_Absence(abs_id) ON DELETE CASCADE, 
    CONSTRAINT FK_prof_id2 FOREIGN KEY (prof_id) REFERENCES Lot2_Professeur(prof_id) ON DELETE CASCADE
); 

CREATE TABLE Lot2_PlanningGroupe ( 
    grp_id INTEGER, 
    cours_id INTEGER, 
    plan_date DATE NOT NULL, 
    plan_heureDebut FLOAT NOT NULL, 
    plan_heureFin FLOAT NOT NULL,
	plan_lienVisio VARCHAR2(50),
	CONSTRAINT PK_PlanningGroupe PRIMARY KEY(grp_id, cours_id, plan_date, plan_heureDebut, plan_heureFin),
    CONSTRAINT FK_grp_id FOREIGN KEY (grp_id) REFERENCES Lot2_Groupe(grp_id) ON DELETE CASCADE,
	CONSTRAINT FK_cours_id FOREIGN KEY (cours_id) REFERENCES Lot2_Cours(cours_id) ON DELETE CASCADE
); 

CREATE TABLE Lot2_Note ( 
    etu_id INTEGER, 
    cours_id INTEGER, 
    note_valeur FLOAT, 
    note_date DATE NOT NULL,
	note_rattrapage VARCHAR2(20),
	CONSTRAINT PK_Note PRIMARY KEY(etu_id, cours_id),
    CONSTRAINT FK_etu_id3 FOREIGN KEY (etu_id) REFERENCES Lot2_Etudiant(etu_id) ON DELETE CASCADE,
	CONSTRAINT FK_cours_id3 FOREIGN KEY (cours_id) REFERENCES Lot2_Cours(cours_id) ON DELETE CASCADE
);