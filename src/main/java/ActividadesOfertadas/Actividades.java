package ActividadesOfertadas;

public class Actividades {
	private String actividad;
	private String fecha;
	private int horaini;
	private int horafin;
	
	public Actividades() {
		
	}
	
	public Actividades(String a, String f, int hi, int hf) {
		this.actividad=a;
		this.fecha=f;
		this.horaini=hi;
		this.horafin=hf;
	}

	public String getActividad() {
		return actividad;
	}
	
	public void setActividad(String a) {
		this.actividad=a;
	}
	
	@Override 
	public String toString() {
		return "Actividades [Nombre: " + actividad + ", fecha: " + fecha + ", hora inicial: " + horaini
				+ ", hora final: " + horafin + "]" ;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getHora_ini() {
		return horaini;
	}

	public void setHora_ini(int hora_ini) {
		this.horaini = hora_ini;
	}

	public int getHora_fin() {
		return horafin;
	}

	public void setHora_fin(int hora_fin) {
		this.horafin = hora_fin;
	}
}
