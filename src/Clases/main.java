package Clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		final String FILE=".//src//Catalogo.txt";
		Scanner sc= new Scanner(System.in);
		int clave=0;
		File filetext= new File(FILE);
		
		Serie s1=new Serie("Dracula", 1990, 5, 12, 6, 18);
		Serie s2=new SeriesPago("Arrow", 8, 169, 5, 2013, 8, 5);
		Serie s3=new Serie("Shameless US", 2010, 9, 6, 10, 140);

		List<Serie> listado=new ArrayList<>();
		listado.add(s2);
		listado.add(s3);
		listado.add(s1);		
		try {
			fileDataAccess.addObjetos(listado, filetext);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*List<Serie> listaDevuelta=null;
		try {
			File filetext= new File(FILE);
			
			listaDevuelta=fileDataAccess.obtenerListaObjetosFichero(filetext);
			
			for (Serie s : listaDevuelta) {
				System.out.println(s.representacionCadena());
			}
		} catch (IOException e) {

		}*/	
		
		//System.out.println();
		//Collections.sort(listado);//TODO Hacer metodo para ordenar la lista que saque del fichero 
			//TODO y entonces despues si que puedo enseniar el listado del ficero ya ordenado por pantalla
	
		/*try {
			File filetext= new File(FILE);
			fileDataAccess.addObjetos(listado, filetext);
			listaDevuelta=fileDataAccess.obtenerListaObjetosFichero(filetext);
			
			for (Serie s : listaDevuelta) {
				System.out.println(s.representacionCadena());
			}
		} catch (IOException e) {

		}	*/
	

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
