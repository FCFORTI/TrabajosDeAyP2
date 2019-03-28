public class Estudiante extends Persona {
	
	private double promedioGeneral;
	private int legajo;
	
	public Estudiante(String dni, String direccion, String telefono,
			String fechaNacimiento, double promedioGeneral, int legajo, String nombre, String apellido) {
		
		super(dni, direccion, telefono, fechaNacimiento, nombre, apellido);
		
		this.promedioGeneral = promedioGeneral;
		this.legajo = legajo;
	
	}
	
	public String toString() {
		return getNombre() + " " + getApellido() + " / Legajo: " + legajo + " / " + "Promedio: " + promedioGeneral;
	}
	
	
}
