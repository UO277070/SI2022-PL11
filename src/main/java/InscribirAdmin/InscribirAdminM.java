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
		return db.executeQueryArray(sql, fechaActual, fechaActual);
	}
	
	public List<Object[]> getListaActividadesEnPeriodoNoSocio(String fechaActual){
		String sql = "SELECT Actividad.nombre FROM Actividad "
				+ "INNER JOIN PeriodoInscripcion "
				+ "ON Actividad.idPeriodoinscrip = PeriodoInscripcion.idPeriodoinscrip "
				+ "WHERE PeriodoInscripcion.fechainscripfin <= ? AND PeriodoInscripcion.fechainscripfinnosocio >= ? ";
		return db.executeQueryArray(sql, fechaActual, fechaActual);
	}
	
	public List<Object[]> getIdActividad(String nombre) {
		String sql = "SELECT Actividad.idActividad FROM Actividad "
				+ "WHERE Actividad.nombre = ?";
		return db.executeQueryArray(sql, nombre);
	}
	
	public List<Object[]> getNumInscripcionesEnActividad(int idActividad) {
		String sql = "SELECT count(*) FROM inscripcion WHERE idActividad=?;";
		return db.executeQueryArray(sql, idActividad);
	} 
	
	public List<Object[]> getInscripcionesEnActividad(int idActividad){
		String sql = "SELECT idActividad, idSocio, idNosocio FROM Inscripcion "
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
	
	public List<NoSocio> getNoSocio(String dni){
		String sql = "SELECT * FROM Nosocio WHERE dni = ?";
		return db.executeQueryPojo(NoSocio.class, sql, dni);
	}
	
	public void insertInscripcionActividadSocio(int idActividad, int idSocio) {
		String sql = "INSERT INTO Inscripcion (idActividad, idSocio, idNoSocio) VALUES (?, ?, NULL)";
		db.executeUpdate(sql, idActividad, idSocio);
	}
	
	public void insertInscripcionActividadNoSocio(int idActividad, int idNoSocio) {
		String sql = "INSERT INTO Inscripcion (idActividad, idSocio, idNosocio) VALUES (?,NULL, ?)";
		db.executeUpdate(sql, idActividad, idNoSocio);
	}
	
	public void insertNoSocio(String dni, String nombre, String apellido1, String apellido2, String correo) {
		String sql = "INSERT INTO Nosocio (dni, nombre, apellido1, apellido2, correo) VALUES (?,?,?,?,?)";
		db.executeUpdate(sql, dni, nombre, apellido1, apellido2, correo);
	}
	
}
