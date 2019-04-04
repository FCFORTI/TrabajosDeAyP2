package Gu�a3Ejercicio4;

public class Docentes extends Personas implements Sueldo{

	private int cuil, antiguedad;
	private double sueldoBase;
	
	public Docentes(String nombre, String apellido,int dni, int telefono, String direccion, String fechaDeNacimiento, int cuil, int antiguedad, double sueldoBase){
		super(nombre,apellido,dni,telefono,direccion,fechaDeNacimiento);
		this.cuil = cuil;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
	}
	
	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	@Override
	public double calcularSueldo() {
		double sueldoFinal = this.sueldoBase;
		if(antiguedad <= 10){
			sueldoFinal = 0.10*sueldoBase;
		}
		if(antiguedad > 10 && antiguedad <= 15){
			sueldoFinal = 0.15*sueldoBase;
		}
		if(antiguedad > 15 && antiguedad <= 20){
			sueldoFinal = 0.20*sueldoBase;
		}
		if(antiguedad > 20){
			sueldoFinal = 0.25*sueldoBase;
		}
		return sueldoFinal;
	}
	
	@Override
	public String toString() {
		return "Docente [nombre=" + super.getNombre() + " "
				+ super.getApellido() +  ", remuneracio=" + calcularSueldo() + "]";
	}

}
