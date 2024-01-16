package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChooserPrice {
    public String nom;
    public double price;

    public ChooserPrice(String nom, double price) {
        this.nom = nom;
        this.price = price;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static ArrayList<ChooserPrice> getByPrice(ConnectionBase connection,double price1,double price2) throws ClassNotFoundException, SQLException {
        ArrayList<ChooserPrice> chooserPrices = new ArrayList<ChooserPrice>();
        String query ="select * from prix_entre where prix_all>=? and prix_all<=?;";
        Connection connex=connection.giveConSql();
        PreparedStatement pst=connex.prepareStatement(query);
        pst.setDouble(1, price1);
        pst.setDouble(2, price2);
        ResultSet res=pst.executeQuery();
        while (res.next()) {
            chooserPrices.add(new ChooserPrice(res.getString(1), res.getDouble(2)));
        }
        return chooserPrices;
    }



}

