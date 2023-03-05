package SocioVerDisponibilidadInstalaciones;

public class Actividades {
	private String actividad;
	private String fecha;
	private int hora_ini;
	private int hora_fin;
	
	public Actividades() {
		
	}
	
	public Actividades(String a, String f, int hi, int hf) {
		this.actividad=a;
		this.fecha=f;
		this.hora_ini=hi;
		this.hora_ini=hf;
	}

	public String getActividad() {
		return actividad;
	}
	
	public void setActividad(String a) {
		this.actividad=a;
	}
	
	@Override 
	public String toString() {
		return "Actividades [Nombre: " + actividad + ", fecha: " + fecha + ", hora inicial: " + hora_ini
				+ ", hora final: " + hora_fin + "]" ;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getHora_ini() {
		return hora_ini;
	}

	public void setHora_ini(int hora_ini) {
		this.hora_ini = hora_ini;
	}

	public int getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(int hora_fin) {
		this.hora_fin = hora_fin;
	}
	
	
}
