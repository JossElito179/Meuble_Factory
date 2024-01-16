package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FomuleCreationAffiche {
    public String nom_categorie;
    public String nom_style;
    public String nom_grandeur;
    public double quantite;
    
    public FomuleCreationAffiche(String nom_categorie, String nom_style, String nom_grandeur, double quantite) {
        this.nom_categorie = nom_categorie;
        this.nom_style = nom_style;
        this.nom_grandeur = nom_grandeur;
        this.quantite = quantite;
    }

    public FomuleCreationAffiche(){}

    public String getNom_categorie() {
        return nom_categorie;
    }
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    public String getNom_style() {
        return nom_style;
    }
    public void setNom_style(String nom_style) {
        this.nom_style = nom_style;
    }
    public String getNom_grandeur() {
        return nom_grandeur;
    }
    public void setNom_grandeur(String nom_grandeur) {
        this.nom_grandeur = nom_grandeur;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
    public ArrayList<FomuleCreationAffiche> getAllCreations(ConnectionBase connectionBase,int id_matiere) throws ClassNotFoundException, SQLException {
        ArrayList<FomuleCreationAffiche> affiches = new ArrayList<FomuleCreationAffiche>();
        Connection connex=connectionBase.giveConSql();
        String query="select * from FormuleCreationAffiche where id_MatierePremiere = ?";
        PreparedStatement pst=connex.prepareStatement(query);
        pst.setInt(1, id_matiere);
        ResultSet res=pst.executeQuery();
        while (res.next()) {
            affiches.add(new FomuleCreationAffiche(res.getString(2), res.getString(3), res.getString(4), res.getDouble(5)));
        }
        connex.close();
        return affiches;
    }
}
