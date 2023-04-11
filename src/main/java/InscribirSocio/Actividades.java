package InscribirSocio;

public class Actividades {
	
	private int idActividad;
	private int idPeriodo;
	private int idInstalacion;
	private String nombre;
	private String tipo;
	private int plazas;
	private String fechaini;
	private String fechafin;
	private String horaini;
	private String horafin;
	private String diasem;
	private int precio;
	private int precionosocio;
	

	@Override
	public String toString() {
		return "Actividades [nombre=" + nombre + ", tipo=" + tipo + ", plazas=" + plazas + ", fechaini=" + fechaini
				+ ", fechafin=" + fechafin + ", precio=" + precio + ", precionosocio=" + precionosocio + "]";
	}

	public int getIdActividad() {
		return this.idActividad;
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

	public String getHoraini() {
		return horaini;
	}

	public void setHoraini(String horaini) {
		this.horaini = horaini;
	}

	public String getHorafin() {
		return horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public String getDiasem() {
		return diasem;
	}

	public void setDiasem(String diasem) {
		this.diasem = diasem;
	}
	
	
	
}
