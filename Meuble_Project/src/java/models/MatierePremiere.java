package models;

public class MatierePremiere extends ModelDAO {
    
   public int  Id_MatierePremiere ;
   public String nom_matiere;
   public String unite ;

    

public MatierePremiere(int id_MatierePremiere, String nom_matiere, String unite) {
    Id_MatierePremiere = id_MatierePremiere;
    this.nom_matiere = nom_matiere;
    this.unite = unite;
}
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
public String getUnite() {
    return unite;
}
public void setUnite(String unite) {
    this.unite = unite;
}

public MatierePremiere(){
    
}
}
