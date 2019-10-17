package ui;

import model.*;
import java.util.*;

class Reciclamos {

    private Reciclamos_Master_Class reciclamosApp;
    public static final String MENU1 = "\n\n 1. Agregar un residuo.\n 2. Generar reporte de todos los residuos.\n 3. Agregar un producto y los residuos que puede generar.\n 4. Buscar informacion de un residuo.\n 5. Lista de productos registrados.\n 6. Mostrar efecto nosivo de un residuo.\n 7. Mostrar si un residuo biodegradable o reciclable es aprovechable.\n 8. Mostrar residuos de un producto (De mas a menos nocivo).\n 9. Salir.\n";

    public Reciclamos() {
        reciclamosApp = new Reciclamos_Master_Class();
    }

    public void init(){
        
        reciclamosApp.getResidues().add(new Biodegradable( "123", "cascara de banano", 2, "amarillo", 12, true, new Product("321", "banano", "rico en potasio")));
        reciclamosApp.getProducts().add(new Product("321", "banano", "rico en potasio"));
        reciclamosApp.getProducts().get(0).getMyResidues().add(new Biodegradable( "123", "cascara de banano", 2, "amarillo", 12, true, new Product("321", "banano", "rico en potasio")));

        reciclamosApp.getResidues().add(new Inert("222", "Jeringa", 5, "transparente", 500, "no enfermarse", new Product("333", "paquete de jeringas", "jeringas matasanos")));
        reciclamosApp.getProducts().add(new Product("333", "paquete de jeringas", "jeringas matasanos"));
        reciclamosApp.getProducts().get(1).getMyResidues().add(new Inert("222", "Jeringa", 5, "transparente", 500, "no enfermarse", new Product("333", "paquete de jeringas", "jeringas matasanos")));

        reciclamosApp.getResidues().add(new Recyclable("657", "hoja de papel", 2, "blanco", 5, "hoja arrugada", 1, new Product("987", "Cuaderno Norma", "Cuaderno sencillo")));
        reciclamosApp.getProducts().add(new Product("987", "Cuaderno Norma", "Cuaderno sencillo"));
        reciclamosApp.getProducts().get(2).getMyResidues().add(new Recyclable("657", "hoja de papel", 2, "blanco", 5, "hoja arrugada", 1, new Product("987", "Cuaderno Norma", "Cuaderno sencillo")));

        reciclamosApp.getProducts().add(new Product("749", "fresa", "fresa que no produce residuos relevaltes"));
    }

    public static void main(String[] args) {

        Reciclamos app = new Reciclamos();
        app.init();
        Scanner reader = new Scanner(System.in);
        int optMenu;
        System.out.println(" ");
        System.out.println("                 BIENVENIDO A RECICLEMOS APP, LA APP AMIGA DEL MEDIO AMBIENTE\n\n");
        do {
            System.out.println(MENU1);
            optMenu = Integer.parseInt(reader.next());
            switch (optMenu) {
            case 1:
                app.reciclamosApp.addResidue();
                break;

            case 2:
                app.reciclamosApp.reportResidues();
                break;

            case 3:
                app.reciclamosApp.addProduct();
                break;

            case 4:
                app.reciclamosApp.searchWasteInformation();
                break;

            case 5:
                app.reciclamosApp.listProducts();
                break;

            case 6:
                app.reciclamosApp.harmfulEffect();
                break;

            case 7:
                app.reciclamosApp.itIsUsable();
                break;

            }

            System.out.println("0. Cerrar esta grandiosa app\n1. Volver al menu principal\n");

            optMenu = Integer.parseInt(reader.next());

        } while (optMenu == 1);
        reader.close();
        System.out.println("\nDeveloped by Camilo Cordoba\nPowered by my love for the code :3\n");
    }

}