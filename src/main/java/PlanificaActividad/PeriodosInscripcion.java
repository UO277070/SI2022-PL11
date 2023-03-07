package PlanificaActividad;

public class PeriodosInscripcion {
	private String idPeriodoinscrip;
	private String nombre;
	
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
}
