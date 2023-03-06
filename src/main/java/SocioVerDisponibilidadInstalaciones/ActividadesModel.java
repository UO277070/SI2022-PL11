package SocioVerDisponibilidadInstalaciones;

import java.util.List;

import giis.demo.util.Database;

public class ActividadesModel {
	private Database db = new Database();
	
	public List<Actividades> getActividades(String fechaini, String fechafin, int idInstalacion){
		/*String sql = "SELECT Actividadhorario.diasem, horaini, horafin, "
				+ "Actividad.nombre FROM (Actividadhorario INNER JOIN Actividad ON Actividadhorario.idActividad = Actividad.idActividad), "
				+ "Socio.Nombre FROM (Instalacion INNER JOIN Reserva ON Instalacion.idInstalacion=Reserva.idInstalacion "
				+ "LEFT OUTER JOIN Socio ON Reserva.idSocio=Socio.idSocio "
				+ "LEFT OUTER JOIN Actividad ON Reserva.idActividad=Actividad.idActividad) "
				+ "WHERE Instalacion.idInstalacion=? AND Actividadhorario.diasem>=? AND Actividadhorario.diasem<=? ";
				*/
		String sql ="SELECT a.nombre AS actividad, r.fecha, r.horaini, r.horafin, s.nombre || ' ' || s.apellido1 || ' ' || s.apellido2 AS socio, i.nombre AS instalacion\r\n"
				+ "FROM Reserva r\r\n"
				+ "LEFT OUTER JOIN Socio s ON r.idSocio = s.idSocio\r\n"
				+ "LEFT OUTER JOIN Actividad a ON r.idActividad = a.idActividad\r\n"
				+ "LEFT OUTER JOIN Instalacion i ON r.idInstalacion = i.idInstalacion\r\n"
				+ "WHERE i.idInstalacion = ?\r\n"
				+ "AND r.fecha BETWEEN '?' AND '?'";
		return db.executeQueryPojo(Actividades.class, sql, idInstalacion, fechaini, fechafin);
	}
	
	public List<Instalaciones> getInstalaciones(){
		String sql = "SELECT idInstalacion, nombre FROM Instalacion";
		return db.executeQueryPojo(Instalaciones.class, sql);
	}
	
}
