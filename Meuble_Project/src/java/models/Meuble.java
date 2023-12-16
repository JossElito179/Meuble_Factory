/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joss
 */
public class Meuble {
    	
		public int id_meuble;
		public String nom_modele;
		public int id_categorie;
		public int id_Grandeur;
		public int id_Style;
		
		public Meuble(int id_meuble, String nom_modele, int id_categorie, int id_Grandeur, int id_Style) {
			this.id_meuble = id_meuble;
			this.nom_modele = nom_modele;
			this.id_categorie = id_categorie;
			this.id_Grandeur = id_Grandeur;
			this.id_Style = id_Style;
		}
		public int getId_meuble() {
			return id_meuble;
		}


		public void setId_meuble(int id_meuble) {
			this.id_meuble = id_meuble;
		}


		public String getNom_modele() {
			return nom_modele;
		}


		public void setNom_modele(String nom_modele) {
			this.nom_modele = nom_modele;
		}


		public int getId_categorie() {
			return id_categorie;
		}


		public void setId_categorie(int id_categorie) {
			this.id_categorie = id_categorie;
		}


		public int getId_Grandeur() {
			return id_Grandeur;
		}


		public void setId_Grandeur(int id_Grandeur) {
			this.id_Grandeur = id_Grandeur;
		}


		public int getId_Style() {
			return id_Style;
		}


		public void setId_Style(int id_Style) {
			this.id_Style = id_Style;
		}


		public void insert(Connection connection) throws SQLException{
			String query="insert into meuble values (default,?,?,?,?)";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, this.getNom_modele());
				pst.setInt(2,this.getId_Style());
				pst.setInt(3, this.getId_categorie());
				pst.setInt(4, this.getId_Grandeur());
				boolean rep=pst.execute();
                        System.out.println(rep +" , " +rep );
			connection.close();
		}
		

	}
