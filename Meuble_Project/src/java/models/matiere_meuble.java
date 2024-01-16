package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class matiere_meuble extends ModelDAO {

    private int Id_MatierePremiere;
    private String nom_matiere;
    private double quantite;

    public matiere_meuble() {
    }
    
    public matiere_meuble(int id_MatierePremiere,String nom_matiere, int quantite) {
        Id_MatierePremiere = id_MatierePremiere;
        this.nom_matiere = nom_matiere;
        this.quantite = quantite;
    }
    public int getId_MatierePremiere() {
        return Id_MatierePremiere;
    }
    public void setId_MatierePremiere(int id_MatierePremiere) {
        Id_MatierePremiere = id_MatierePremiere;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    } 

        public static ArrayList<matiere_meuble> getAllMaitiereByMeuble(Connection connection,int id_meuble) throws SQLException{
            ArrayList<matiere_meuble> rep=new ArrayList<>();
            String query="select * from matiere_meuble where id_meuble=?";
				PreparedStatement pst=connection.prepareStatement(query);
                pst.setInt(1,id_meuble);
                ResultSet res=pst.executeQuery();
                while (res.next()) { 
                    rep.add(new matiere_meuble(res.getInt(2),res.getString(3), res.getInt(4)));
                }
                connection.close();
            return rep;
        }

        public String getnom_matiere() {
            return nom_matiere;
        }

        public void setnom_matiere(String nom_matiere) {
            this.nom_matiere = nom_matiere;
        }


}
