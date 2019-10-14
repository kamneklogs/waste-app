package model;
import java.util.*;

public class Reciclamos_Master_Class{

    private ArrayList<Residue> residues;
    private ArrayList<Product> products;

    public Reciclamos_Master_Class(){

        residues = new ArrayList<Residue>();
        products = new ArrayList<Product>();

    }
    
    public void addResidue() {
    	Scanner r = new Scanner(System.in);
    	String id, name, color, description, tips;
    	int origin, wasteTime, opt = 0, type, typeResidue, aux = 1;;
    	String idP, nameP, descriptionP;
    	boolean composting;
    	Product theProduct = null;
    	
    	System.out.println("Este es el menu para ingresar residuos al sistema.\n\n");
    	do {
    		System.out.println("Ingrese los siguientes datos acerca del residuo:\n");
    		System.out.print("ID: ");
    		id = r.nextLine();
    		System.out.print("Nombre: ");
    		name = r.next();
    		System.out.print("Color: ");
    		color = r.nextLine();
    		color = r.next();
    		System.out.println("Tipo de origen: ");
    		for (String s : Residue.ORIGINS) {
    			
				System.out.println(aux + ". " + s);
				aux++;
			}
    		origin = r.nextInt();
    		System.out.print("Tiempo de descomposicion (Numero de dias): ");
    		wasteTime = r.nextInt();
    		System.out.println("Seleccione el tipo de residuo:\n  1. Biodegradable.\n  2. Reciclable.\n  3. Inerte.\n");
    		typeResidue = r.nextInt();
    		System.out.println("Ahora debe agregar la informacion del producto de origen:\n\n  1. Agregar de la lista de productos.\n  2. Crear nuevo producto.\n");
    		opt = r.nextInt();
    		switch (opt) {
			case 1:
				if(products.isEmpty()) {
					System.out.println("La base de datos de productos esta vacia por el momento.\n Ingrese un nuevo producto a continuacion:\n\n");
					System.out.print("ID: ");
					idP = r.next();
					System.out.print("Nombre: ");
					nameP = r.next();
					System.out.print("Descripcion: ");
					descriptionP = r.next();
					theProduct = new Product(idP, nameP, descriptionP);
				}else {
					for (Product p : products) {
					System.out.println(aux + ". " + p.getName());
					aux++;
					}
				opt = r.nextInt() - 1;
				theProduct = products.get(opt);
				}
				
				break;

			case 2:
				System.out.print("ID: ");
				idP = r.next();
				System.out.print("Nombre: ");
				nameP = r.next();
				System.out.print("Descripcion: ");
				descriptionP = r.next();
				theProduct = new Product(idP, nameP, descriptionP);
				break;
			}
    		
    		switch(typeResidue) {
    		case 1:
    			System.out.println("El residuo a registrar se descompone?\n\n1. Si.\n2. No.\n");
    			opt = r.nextInt();
    			if(opt == 1) {
    				composting = true;
    			}else {
    				composting = false;
    			}
    			
    			residues.add(new Biodegradable(id, name, origin, color, wasteTime, composting, theProduct));
    			break;
    			
    		case 2:
    			System.out.println("Elija el tipo de residuo reciclable: ");
    			aux = 1;
    			for (String s : Recyclable.TYPES) {
					System.out.println(aux + ". " + s);
					aux++;
				}
    			type = r.nextInt();
    			System.out.print("Ingrese una breve descripcion del residuo reciclable: ");
    			description = r.next();
    			residues.add(new Recyclable(id, name, origin, color, wasteTime, description, type, theProduct));
    			break;
    			
    		case 3:
    			System.out.print("Ingrese consejos breves para reducir el uso de este reisuo inerte: ");
    			tips = r.next();
    			residues.add(new Inert(id, name, origin, color, wasteTime, tips, theProduct));
    			
    		}
    		
    		System.out.println("RESIDUO AGREGADO EXITOSAMENTE");
    		
    		System.out.println("\n\nDesea agregar un nuevo residuo?\n\n1. Si.\n2. No.\n\n");
    		
    		opt = r.nextInt();
    			
    	}while(opt != 2);
    
    	r.close();
    }
    
    

    
    
}