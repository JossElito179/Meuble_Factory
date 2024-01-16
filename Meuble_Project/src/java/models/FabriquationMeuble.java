package models;

public class FabriquationMeuble extends ModelDAO {
    
    private int Id_fabriquationMeuble;
    private int Id_Meuble ;
    private int quantite;

    public FabriquationMeuble() {
    }
    public FabriquationMeuble(int id_fabriquationMeuble, int id_Meuble, int quantite) {
        Id_fabriquationMeuble = id_fabriquationMeuble;
        Id_Meuble = id_Meuble;
        this.quantite = quantite;
    }

    public int getId_fabriquationMeuble() {
        return Id_fabriquationMeuble;
    }
    public void setId_fabriquationMeuble(int id_fabriquationMeuble) {
        Id_fabriquationMeuble = id_fabriquationMeuble;
    }
    public int getId_Meuble() {
        return Id_Meuble;
    }
    public void setId_Meuble(int id_Meuble) {
        Id_Meuble = id_Meuble;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    
}
