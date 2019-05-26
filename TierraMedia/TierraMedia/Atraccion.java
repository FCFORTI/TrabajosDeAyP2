package TierraMedia;

public class Atraccion implements Comparable<Atraccion>{
	
	private String nombre, tipo;
	private double costo, tiempo;
	private int cupo;
	
	
	public Atraccion(String nombre, double costo, double tiempo, int cupo, String tipo) {
		
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return " Nombre Atraccion: " + this.nombre + " / " + "Costo: " + this.costo + " / " + "tiempo: " + this.tiempo + " / " + "Cupo : " + this.cupo + " / " + "Tipo: " + this.tipo + "\n" ;
		
	}
	
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public double getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public int getCupo() {
		return cupo;
	}
	
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public void disminuirCupo() {
		this.cupo--;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public int compareTo(Atraccion o) {
		
		if(this.getCosto() > o.getCosto() ) {
			return -1;
		} else 
			if (this.getCosto() < o.getCosto()) {
				return 1;
			} else 
				if(this.getTiempo() > o.getTiempo()) 
					return -1;	
					else 
						if (this.getTiempo() > o.getTiempo()) {
							return 1;
						} else return 0;
	}

}
