package ActividadesOfertadas;

public class PeriodosInscripcion {
	 String idPeriodoinscrip;
	 String nombre;
	 String fechainscripini, fechainscripfin, fechainscripfinnosocio;
	
	public PeriodosInscripcion() {}
	
	public PeriodosInscripcion(String idPeriodoinscrip, String n){
		this.idPeriodoinscrip = idPeriodoinscrip;
		this.nombre = n;
	}
	
	public String getIdPeriodoinscrip() {
		return idPeriodoinscrip;
	}
	public void setIdPeriodoinscrip(String idPeriodoinscrip) {
		this.idPeriodoinscrip = idPeriodoinscrip;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechainscripini() {
		return fechainscripini;
	}

	public void setFechainscripini(String fechainscripini) {
		this.fechainscripini = fechainscripini;
	}

	public String getFechainscripfinnosocio() {
		return fechainscripfinnosocio;
	}

	public void setFechainscripfinnosocio(String fechainscripfinnosocio) {
		this.fechainscripfinnosocio = fechainscripfinnosocio;
	}
}
