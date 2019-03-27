public class Rectangulo extends Figura {
	
	private double base, altura;
	private Punto esquinaInferiorIzq, esquinaSuperiorDer;
	
	public Rectangulo(Punto esquinaInferiorIzq, Punto esquinaSuperiorDer) {
		
		this.esquinaInferiorIzq = esquinaInferiorIzq;
		this.esquinaSuperiorDer = esquinaSuperiorDer;
		
		this.base = esquinaSuperiorDer.getX() - esquinaInferiorIzq.getX();
		this.altura = esquinaSuperiorDer.getY() - esquinaInferiorIzq.getY();
		
	}

	@Override
	public double area() {
		return base*altura;
	}

	@Override
	public void mover(double incremetoX, double incrementoY) {
		
		esquinaSuperiorDer.mover(incremetoX, incrementoY);
		esquinaInferiorIzq.mover(incremetoX, incrementoY);
		
	}


}
