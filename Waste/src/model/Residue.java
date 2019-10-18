package model;

public class Residue implements Comparable{

	static final String[] ORIGINS = { "Industriales", "Domiciliarios", "Municipales", "Construccion", "Hospitalarios" };

	protected Product theProduct;

	protected String id, name, origin, color;
	protected int wasteTime;

	public Residue(String id, String name, int origin, String color, int wasteTime, Product theProduct) {

		this.id = id;
		this.name = name;
		switch (origin) {
		case 1:
			this.origin = ORIGINS[0];
			break;

		case 2:
			this.origin = ORIGINS[1];
			break;

		case 3:
			this.origin = ORIGINS[2];
			break;

		case 4:
			this.origin = ORIGINS[3];
			break;

		case 5:
			this.origin = ORIGINS[4];
			break;
		}
		this.color = color;
		this.wasteTime = wasteTime;
		this.theProduct = theProduct;

	}

	public int compareTo(Object o) {
		
		Residue aResidue = (Residue)o;
		if(this.harmfulEffect() > aResidue.harmfulEffect()){
			return -1;
		}

		if(this.harmfulEffect() < aResidue.harmfulEffect()){

			return 1;

		}

		return 0;
	}

	public String toString() {
		return name + " - " + origin + " - " + color + " - " + wasteTime + " dias para descomponerse. " + " - "
				+ theProduct.getName() + " (Identificador - " + theProduct.getId() + " Descripcion - "
				+ theProduct.getDescription();
	}

	public double harmfulEffect() {
		double value = 0;
		switch (origin) {
		case "Industriales":
			value = wasteTime * 0.1;
			break;

		case "Domiciliarios":
			value = wasteTime * 0.05;
			break;

		case "Municipales":
			value = wasteTime * 0.08;
			break;

		case "Construccion":
			value = wasteTime * 0.12;
			break;

		case "Hospitalarios":
			value = wasteTime * 0.15;
			break;
		}

		return value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWasteTime() {
		return wasteTime;
	}

	public void setWasteTime(int wasteTime) {
		this.wasteTime = wasteTime;
	}

	public Product getTheProduct() {
		return theProduct;
	}

	public void setTheProduct(Product theProduct) {
		this.theProduct = theProduct;
	}

}