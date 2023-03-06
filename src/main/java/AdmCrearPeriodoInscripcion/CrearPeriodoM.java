package AdmCrearPeriodoInscripcion;

import java.util.Date;
import java.util.List;

import giis.demo.util.Database;
import giis.demo.util.Util;

public class CrearPeriodoM {
	
	private Database db=new Database();
	
	public List<PeriodosInscripcion> getPeriodos(){
		return db.executeQueryPojo(PeriodosInscripcion.class, "SELECT idPeriodoinscrip, nombre FROM PeriodoInscripcion");
	}
		
	public void insertaPeriodo(String nombre,Date ini,Date finSocios,Date finNoSocios){
			
		db.executeUpdate("Insert into PeriodoInscripcion (nombre, fechainscripini, fechainscripfin, fechainscripfinnosocio) "
				+ "values('"+nombre+"','"+Util.dateToIsoString(ini)+"','"+Util.dateToIsoString(finSocios)+"','"+Util.dateToIsoString(finNoSocios)+"')");			
	}

}
