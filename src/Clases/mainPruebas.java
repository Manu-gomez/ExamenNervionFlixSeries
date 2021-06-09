package Clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class mainPruebas {

	public static void main(String[] args) {
		final String FILE=".//src//Catalogo.txt";
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
	
	}
	

}
