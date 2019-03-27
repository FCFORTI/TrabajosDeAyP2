public abstract class Figura implements Comparable <Figura>, Movible {

	public static void main(String[] args) {
		
		Figura figuras[] = new Figura[1];
		figuras[0] = new Rectangulo(new Punto(3,3), new Punto(3,3));
		
		for(int i = 0; i < figuras.length; i++){
			System.out.println(figuras[i].area());
		}

	}
	
	public abstract double area();
	
	@Override
	public int compareTo(Figura arg0) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}
	
}
