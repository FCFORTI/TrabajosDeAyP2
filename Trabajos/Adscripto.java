public class Adscripto extends Estudiante implements Sueldo {
	
	private double sueldoBase;
	private int materiasAdscriptas;
	
	public Adscripto(String dni, String direccion, String telefono,
			String fechaNacimiento, double promedioGeneral, int legajo, double sueldoBase, int materiasAdscriptas, String nombre, String apellido) {
		
		super(dni, direccion, telefono, fechaNacimiento, promedioGeneral, legajo, nombre, apellido);
		
		this.sueldoBase = sueldoBase;
		this.materiasAdscriptas = materiasAdscriptas;
	
	}
	
	@Override
		
	public double calcularSueldo() {
		return this.sueldoBase * this.materiasAdscriptas;
	}
	
	

}
