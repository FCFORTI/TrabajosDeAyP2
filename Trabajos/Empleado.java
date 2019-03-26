import java.util.Date;

public  abstract class Empleado {
	
	private int dni, antiguedad;
	private Date fechaDeIngreso;
	
	public Empleado(int dni, int antiguedad, Date fechaDeingreso){
		
		this.dni = dni;
		this.antiguedad = antiguedad;
		this.fechaDeIngreso = fechaDeingreso;
		
	}
	
	public abstract String trabajar();

}
