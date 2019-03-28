public abstract class Persona implements Comparable <Persona> {

	private String dni, direccion, telefono,fechaNacimiento, nombre, apellido;

	public Persona(String dni, String direccion, String telefono,
			String fechaNacimiento, String nombre, String apellido) {
		
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public abstract String toString();
	
	@Override
	public int compareTo(Persona other) {
		
		int result;
		result = this.nombre.compareTo(other.nombre);
		
		if (result == 0) {
			result = this.apellido.compareTo(other.nombre);
		}
		
		return result;
	}
	
}

