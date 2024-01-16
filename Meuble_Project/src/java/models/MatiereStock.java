package models;

public class MatiereStock {

    public  String matiere;
    public double quantite;
    public MatiereStock() {
    }

    public MatiereStock(String matiere, double quantite) {
        this.matiere = matiere;
        this.quantite = quantite;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
    
}
