package pagosSocio;

import java.util.List;

import giis.demo.util.Database;

public class PagosModel {
	private Database db=new Database();

	public List<Object []> getPagos(int id) {
		String sql=
				"SELECT fecha, importe, idpago "
				+ "FROM Pago "
				+ "where idSocio=? AND estado ='sinpagar'";
		return db.executeQueryArray(sql, id);
	}
	
	public Object [] getPagoDatos(int idpago) {
		String sql=
				"SELECT Pago.importe, Reserva.fecha, Reserva.horaIni, Reserva.horafin, Reserva.idActividad, "
				+ "Reserva.reservadoPor, Instalacion.nombre "
				+ "FROM Pago INNER JOIN Reserva ON (Pago.idReserva=Reserva.idReserva) "
				+ "INNER JOIN Instalacion ON (Reserva.idInstalacion=Instalacion.idInstalacion) "
				+ "where Pago.idpago=?";
		List<Object []> rows = db.executeQueryArray(sql, idpago);
		return rows.get(0);
	}


}
