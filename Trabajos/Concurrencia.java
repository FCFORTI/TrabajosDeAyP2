import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Concurrencia {
	
	public static void main(String[] args) {
		
		HashMap <String, List<String>> entrada = new HashMap <String, List<String>>(); 
		
		//
		//
	
		LinkedList<String> diasDeAna = new LinkedList<String>();
		diasDeAna.add("Mie 10");
		diasDeAna.add("Vie 12");
		entrada.put("Ana",diasDeAna);
		
		LinkedList<String> diasDeLuz = new LinkedList<String>();
		diasDeLuz.add("Vie 12");
		diasDeLuz.add("Mie 17");
		entrada.put("Luz", diasDeLuz);
		
		LinkedList<String> diasDePedro = new LinkedList<String>();
		diasDePedro.add("Mie 10");
		diasDePedro.add("Mie 17");
		entrada.put("Pedro", diasDePedro);
	
		Map <String, TreeSet<String> > resultado = new HashMap< String, TreeSet<String> >();
		
		
		
		for (String persona : entrada.keySet()) {
			
			List<String> fechas = entrada.get(persona);
				
				for (String fecha : fechas) {
					
					if(resultado.containsKey(fecha)) {
						resultado.get(fecha).add(persona);
					} else {
						TreeSet<String> nuevo = new TreeSet<String>();
						nuevo.add(persona);
						resultado.put(fecha, nuevo);
					}
				}
		}
		
		System.out.println(resultado);
	
	}
	
	
	
	
}
