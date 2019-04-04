package Guía3Ejercicio4;
import java.util.Comparator;

public class ComparadorDeEstudiantes implements Comparator<Estudiante>{

	@Override
	public int compare(Estudiante o1, Estudiante o2) {
		if(o1.getPromedio() > o2.getPromedio()){
			return -1;
		} else if(o1.getPromedio() < o2.getPromedio()){
			return 1;
		}
		return 0;
	}

}
