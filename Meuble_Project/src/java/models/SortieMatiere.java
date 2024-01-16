package models;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class SortieMatiere extends ModelDAO {
    
    private int Id_SortieMatiere ;
    private int Id_MatierePremiere ;
    private Date date_sortie ;
    private double  quantite ;

    public SortieMatiere() {
    }

    public SortieMatiere(int id_SortieMatiere, int id_MatierePremiere, Date date_sortie, double quantite) {
        Id_SortieMatiere = id_SortieMatiere;
        Id_MatierePremiere = id_MatierePremiere;
        this.date_sortie = date_sortie;
        this.quantite = quantite;
    }

    public int getId_SortieMatiere() {
        return Id_SortieMatiere;
    }
    public void setId_SortieMatiere(int id_SortieMatiere) {
        Id_SortieMatiere = id_SortieMatiere;
    }
    public int getId_MatierePremiere() {
        return Id_MatierePremiere;
    }
    public void setId_MatierePremiere(int id_MatierePremiere) {
        Id_MatierePremiere = id_MatierePremiere;
    }
    public Date getDate_sortie() {
        return date_sortie;
    }
    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public ArrayList<MatiereStock> InsertMeubleFabrique(ConnectionBase connectionBase,int Id_meuble,int quantite ) throws ClassNotFoundException, SQLException{
        boolean found = false;
        ArrayList<Stock> stocks=Stock.getAll(connectionBase);
        ArrayList<MatiereStock> matiereStocks=new ArrayList<>();
        matiere_meuble matmeb=new matiere_meuble();
        ArrayList<matiere_meuble> maitiereall=matmeb.findAllDAO(connectionBase, matiere_meuble.class);
        boolean misype [] = new boolean[maitiereall.size()];
        if (stocks.isEmpty()) {
            for (int j = 0; j < maitiereall.size(); j++) {
                matiereStocks.add(new MatiereStock(maitiereall.get(j).getnom_matiere(),quantite*maitiereall.get(j).getQuantite()));
            }            
        }else{
            for (int j = 0; j < maitiereall.size(); j++) {
                for (int i = 0; i < stocks.size(); i++) {
                    if (stocks.get(i).getId_MatierePremiere()==maitiereall.get(j).getId_MatierePremiere()) {
                        misype[j]=true;
                        if (stocks.get(i).getQuantite()>quantite*maitiereall.get(j).getQuantite()) {
                            found = true;
                        }else{
                            matiereStocks.add(new MatiereStock(stocks.get(i).getNom_matiere(),-(stocks.get(i).getQuantite()-(quantite*maitiereall.get(j).getQuantite()))));
                        }
                    }
                }
            }
            for (int i = 0; i < maitiereall.size(); i++) {
                if (misype[i]==false) {
                    matiereStocks.add(new MatiereStock(maitiereall.get(i).getnom_matiere(),quantite*maitiereall.get(i).getQuantite()));
                }
            }

        if (matiereStocks.isEmpty()) {
            for (int j = 0; j < maitiereall.size(); j++) {
                for (int i = 0; i < stocks.size(); i++) {
                if (stocks.get(i).getId_MatierePremiere()==maitiereall.get(j).getId_MatierePremiere()) {
                    SortieMatiere sortie=new SortieMatiere(0, stocks.get(i).getId_MatierePremiere(), date_sortie,quantite*maitiereall.get(j).getQuantite());
                    sortie.insertDAO(connectionBase, "*");
                }
            }
        }
            FabriquationMeuble fabrique=new FabriquationMeuble(0, Id_meuble, quantite);
            fabrique.insertDAO(connectionBase, "*");   
        }
    }
        return matiereStocks;
    }
    
    
}
