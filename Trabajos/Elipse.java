public class Elipse extends Figura  {

	private double radio1;
	private double radio2;
	private Punto centro;
	
	public Elipse(double radio1, double radio2, Punto centro) {
	
		this.radio1 = radio1;
		this.radio2 = radio2;
		this.centro = centro;
			
	}
	
	@Override
	public double area() {
		return Math.PI * radio1 * radio2 ;
	}
	
}
