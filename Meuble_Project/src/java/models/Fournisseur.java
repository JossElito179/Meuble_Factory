package models;

public class Fournisseur extends ModelDAO {


    public int Id_fournisseur ;
    public String nom;
    public Fournisseur(int id_fournisseur, String nom) {
        Id_fournisseur = id_fournisseur;
        this.nom = nom;
    }
    public Fournisseur() {
    }

    
}
