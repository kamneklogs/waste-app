package model;

public class Inert extends Residue{

    private String tips;

    public Inert(String id,String name,int origin,String color, int wasteTime, String tips, Product theProduct){

        super( id, name, origin, color, wasteTime, theProduct);
        this.tips = tips;

    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    
}