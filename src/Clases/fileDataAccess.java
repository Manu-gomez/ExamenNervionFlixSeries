package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileDataAccess {
	
	
	/**
	 * Cabecera: public static void addObjetos(Serie serie, File file) throws IOException <br>
	 * Descripcion: La finalidad de este metodo es add una serie en un fichero de texto.<br>
	 * Precondiciones: La serie introducida no puede ser null, ni tampoco el file. <br>
	 * Postcondiciones: Se aniadira un objeto serie al fichero.<br>
	 * Entrada: Serie serie, File file <br>
	 * Salida: <br>
	 * @param serie, file<br>
	 * @return <br>
	 * @throws IOException
	 */	
	public static void addObjetos(Serie serie, File file) throws IOException {
		FileWriter fw= new FileWriter(file,true);
		BufferedWriter bw= new BufferedWriter(fw);
	
		try {
			bw.write(serie.toString());
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Cabecera: public static void addObjetos(List<Serie> listado, File file) throws IOException <br>
	 * Descripcion: La finalidad de este metodo es add una lista de series en un fichero de texto.<br>
	 * Precondiciones: La serie introducida no puede ser null, ni tampoco el file. <br>
	 * Postcondiciones: Se aniadira una lista de objetos serie al fichero.<br>
	 * Entrada: List<Serie> listado, File file <br>
	 * Salida: <br>
	 * @param listado, file<br>
	 * @return <br>
	 * @throws IOException
	 */	
	public static void addObjetos(List<Serie> listado, File file) throws IOException {
		FileWriter fw= new FileWriter(file,true);
		BufferedWriter bw= new BufferedWriter(fw);
		
		try {
			for (Serie p : listado) {
				bw.write(p.toString());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Cabecera: public static List<Serie> obtenerListaObjetosFichero(File file) throws IOException <br>
	 * Descripcion: Este metodo devuelve una lista con las Series, que tenga el fichero que le pasamos por parametros.<br>
	 * Precondiciones: El fichero introducido no puede ser null <br>
	 * Postcondiciones: Se aniadira una lista de objetos serie al fichero.<br>
	 * Entrada: File file <br>
	 * Salida: <br>
	 * @param file<br>
	 * @return List<Serie><br>
	 * @throws IOException
	 */	
	public static List<Serie> obtenerListaObjetosFichero(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String linea=null;
		Serie s=null;
		List<Serie> listadevolver=new ArrayList<>();
		String [] lista;
		String[] fecha;

		try {
			while((linea=br.readLine())!= null) {
				lista=linea.split(",");
				fecha=lista[2].split("-");
				if (lista[0].getClass().getSimpleName().equals(SeriesPago.class.getSimpleName())) {
					s=reconstruirSeriePago(lista, fecha);
				}else {
					s=reconstruirSerie(lista,fecha);
				}
				listadevolver.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return listadevolver;	
	}
	
	/**
	 * Cabecera: public static Serie reconstruirSerie(String[] atributo,String[] fecha) <br>
	 * Descripcion:Este metodo reconstruira el un objeto Serie segun un array que le pasemos, con todos sus atributos.<br>
	 * Precondiciones: Ninguna de las dos arrays introducids pueden ser null <br>
	 * Postcondiciones: Se aniadira una lista de objetos serie al fichero.<br>
	 * Entrada: String[] atributo,String[] fecha <br>
	 * Salida: <br>
	 * @param atributo, fecha<br>
	 * @return Serie<Serie><br>
	 * @throws IOException
	 */	
	public static Serie reconstruirSerie(String[] atributo,String[] fecha) {
		return new Serie(atributo[1],Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]), Double.parseDouble(atributo[3]), Integer.parseInt(atributo[4]));
		
	}
	/**
	 * Este metodo reconstruira el un objeto Serie segun un array que le pasemos, con todos sus atributos.
	 * @param atributo
	 * @return Serie
	 */
	public static Serie reconstruirSeriePago(String[] atributo,String[] fecha) {
		return new SeriesPago(atributo[1],Double.parseDouble(atributo[3]), Integer.parseInt(atributo[4]), Float.parseFloat(atributo[5]), Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]));
	}
}
