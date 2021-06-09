package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

	/**
	 * <h1> Postcondicion: </h1>
	 * <p> Este metodo tiene la funcionalidad de enseñar el menu por la pantalla. </p>
	 */
	public static void pantallaMenu() {
		System.out.println("Elige un numero:");
		System.out.println("1 Menú impresión:");
		System.out.println("2 Menú cálculos:");
		System.out.println("3 Menú gestión:");
	}	
	
	/**
	 * Cabecera: public static void casoMenu1() <br>
	 * Descripcion: Este metodo imprime por pantalla el primer submenu<br>
	 * Precondiciones:  <br>
	 * Postcondiciones: Se enseniara por pantalla el submenu <br>
	 * Entrada:  <br>
	 * Salida: <br>
	 * @param <br>
	 * @return <br>
	 */	
	public static void casoMenu1() {
		System.out.println("Imprimir listado en pantalla de todas las series estrenadas en un año dado por el usuario. ");
		// RESGUARDO
	}
	
	/**
	 * Cabecera: public static void casoMenu2(Scanner sc, File file) <br>
	 * Descripcion: Este metodo imprime por pantalla el segundo submenu, y te da ha elegir entre sus opciones.<br>
	 * Precondiciones: El Scanner no puede ser null y el file tiene que existir y ser distinto de null <br>
	 * Postcondiciones: Se enseniara por pantalla su menu y te dara ha elegir entre sus dos opciones.<br>
	 * Entrada: Scanner sc, File file <br>
	 * Salida: <br>
	 * @param sc, file <br>
	 * @return <br>
	 */	
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
	 * Cabecera: public static void casoMenu3(Scanner sc,File file) <br>
	 * Descripcion: Este metodo imprime por pantalla el tercero submenu, y te da ha elegir entre sus opciones.<br>
	 * Precondiciones: El Scanner no puede ser null y el file tiene que existir y ser distinto de null <br>
	 * Postcondiciones: Se enseniara por pantalla su menu y te dara ha elegir entre sus dos opciones.<br>
	 * Entrada: Scanner sc, File file <br>
	 * Salida: <br>
	 * @param sc, file <br>
	 * @return <br>
	 */	
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
				// EN PROCESO 
				break;
			}
		default:
			System.out.println("Eso es invalido");
		}
	}

	/**
	 * Cabecera: private static float sumatorioPrecioPago(File file) throws IOException <br>
	 * Descripcion: Este metodo lee por lineas el fichero y cogiendo los datos de cada Serie de Pago sumara su precio.<br>
	 * Precondiciones: El file tiene que existir y ser distinto de null. <br>
	 * Postcondiciones: Lee cada linea del fichero, comprueba si el objeto que lee es una Serie de Pago, si lo es guarda y suma su precio.<br>
	 * Entrada: File file <br>
	 * Salida: float <br>
	 * @param file <br>
	 * @return float <br>
	 * @throws IOExeption
	 */	
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
	 * Cabecera: private static void serieMayorRepercusion(File file) throws IOException <br>
	 * Descripcion: Este metodo coge los datos de cada Serie del fichero y busca la serie con mayor .<br>
	 * Precondiciones: El file tiene que existir y ser distinto de null. <br>
	 * Postcondiciones: Lee cada linea del fichero, consigue su Indice de repercusion y lo guarda para compararlo con la siguiente serie, acaba guardando el que tenga mayor.<br>
	 * Entrada: File file <br>
	 * Salida:  <br>
	 * @param file <br>
	 * @return  <br>
	 * @throws IOExeption
	 */	
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
	 * Cabecera: private static void menuAddSerie(Scanner sc, File file) <br>
	 * Descripcion: Este metodo muestra por pantalla un menu que le preguntara al usuario que tipo de serie quiere anhadir y te da a elegir entre dos opciones<br>
	 * Precondiciones: El Scanner tiene que ser distinto de null y el file tiene que existir y ser distinto de null. <br>
	 * Postcondiciones: Tiene que mostrar al usuario el siguiente metodo<br>
	 * Entrada: Scanner sc,File file <br>
	 * Salida:  <br>
	 * @param sc,file <br>
	 * @return  <br>
	 */	
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
	 * Cabecera: private static Serie obtenerDatosSerie(Scanner sc) <br>
	 * Descripcion: Este metodo le pide al usuario que introduzca los datos para crear una serie y la crea<br>
	 * Precondiciones: El Scanner tiene que ser distnto de null <br>
	 * Postcondiciones: Habra creado una serie<br>
	 * Entrada: Scanner sc <br>
	 * Salida: Serie <br>
	 * @param sc <br>
	 * @return serie <br>
	 */	
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
	 * Cabecera: private static Serie obtenerDatosSerie(Scanner sc) <br>
	 * Descripcion: Este metodo le pide al usuario que introduzca los datos para crear una serie y la crea<br>
	 * Precondiciones: El Scanner tiene que ser distnto de null <br>
	 * Postcondiciones: Habra creado una serie<br>
	 * Entrada: Scanner sc <br>
	 * Salida: Serie <br>
	 * @param sc <br>
	 * @return serie <br>
	 */	
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
