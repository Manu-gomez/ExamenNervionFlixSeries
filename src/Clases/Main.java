package Clases;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final String FILE=".//src//Catalogo.txt";
		Scanner sc= new Scanner(System.in);
		int clave=0;
		File filetext= new File(FILE);
		
		do {
			Menu.pantallaMenu();	
			clave=sc.nextInt();
			switch (clave) {
			case 1: {
				System.out.println("Menu impresion");
				Menu.casoMenu1();
				break;
			}
			case 2: {
				System.out.println("Menu calculos");
				Menu.casoMenu2(sc, filetext);
				break;
			}
			case 3: {
				System.out.println("Menu gestion");
				Menu.casoMenu3(sc,filetext);
				break;
			}
			default:
				System.out.println("Fallo");
				break;
			}
		} while (clave>0&&clave<4);
		
		}

}
