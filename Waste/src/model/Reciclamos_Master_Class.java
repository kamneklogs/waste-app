package model;

import java.util.*;

public class Reciclamos_Master_Class {

	private ArrayList<Residue> residues;
	private ArrayList<Product> products;

	public Reciclamos_Master_Class() {

		residues = new ArrayList<Residue>();
		products = new ArrayList<Product>();

	}

	public void addResidue() {
		Scanner r = new Scanner(System.in);
		String id, name, color, description, tips;
		int origin, wasteTime, opt = 0, type, typeResidue, aux = 1;
		String idP, nameP, descriptionP;
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
					descriptionP = r.next();
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
				descriptionP = r.next();
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
				break;

			case 3:
				System.out.print("Ingrese consejos breves para reducir el uso de este reisuo inerte: ");
				tips = r.next();
				residues.add(new Inert(id, name, origin, color, wasteTime, tips, theProduct));
				products.add(theProduct);

			}

			System.out.println("RESIDUO AGREGADO EXITOSAMENTE");

			System.out.println("\n\nDesea agregar un nuevo residuo?\n\n1. Si.\n2. No.\n\n");

			opt = r.nextInt();
			if (auxB) {
				r.reset();
			}
			auxB = true;
		} while (opt != 2);

	}

	public void reportResidues() {
		String stringBio = "BIODEGRADABLES:\n";
		String stringRec = "RECICLABLES:\n";
		String stringIne = "INERTES:\n";
		String superString = "\nLO SENTIMOS, AUN NO HAY REGISTROS DE RESIDUOS\n\n";
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
					stringBio += c + ". " + r.toString();
					aux1++;
				}

				if (r instanceof Recyclable) {
					c = (char) ('a' + aux2);
					stringRec += c + ". " + r.toString();
					aux2++;
				}

				if (r instanceof Inert) {
					c = (char) ('a' + aux3);
					stringIne += c + ". " + r.toString();
					aux3++;
				}
			}
			superString = stringBio + "\n\n" + stringRec + "\n\n" + stringIne + "\n\n";
			System.out.println(superString);
		}
	}

}