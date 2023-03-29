package InscribirAdmin;

import java.util.List;

import ActividadesOfertadas.Actividades;
import giis.demo.util.Database;

public class InscribirAdminM {
	private Database db = new Database();
	
	public List<Actividades> getListaActividades(String periodo){
		String sql = "SELECT Actividad.nombre FROM Actividad "
				+ "INNER JOIN PeriodoInscripcion "
				+ "ON Actividad.idPeriodoinscrip = PeriodoInscripcion.idPeriodoinscrip "
				+ "WHERE PeriodoInscripcion.nombre=?";
		return db.executeQueryPojo(Actividades.class, sql, periodo);
	}
	
	public List<Object[]> getListaSocios(){
		String sql = "SELECT Socio.idSocio, Socio.Nombre, Socio.apellido1, Socio.apellido2, Socio.correo FROM Socio";
		return db.executeQueryArray(sql);
	}
	
	
}
