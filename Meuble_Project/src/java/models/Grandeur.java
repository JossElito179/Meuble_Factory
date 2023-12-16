package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Grandeur {

    public int id_grandeur;
    public String nom;

    public Grandeur() {
    }

    public Grandeur(int id_grandeur, String nom) {
        this.id_grandeur = id_grandeur;
        this.nom = nom;
        
    }
    public int getId_grandeur() {
        return id_grandeur;
    }

    public void setId_grandeur(int id_grandeur) {
        this.id_grandeur = id_grandeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public static ArrayList<Grandeur> getGrandeur(Connection connection){
        ArrayList<Grandeur> rep =new ArrayList<>();
        try {
            
            String query = "SELECT * FROM Grandeur";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())    {
                rep.add(new Grandeur(resultSet.getInt(1),resultSet.getString(2)));
                
            }
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }
}

           


            
    