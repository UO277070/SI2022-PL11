package consultarReservas;

import java.util.List;

import giis.demo.util.Database;

public class ConsultasModel {
		private Database db=new Database();
	
		public List<Object[]> getInstalaciones() {
			String sql=
					"select nombre from Instalacion";
			return db.executeQueryArray(sql);
		}
		
		public List<Object[]> getReservas(String fecha, String nombre) {
			String sql = "select Reserva.reservadoPor, Reserva.horaini, Reserva.horafin "
					+ "from Reserva INNER JOIN Instalacion ON (Reserva.idInstalacion = Instalacion.idInstalacion)  "
					+ "where Reserva.fecha = ? and Instalacion.nombre = ?";
			return db.executeQueryArray(sql,fecha,nombre);
		}
		
		
}
