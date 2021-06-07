package Clases;

import java.time.LocalDate;

public class Serie implements Comparable<Serie>{
	public static final int FACTORCAP = 3;
	public static final double FACTORVAL = 1.5;
	public static final double FACTORFINAL = 4;
	private String nombre;
	private LocalDate FechaDeEstreno;
	private double valoracion=5;
	private int numeroCapitulos;
	
	public Serie(String nombre, int year, int month, int day, double valoracion, int numeroCapitulos) {
		this.nombre = nombre;
		FechaDeEstreno = LocalDate.of(year, month, day);
		
		if (valoracion>=0 && valoracion <=10) {
			this.valoracion = valoracion;
		}
		
		this.numeroCapitulos = numeroCapitulos;
	}

	public double getValoracion() {		return valoracion;	}

	public void setValoracion(double valoracion) {		this.valoracion = valoracion;	}

	public String getNombre() {		return nombre;	}

	public LocalDate getFechaDeEstreno() {		return FechaDeEstreno;	}

	public int getNumeroCapitulos() {		return numeroCapitulos;	}

	/**
	 *	<h1>Postcondicion: </h1>
	 *<p> Este metodo nos calculara el valor especifico, que tendremos en cuenta para calcular IndiceDeRepercucion </p>
	 * @return int
	 */
	public int getValorEspecifico() {
		return getNumeroCapitulos()*FACTORCAP;
	}
	
	/**
	 * <h1>Precondicion:</h1>
	 *  <p>Queremos calcular el indice de repercucion que representa la importancia que podría tener la serie para los usuarios en la plataforma</p>
	 * <h1> PostCondicion:</h1>
	 * <p>Utilizamos la valoracion y el numero de capitulo de la serie para hacer un calculo de dicho indice</p>
	 * @return float
	 */
	public float getIndiceDeRepercucion() {
		return (float) ((getValoracion()*FACTORVAL+getValorEspecifico())*FACTORFINAL);	
	}
	
	/**
	 * <h1>Postcondicion: </h1>
	 * <p> Este metodo toString mostrara los datos de este objeto pero separados por coma </p>
	 * @return String
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() 
				+ "," + nombre 
				+ "," + FechaDeEstreno 
				+ "," + valoracion 
				+ "," + numeroCapitulos;
	}
	
	/**
	 * <h1>Postcondicion:</h1>
	 * <p>Este metodo devolvera un String que sirve para mostrar por pantalla la informacion de este objeto.</p>
	 * @return String
	 */
	public String representacionCadena() {
		return " nombre=" + nombre 
				+ ", FechaDeEstreno=" + FechaDeEstreno 
				+ ", valoracion=" + valoracion
				+ ", numeroCapitulos=" + numeroCapitulos 
				+ ", indiceDeRepercucion=" + getIndiceDeRepercucion();
	}
	
	/**
	 * <h1>Postcondicion:</h1> 
	 * <p>Se mirara si son el mismo tipo de objeto y luego se comparara segun sus nombres, para saber si son le mismo objeto.</p>
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		boolean esIgual=false;
		if (obj instanceof Serie)
			esIgual= this.nombre.equals(((Serie)obj).getNombre());
		return esIgual;
	}
	
	/**
	 * El compareTo de String lo hace por orden alfabetico, si el this es comparado 
	 * 		por el del parametro te lo ordena en orden inverso
	 */
	@Override
	public int compareTo(Serie o) {
		return o.getNombre().compareTo(this.getNombre());
	}
	
	
}
