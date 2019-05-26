import java.util.ArrayList;


public class Porcentual extends Promocion {

	private double coeficienteDescuento;
	
	public Porcentual(String nombrePromo, ArrayList<Atraccion> atraccionesPaquetizadas, double coeficienteDescuento, String fechaVencimiento) {
		
		super(nombrePromo, atraccionesPaquetizadas, fechaVencimiento);
		this.coeficienteDescuento = coeficienteDescuento;
		
	}

	public double precioPromocion() {
		
		double precioNeto = 0;
		
		for (int i=0 ; i<getAtracciones().size() ; i++) {
			precioNeto += getAtracciones().get(i).getCosto();
		}
		
		return precioNeto - ( precioNeto*(coeficienteDescuento/100) ); 
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "Descuento Aplicado: " + this.coeficienteDescuento + "%\n";
	}
}