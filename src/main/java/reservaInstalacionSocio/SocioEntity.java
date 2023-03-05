package reservaInstalacionSocio;

public class SocioEntity {
	int idSocio; 
	String Nombre; 
	String apellido1;
	String apellido2;
	String correo;
	int cuota;
	boolean moroso;
	public int getIdSocio() {
		return idSocio;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public String getCorreo() {
		return correo;
	}
	public int getCuota() {
		return cuota;
	}
	public boolean getMoroso() {
		return moroso;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	public void setMoroso(boolean moroso) {
		this.moroso = moroso;
	}
	
	

}
