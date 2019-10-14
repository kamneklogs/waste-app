package model;

public class Biodegradable extends Residue implements Usable{

    private boolean composting;

    public Biodegradable(String id, String name, int origin, String color, int wasteTime, boolean composting, Product theProduct) {

        super(id, name, origin, color, wasteTime, theProduct);
        this.composting = composting;

    }

    public double harmfulEffect(){
       if(composting == true){
           return super.harmfulEffect() - (super.harmfulEffect()*0.01);
       }
        return super.harmfulEffect();
    
    }

    public boolean isUsable(){
    	if (wasteTime < 360 && composting == true) {
            return true;
		}
        return false;
    }

    public boolean getComposting() {
        return composting;
    }

    public void setComposting(boolean composting) {
        this.composting = composting;
    }

    
}