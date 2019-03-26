import java.util.Date;

public class Cocinero extends Empleado{
	
	public Cocinero(int dni, int antiguedad, Date fechaDeIngreso) {
		super(dni, antiguedad, fechaDeIngreso);
	}
	
	public String trabajar(){
		return "a";
	}

}
