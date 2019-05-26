package TierraMedia;

public class Visitante {

	private double tiempo, presupuesto;
	private String nombre, preferencia;
	
	public Visitante(String nombre , double tiempo , double presupuesto, String preferencia) { 
		
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.presupuesto = presupuesto;
		this.preferencia = preferencia;
		
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public void disminuirTiempo(double tiempoDescontable) {
		this.tiempo = this.tiempo-tiempoDescontable;
	}
	
	public void contratar(Atraccion atraccion) {
		
		this.presupuesto = this.presupuesto-atraccion.getCosto();
		this.tiempo = this.tiempo-atraccion.getTiempo();
		
	}
	
	public void contratar (Promocion promocion) {
		
		this.presupuesto = this.presupuesto-promocion.precioPromocion();
		this.tiempo = this.tiempo-promocion.getTiempoNecesario();
		
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public void disminuirPresupuesto(double montoDescontable) {
		this.presupuesto = this.presupuesto- montoDescontable;
	}
	
	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Nombre: " + getNombre() + " / " + "Tiempo: " + getTiempo() + " / " + "Presupuesto: " + getPresupuesto() + " / " + "Preferencia: " + getPreferencia() + "\n";
	}
	
	

}
