package InscribirAdmin;

public class Actividades {
	int idActividad;
	private int idPeriodo;
	private int idInstalacion;
	private String nombre;
	private String tipo;
	private int plazas;
	private String fechaini;
	private String fechafin;
	private int precio;
	private int precionosocio;
	
	@Override
	public String toString() {
		return "Actividades [nombre=" + nombre + ", tipo=" + tipo + ", plazas=" + plazas + ", fechaini=" + fechaini
				+ ", fechafin=" + fechafin + ", precio=" + precio + ", precionosocio=" + precionosocio + "]";
	}
	
	public int getIdActividad() {
		return idActividad;
	}
	
	public void setIdActividad(int id) {
		this.idActividad = id;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getPlazas() {
		return plazas;
	}


	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}


	public String getFechaini() {
		return fechaini;
	}


	public void setFechaini(String fechaini) {
		this.fechaini = fechaini;
	}


	public String getFechafin() {
		return fechafin;
	}


	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getPrecionosocio() {
		return precionosocio;
	}


	public void setPrecionosocio(int precionosocio) {
		this.precionosocio = precionosocio;
	}
	
	
	
}
