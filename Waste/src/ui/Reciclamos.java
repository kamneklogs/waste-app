package ui;

import model.*;
import java.util.*;

class Reciclamos{

    private Reciclamos_Master_Class reciclamosApp;
    public static final String MENU1 = "1. Agregar un residuo.\n2. Generar reporte de todos los residuos.\n3. Agregar un producto y los residuos que puede generar.\n4. Buscar informacion de un residuo.\n5. Lista de productos registrados.\n6. Mostrar efecto nosivo de un residuo.\n7. Mostrar si un residuo biodegradable o reciclable es aprovechable.\n8. Mostrar residuos de un producto (De mas a menos nocivo).\n\n9. Salir.";
    
    public Reciclamos(){

        reciclamosApp = new Reciclamos_Master_Class();

    }
    
    

    public static void main(String[] args) {

        Reciclamos app = new Reciclamos();
        Scanner r = new Scanner(System.in);
        int optMenu;
        do {
        	System.out.println(MENU1);
        	optMenu = r.nextInt();
        	switch(optMenu){
        		case 1:
        			app.reciclamosApp.addResidue();
        			break;
            }
            
        	System.out.println("1. Volver al menu principal\n2. Cerrar esta grandiosa app");
            optMenu = r.nextInt();       
         	
        }while(optMenu != 2);

        r.close();
        System.out.println("\nDeveloped by Camilo Cordoba\n\nPowered by my love for the code :3");
    }



	

}