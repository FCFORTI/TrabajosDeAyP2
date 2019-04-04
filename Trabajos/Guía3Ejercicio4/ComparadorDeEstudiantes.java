package Guía3Ejercicio4;
import java.util.Comparator;

public class ComparadorDeEstudiantes implements Comparator<Promedio>{

	@Override
	public int compare(Promedio o1, Promedio o2) {
		if(o1.calcularPromedio() > o2.calcularPromedio()){
			return -1;
		} else if(o1.calcularPromedio() < o2.calcularPromedio()){
			return 1;
		}
		return 0;
	}

}
