package ReservarInstalacionComoSocio;

public class InstalacionDTO {
	String idInstalacion, nombre, preciohora;

	public InstalacionDTO(String idInstalacion,String nombre,String preciohora) {
		
		this.nombre = nombre;
	}

	public String getidInstalacion() {
		return idInstalacion;
	}

	public void setIdinstalacion(String idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	public String getPrecio_hora() {
		return preciohora;
	}

	public void setPrecio_hora(String preciohora) {
		this.preciohora = preciohora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
