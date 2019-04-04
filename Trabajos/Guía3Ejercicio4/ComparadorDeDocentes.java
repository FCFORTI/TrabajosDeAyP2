package Gu�a3Ejercicio4;
import java.util.Comparator;

public class ComparadorDeDocentes implements Comparator<Sueldo>{

	@Override
	public int compare(Sueldo o1, Sueldo o2) {
		if(o1.calcularSueldo() > o2.calcularSueldo()){
			return -1;
		} else if(o1.calcularSueldo() < o2.calcularSueldo()){
			return 1;
		}
		return 0;
	}

}
