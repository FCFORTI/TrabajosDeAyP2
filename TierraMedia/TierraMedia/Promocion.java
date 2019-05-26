package TierraMedia;

import java.util.ArrayList;

public abstract class Promocion implements Comparable<Promocion>{

	private ArrayList <Atraccion> atracciones;
	private String fechaVencimiento, nombrePromo, tipoPromo;
	private double tiempoNecesario;
	
	
	
	public Promocion(String nombrePromo, ArrayList <Atraccion> atracciones, String fechaVencimiento) {
		
		this.atracciones = atracciones;
		this.fechaVencimiento = fechaVencimiento;
		this.nombrePromo = nombrePromo;
		
		boolean comprueba = true;
		
		for(int i=0 ; i < atracciones.size()-1 && comprueba ; i++) {
			
			if (atracciones.get(i).getTipo().equals(atracciones.get(i+1).getTipo())) {
				this.tipoPromo =atracciones.get(i).getTipo();
				
			} else {
				comprueba = false;
				this.tipoPromo = "No hay tipo";
			}
		}	
		
		for(Atraccion c : atracciones) {
				this.tiempoNecesario += c.getTiempo();
		}
		
	}
	
	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	public void disminuirCupo() {
	
		for(Atraccion atraccion : atracciones) {
			atraccion.disminuirCupo();
		}
		
	}
	
	public boolean estaDisponible (){
		
		boolean estaDisponible = true;
		
		for(int i=0 ; i<atracciones.size() && estaDisponible ; i++) {
			
			if(atracciones.get(i).getCupo() <= 0){
				estaDisponible=false;
			}
		}
		return estaDisponible;
			
		
	}
		
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public double getTiempoNecesario() {
		return tiempoNecesario;
	}
	
	public String getTipoPromo() {
		return this.tipoPromo;
	}
	
	public String getNombrePromo() {
		return this.nombrePromo; 
	}

	public abstract double precioPromocion();
	
	public String toString() {		
		return "Nombre Promo: " + this.nombrePromo + "\nAtracciones Incluidas:\n" + this.atracciones + "\nPrecio: " + this.precioPromocion() + "\nVencimiento: " + getFechaVencimiento() + "\nTiempo Necesario: " + getTiempoNecesario() + "\n" ;
	}
	
	@Override
	public int compareTo(Promocion o) {
		
		if(this.precioPromocion() > o.precioPromocion()) {
			return -1;
			} else 
				if(this.precioPromocion() < o.precioPromocion()) {
					return 1;
				}else 
					if(this.getTiempoNecesario() > o.getTiempoNecesario()) 
						return -1;	
						else 
							if (this.getTiempoNecesario() > o.getTiempoNecesario()) {
								return 1;
							} else return 0;
	}
}
