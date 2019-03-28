public class Docente extends Persona implements Sueldo{
	
	private String cuil;
	private int antiguedad; 
	private double sueldoBase;
	
	public Docente(String dni, String direccion, String telefono,
			String fechaNacimiento, String cuil, int antiguedad, double sueldoBase, String nombre, String apellido) {
		
		super(dni, direccion, telefono, fechaNacimiento, nombre, apellido);
		
		this.cuil = cuil;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
	
	}
	
	@Override
	public String toString() {
		return getNombre() + " " +getApellido() + " / Sueldo: " + calcularSueldo();
	}
	
	@Override
	public double calcularSueldo() {
		
		double sueldoFinal;
		
		if (antiguedad <= 10) {
			
			sueldoFinal = this.sueldoBase + ( this.sueldoBase * 10/100 );
			
		} else if (antiguedad > 10 && antiguedad <= 15) {
			
			sueldoFinal = this.sueldoBase + ( this.sueldoBase * 15/100 );
		
		} else if (antiguedad > 15 && antiguedad <= 20) {
			
			sueldoFinal = this.sueldoBase + ( this.sueldoBase * 20/100 );
			
		} else {
			
			sueldoFinal = this.sueldoBase + ( this.sueldoBase * 25/100 );
			
		}
		
		return sueldoFinal;
	}

}
