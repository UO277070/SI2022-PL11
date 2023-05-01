package PlanificaActividad;

import java.util.Date;
import java.util.List;

import giis.demo.util.Database;
import giis.demo.util.Util;

public class PlanificaActividad_Model {
	
	private Database db = new Database();
	
	public List<Object []> getListaInstalaciones(){
		String sql = "SELECT idInstalacion, nombre from instalacion";
		return db.executeQueryArray(sql);
	}
	
	public List<Object[]> getPeriodos(){
		return db.executeQueryArray( "SELECT nombre FROM PeriodoInscripcion");
	}
	
	public List<Object[]> getIdPeriodo(String periodo){
		String sql = "SELECT idPeriodoinscrip FROM PeriodoInscripcion WHERE nombre = ?";
		return db.executeQueryArray(sql, periodo);
	}
	
	public List<Object[]> getIdInstalacion(String instalacion){
		String sql = "SELECT idInstalacion FROM Instalacion WHERE nombre = ?";
		return db.executeQueryArray(sql, instalacion);
	}
	
	public void insertaActividad(int idPeriodo,int idInstalacion, String nombre, String tipo, int plazas, int precio, int precionosocio, String fechaini, String fechafin) {
		String sql = "Insert into actividad(idPeriodoinscripcion, idInstalacion, nombre,tipo,plazas,precio,precionosocio,fechaini,fechafin,estado) values (?,?,?,?,?,?,?,?,?,"+"En espera"+")";
		db.executeUpdate(sql, idPeriodo, idInstalacion, nombre, tipo, plazas, precio, precionosocio, fechaini, fechafin);
	}
	
	public void insertaHorario(List<Dia> a, int idActividad) {
		String sql = "Insert into actividad_horario values(?,?,?,?) ";
		for(Dia i:a){
			db.executeUpdate(sql,idActividad,i.getDiasem(),i.getHoraini(),i.getHorafin());
		}
	}
}
