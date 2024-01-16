package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Matiere extends ModelDAO {


    public int Id_MatirePremiere ;
    public String nom_matiere;
    public double quantite;
    public int id_style;

    
    // Id_StyleMatiere SERIAL,
    // quantite DOUBLE PRECISION,
    // Id_Style INTEGER NOT NULL,
    // Id_MatirePremiere

    public Matiere(int id_MatirePremiere, String nom_matiere) {
        Id_MatirePremiere = id_MatirePremiere;
        this.nom_matiere = nom_matiere;
    }

        public static ArrayList<Matiere> getAll(Connection connection) throws SQLException{
            ArrayList<Matiere> rep=new ArrayList<>();
            String query="select * from matierepremiere";
				PreparedStatement pst=connection.prepareStatement(query);
                ResultSet res=pst.executeQuery();
                while (res.next()) {
                    rep.add(new Matiere(res.getInt(1),res.getString(2)));
                }
                connection.close();
            return rep;
        }

        public static ArrayList<Matiere> getAllByStyle(Connection connection,int id_style) throws SQLException{
            ArrayList<Matiere> rep=new ArrayList<>();
            String query="select * from matierepremiere join stylematiere on \r\n"+
            " matierepremiere.id_matierepremiere=stylematiere.id_matierepremiere where stylematiere.id_style=?";
				PreparedStatement pst=connection.prepareStatement(query);
                pst.setInt(1,id_style);
                ResultSet res=pst.executeQuery();
                while (res.next()) { 
                    rep.add(new Matiere(res.getInt(1),res.getString(2)));
                }
                connection.close();
            return rep;
        }

    	public void insert(Connection connection) throws SQLException{
			String query="insert into matierepremiere values (default,?)";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, this.nom_matiere);
				boolean rep=pst.execute();
                connection.close();
		}

}
