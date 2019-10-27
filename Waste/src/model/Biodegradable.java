package model;

/**
 * This class represents the biodegradable residues
 * 
 * @author Camilo Cordoba.
 * @since 1.0
 */
public class Biodegradable extends Residue implements Usable{

    private boolean composting;

    public Biodegradable(String id, String name, int origin, String color, int wasteTime, boolean composting, Product theProduct) {

        super(id, name, origin, color, wasteTime, theProduct);
        this.composting = composting;

    }

    /**
     * This method return the potition of a archangel searched by name
     * <b>pre:</b> The param string is a valid string <br>
     * <b>post:</b> position is found. If not found return -1 <br>
     * 
     * @param name is a valid String != null
     * @return int that containing the required potition
     */
    public double harmfulEffect(){
       if(composting == true){
           return super.harmfulEffect() - (super.harmfulEffect()*0.01);
       }
        return super.harmfulEffect();
    
    }

    /**
     * This method return the potition of a archangel searched by name
     * <b>pre:</b> The param string is a valid string <br>
     * <b>post:</b> position is found. If not found return -1 <br>
     * 
     * @param name is a valid String != null
     * @return int that containing the required potition
     */
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