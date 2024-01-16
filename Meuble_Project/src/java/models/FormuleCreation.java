package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormuleCreation extends ModelDAO {

    public int Id_FormuleCreation ;
    public double quantite ;
    public int Id_Grandeur ;
    public int Id_Style ;
    public int Id_Categorie ;
    public int Id_MatierePremiere ;

    public FormuleCreation(int id_FormuleCreation, double quantite, int id_Grandeur, int id_Style, int id_Categorie,
            int id_MatierePremiere) {
        Id_FormuleCreation = id_FormuleCreation;
        this.quantite = quantite;
        Id_Grandeur = id_Grandeur;
        Id_Style = id_Style;
        Id_Categorie = id_Categorie;
        Id_MatierePremiere = id_MatierePremiere;
    }

    public FormuleCreation(){}

    public int getId_FormuleCreation() {
        return Id_FormuleCreation;
    }
    public void setId_FormuleCreation(int id_FormuleCreation) {
        Id_FormuleCreation = id_FormuleCreation;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public int getId_Grandeur() {
        return Id_Grandeur;
    }
    public void setId_Grandeur(int id_Grandeur) {
        Id_Grandeur = id_Grandeur;
    }
    public int getId_Style() {
        return Id_Style;
    }
    public void setId_Style(int id_Style) {
        Id_Style = id_Style;
    }
    public int getId_Categorie() {
        return Id_Categorie;
    }
    public void setId_Categorie(int id_Categorie) {
        Id_Categorie = id_Categorie;
    }
    public int getId_MatierePremiere() {
        return Id_MatierePremiere;
    }
    public void setId_MatierePremiere(int id_MatierePremiere) {
        Id_MatierePremiere = id_MatierePremiere;
    }

    public static ArrayList<Integer> selectIdForMeuble(ConnectionBase connex,int Id_Grandeur,int Id_Style,int Id_Categorie){
        ArrayList<Integer> ids=new ArrayList<>();
        String query="select id_formulecreation from formulecreation where id_grandeur=? and id_style=? and id_categorie=?";
        try {
            Connection connection = connex.giveConSql();
            PreparedStatement pst= connection.prepareStatement(query);
            pst.setInt(1, Id_Grandeur);
            pst.setInt(2, Id_Style);
            pst.setInt(3, Id_Categorie);
            ResultSet res=pst.executeQuery();
            while (res.next()) {
                ids.add(res.getInt(1));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ids;
    }

}
