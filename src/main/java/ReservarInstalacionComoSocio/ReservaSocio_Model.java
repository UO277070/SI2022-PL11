package ReservarInstalacionComoSocio;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class ReservaSocio_Model {
	private Database db=new Database();
	 
	
	
	public int SacaridReserva(String idSocio,int idInstalacion,String Fecha, int ini,int fin) {
		String sql="SELECT idReserva from Reserva where idInstalacion= "+idInstalacion+" and fecha='"+Fecha+"' and horaini="+ini+" and horafin="+fin+" and idSocio='"+idSocio+"'; ";	
		//Como no puedes reservar mas lejos del periodo no hace falta filtrar por fecha
		
		List<ReservaEntity> ReservasSocio=db.executeQueryPojo(ReservaEntity.class, sql);

		return ReservasSocio.get(0).idReserva;
	}
	
	public void Insertapago(int importe, String fecha, String estado, String idSocio, int idReserva) {
		
		String sql2= "insert into Pago (importe, fecha, estado, idSocio, idReserva) values (?,?,?,?,?)";
		db.executeUpdate(sql2, importe, fecha, estado, idSocio, idReserva);

		
	}
	
	public Integer getprecio(String idInstalacion) {	//Necesito saber bien como va lo del periodo para hacer esto
		String sql="SELECT preciohora from Instalacion where nombre= '"+idInstalacion+"'; ";	
		//Como no puedes reservar mas lejos del periodo no hace falta filtrar por fecha
		
		List<InstalacionEntity> ReservasSocio=db.executeQueryPojo(InstalacionEntity.class, sql);
		return ReservasSocio.get(0).preciohora;

	}

	public Integer getidInstalacion(String NombreInstalacion) {	//Necesito saber bien como va lo del periodo para hacer esto
		String sql="SELECT idInstalacion from Instalacion where nombre= '"+NombreInstalacion+"'; ";	
		//Como no puedes reservar mas lejos del periodo no hace falta filtrar por fecha
		
		List<InstalacionEntity> ReservasSocio=db.executeQueryPojo(InstalacionEntity.class, sql);
		return ReservasSocio.get(0).idInstalacion;

	}
	
	
	
	public void ReservarInstalacion(String idSocio, Integer idInstalacion, String fecha, int horaini, int horafin,String NombreReservador) {	//Necesito saber bien como va lo del periodo para hacer esto

		String sql2= "insert into reserva (idSocio,idInstalacion,fecha,horaini,horafin,estado,reservadopor) values (?,?,?,?,?,?,?)";
		db.executeUpdate(sql2, idSocio,idInstalacion,fecha,horaini,horafin,"ocupado",NombreReservador);

	}
	 


	public List<ReservaEntity> getReservaInstalacion(Integer idInstalacion, String Fecha) {	//Necesito saber bien como va lo del periodo para hacer esto
		String sql="SELECT * from Reserva where idInstalacion= "+idInstalacion+" and fecha='"+Fecha+"'; ";	
		//Como no puedes reservar mas lejos del periodo no hace falta filtrar por fecha
		
		List<ReservaEntity> ReservasSocio=db.executeQueryPojo(ReservaEntity.class, sql);
		return ReservasSocio;

	}


	public List<InstalacionEntity> getNombreinstalaciones() {
		String sql="SELECT nombre from Instalacion ; ";
		
		List<InstalacionEntity> instalaciones=db.executeQueryPojo(InstalacionEntity.class, sql);
		validateCondition(!instalaciones.isEmpty(),"Instalaciones no encontradas: ");
		return instalaciones;
	}
	
	public List<ReservaEntity> getReservasSocio(String idSocio) {	//Necesito saber bien como va lo del periodo para hacer esto
		String sql="SELECT * from Reserva where idSocio= "+idSocio+"; ";	
		//Como no puedes reservar mas lejos del periodo no hace falta filtrar por fecha
		
		List<ReservaEntity> ReservasSocio=db.executeQueryPojo(ReservaEntity.class, sql);
		return ReservasSocio;

	}

	public boolean getSocioidExiste(String idSocio,String NombreSocio) {
		String sql="SELECT * from socio where idSocio= '"+idSocio+"' and Nombre='"+NombreSocio+"'; ";
		
		List<socioEntity> instalaciones=db.executeQueryPojo(socioEntity.class, sql);
		if(instalaciones == null) {
			return false;
		}
		else	return true;		
	}
	
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

}
