public class Triangulo extends Figura{
	
	private double base, altura;
	
	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public double area(){
		return  (base*altura)/2;
	}

	@Override
	public void mover(double incremetoX, double incrementoY) {
		// TODO Apéndice de método generado automáticamente
		
	}

}
