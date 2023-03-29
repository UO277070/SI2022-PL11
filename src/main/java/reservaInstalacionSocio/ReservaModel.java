package reservaInstalacionSocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import giis.demo.tkrun.CarreraDisplayDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;
import loginSocio.SocioEntity;

public class ReservaModel {
	private Database db=new Database();


	public List<Object[]> getInstalaciones() {
		String sql=
				"select nombre from Instalacion";
		return db.executeQueryArray(sql);
	}

	public double getPrecio(String nombreInst) {
		String sql=
				"select preciohora from Instalacion where nombre=?";
		List<Object[]>rows=db.executeQueryArray(sql,nombreInst);
		return (int)rows.get(0)[0];
	}
	
	
	public List<Object []> getHorasOcupadas(String nombreInst, String fecha) {
		String sql=
				"SELECT Reserva.horaini,Reserva.horafin "
				+ "FROM Reserva INNER JOIN Instalacion ON (Reserva.idInstalacion = Instalacion.idInstalacion) "
				+ "where Instalacion.nombre=? AND Reserva.fecha=?";
		return db.executeQueryArray(sql, nombreInst,fecha);
	}
	
	public SocioEntity getSocio(int idsocio) {
		String sql=
				"SELECT idSocio,Nombre,apellido1,apellido2,correo,cuota,moroso FROM Socio WHERE idSocio=?";
		List<SocioEntity> datossocio = db.executeQueryPojo(SocioEntity.class, sql, idsocio);
		
		if(datossocio.isEmpty()) {
			return null;
		}
		return datossocio.get(0);
	}
	
	public boolean horaocupada(int idInstalacion, String fecha, int horaini, int horafin) {
		String sql=
				"SELECT COUNT(idReserva) FROM Reserva "
				+ "WHERE idInstalacion=? AND fecha=? AND horaini=? AND horafin=?";
		List<Object[]> datossocio = db.executeQueryArray(sql, idInstalacion,fecha,horaini,horafin);
		return ((int)datossocio.get(0)[0])!=0;
	}
	
	public int getIdInstalacion(String nombre) {
		String sql =
				"SELECT idInstalacion FROM Instalacion WHERE nombre=?";
		List<Object[]> id = db.executeQueryArray(sql, nombre);
		return (int)id.get(0)[0];
	}
	
	public void reservaInstalacion(int idSocio, int idInstalacion, String fecha, int horaIni, int horaFin, String nombre) {
		String sql = 
				"INSERT INTO Reserva (idSocio, idInstalacion , fecha, horaIni, horafin, estado, reservadoPor, idActividad) "
				+ "values (?,?,?,?,?,'ocupado',?,NULL)";
		db.executeUpdate(sql,idSocio,idInstalacion,fecha,horaIni,horaFin,nombre);
	}
	
	public List<Object []> Prueba() {
		String sql=
				"SELECT * FROM Pago";
		return db.executeQueryArray(sql);
	}
	
	public ReservaEntity reservaDetalles(int idSocio, int idInstalacion, String fecha, int horaIni, int horaFin) {
		String sql=
				"SELECT idReserva,idSocio,idInstalacion,fecha,horaini,horafin,estado,reservadopor FROM Reserva "
				+ "WHERE idSocio=? AND idInstalacion=? AND fecha=? AND horaini=? AND horafin=?";
		List<ReservaEntity> datosreserva = db.executeQueryPojo(ReservaEntity.class,sql,idSocio,idInstalacion,fecha,horaIni,horaFin);
		return datosreserva.get(0);
	}
	
	public void generaPago(double importe, String fecha, String estado, int idSocio, int idReserva) {
		String sql = 
				"INSERT INTO Pago (importe,fecha,estado,idSocio,idReserva) "
				+ "values (?,?,?,?,?)";
		db.executeUpdate(sql,importe,fecha,estado,idSocio,idReserva);
	}
	
	public void updateCuotaMensual(double cuota,int idSocio) {
		String sql = 
				"UPDATE Socio SET cuota=? WHERE idSocio=?";
		db.executeUpdate(sql,cuota,idSocio);
	}
	
	public List<Object[]> socioHoras(int idSocio,String fecha) {
		String sql=
				"SELECT horaini,horafin FROM Reserva "
				+ "WHERE idsocio=? AND fecha=?";
		return db.executeQueryArray(sql,idSocio, fecha);
	}

}

