package model;

/**
 * This class manages the entire legion
 * 
 * @author Camilo Cordoba.
 * @since 1.0
 */
public class Recyclable extends Residue implements Usable{
	
	static final String[] TYPES = {"Papel", "Carton", "Vidrio", "Plasticos", "Metales"};

    private String type, description;

    public Recyclable(String id,String name,int origin,String color, int wasteTime, String description, int type, Product theProduct){

        super( id, name, origin, color, wasteTime, theProduct);
        switch (type) {
		case 1:
			this.type = TYPES[0];
			break;
			
		case 2:
			this.type = TYPES[1];
			break;
			
		case 3:
			this.type = TYPES[2];
			break;
			
		case 4:
			this.type = TYPES[3];
			break;
			
		case 5:
			this.type = TYPES[4];
			break;
		}
        this.description = description;

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
        return super.harmfulEffect() - (super.harmfulEffect()*0.02);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


	/**
     * This method return the potition of a archangel searched by name
     * <b>pre:</b> The param string is a valid string <br>
     * <b>post:</b> position is found. If not found return -1 <br>
     * 
     * @param name is a valid String != null
     * @return int that containing the required potition
     */
	public boolean isUsable() {
		if(description != null) {
			return true;
		}
		return false;
	}

    
}