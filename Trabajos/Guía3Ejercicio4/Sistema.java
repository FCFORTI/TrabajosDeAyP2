package Guía3Ejercicio4;

import java.util.Arrays;

public class Sistema {

	public static void main(String[] args){
		Personas a = new Estudiante("Paula","Geanetti",40427711,45528778,"Calle paulita","060697",1084169,1);
		Personas b = new Adscripto("Ezequiel","Frete",39960241,45537887,"Calle eze","191096",1523118,2,2,50);
		Personas c = new Docentes("Franco","Forti",40259787,52930005,"Calle forti","300397",23259787,14,10000);
		Personas d = new Docentes("Pedro","Perez",40259788,52930006,"Calle pedro","310397",23234564,28,10000);	
		
		Personas[] listadoDePersonas = {a,b,c,d};

		listadoDePersonas(listadoDePersonas);
		listadoDeRemuneracion(listadoDePersonas);
		listadoDePromedios(listadoDePersonas);
	}
	
	static void listadoDePersonas(Personas[] personas){
		System.out.println("Lista de personas:");
		Arrays.sort(personas);		
		for(int i = 0; i < personas.length; i++){
			System.out.println(personas[i].toString());
		}
	}
	
	static void listadoDeRemuneracion(Personas[] remunerados){
		System.out.println("Lista de remunerados:");
		Arrays.sort(remunerados, new ComparadorDeRemunerados());		
		for(int i = 0; i < remunerados.length; i++){
			System.out.println(remunerados[i].toString());
		}		
	}
	
	static void listadoDePromedios(Personas[] estudiantes){
		System.out.println("Lista de promedios:");
		Arrays.sort(estudiantes, new ComparadorDeEstudiantes());	
		for(int i = 0; i < estudiantes.length; i++){
			System.out.println(estudiantes[i].toString());
		}
	}
	
}
