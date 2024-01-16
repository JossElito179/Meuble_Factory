package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stock extends ModelDAO {


    private int Id_MatierePremiere;
    private String nom_matiere;
    private int quantite;

    public int getId_MatierePremiere() {
        return Id_MatierePremiere;
    }
    public void setId_MatierePremiere(int id_MatierePremiere) {
        Id_MatierePremiere = id_MatierePremiere;
    }
    public String getNom_matiere() {
        return nom_matiere;
    }
    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public Stock(int id_MatierePremiere, String nom_matiere, int quantite) {
        Id_MatierePremiere = id_MatierePremiere;
        this.nom_matiere = nom_matiere;
        this.quantite = quantite;
    }

        public static ArrayList<Stock> getAll(ConnectionBase connex) throws SQLException, ClassNotFoundException{
            Connection connection = connex.giveConSql();
            ArrayList<Stock> rep=new ArrayList<>();
            String query="select * from stock";
			PreparedStatement pst=connection.prepareStatement(query);
            ResultSet res=pst.executeQuery();
                while (res.next()) { 
                    rep.add(new Stock(res.getInt(1),res.getString(2),res.getInt(3)));
                }
                connection.close();
            return rep;
        }    

}
