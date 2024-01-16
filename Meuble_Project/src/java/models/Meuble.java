/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joss
 */
public class Meuble extends ModelDAO {
    	
		public int id_meuble;
		public String nom_modele;
		
		public Meuble(int id_meuble, String nom_modele) {
			this.id_meuble = id_meuble;
			this.nom_modele = nom_modele;
		}

		

		public Meuble() {
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

		public void insert(Connection connection) throws SQLException{
			String query="insert into meuble values (default,?)";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, this.getNom_modele());
				boolean rep=pst.execute();
                System.out.println(rep +" , " +rep );
			connection.close();
		}

		public static int finalId(ConnectionBase connex){
        int id=0;
        String query="select max(id_meuble) from meuble ";
        try {
            Connection connection = connex.giveConSql();
            PreparedStatement pst= connection.prepareStatement(query);
            ResultSet res=pst.executeQuery();
            while (res.next()) {
                id=res.getInt(1);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;

    }

	public static ArrayList<Meuble> getAll(ConnectionBase connex){
		ArrayList<Meuble> meubles = new ArrayList<Meuble>();
        String query="select * from meuble ";
        try {
            Connection connection = connex.giveConSql();
            PreparedStatement pst= connection.prepareStatement(query);
            ResultSet res=pst.executeQuery();
            while (res.next()) {
				meubles.add(new Meuble(res.getInt(1), res.getString(2)));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return meubles;

    }


		public static void InsertAllMeuble(ConnectionBase connection,String nom,int Id_Grandeur,int Id_Style,int Id_Categorie) throws ClassNotFoundException, SQLException{
			Meuble meub=new Meuble(0, nom);
			meub.insert(connection.giveConSql());
			int idmeuble=Meuble.finalId(connection);
			ArrayList<Integer> ids=FormuleCreation.selectIdForMeuble(connection, Id_Grandeur, Id_Style, Id_Categorie);
			Connection connex=connection.giveConSql();
			String query="INSERT INTO meubleformule values (default,?,?)";
			PreparedStatement pst=connex.prepareStatement(query);
			for (Integer long1 : ids) {
				pst.setInt(1, idmeuble);
				pst.setInt(2, long1.intValue());
				int valiny=pst.executeUpdate();
			}
		}		

	}
