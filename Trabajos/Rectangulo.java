public class Rectangulo extends Figura{
	
	private double base, altura;
	
	public Rectangulo(double base, double altura){
		if(base<0 || altura<0){
			throw new Error("Los lados ingresados debem ser mayores a 0.");
		}
		this.base = base;
		this.altura = altura;
	}
	
	public double area(){
		return base*altura;
	}

}
