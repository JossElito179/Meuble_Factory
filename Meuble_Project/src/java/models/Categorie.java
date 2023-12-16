package models;

  

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Categorie {

    public int id_categorie;
    public String nom;

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom) {
        this.id_categorie = id_categorie;
        this.nom = nom;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
  
    public static ArrayList<Categorie> getAllCategories(Connection connection){
        ArrayList<Categorie> rep =new ArrayList<>();
        try {
            
            String query = "SELECT * FROM Categorie";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())    {
                rep.add(new Categorie(resultSet.getInt(1),resultSet.getString(2)));
                
            }
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }
}

           


            
    