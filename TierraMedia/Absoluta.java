import java.util.ArrayList;


public class Absoluta extends Promocion {

	private double precioPromocion;
		
	public Absoluta(String nombrePromo, ArrayList<Atraccion> atraccionesPaquetizadas,double precioPromocion, String fechaVencimiento) {
		super(nombrePromo, atraccionesPaquetizadas,fechaVencimiento);
		this.precioPromocion = precioPromocion;
	}
	
	@Override
	public double precioPromocion() {
		return precioPromocion;
	}
	
	
	

}
