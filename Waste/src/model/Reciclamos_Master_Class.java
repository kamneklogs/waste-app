package model;

import java.util.*;

public class Reciclamos_Master_Class {

	private Scanner r;
	private ArrayList<Residue> residues;
	private ArrayList<Product> products;
	private Random rnd;

	public Reciclamos_Master_Class() {

		residues = new ArrayList<Residue>();
		products = new ArrayList<Product>();
		r = new Scanner(System.in);
		rnd = new Random();

	}

	public void itIsUsable() {
		int opt = 0, i = 1;
		String usable = " El residuo es: ";

		ArrayList<Recyclable> recyclables = new ArrayList<Recyclable>();
		ArrayList<Biodegradable> biodegradables = new ArrayList<Biodegradable>();

		System.out.println("Elija el tipo de residuo a consultar:\n 1. Biodegradable\n 2. Reciclable.\n");
		opt = Integer.parseInt(r.next());

		if (opt == 1) {
			for (Residue r : residues) {
				if (r instanceof Biodegradable) {
					biodegradables.add((Biodegradable) r);
				}
			}

			System.out.println("Elija el residuo a consultar:\n");
			for (Biodegradable b : biodegradables) {
				System.out.println(i + ". " + b.getName() + ".");
				i++;
			}

			opt = Integer.parseInt(r.next());

			if (biodegradables.get(opt - 1).isUsable()) {
				usable += "UTILIZABLE\n";
			} else {
				usable += "NO USABLE\n";
			}

		} else {
			for (Residue r : residues) {
				if (r instanceof Recyclable) {
					recyclables.add((Recyclable) r);
				}
			}

			System.out.println("Elija el residuo a consultar:\n");
			for (Recyclable r : recyclables) {
				System.out.println(i + ". " + r.getName() + ".");
				i++;
			}

			opt = Integer.parseInt(r.next());

			if (recyclables.get(opt - 1).isUsable()) {
				usable += "UTILIZABLE\n";
			} else {
				usable += "NO UTILIZABLE\n";
			}
		}

		System.out.println(usable);

	}

	public void listResidues() {
		String lR = "";
		int i = 1;
		for (Residue r : residues) {
			lR += " " + i + ". " + r.getName() + ".\n";
			i++;
		}

		System.out.println(lR);
	}

	public void harmfulEffect() {
		int opt = -1;
		System.out.println("Elija un residuo de la lista:\n");
		listResidues();
		opt = Integer.parseInt(r.next()) - 1;
		System.out.println("El efecto nosivo de este residuo es: " + residues.get(opt).harmfulEffect() + "\n");
	}

	public void listProducts() {
		String lP = "PRODUCTOS REGISTRADOS:\n\n";
		int i = 0;
		// (char) ('a' + aux1);
		for (Product p : products) {
			lP += " " + (char) ('a' + i) + ". " + p.getName() + ".\n";
			i++;
		}

		if (lP.equals("PRODUCTOS REGISTRADOS:\n\n")) {
			lP = "***** Aun no hay productos registrados *****\n";
		}

		System.out.println(lP);
	}

	public void searchWasteInformation() {
		int opt = 0;
		do {
			System.out.println("Buscar mediante:\n\n 1. Nombre del residuo\n 2. Identificador del producto.\n");
			opt = Integer.parseInt(r.next());
			String nameW, idP;
			boolean find = false;
			switch (opt) {
			case 1:
				System.out.print("Ingrese el nombre exacto del residuo: ");
				r.nextLine();
				nameW = r.nextLine();
				for (Residue r : residues) {
					if (r.getName().equals(nameW)) {
						System.out.println(r.toString());
						find = true;
					}
				}
				if (find == false) {
					System.out.println("\n ****Residuo no encontrado ****\n");
				}

				break;

			case 2:
				System.out.println("Ingrese el ID exacto del producto: ");
				r.nextLine();
				idP = r.nextLine();
				int indexProduct = -1;
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getId().equals(idP)) {
						indexProduct = i;
					}
				}
				if (indexProduct != -1) {
					if (products.get(indexProduct).getMyResidues().size() < 2) {
						System.out.println("Este producto tiene un solo residuo que se lista a continuacion: \n\n");
						System.out.println(products.get(indexProduct).getMyResidues().get(0).toString() + "\n");
					}
				} else {
					System.out.println("\n **** Residuo no encontrado ****\n");
				}

				if (indexProduct != -1) {
					if (products.get(indexProduct).getMyResidues().isEmpty()) {
						System.out.println("Este producto no tiene residuos relacionados.\n");
					}
				}

				if (indexProduct != -1) {
					if (products.get(indexProduct).getMyResidues().size() > 1) {
						System.out.println("Este producto tiene mas de un residuo relacionado, elija uno:\n");
						System.out.println(products.get(indexProduct).listRName());
						opt = Integer.parseInt(r.next()) - 1;
						products.get(indexProduct).getMyResidues().get(opt).toString();
					}
				}

				break;
			}

