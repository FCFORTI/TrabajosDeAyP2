package Gu�a3Ejercicio4;

import java.util.Arrays;

public class Sistema {

	public static void main(String[] args){
		Personas a = new Estudiante("Paula","Geanetti",40427711,45528778,"Calle paulita","060697",1084169,1);
		Personas b = new Adscripto("Eze","Frete",39960241,45537887,"Calle eze","191096",1523118,2,2,50000);
		Personas c = new Docentes("Franco","Forti",40259787,52930005,"Calle forti","300397",23259787,14,10000);
		
		Personas[] listadoDePersonas = {a,b,c};
		Arrays.sort(listadoDePersonas);
		
		for(int i = 0; i < listadoDePersonas.length; i++){
			System.out.println(listadoDePersonas[i].toString());
		}
		
	}
	
}
