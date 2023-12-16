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

CREATE TABLE Meuble(
   Id_Meuble SERIAL,
   nom_modele VARCHAR(50) ,
   Id_Style INTEGER NOT NULL,
   Id_Categorie INTEGER NOT NULL,
   Id_Grandeur INTEGER NOT NULL,
   PRIMARY KEY(Id_Meuble),
   FOREIGN KEY(Id_Style) REFERENCES Style(Id_Style),
   FOREIGN KEY(Id_Categorie) REFERENCES Categorie(Id_Categorie),
   FOREIGN KEY(Id_Grandeur) REFERENCES Grandeur(Id_Grandeur)
);

INSERT INTO Grandeur (nom) VALUES
('Petite'),
('Moyenne'),
('Grande');


INSERT INTO Style (nom_style) VALUES
('Moderne'),
('Classique'),
('Contemporain');

INSERT INTO Categorie (nom_categorie) VALUES
('Chaise'),
('Table'),
('Armoire');

INSERT INTO MatierePremiere (nom_matiere) VALUES
('Bois'),
('Métal'),
('Plastique');

INSERT INTO StyleMatiere (quantite, Id_Style, Id_MatierePremiere) VALUES
(10.5, 1, 1),
(8.0, 2, 2),
(15.3, 3, 3);

INSERT INTO Meuble (nom_modele, Id_Style, Id_Categorie, Id_Grandeur) VALUES
('Chaise Moderne', 1, 1, 1),
('Table Classique', 2, 2, 2),
('Armoire Contemporaine', 3, 3, 3);

