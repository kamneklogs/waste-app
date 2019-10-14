package ui;

import model.*;
import java.util.*;

class Reciclamos {

    private Reciclamos_Master_Class reciclamosApp;
    public static final String MENU1 = "\n\n 1. Agregar un residuo.\n 2. Generar reporte de todos los residuos.\n 3. Agregar un producto y los residuos que puede generar.\n 4. Buscar informacion de un residuo.\n 5. Lista de productos registrados.\n 6. Mostrar efecto nosivo de un residuo.\n 7. Mostrar si un residuo biodegradable o reciclable es aprovechable.\n 8. Mostrar residuos de un producto (De mas a menos nocivo).\n 9. Salir.\n";
    

    public Reciclamos() {
        reciclamosApp = new Reciclamos_Master_Class();
    }

    public static void main(String[] args) {

        Reciclamos app = new Reciclamos();
        Scanner reader = new Scanner(System.in);
        int optMenu;
        System.out.println(" ");
        System.out.println("                 BIENVENIDO A RECICLEMOS APP, LA APP AMIGA DEL MEDIO AMBIENTE\n\n");
        do {
            System.out.println(MENU1);
            optMenu = reader.nextInt();
            switch (optMenu) {
            case 1:
                app.reciclamosApp.addResidue();
                break;

            case 2:
                app.reciclamosApp.reportResidues();
                break;
            }

            System.out.println("0. Cerrar esta grandiosa app\n1. Volver al menu principal\n");

            optMenu = reader.nextInt();

        } while (optMenu == 1);
        reader.close();
        System.out.println("\nDeveloped by Camilo Cordoba\nPowered by my love for the code :3\n");
    }

}