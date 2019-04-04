package Guía3Ejercicio4;

public class Adscripto extends Estudiante{
	
	private int cantMaterias;
	private double sueldoBase;
	
	public Adscripto(String nombre, String apellido,int dni, int telefono, String direccion, String fechaDeNacimiento, int legajo, double promedio, int cantMaterias, double sueldoBase){
		super(nombre,apellido,dni,telefono,direccion,fechaDeNacimiento,legajo,promedio);
		if(cantMaterias>3){
			this.cantMaterias = 3;
		} else {
			this.cantMaterias = cantMaterias;
		}		
		this.sueldoBase = sueldoBase;
	}

	@Override
	public double calcularSueldo() {
		return sueldoBase*cantMaterias;
	}

	public int getCantMaterias() {
		return cantMaterias;
	}

	public void setCantMaterias(int cantMaterias) {
		this.cantMaterias = cantMaterias;
	}

}
