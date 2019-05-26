package TierraMedia;

public class Ticket {

	private String nombreUsuario;
	private String primeraParte = "Tierra Media\n -----------------------------------------\nNombre del Comprador: ";
	private String promosCompradas = "";
	private String atraccionesCompradas ="";
	private double costoPromo = 0.0;
	private double costoAtraccion = 0.0;
	private double costoFinal = 0.0;
	private String segundaParte = "\nPROMOCIONES COMPRADAS:\n";
	private String terceraParte = "\nATRACCIONES COMPRADAS:\n";
	private String cuartaParte = "\nUsted sumo un costo total de: ";
	private String quintaParte = "\nMuchas Gracias por su Compra !!";
	
	public Ticket(String nombreUsuario){
		
		
		this.nombreUsuario = nombreUsuario;
		this.primeraParte = this.primeraParte + this.nombreUsuario +"\n";
		
	}
	
	
	public void setPromos(String promociones, double costo){
		
		this.promosCompradas = promociones;
		this.costoPromo += costo;
		
		this.segundaParte += " " + this.promosCompradas + ": $ " + costo +"\n";
		
	}
	
	public void setAtracciones(String atracciones, double costo){
		
		this.atraccionesCompradas = atracciones;
		this.costoAtraccion += costo;
		
		this.terceraParte += " " + this.atraccionesCompradas + ": $ " + costo +"\n";
		
	}
	
	private void costoTotal() {
		this.costoFinal = this.costoPromo + this.costoAtraccion;
	}
	
	public void armadoTicket(){
		
		costoTotal();
		
		this.cuartaParte += "$ " + this.costoFinal;
		this.quintaParte = this.quintaParte + "\n ------------------------------------------\n";
		System.out.print(this.primeraParte + this.segundaParte + this.terceraParte + this.cuartaParte + this.quintaParte);
	}
	
	
	
}

	
	
	

