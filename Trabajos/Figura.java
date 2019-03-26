public abstract class Figura {
	
	public static void main(String[] args){
		
		Figura figuras[] = new Figura[3];
		figuras[0] = new Rectangulo(3,6);
		figuras[1] = new Cuadrado(4);
		figuras[2] = new Triangulo(2,3);
		
		for(int i=0; i < figuras.length; i++){
			System.out.println(figuras[i].area());
		}
		
	}
	
	public abstract double area();

}
