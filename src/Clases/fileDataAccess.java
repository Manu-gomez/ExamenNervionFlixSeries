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
	 * La finalidad de este metodo es add una lista de personas en un fichero de texto.
	 * @param listado
	 * @param file
	 * @throws IOException 
	 */
	public static void addObjetos(List<Serie> listado, File file) throws IOException {
		FileWriter fw= new FileWriter(file);
		BufferedWriter bw= new BufferedWriter(fw);
		
		for (Serie p : listado) {
			bw.write(p.toString());
			bw.newLine();
			bw.flush();
		}
		fw.close();
		bw.close();
	}
	
	/**
	 * Este metodo devuelve una lista con las Series, que tenga el fichero que le pasamos por parametros.
	 *  
	 * @param file
	 * @return List<Persona>
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
		
		fr.close();
		br.close();
	
		return listadevolver;	
	}
	
	/**
	 * Este metodo reconstruira el un objeto Serie segun un array que le pasemos, con todos sus atributos.
	 * @param atributo
	 * @return Serie
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
