package SocioVerDisponibilidadInstalaciones;

public class Instalaciones {
	private int idInstalacion;
	private String nombre;
	private int preciohora;
	
	public Instalaciones() {}
	public Instalaciones(int idInstalacion, String nombre) {
		super();
		this.idInstalacion = idInstalacion;
		this.nombre = nombre;
	}
	
	public Instalaciones(String nombre, int preciohora) {
		super();
		this.nombre = nombre;
		this.preciohora=preciohora;
	}
	public int getIdInstalacion() {
		return idInstalacion;
	}
	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPreciohora() {
		return preciohora;
	}
	public void setPreciohora(int preciohora) {
		this.preciohora = preciohora;
	}
	
	@Override
	public String toString() {
		return idInstalacion + " - " + nombre;
	}
}

