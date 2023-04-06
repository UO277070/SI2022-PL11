package InscribirAdmin;

import java.util.List;

import ActividadesOfertadas.Actividades;
import giis.demo.util.Database;

public class InscribirAdminM {
	private Database db = new Database();
	
	public List<Object[]> getListaActividadesEnPeriodoSocio(String fechaActual){
		String sql = "SELECT Actividad.nombre FROM Actividad "
				+ "INNER JOIN PeriodoInscripcion "
				+ "ON Actividad.idPeriodoinscrip = PeriodoInscripcion.idPeriodoinscrip "
				+ "WHERE PeriodoInscripcion.fechainscripini <= ? AND PeriodoInscripcion.fechainscripfin >= ? ";
		return db.executeQueryArray(sql, fechaActual);
	}
	
	public List<Object[]> getListaActividadesEnPeriodoInsNoSocio(String fechaActual){
		String sql = "SELECT Actividad.nombre FROM Actividad "
				+ "INNER JOIN PeriodoInscripcion "
				+ "ON Actividad.idPeriodoinscrip = PeriodoInscripcion.idPeriodoinscrip "
				+ "WHERE PeriodoInscripcion.fechainscripini <= ? AND PeriodoInscripcion.fechainscripfinnosocio >= ? ";
		return db.executeQueryArray(sql, fechaActual);
	}
	
	public List<Object[]> getNumInscripcionesEnActividad(int idActividad) {
		String sql = "SELECT count(*) FROM inscripcion WHERE idActividad=?;";
		return db.executeQueryArray(sql, idActividad);
	} 
	
	public List<Object[]> getInscripcionesEnActividad(int idActividad){
		String sql = "SELECT idActividad, idSocio, idNosocio FROM Inscripcion"
				+ "WHERE idActividad = ?";
		return db.executeQueryArray(sql, idActividad);
	}
	
	public List<Object[]> getPlazasTotalesActividad(int idActividad){
		String sql = "SELECT plazas FROM Actividad WHERE idActividad = ?";
		return db.executeQueryArray(sql, idActividad);
	}
	
	public List<Object[]> getListaSocios(){
		String sql = "SELECT idSocio FROM Socio";
		return db.executeQueryArray(sql);
	}
	
	
}
