package Guía3Ejercicio4;

import java.util.Arrays;

public class Sistema {

	public static void main(String[] args){
		Personas a = new Estudiante("Paula","Geanetti",40427711,45528778,"Calle paulita","060697",1084169,1);
		Adscripto b = new Adscripto("Ezequiel","Frete",39960241,45537887,"Calle eze","191096",1523118,2,2,50000);
		Docentes c = new Docentes("Franco","Forti",40259787,52930005,"Calle forti","300397",23259787,14,10000);
		Docentes d = new Docentes("Pedro","Perez",40259788,52930006,"Calle pedro","310397",23234564,8,10000);
		
		
		Personas[] listadoDePersonas = {a,b,c,d};
		Arrays.sort(listadoDePersonas);
		
		for(int i = 0; i < listadoDePersonas.length; i++){
			System.out.println(listadoDePersonas[i].toString());
		}
		
		Docentes[] listadoDeDocentes = {c,d};
		Adscripto[] listadoDeAdscriptos = {b};
		listadoDeRemuneracion(listadoDeDocentes, listadoDeAdscriptos);
		
	}
	
	static void listadoDeRemuneracion(Docentes[] docentes, Adscripto[] adscriptos){
		Arrays.sort(docentes, new ComparadorDeDocentes());		
		for(int i = 0; i < docentes.length; i++){
			System.out.println(docentes[i].toString());
		}
		
		Arrays.sort(adscriptos, new ComparadorDeAdscriptos());		
		for(int i = 0; i < adscriptos.length; i++){
			System.out.println(adscriptos[i].toString());
		}
		
	}
	
	static void listadoDeAlumnos(Estudiante[] estudiantes){
		Arrays.sort(estudiantes, new ComparadorDeEstudiantes());
		
		for(int i = 0; i < estudiantes.length; i++){
			System.out.println(estudiantes[i].toString());
		}
		
	}
	
}
