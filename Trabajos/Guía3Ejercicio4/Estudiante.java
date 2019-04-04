package Guía3Ejercicio4;

public class Estudiante extends Personas implements Promedio{

	private int legajo;
	private double promedio;
	
	public Estudiante(String nombre, String apellido,int dni, int telefono, String direccion, String fechaDeNacimiento, int legajo, double promedio){
		super(nombre,apellido,dni,telefono,direccion,fechaDeNacimiento);
		this.legajo = legajo;
		this.promedio = promedio;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	@Override
	public double calcularSueldo() {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	@Override
	public double calcularPromedio() {
		return this.promedio;
	}
	
}
