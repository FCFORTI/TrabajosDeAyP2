package Gu�a3Ejercicio4;

public abstract class Personas implements Comparable<Personas>, Sueldo, Promedio{
	
	private int dni, telefono;
	private String direccion, fechaDeNacimiento, nombre, apellido;
	
	public Personas(String nombre, String apellido,int dni, int telefono, String direccion, String fechaDeNacimiento){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	@Override
	public String toString() {
		return "Personas [Nombre:" + apellido + " " + nombre;
	}
	
	@Override
	public int compareTo(Personas other){
		int result;
		result = this.apellido.compareTo(other.apellido);
		
		if (result == 0) {
			result = this.nombre.compareTo(other.nombre);
		}
		
		return result;
	}
	

}