			System.out.println("\nBuscar otro residuo?\n\n 1. Si.\n 2. No.\n");
			opt = Integer.parseInt(r.next());
		} while (opt != 2);

	}

	public void addResidue() {

		String id = Integer.toString(rnd.nextInt(10000)), name = "N/E.", color = "N/E.", description = "N/E.",
				tips = "N/E.";
		int origin, wasteTime, opt = 0, type, typeResidue, aux = 1;
		String idP = Integer.toString(rnd.nextInt(10000)), nameP = "N/E.", descriptionP = "N/E.";
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
			r.next();
			origin = Integer.parseInt(r.next());
			System.out.print("Tiempo de descomposicion (Numero de dias): ");
			wasteTime = Integer.parseInt(r.next());
			System.out.println("Seleccione el tipo de residuo:\n  1. Biodegradable.\n  2. Reciclable.\n  3. Inerte.\n");
			typeResidue = Integer.parseInt(r.next());
			System.out.println(
					"Ahora debe agregar la informacion del producto de origen:\n\n  1. Agregar de la lista de productos.\n  2. Crear nuevo producto.\n");
			opt = Integer.parseInt(r.next());
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
					opt = Integer.parseInt(r.next()) - 1;
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
				opt = Integer.parseInt(r.next());
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
				type = Integer.parseInt(r.next());
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
			r.next();
			opt = r.nextInt();
			auxB = true;
		} while (opt != 2);

	}

	public void addProduct() {
		String id = Integer.toString(rnd.nextInt(10000)), name = "N/E.", color = "N/E.", description = "N/E.",
				tips = "N/E.";
		int origin, wasteTime, opt = 0, type, typeResidue, aux = 1;
		String idP = Integer.toString(rnd.nextInt(10000)), nameP = "N/E.", descriptionP = "N/E.";
		boolean composting, auxB = false;
		Product theProduct = null;

		do {
			System.out.println("Ingrese los siguientes datos acerca del producto:\n");

			System.out.print("ID: ");
			idP = r.nextLine();
			System.out.print("Nombre: ");
			nameP = r.nextLine();
			System.out.print("Descripcion: ");
			descriptionP = r.nextLine();

			System.out.println("El producto tiene residuos asociados? \n1. Si.\n2. No.\n");
			opt = Integer.parseInt(r.next());
			theProduct = new Product(id, name, description);
			if (opt == 1) {
				System.out.print("Cantidad de residuos asociados: ");
				opt = Integer.parseInt(r.next());
				for (int i = 0; i < opt; i++) {

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
					origin = Integer.parseInt(r.next());
					System.out.print("Tiempo de descomposicion (Numero de dias): ");
					wasteTime = Integer.parseInt(r.next());
					System.out.println(
							"Seleccione el tipo de residuo:\n  1. Biodegradable.\n  2. Reciclable.\n  3. Inerte.\n");
					typeResidue = Integer.parseInt(r.next());
					switch (typeResidue) {
					case 1:
						System.out.println("El residuo a registrar se descompone?\n\n1. Si.\n2. No.\n");
						opt = Integer.parseInt(r.next());
						if (opt == 1) {
							composting = true;
						} else {
							composting = false;
						}

						residues.add(new Biodegradable(id, name, origin, color, wasteTime, composting, theProduct));
						theProduct.getMyResidues()
								.add((new Biodegradable(id, name, origin, color, wasteTime, composting, theProduct)));
						products.add(theProduct);

						break;

					case 2:
						System.out.println("Elija el tipo de residuo reciclable: ");
						aux = 1;
						for (String s : Recyclable.TYPES) {
							System.out.println(aux + ". " + s);
							aux++;
						}
						type = Integer.parseInt(r.next());
						System.out.print("Ingrese una breve descripcion del residuo reciclable: ");
						description = r.next();
						residues.add(new Recyclable(id, name, origin, color, wasteTime, description, type, theProduct));
						theProduct.getMyResidues()
								.add(new Recyclable(id, name, origin, color, wasteTime, description, type, theProduct));
						products.add(theProduct);
						break;

					case 3:
						System.out.print("Ingrese consejos breves para reducir el uso de este residuo inerte: ");
						tips = r.next();
						residues.add(new Inert(id, name, origin, color, wasteTime, tips, theProduct));
						products.add(theProduct);

						break;
					}
					auxB = true;
				}
				System.out.println("PRODUCTO AGREGADO EXITOSAMENTE");

				System.out.println("\n\nDesea agregar un nuevo residuo?\n\n1. Si.\n2. No.");
				opt = Integer.parseInt(r.next());
			}
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
				stringBio += "\n******* Aun sin registros de este tipo de residuos*******\n\n";
			}
			if (stringRec.equals("||||||||| RECICLABLES: |||||||||\n")) {
				stringRec += "\n******* Aun sin registros de este tipo de residuos*******\n\n";
			}
			if (stringIne.equals("||||||||| INERTES: |||||||||\n")) {
				stringIne += "\n******* Aun sin registros de este tipo de residuos*******\n\n";
			}
			superString = stringBio + "\n\n" + stringRec + "\n\n" + stringIne + "\n\n";
			System.out.println(superString);
		}
	}

	public ArrayList<Residue> getResidues() {
		return residues;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

}