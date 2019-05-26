import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Sistema {
	
	private TreeMap <String, Visitante> diccionarioUsuarios = new TreeMap <String, Visitante>();
	private TreeMap <String, Atraccion> diccionarioAtracciones = new TreeMap <String, Atraccion>();
	private TreeMap <String, Promocion> diccionarioPromociones = new TreeMap <String, Promocion>();

	public static void main(String[] args) throws IOException {
		
		Sistema sistema = new Sistema();
		
		sistema.cargarUsuarios();
		sistema.cargarAtracciones();
		sistema.cargarPromociones();
		
		boolean quieraSeguir = true;
		
		while (quieraSeguir) {	
		
			int flag = 1;
			String nombrePantalla = "";
			
			while (flag !=0) {
				System.out.println("Ingrese nombre del turista:");
				Scanner sc = new Scanner(System.in);
				nombrePantalla = sc.nextLine();
			
				if (sistema.getDiccionarioUsuarios().containsKey(nombrePantalla)) {
					System.out.println("¡Hola " + nombrePantalla + "!");
					flag = 0;
				}
				else {
					System.out.println("Ingrese un nombre de turista correcto.");
				}
			}
			System.out.println("Se encontro tu usuario - Tus atributos son: " + sistema.getDiccionarioUsuarios().get(nombrePantalla));
			
			Visitante usuarioIngresado = sistema.diccionarioUsuarios.get(nombrePantalla);
			
			ArrayList<Atraccion> listaAtracciones = sistema.generarListadoAtraccionesOrdenado(sistema.diccionarioAtracciones);
			ArrayList<Promocion> listaPromociones = sistema.generarListadoPromocionesOrdenado(sistema.diccionarioPromociones);
			
			ArrayList<Atraccion> atraccionesInteresadas = new ArrayList <Atraccion>(), atraccionesSinInteres = new ArrayList <Atraccion>();
			ArrayList<Promocion> promocionesInteresadas = new ArrayList <Promocion>(), promocionesSinInteres = new ArrayList <Promocion>();
			
			for (int i=0 ; i<listaAtracciones.size() ;i++) {
				
				if(listaAtracciones.get(i).getTipo().equals(usuarioIngresado.getPreferencia())) {
					atraccionesInteresadas.add(listaAtracciones.get(i));
				} else {
					atraccionesSinInteres.add(listaAtracciones.get(i));
				}
			}
			
			for (int i=0 ; i<listaPromociones.size() ; i++) {
				
				if(listaPromociones.get(i).getTipoPromo().equals(usuarioIngresado.getPreferencia())) {
					promocionesInteresadas.add(listaPromociones.get(i));
				} else {
					promocionesSinInteres.add(listaPromociones.get(i));
				}
			}
			
			ArrayList<String> listaCompras = new ArrayList <String>();
			Ticket ticket = new Ticket(usuarioIngresado.getNombre());
			
			sistema.ofrecerPromociones(promocionesInteresadas, usuarioIngresado, listaCompras, ticket, sistema);
			sistema.ofrecerAtracciones(atraccionesInteresadas, usuarioIngresado, listaCompras, ticket, sistema);
			sistema.ofrecerPromociones(promocionesSinInteres, usuarioIngresado, listaCompras, ticket, sistema);
			sistema.ofrecerAtracciones(atraccionesSinInteres, usuarioIngresado, listaCompras, ticket, sistema);
			
			System.out.println("YA NO TENEMOS MAS SERVICIOS PARA OFRECERTE !!\n");
			ticket.armadoTicket();
		
			System.out.println("Desea continuar ?" + "\n(Y/N)");
			Scanner sc = new Scanner(System.in);
			String pantalla = sc.nextLine();
			
			if (pantalla.equals("Y")) {
				quieraSeguir = true;
			}
			
			if (pantalla.equals("N")) {
				quieraSeguir = false;
			}
		}
	System.out.print("Gracias por utilizar nuestro sistema");
	}
		
	private void ofrecerAtracciones(ArrayList<Atraccion> atracciones, Visitante turista, ArrayList<String> listaCompras, Ticket ticket, Sistema sistema) {
		
		double precioMin = atracciones.get(atracciones.size()-1).getCosto();
		double tiempoMin = sistema.consultarTiempoMenorDeAtracciones(atracciones);
		boolean corte = false;
		
		for (int i=0 ; i<atracciones.size() && !corte ; i++) {
			
			if(turista.getPresupuesto()<precioMin || turista.getTiempo()<tiempoMin || sistema.siSeCompro(listaCompras, atracciones.get(i).getNombre())) {
				corte = true;
			}
			
			else {
				if ( !(sistema.siSeCompro(listaCompras, atracciones.get(i).getNombre())) && (atracciones.get(i).getCupo()>0) && (turista.getPresupuesto()>=atracciones.get(i).getCosto())&&(turista.getTiempo()>=atracciones.get(i).getTiempo())) {
					
					System.out.println("Tu presupuesto es de: " + turista.getPresupuesto() + " y tu tiempo actual es de: " + turista.getTiempo());
					System.out.println("\nTenemos para ofrecerte el siguiente servicio: \n" + atracciones.get(i) + "¿Lo compras? (Y/N)");
			
					String respuestaPantalla = "";
					Scanner sc = new Scanner(System.in);
					respuestaPantalla = sc.nextLine();
			
					if (respuestaPantalla.equals("Y")){
					
						turista.contratar(atracciones.get(i));
						atracciones.get(i).disminuirCupo();
						listaCompras.add(atracciones.get(i).getNombre());
						ticket.setAtracciones(atracciones.get(i).getNombre(), atracciones.get(i).getCosto());
						System.out.println("Tu respuesta fue si.");
						
					}
				
					if (respuestaPantalla.equals("N")){
						
						System.out.println("Tu respuesta fue no.");
					}
				}
					
			}
		}
				
	}
	
	private void ofrecerPromociones(ArrayList<Promocion> promociones, Visitante turista, ArrayList<String> listaCompras , Ticket ticket,  Sistema sistema) {
		
		double precioMin= promociones.get(promociones.size()-1).precioPromocion();
		double tiempoMin = sistema.consultarTiempoMenorPromociones(promociones);
		boolean corte = false;
		
		for (int i=0 ; i<promociones.size() && !corte ; i++) {
			
			if(turista.getPresupuesto()<precioMin || turista.getTiempo()<tiempoMin || sistema.siSeCompro(listaCompras, promociones.get(i).getAtracciones())) {
				corte = true;;
			}
			else {
				if ( (promociones.get(i).estaDisponible() ) && !(sistema.siSeCompro(listaCompras, promociones.get(i).getAtracciones())) && ( turista.getPresupuesto() >= promociones.get(i).precioPromocion() ) && ( turista.getTiempo()>=promociones.get(i).getTiempoNecesario()) ) {
				
				System.out.println("Tu presupuesto es de: " + turista.getPresupuesto() + " y tu tiempo actual es de: " + turista.getTiempo());	
				System.out.println("\nTenemos para ofrecerte el siguiente servicio: \n" + promociones.get(i) + "¿Lo compras? (Y/N)");
			
				String respuestaPantalla = "";
				Scanner sc = new Scanner(System.in);
				respuestaPantalla = sc.nextLine();
				
					if (respuestaPantalla.equals("Y")){
						turista.contratar(promociones.get(i));
						promociones.get(i).disminuirCupo();
						
						for(int j=0 ; j<promociones.get(i).getAtracciones().size() ; j++) {
							listaCompras.add(promociones.get(i).getAtracciones().get(j).getNombre());
							}
						ticket.setPromos(promociones.get(i).getNombrePromo(),promociones.get(i).precioPromocion());
						
						System.out.println("Tu respuesta fue si.");
					} 
				
					if (respuestaPantalla.equals("N")){
						System.out.println("Tu respuesta fue no.");
					}
						
				}
				
			}
			
		}	
	
	}
	
	private boolean siSeCompro(ArrayList<String> listaCompras, String nombreAtraccion) {
		return listaCompras.contains(nombreAtraccion); 
	}
	
	private boolean siSeCompro(ArrayList<String> listaCompras, ArrayList<Atraccion>listaAtracciones) {
		
		boolean seCompro = false;
		
		for(int i=0 ; i<listaAtracciones.size() && !seCompro ; i++) {
			
			if(listaCompras.contains(listaAtracciones.get(i).getNombre())) {
				seCompro = true;
			}
		}
		return seCompro;	
	}
	
	private double consultarTiempoMenorDeAtracciones(ArrayList<Atraccion> atracciones) {
		
		double min = atracciones.get(0).getTiempo();
		
		for (int i=1; i<atracciones.size(); i++) {
			
			if(atracciones.get(i).getTiempo() < min) {
				min = atracciones.get(i).getTiempo();
			}
		}
		return min;
		
	}
	
	private double consultarTiempoMenorPromociones(ArrayList<Promocion> promociones) {
		
		double min = promociones.get(0).getTiempoNecesario();
		
		for (int i=1; i<promociones.size(); i++) {
			
			if(promociones.get(i).getTiempoNecesario() < min) {
				min = promociones.get(i).getTiempoNecesario();
			}
		}
		return min;
		
	}
	
	private void cargarPromociones() throws IOException { 		
		
		cargarPorcentuales();
		cargarAbsolutas();
		cargarAxB();
	
	}
			
	private void cargarUsuarios() throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("/C:/Datos/Usuarios.txt"));
		String linea; 
		ArrayList<String> tokens = new ArrayList<String>();
		double tiempo, presupuesto;	
			
			while ( ( linea = bf.readLine() ) != null ) {
			
				StringTokenizer st = new StringTokenizer(linea,"-");
				int cantidadTokens = st.countTokens();
				
				for(int i = 0 ; i < cantidadTokens ; i++) {
					tokens.add(st.nextToken());
				}
				
				tiempo =  Double.parseDouble(tokens.get(1));
				presupuesto = Double.parseDouble(tokens.get(2));
				
				diccionarioUsuarios.put(tokens.get(0), new Visitante(tokens.get(0),tiempo, presupuesto, tokens.get(3)));
				tokens.clear();
			}
		bf.close();
	}
	
	private void cargarAtracciones() throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("/C:/Datos/Atracciones.txt"));
		String linea; 
		double costo, tiempo;
		int cupo;
		ArrayList<String> tokens = new ArrayList<String>();
		
			while ( ( linea = bf.readLine() ) != null ) {
				
				StringTokenizer st = new StringTokenizer(linea,"-");
				int cantidadTokens = st.countTokens();
				
				for(int i = 0 ; i < cantidadTokens ; i++) {
					tokens.add(st.nextToken());
				}
				
				costo =  Double.parseDouble(tokens.get(1));
				tiempo =  Double.parseDouble(tokens.get(2));
				cupo = Integer.parseInt(tokens.get(3));
				
				diccionarioAtracciones.put( tokens.get(0), new Atraccion(tokens.get(0),costo,tiempo,cupo,tokens.get(4)) );
				tokens.clear();
			}
		bf.close();	
	}		
	
	private void cargarPorcentuales() throws IOException {
		
		ArrayList<Atraccion> atraccionesPaquetizadas = new ArrayList<Atraccion>();
		
		BufferedReader bf = new BufferedReader(new FileReader("/C:/Datos/Porcentuales.txt"));
		String linea="", nombrePromo="", cantidadDeAtracciones="",atracciones="", coeficienteDescuento="", fechaVencimiento="";
		int cantidadDeAtraccionesInt=0;
		double coeficienteDescuentoDouble=0;
			
			while ( ( linea = bf.readLine() ) != null ) {
				
				StringTokenizer st = new StringTokenizer(linea,"-");
				
				nombrePromo = st.nextToken();
				cantidadDeAtracciones=st.nextToken();
				cantidadDeAtraccionesInt = Integer.parseInt(cantidadDeAtracciones);
				
				atraccionesPaquetizadas.clear();
				
				for(int i=0 ; i<cantidadDeAtraccionesInt ; i++) {
					atracciones= st.nextToken();
					atraccionesPaquetizadas.add(diccionarioAtracciones.get(atracciones));
				}
				
				coeficienteDescuento = st.nextToken();
				fechaVencimiento = st.nextToken();
				coeficienteDescuentoDouble =  Double.parseDouble(coeficienteDescuento);
				
				diccionarioPromociones.put(nombrePromo, new Porcentual(nombrePromo, atraccionesPaquetizadas,coeficienteDescuentoDouble, fechaVencimiento));
			
			}
			bf.close();
	}
			
	private void cargarAbsolutas() throws IOException {
		
		ArrayList<Atraccion> atraccionesPaquetizadas = new ArrayList<Atraccion>();
		
		BufferedReader bf = new BufferedReader(new FileReader("/C:/Datos/Absolutas.txt"));
		String linea, nombrePromo="", cantidadDeAtracciones="", atracciones="", precioFinalPromo="", fechaVencimiento="";;
		double precioFinalPromoDouble=0;
		int cantidadDeAtraccionesInt=0;
			
			while ( ( linea = bf.readLine() ) != null ) {
				StringTokenizer st = new StringTokenizer(linea,"-");
				
				nombrePromo = st.nextToken();
				cantidadDeAtracciones=st.nextToken();
				cantidadDeAtraccionesInt = Integer.parseInt(cantidadDeAtracciones);
				
				atraccionesPaquetizadas.clear();
				
				for(int i=0 ; i<cantidadDeAtraccionesInt ; i++) {
					atracciones= st.nextToken();
					atraccionesPaquetizadas.add(diccionarioAtracciones.get(atracciones));
				}
				precioFinalPromo = st.nextToken();
				fechaVencimiento= st.nextToken();
				
				precioFinalPromoDouble =  Double.parseDouble(precioFinalPromo);
				diccionarioPromociones.put(nombrePromo, new Absoluta(nombrePromo, atraccionesPaquetizadas,precioFinalPromoDouble, fechaVencimiento));
				
			}
			bf.close();
	}
	
	private void cargarAxB() throws IOException {
		
		ArrayList<Atraccion> atraccionesPaquetizadas = new ArrayList<Atraccion>();
		
		BufferedReader bf = new BufferedReader(new FileReader("/C:/Datos/AxB.txt"));
		String linea, nombrePromo="", cantidadDeAtracciones="",atracciones="", fechaVencimiento="";
		int cantidadDeAtraccionesInt=0;
			
			while ( ( linea = bf.readLine() ) != null ) {
				StringTokenizer st = new StringTokenizer(linea,"-");
				
				nombrePromo = st.nextToken();
				cantidadDeAtracciones=st.nextToken();
				cantidadDeAtraccionesInt = Integer.parseInt(cantidadDeAtracciones);
				
				atraccionesPaquetizadas.clear();
						
				for(int i=0 ; i<cantidadDeAtraccionesInt ; i++) {
					atracciones= st.nextToken();
					atraccionesPaquetizadas.add(diccionarioAtracciones.get(atracciones));
				}
				
				fechaVencimiento = st.nextToken();
				
				diccionarioPromociones.put( nombrePromo, new AxB(nombrePromo, atraccionesPaquetizadas, fechaVencimiento) );
		
			}
			bf.close();
	}

	public TreeMap<String, Visitante> getDiccionarioUsuarios() {
		return diccionarioUsuarios;
	}

	public TreeMap<String, Atraccion> getDiccionarioAtracciones() {
		return diccionarioAtracciones;
	}

	public TreeMap<String, Promocion> getDiccionarioPromociones() {
		return diccionarioPromociones;
	}
	
	private ArrayList<Atraccion> generarListadoAtraccionesOrdenado(TreeMap<String, Atraccion> diccionario) {
		
		ArrayList<Atraccion> listaAtraccionOrdenada = new ArrayList<Atraccion>();
		
		Iterator <String> it = diccionario.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			listaAtraccionOrdenada.add(diccionario.get(key));
		}
		
		listaAtraccionOrdenada.sort(null);
		return listaAtraccionOrdenada; 
	}
	
	private ArrayList<Promocion> generarListadoPromocionesOrdenado(TreeMap<String, Promocion> diccionario) {
	
		ArrayList<Promocion> listaPromocionesOrdenada = new ArrayList<Promocion>();
		Iterator <String> it = diccionario.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			listaPromocionesOrdenada.add(diccionario.get(key));
		}
		
		listaPromocionesOrdenada.sort(null);
		return listaPromocionesOrdenada; 
	}
	
}