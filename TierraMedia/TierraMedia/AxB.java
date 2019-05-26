package TierraMedia;

import java.util.ArrayList;

public class AxB extends Promocion {

	private Atraccion atraccionGratis;
	
	public AxB(String nombrePromo, ArrayList<Atraccion> atraccionesPaquetizadas, String fechaVencimiento) {
		
		super(nombrePromo, atraccionesPaquetizadas, fechaVencimiento);
		this.atraccionGratis = atraccionesPaquetizadas.get(atraccionesPaquetizadas.size()-1);
		
	}

	@Override
	public double precioPromocion() {
		
		double precio = 0;
		
		for (int i=0 ; i<getAtracciones().size() ; i++) {
			
			if (  !(getAtracciones().get(i).getNombre() == this.atraccionGratis.getNombre()) ) {
			
				precio += getAtracciones().get(i).getCosto();
			}
		}
		return precio;
	}
	@Override
	public String toString() {
		return super.toString() + "Atraccion Gratis: " + this.atraccionGratis.getNombre() + "\n";
	}
	
	
}