create database meuble;

\c meuble;

CREATE TABLE Grandeur(
   Id_Grandeur SERIAL,
   nom VARCHAR(50) ,
   PRIMARY KEY(Id_Grandeur)
);

CREATE TABLE Style(
   Id_Style SERIAL,
   nom_style VARCHAR(50) ,
   PRIMARY KEY(Id_Style)
);

CREATE TABLE Categorie(
   Id_Categorie SERIAL,
   nom_categorie VARCHAR(50) ,
   PRIMARY KEY(Id_Categorie)
);

CREATE TABLE MatierePremiere(
   Id_MatierePremiere SERIAL,
   nom_matiere VARCHAR(50) ,
   prix_unitaire DOUBLE PRECISION,
   unite VARCHAR(50),
   PRIMARY KEY(Id_MatierePremiere)
);

CREATE TABLE StyleMatiere(
   Id_StyleMatiere SERIAL,
   quantite DOUBLE PRECISION,
   Id_Style INTEGER NOT NULL,
   Id_MatierePremiere INTEGER NOT NULL,
   PRIMARY KEY(Id_StyleMatiere),
   FOREIGN KEY(Id_Style) REFERENCES Style(Id_Style),
   FOREIGN KEY(Id_MatierePremiere) REFERENCES MatierePremiere(Id_MatierePremiere)
);

CREATE TABLE FormuleCreation(
   Id_FormuleCreation SERIAL,
   quantite DOUBLE PRECISION,
   Id_Grandeur INTEGER NOT NULL,
   Id_Style INTEGER NOT NULL,
   Id_Categorie INTEGER NOT NULL,
   Id_MatierePremiere INTEGER NOT NULL,
   PRIMARY KEY(Id_FormuleCreation),
   FOREIGN KEY(Id_Style) REFERENCES Style(Id_Style),
   FOREIGN KEY(Id_Grandeur) REFERENCES Grandeur(Id_Grandeur),
   FOREIGN KEY(Id_Categorie) REFERENCES Categorie(Id_Categorie),
   FOREIGN KEY(Id_MatierePremiere) REFERENCES MatierePremiere(Id_MatierePremiere)
);


CREATE TABLE Meuble(
   Id_Meuble SERIAL,
   nom_modele VARCHAR(50) ,
   PRIMARY KEY(Id_Meuble)
);

CREATE TABLE Fournisseur(
   Id_fournisseur SERIAL PRIMARY key ,
   nom VARCHAR(50)
);

CREATE TABLE fabriquationMeuble(
   Id_fabriquationMeuble SERIAL PRIMARY KEY,
   Id_Meuble int not null,
   quantite int not null
);

CREATE TABLE EntreMatiere(
   Id_EntreMatiere SERIAL,
   Id_MatierePremiere int not null,
   Id_fournisseur int not null,
   date_entre date,
   quantite int not null,
   PRIMARY KEY (Id_EntreMatiere),
   FOREIGN KEY (Id_MatierePremiere) REFERENCES MatierePremiere(Id_MatierePremiere),
   FOREIGN KEY (Id_fournisseur) REFERENCES Fournisseur(Id_fournisseur)
);

CREATE TABLE SortieMatiere(
   Id_SortieMatiere SERIAL,
   Id_MatierePremiere int not null,
   quantite int not null,
   date_sortie date,
   PRIMARY KEY (Id_SortieMatiere),
   FOREIGN KEY (Id_MatierePremiere) REFERENCES MatierePremiere(Id_MatierePremiere)
);



CREATE TABLE meubleFormule(
   id_meubleFormule SERIAL PRIMARY KEY,
   id_meuble int not null,
   Id_FormuleCreation int not null,
   FOREIGN key (id_meuble) REFERENCES meuble(id_meuble),
      FOREIGN key (Id_FormuleCreation) REFERENCES FormuleCreation(Id_FormuleCreation)
);

INSERT INTO Grandeur (nom) VALUES
('Petit'),
('Moyen'),
('Grand');

INSERT INTO Style (nom_style) VALUES
('Moderne'),
('Classique'),
('Contemporain');

INSERT INTO Categorie (nom_categorie) VALUES
('Chaise'),
('Table'),
('Armoire');

INSERT INTO MatierePremiere (nom_matiere,prix_unitaire, unite) VALUES
('Bois',100, 'mètre cube'),
('Métal',500, 'kilo'),
('Tissu',600, 'mètre carré');

INSERT INTO StyleMatiere (quantite, Id_Style, Id_MatierePremiere) VALUES
(10, 1, 1),
(5, 2, 2),
(8, 3, 3);

INSERT INTO FormuleCreation (quantite, Id_Grandeur, Id_Style, Id_Categorie, Id_MatierePremiere) VALUES
(15, 1, 1, 1, 1),
(20, 2, 2, 2, 2),
(25, 3, 3, 3, 3);

INSERT INTO Meuble (nom_modele) VALUES
('Chaise Moderne'),
('Table Classique'),
('Armoire Contemporaine');

insert into fournisseur values (default,'bogosy');

create view FormuleCreationAffiche as select
   FormuleCreation.Id_MatierePremiere,
   Categorie.nom_categorie,
   Style.nom_style,
   Grandeur.nom,
   FormuleCreation.quantite
from 
 FormuleCreation
 join Categorie on FormuleCreation.Id_Categorie=Categorie.Id_Categorie
 join Style on FormuleCreation.Id_Style=Style.Id_Style
 join Grandeur on FormuleCreation.Id_Grandeur=Grandeur.Id_Grandeur;


create or replace view v_formulemeuble as select 
   meuble.nom_modele ,
   Id_FormuleCreation
   from meuble join meubleFormule
   on meuble.id_meuble=meubleFormule.id_meuble group by meuble.nom_modele ,Id_FormuleCreation;

create view prix_entre as select 
   v_formulemeuble.nom_modele,
   sum(FormuleCreation.quantite*MatierePremiere.prix_unitaire) as prix_all
   from v_formulemeuble join FormuleCreation on
   v_formulemeuble.Id_FormuleCreation=FormuleCreation.Id_FormuleCreation join 
   MatierePremiere on FormuleCreation.Id_MatierePremiere=MatierePremiere.Id_MatierePremiere group by v_formulemeuble.nom_modele;


create view matiere_meuble as select 
   meubleFormule.id_meuble,
   MatierePremiere.nom_matiere,
   FormuleCreation.Id_MatierePremiere,
   FormuleCreation.quantite 
   from meubleFormule join FormuleCreation on 
   FormuleCreation.Id_FormuleCreation=meubleFormule.Id_FormuleCreation join
   MatierePremiere on MatierePremiere.Id_MatierePremiere=FormuleCreation.Id_MatierePremiere;

 
create or replace view stock as SELECT 
    MatierePremiere.Id_MatierePremiere,
    MatierePremiere.nom_matiere,
    EntreMatiere.quantite - COALESCE(SortieMatiere.quantite, 0) AS reste
FROM 
    MatierePremiere
JOIN 
    EntreMatiere ON MatierePremiere.Id_MatierePremiere = EntreMatiere.Id_MatierePremiere
LEFT JOIN 
    SortieMatiere ON EntreMatiere.Id_MatierePremiere = SortieMatiere.Id_MatierePremiere;


select * from prix_entre where prix_all>=1000 and prix_all<=2000;

