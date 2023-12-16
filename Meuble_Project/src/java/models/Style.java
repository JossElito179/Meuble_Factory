package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Style {
    	
               public  int id_style;
		public String nom_Style;
		public ArrayList<Matiere> matierePrim;

        // Id_StyleMatiere SERIAL,
        // quantite DOUBLE PRECISION,
        // Id_Style INTEGER NOT NULL,
        // Id_MatirePremiere

        

        public void insert(Connection connection,String [] quantite, String [] idMatiere) throws SQLException{
			String query="insert into Style values (default,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setString(1, this.nom_Style);
			boolean rep=pst.execute();
            int id_style=this.getMaxRowCount(connection);
            System.out.println(id_style+" id style matiere ");
            this.setId_style(id_style);
            for (int i=0 ; i<idMatiere.length;i++) {
                this.insertWithStyle(connection,Double.valueOf(quantite[i]),Integer.valueOf(idMatiere[i]));   
            }
            connection.close();
		}


        public int getMaxRowCount(Connection connection) {
        int rep =0;
        try {
            String query = "SELECT max(id_style) FROM Style";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())    {
                rep=resultSet.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rep;
        }

        public void insertWithStyle(Connection connection,double quantite,int idmatiere) throws SQLException{
            String query2="insert into StyleMatiere values (default,?,?,?)";
            PreparedStatement pst2=connection.prepareStatement(query2);
            pst2.setInt(2,this.id_style);
            pst2.setDouble(1,quantite);
            pst2.setInt(3,idmatiere);
            boolean rep2=pst2.execute();
        }

        public int getId_style() {
            return id_style;
        }

        public void setId_style(int id_style) {
            this.id_style = id_style;
        }

        public String getNom_Style() {
            return nom_Style;
        }

        public void setNom_Style(String nom_Style) {
            this.nom_Style = nom_Style;
        }

        public ArrayList<Matiere> getMatierePrim() {
            return matierePrim;
        }

        public void setMatierePrim(ArrayList<Matiere> matierePrim) {
            this.matierePrim = matierePrim;
        }

        public ArrayList<Matiere> getAllById(Connection connection) throws SQLException {
            this.setMatierePrim(Matiere.getAllByStyle(connection, id_style));
            return this.getMatierePrim();
        }

        public Style(int id_style, String nom_Style, ArrayList<Matiere> matierePrim) {
            this.id_style = id_style;
            this.nom_Style = nom_Style;
            this.matierePrim = matierePrim;
        }

        public Style(int int1, String string) {
            this.id_style=int1;
            this.nom_Style=string;
        }

    public Style() {
        }


    public static ArrayList<Style> getStyle(Connection connection){
        ArrayList<Style> rep =new ArrayList<>();
        try {
            String query = "SELECT * FROM Style";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())    {
                rep.add(new Style(resultSet.getInt(1),resultSet.getString(2)));
            }
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

        public static Style getStyleById(Connection connection,int id_tyle){
                    System.out.println(id_tyle);
        Style rep =new Style();
        try {
            String query = "SELECT * FROM Style where id_style=?";
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setInt(1, id_tyle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())    {
                rep=new Style(resultSet.getInt(1),resultSet.getString(2));
                System.out.println(resultSet.getInt(1)+" , "+resultSet.getString(2));
            }
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    }
