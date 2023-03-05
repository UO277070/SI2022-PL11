package SocioVerDisponibilidadInstalaciones;

import java.util.List;

import giis.demo.util.Database;

public class ActividadesModel {
	private Database db = new Database();
	
	public List<Actividades> getActividades(String fechaini, String fechafin, int idInstalacion){
		String sql = "SELECT Actividadhorario.diasem, horaini, horafin, "
				+ "Actividad.nombre FROM (Actividadhorario INNER JOIN Actividad ON Actividadhorario.idActividad = Actividad.idActividad), "
				+ "Socio.Nombre FROM (Instalacion INNER JOIN Reserva ON Instalacion.idInstalacion=Reserva.idInstalacion "
				+ "LEFT OUTER JOIN Socio ON Reserva.idSocio=Socio.idSocio "
				+ "LEFT OUTER JOIN Actividad ON Reserva.idActividad=Actividad.idActividad) "
				+ "WHERE Instalacion.idInstalacion=? AND Actividadhorario.diasem>=? AND Actividadhorario.diasem<=? ";
		return db.executeQueryPojo(Actividades.class, sql, idInstalacion, fechaini, fechafin);
	}
	
	public List<Instalaciones> getInstalaciones(){
		String sql = "SELECT idInstalacion, nombre from Instalacion";
		return db.executeQueryPojo(Instalaciones.class, sql);
	}
	
}
