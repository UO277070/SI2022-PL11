package PlanificaActividad;

public class Dia {
	private int idActividad;
	private String diasem;
	private int horaini;
	private int horafin;
	
	
	public Dia() {
		
	}
	
	public Dia(String diasem, int horaini, int horafin) {
		this.diasem = diasem;
		this.horaini = horaini;
		this.horafin = horafin;
	}
	
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(String actividad_id) {
		this.idActividad = idActividad;
	}
	public String getDiasem() {
		return diasem;
	}
	public void setDiasem(String diasem) {
		this.diasem = diasem;
	}
	public int getHoraini() {
		return horaini;
	}
	@Override
	public String toString() {
		return "DiasDTO [actividad_id=" + idActividad + ", diasem=" + diasem + ", hora_ini=" + horaini + ", hora_fin="
				+ horafin + "]";
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
}
