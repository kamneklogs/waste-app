package model;

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

	
	public boolean isUsable() {
		if(description != null) {
			return true;
		}
		return false;
	}

    
}