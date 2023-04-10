package InscribirSocio;

import java.util.List;

import giis.demo.util.Database;

public class InscribirSocioM {
	private Database db = new Database();
	
	public List<Object[]> getListaActividadesEnPeriodoSocio(String fechaActual){
		String sql = "SELECT Actividad.nombre FROM Actividad "
				+ "INNER JOIN PeriodoInscripcion "
				+ "ON Actividad.idPeriodoinscrip = PeriodoInscripcion.idPeriodoinscrip "
				+ "WHERE PeriodoInscripcion.fechainscripini <= ? AND PeriodoInscripcion.fechainscripfin >= ? ";
		return db.executeQueryArray(sql, fechaActual);
	}
	
	
	public List<Actividades> getActividad(int idActividad){
		String sql = "SELECT Actividad.nombre, Actividad.tipo, Actividad.precio, Actividad.fechaini"
				+ "Actvidad.fechafin, Actividadhorario.horaini, Actividadhorario.horafin, Actividahorario.diasem"
				+ "FROM Actividad INNER JOIN Actividadhorario"
				+ "ON Actividad.idActividad = Actividadhorario.idActividad"
				+ "WHERE Actividad.idActividad = ?";
		return db.executeQueryPojo(Actividades.class, sql, idActividad);
	}
	
}
