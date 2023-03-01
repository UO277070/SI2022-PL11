package ReservarInstalacionComoSocio;

public class ActividadEntity {
	int idActividad ,idPeriodoinscrip,idInstalacion,plazas,precio,precionosocio;
	String nombre,tipo,fechaini,fechafin,estado	;
	
	
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
	public int getIdPeriodoinscrip() {
		return idPeriodoinscrip;
	}
	public void setIdPeriodoinscrip(int idPeriodoinscrip) {
		this.idPeriodoinscrip = idPeriodoinscrip;
	}
	public int getIdInstalacion() {
		return idInstalacion;
	}
	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
