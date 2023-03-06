package ActividadesOfertadas;

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

public class ActividadesOfertadas_Model {
private Database db = new Database();
	
	public List<Object []> getListaActividades(String periodo){
		String sql = "SELECT nombre, tipo, fechaini, fechafin, plazas, precio, precionosocio FROM Actividad"
				+ "INNER JOIN PeriodoInscripcion"
				+ "ON Actividad.idPeriodoinscrip = PeriodoInscripcion.idPeriodoinscrip"
				+ "WHERE PeriodoInscripcion.nombre=?";
		return db.executeQueryArray(sql, periodo);
	}
}
