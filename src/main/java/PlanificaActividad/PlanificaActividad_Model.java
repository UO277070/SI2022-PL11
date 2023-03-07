package PlanificaActividad;

import java.util.Date;
import java.util.List;

import giis.demo.util.Database;
import giis.demo.util.Util;

public class PlanificaActividad_Model {
	
	private Database db = new Database();
	
	public List<Instalaciones> getListaInstalaciones(){
		String sql = "SELECT * from instalacion";
		
		return db.executeQueryPojo(Instalaciones.class, sql);
		
	}
	
	public void insertaActividad(String nombre, String tipo, int plazas, int precio, int precionosocio, Date fechaini, Date fechafin, int idp) {
		db.executeUpdate("Insert into actividad(nombre,tipo,plazas,precio,precionosocio,fechaini,fechafin,periodoIns_id ,estado) values("+"'"+nombre+"'"+","+plazas+","+"'"+tipo+"'"+","+precio+","+precionosocio+","+"'"+Util.dateToIsoString(fechaini)+"'"+","+"'"+Util.dateToIsoString(fechafin)+"',"+idp+",1)");
	}
	
	public void insertaHorario(List<Dia> a, int id) {
		String insert = "Insert into actividad_horario values(?,?,?,?) ";
		for(Dia i:a){
			db.executeUpdate(insert,id,i.getDiasem(),i.getHoraini(),i.getHorafin());
		}
	}
}
