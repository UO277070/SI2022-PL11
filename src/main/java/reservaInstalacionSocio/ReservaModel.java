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
	
	
	
	

}

