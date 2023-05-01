package InscribirSocio;

import java.util.List;

import InscribirAdmin.ListaEsperaSocio;
import loginSocio.*;
import giis.demo.util.Database;

public class InscribirSocioM {
	private Database db = new Database();
	
	public List<Object[]> getListaActividadesEnPeriodoSocio(String fechaActual){
		String sql = "SELECT Actividad.nombre FROM Actividad "
				+ "INNER JOIN PeriodoInscripcion "
				+ "ON Actividad.idPeriodoinscrip = PeriodoInscripcion.idPeriodoinscrip "
				+ "WHERE PeriodoInscripcion.fechainscripini <= ? AND PeriodoInscripcion.fechainscripfin >= ? ";
		return db.executeQueryArray(sql, fechaActual, fechaActual);
	}
	
	
	public List<Actividades> getActividad(String nombre){
		String sql = "SELECT Actividad.idActividad, Actividad.nombre, Actividad.tipo, Actividad.precio, Actividad.fechaini, "
				+ "Actividad.fechafin, Actividad.plazas, Actividadhorario.horaini, Actividadhorario.horafin, Actividadhorario.diasem "
				+ "FROM Actividad INNER JOIN Actividadhorario "
				+ "ON Actividad.idActividad = Actividadhorario.idActividad "
				+ "WHERE Actividad.nombre = ?";
		return db.executeQueryPojo(Actividades.class, sql, nombre);
	}
	
	public List<SocioEntity> getSocio(int idSocio){
		String sql=
				"SELECT idSocio,Nombre,apellido1,apellido2,correo,cuota FROM Socio WHERE idSocio=?";
		return db.executeQueryPojo(SocioEntity.class, sql, idSocio);
	}
	
	public List<Object[]> getPlazasTotalesActividad(int idActividad){
		String sql = "SELECT plazas FROM Actividad WHERE idActividad = ?";
		return db.executeQueryArray(sql, idActividad);
	}
	
	public List<Object[]> getNumInscripcionesEnActividad(int idActividad) {
		String sql = "SELECT count(*) FROM inscripcion WHERE idActividad=?;";
		return db.executeQueryArray(sql, idActividad);
	} 
	
	public List<Inscripcion> getInscripcionesSocio(int idSocio){
		String sql = "SELECT idActividad, idSocio FROM Inscripcion "
				+ "WHERE idSocio = ?";
		return db.executeQueryPojo(Inscripcion.class,sql, idSocio);
	}
	
	public void insertInscripcionActividadSocio(int idActividad, int idSocio) {
		String sql = "INSERT INTO Inscripcion (idActividad, idSocio) VALUES (?, ?)";
		db.executeUpdate(sql, idActividad, idSocio);
	}
	
	public void insertListaEsperaSocio(int idActividad, int idSocio, int posicion) {
		String sql = "INSERT INTO Listaesperasocio VALUES (?, ?, ?)";
		db.executeUpdate(sql, idActividad, idSocio, posicion);
	}
	
	public List<ListaEsperaSocio> getListaEsperaSocioActividad(int idActividad){
		String sql = "SELECT idActividad, idSocio, posicion FROM Listaesperasocio WHERE idActividad = ?";
		return db.executeQueryPojo(ListaEsperaSocio.class, sql, idActividad);
	}
	
	public void deleteListaEsperaSocio(int idActividad, int idSocio) {
		String sql = "DELETE FROM Listaesperasocio WHERE idActividad = ? AND idSocio = ?";
		db.executeUpdate(sql, idActividad, idSocio);
	}
}
