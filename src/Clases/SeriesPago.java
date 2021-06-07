package Clases;

import java.time.LocalDate;

public class SeriesPago extends Serie {
	public static final float FACTORPRECIO = 2;
	private float precio;

	public SeriesPago(String nombre, LocalDate fechaDeEstreno, double valoracion, int numeroCapitulos,
			float indiceDeRepercucion, float precio,int year,int month,int day) {
		super(nombre, year, month, day, valoracion, numeroCapitulos);
		this.precio = precio; 
	}

	/**
	 * 
	 * @return
	 */
	public float getPrecio() {
		return precio;
	}
	
	/**
	 * @return int
	 */
	public int getValorEspecifico() {
		return (int) (getPrecio()*FACTORPRECIO);
	}

	@Override
	public String toString() {
		return super.toString()+ precio + ", toString()="  ;
	}
	
	//TODO Meter toString, representacionCadena, equals, compareTo

	
}
