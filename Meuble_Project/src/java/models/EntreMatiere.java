package models;

import java.sql.Date;

public class EntreMatiere extends ModelDAO {

    private int Id_EntreMatiere ;
    private int Id_MatierePremiere ;
    private int Id_fournisseur ;
    private Date date_entre ;
    private int  quantite ;

    public EntreMatiere(int id_EntreMatiere, int id_MatierePremiere, int id_fournisseur, Date date_entre, int quantite) {
        Id_EntreMatiere = id_EntreMatiere;
        Id_MatierePremiere = id_MatierePremiere;
        Id_fournisseur = id_fournisseur;
        this.date_entre = date_entre;
        this.quantite = quantite;
    }

    public EntreMatiere() {
    }

    public int getId_EntreMatiere() {
        return Id_EntreMatiere;
    }
    public void setId_EntreMatiere(int id_EntreMatiere) {
        Id_EntreMatiere = id_EntreMatiere;
    }
    public int getId_MatierePremiere() {
        return Id_MatierePremiere;
    }
    public void setId_MatierePremiere(int id_MatierePremiere) {
        Id_MatierePremiere = id_MatierePremiere;
    }
    public int getId_fournisseur() {
        return Id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        Id_fournisseur = id_fournisseur;
    }
    public Date getDate_entre() {
        return date_entre;
    }
    public void setDate_entre(Date date_entre) {
        this.date_entre = date_entre;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    
}
