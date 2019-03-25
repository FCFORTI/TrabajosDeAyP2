public class Rectangulo extends Figura{
	
	private double base, altura;
	
	public Rectangulo(double base, double altura){
		this.base = base;
		this.altura = altura;
	}
	
	public double area(){
		return base*altura;
	}

}
