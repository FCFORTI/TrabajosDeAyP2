import java.util.Arrays;

public class Sistema {

	public static void main(String[] args) {
		
		Persona a = new Estudiante("22651192","Caseros 1","47529088","2172", 7, 50049,"Agustin", "Perez");
		Persona b = new Estudiante("22651192","Caseros 1","47529088","2172", 6, 50050,"Juan", "Lopez");
		Persona c = new Estudiante("22651192","Caseros 1","47529088","2172", 9, 50050,"Agustin", "Gonzales");
		Persona d = new Docente("41393532","Bazzini 1874","1560010001", "6199","2012347", 3, 1600,"Bruno","Rodas");
		Persona e = new Docente("41393532","Bazzini 1874","1560010001", "6199","2012347", 3, 1700,"Gaston","Mina");
		Persona f = new Docente("41393532","Bazzini 1874","1560010001", "6199","2012347", 3, 1500,"Gaston","Ferreira");

		
		Persona[] listadoPersonas = {a,b,c,d,e,f};
		Arrays.sort(listadoPersonas);

		for (int i = 0 ; i < listadoPersonas.length ; i++) {
			
			System.out.println(listadoPersonas[i].toString());
		
		}
		
	}
}
