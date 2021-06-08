package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	/**
	 * 
	 */
	public static void pantallaMenu() {
		System.out.println("Elige un numero:");
		System.out.println("1 Menú impresión:");
		System.out.println("2 Menú cálculos:");
		System.out.println("3 Menú gestión:");
	}	
	
	/**
	 * 
	 *///TODO Comentar
	public static void casoMenu1() {
		System.out.println("Imprimir listado en pantalla de todas las series estrenadas en un año dado por el usuario. ");
		//TODO RESGUARDO
	}
	
	/**
	 * 
	 * @param sc
	 *///TODO Comentar
	public static void casoMenu2(Scanner sc,File file) {
		System.out.println("Elige una letra a y b:");
		System.out.println("a. Sumatorio del precio de las series de pago de la plataforma. Solo queremos saber el número resultante. ");
		System.out.println("b. Mostrar los datos por pantalla de la serie con mayor índiceDeRepercursion.");

		String letra=sc.next();
		switch (letra) {
		case "a": {
				System.out.println("Sumatorio del precio de las series de pago de la plataforma. Solo queremos saber el número resultante. ");
				try {
					System.out.println(sumatorioPrecioPago(file)); 
				} catch (IOException e) {	e.printStackTrace();			}	
				break;
				
			}
		case "b": {
				System.out.println("Mostrar los datos por pantalla de la serie con mayor índiceDeRepercursion.");
				try {
					serieMayorRepercusion(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		default:
			System.out.println("Eso es invalido");
		}
	}
	

	/**
	 * 
	 * @param sc
	 *///TODO Comentar
	public static void casoMenu3(Scanner sc,File file) {
		System.out.println("Escribe a si quiere aniadir una serie nueva al fichero \n Escribe b si desea borrar una serie");
		String letra=sc.next();
		switch (letra) {
		case "a": {
				System.out.println("Aniadir una serie nueva al archivo. ");
				menuAddSerie(sc,file);
				break;
			}
		case "b": {
				System.out.println("Borrar una serie");
				//TODO EN PROCESO 
				break;
			}
		default:
			System.out.println("Eso es invalido");
		}
	}

	/**
	 * @throws IOException 
	 *
	 *///TODO Comentar
	private static float sumatorioPrecioPago(File file) throws IOException {
		float cuenta=0;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linea=null;
		String[] arrayaux=null;
		while((linea=br.readLine())!= null) {
			arrayaux=linea.split(",");
			if (arrayaux[0].equals("SeriesPago")) {
				cuenta+=Float.parseFloat(arrayaux[5]);
			}
		}	
		br.close();
		fr.close();
		return cuenta;
	}
	
	/**
	 * 
	 * @throws IOException 
	 *///TODO COMENTAR
	private static void serieMayorRepercusion(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String linea=null;
		Serie serie=null;
		Serie aux=null;
		String [] lista;
		String[] fecha;
		while((linea=br.readLine())!= null) {
			lista=linea.split(",");
			fecha=lista[2].split("-");
			if (lista[0].getClass().getSimpleName().equals(SeriesPago.class.getSimpleName())) {
				serie=fileDataAccess.reconstruirSeriePago(lista, fecha);
			}else {
				serie=fileDataAccess.reconstruirSerie(lista,fecha);
			}
			if (aux==null) {
				aux=serie;
			}else if (aux.getIndiceDeRepercucion()<serie.getIndiceDeRepercucion()) {
				aux=serie;
			}
			
		}
		System.out.println(aux.representacionCadena()); 
		br.close();
		fr.close();
	}
	
	/**
	 * 
	 *///TODO COMENTAR
	private static void menuAddSerie(Scanner sc, File file) {
		System.out.println("Escriba 1 si quiere aniadir una serie \n Escriba 2 si quiere aniadir una Serie de Pago");
		int clave=sc.nextInt();
		switch (clave) {
		case 1: {
			System.out.println("Aniadir Serie");
			//Llamada metodo obtenerDatosSerie para obtener la serie
			//Llamada al metodo addSerie
			try {
				fileDataAccess.addObjetos(obtenerDatosSerie(sc), file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		case 2: {
			System.out.println("Aniadir Serie de Pago");
			//Llamada metodo obtenerDatosSeriePago para obtener la serie
			//Llamada al metodo addSerie
			try {
				fileDataAccess.addObjetos(obtenerDatosSeriePago(sc), file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			break;
		}
		default:
			System.out.println("Dato incorrecto");
		}
	}

	/**
	 * 
	 * @param sc
	 * @return
	 *///TODO COMENTAR
	private static Serie obtenerDatosSerie(Scanner sc) {
		Serie serie=null;
		String snombre=null;
		int syear=0;
		int smonth=0;
		int sday=0;
		double sval=0;
		int snum=0;
		
		System.out.println("Cual es el nombre de la serie");
		snombre=sc.next();
		System.out.println("Cual es el anio de la serie");
		syear=sc.nextInt();
		System.out.println("Cual es el mes de la serie");
		smonth=sc.nextInt();
		System.out.println("Cual es el dia de la serie");
		sday=sc.nextInt();
		System.out.println("Cual es la valoracion de la serie");
		sval=sc.nextDouble();
		System.out.println("Cual es el numero de capitulos de la serie");
		snum=sc.nextInt();
		
		serie=new Serie(snombre, syear, smonth, sday, sval, snum);
		
		return serie;
	}

	/**
	 * 
	 * @param sc
	 * @return
	 *///TODO COMENTAR
	private static Serie obtenerDatosSeriePago(Scanner sc) {
		SeriesPago serie=null;
		String snombre=null;
		int syear=0;
		int smonth=0;
		int sday=0;
		double sval=0;
		int snum=0;
		float sprecio=0;
		
		System.out.println("Cual es el nombre de la serie");
		snombre=sc.next();
		System.out.println("Cual es el anio de la serie");
		syear=sc.nextInt();
		System.out.println("Cual es el mes de la serie");
		smonth=sc.nextInt();
		System.out.println("Cual es el dia de la serie");
		sday=sc.nextInt();
		System.out.println("Cual es la valoracion de la serie");
		sval=sc.nextDouble();
		System.out.println("Cual es el numero de capitulos de la serie");
		snum=sc.nextInt();
		System.out.println("Cuanto vale esta serie");
		sprecio=sc.nextFloat();
		
		serie=new SeriesPago(snombre, sval, snum, sprecio, syear, smonth, sday);	
		
		return serie;
	}

}
