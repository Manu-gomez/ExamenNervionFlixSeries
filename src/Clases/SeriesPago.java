package Clases;


public class SeriesPago extends Serie {
	public static final float FACTORPRECIO = 2;
	private float precio;

	public SeriesPago(String nombre, double valoracion, int numeroCapitulos, float precio,int year,int month,int day) {
		super(nombre, year, month, day, valoracion, numeroCapitulos);
		this.precio = precio; 
	}

	public float getPrecio() {		return precio;	}
	
	/**
	 *	<h1>Postcondicion: </h1>
	 *<p> Este metodo nos calculara el valor especifico, que tendremos en cuenta para calcular IndiceDeRepercucion </p>
	 * @return int
	 */
	@Override
	public int getValorEspecifico() {
		return (int) (getPrecio()*FACTORPRECIO);
	}

	/**
	 * <h1>Postcondicion: </h1>
	 * <p> Este metodo toString mostrara los datos de este objeto pero separados por coma </p>
	 * @return String
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() 
				+ "," + super.getNombre() 
				+ "," + super.getFechaDeEstreno()
				+ "," + super.getValoracion()
				+ "," + super.getNumeroCapitulos()
				+ "," + getPrecio();
	}
	
	/**
	 * <h1>Postcondicion:</h1>
	 * <p>Este metodo devolvera un String que sirve para mostrar por pantalla la informacion de este objeto.</p>
	 * @return String
	 */
	@Override
	public String representacionCadena() {
		return " nombre= " + super.getNombre() 
			+ ", FechaDeEstreno= " + super.getFechaDeEstreno() 
			+ ", valoracion= " + super.getValoracion()
			+ ", numeroCapitulos= " + super.getNumeroCapitulos() 
			+ ", indiceDeRepercucion= " + getIndiceDeRepercucion()
			+ ", precio= " + getPrecio();
	}
	
	/**
	 * <h1>Postcondicion:</h1> 
	 * <p>Se mirara si son el mismo tipo de objeto y luego se comparara segun sus nombres, para saber si son le mismo objeto.</p>
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		boolean esIgual=false;
		if (obj instanceof SeriesPago)
			esIgual= super.getNombre().equals(((SeriesPago)obj).getNombre());
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
