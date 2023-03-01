package ReservarInstalacionComoSocio;

public class ReservaEntity {
	int idReserva,idSocio,idInstalacion,idActividad,horaini,horafin ;
	String fecha,estado	,reservadopor ;
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public int getIdInstalacion() {
		return idInstalacion;
	}
	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getHoraini() {
		return horaini;
	}
	public void setHoraini(int horaini) {
		this.horaini = horaini;
	}
	public int getHorafin() {
		return horafin;
	}
	public void setHorafin(int horafin) {
		this.horafin = horafin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getReservadopor() {
		return reservadopor;
	}
	public void setReservadopor(String reservadopor) {
		this.reservadopor = reservadopor;
	}
	
	
}
