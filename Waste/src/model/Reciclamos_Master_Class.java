package model;

import java.util.*;

public class Reciclamos_Master_Class {

	private Scanner r;
	private ArrayList<Residue> residues;
	private ArrayList<Product> products;

	public Reciclamos_Master_Class() {

		residues = new ArrayList<Residue>();
		products = new ArrayList<Product>();
		r = new Scanner(System.in);

	}

	public void addResidue() {

		String id, name, color, description, tips;
		int origin, wasteTime, opt = 0, type, typeResidue, aux = 1;
		String idP = null, nameP, descriptionP = "No especifica.";
		boolean composting, auxB = false;
		Product theProduct = null;

		System.out.println("Este es el menu para ingresar residuos al sistema.\n\n");
		do {
			System.out.println("Ingrese los siguientes datos acerca del residuo:\n");
			System.out.print("ID: ");
			if (auxB) {
				id = r.nextLine();
			}
			id = r.nextLine();
			System.out.print("Nombre: ");
			name = r.next();
			System.out.print("Color: ");
			color = r.next();
			System.out.println("Tipo de origen: ");
			aux = 1;
			for (String s : Residue.ORIGINS) {

				System.out.println(aux + ". " + s);
				aux++;
			}
			r.reset();
			origin = r.nextInt();
			System.out.print("Tiempo de descomposicion (Numero de dias): ");
			wasteTime = r.nextInt();
			System.out.println("Seleccione el tipo de residuo:\n  1. Biodegradable.\n  2. Reciclable.\n  3. Inerte.\n");
			typeResidue = r.nextInt();
			System.out.println(
					"Ahora debe agregar la informacion del producto de origen:\n\n  1. Agregar de la lista de productos.\n  2. Crear nuevo producto.\n");
			opt = r.nextInt();
			switch (opt) {
			case 1:
				if (products.isEmpty()) {
					System.out.println(
							"La base de datos de productos esta vacia por el momento.\n\n Ingrese un nuevo producto a continuacion:\n");
					System.out.print("ID: ");
					idP = r.next();
					System.out.print("Nombre: ");
					nameP = r.next();
					System.out.print("Descripcion: ");
					descriptionP = r.nextLine();
					theProduct = new Product(idP, nameP, descriptionP);
				} else {
					aux = 1;
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
				if (auxB) {
					descriptionP = r.nextLine();
				} else {
					descriptionP = r.nextLine();
				}
				descriptionP = r.nextLine();
				theProduct = new Product(idP, nameP, descriptionP);
				break;
			}

			switch (typeResidue) {
			case 1:
				System.out.println("El residuo a registrar se descompone?\n\n1. Si.\n2. No.\n");
				opt = r.nextInt();
				if (opt == 1) {
					composting = true;
				} else {
					composting = false;
				}

				residues.add(new Biodegradable(id, name, origin, color, wasteTime, composting, theProduct));
				products.add(theProduct);
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getId().equals(idP)) {
						products.get(i).getMyResidues()
								.add(new Biodegradable(id, name, origin, color, wasteTime, composting, theProduct));
					}
				}
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
				products.add(theProduct);
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getId().equals(idP)) {
						products.get(i).getMyResidues()
								.add(new Recyclable(id, name, origin, color, wasteTime, description, type, theProduct));
					}
				}
				break;

			case 3:
				System.out.print("Ingrese consejos breves para reducir el uso de este residuo inerte: ");
				tips = r.next();
				residues.add(new Inert(id, name, origin, color, wasteTime, tips, theProduct));
				products.add(theProduct);
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getId().equals(idP)) {
						products.get(i).getMyResidues()
								.add(new Inert(id, name, origin, color, wasteTime, tips, theProduct));
					}
				}
				break;

			}

			System.out.println("RESIDUO AGREGADO EXITOSAMENTE");

			System.out.println("\n\nDesea agregar un nuevo residuo?\n\n1. Si.\n2. No.");

			opt = r.nextInt();
			auxB = true;
		} while (opt != 2);

	}

	public void reportResidues() {
		String stringBio = "||||||||| BIODEGRADABLES: |||||||||\n";
		String stringRec = "||||||||| RECICLABLES: |||||||||\n";
		String stringIne = "||||||||| INERTES: |||||||||\n";
		String superString = "\n**** LO SENTIMOS, AUN NO HAY REGISTROS DE RESIDUOS ****\n\n";
		int aux1 = 0;
		int aux2 = 0;
		int aux3 = 0;
		char c;

		if (residues.isEmpty()) {
			System.out.println(superString);
		} else {
			for (Residue r : residues) {
				if (r instanceof Biodegradable) {
					c = (char) ('a' + aux1);
					stringBio += c + ". " + r.toString() + "\n";
					aux1++;
				}

				if (r instanceof Recyclable) {
					c = (char) ('a' + aux2);
					stringRec += c + ". " + r.toString() + "\n";
					aux2++;
				}

				if (r instanceof Inert) {
					c = (char) ('a' + aux3);
					stringIne += c + ". " + r.toString() + "\n";
					aux3++;
				}
			}

			if (stringBio.equals("||||||||| BIODEGRADABLES: |||||||||\n")) {
				stringBio += "\n******* Aun no registros de este tipo de residuos*******\n\n";
			}
			if (stringRec.equals("||||||||| RECICLABLES: |||||||||\n")) {
				stringRec += "\n******* Aun si registros de este tipo de residuos*******\n\n";
			}
			if (stringIne.equals("||||||||| INERTES: |||||||||\n")) {
				stringIne += "\n******* Aun si registros de este tipo de residuos*******\n\n";
			}
			superString = stringBio + "\n\n" + stringRec + "\n\n" + stringIne + "\n\n";
			System.out.println(superString);
		}
	}

}