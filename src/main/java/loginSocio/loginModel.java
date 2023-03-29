package loginSocio;

import java.util.List;

import giis.demo.util.Database;

public class loginModel {

	private Database db=new Database();
	
	public SocioEntity getSocio(int idsocio) {
		String sql=
				"SELECT idSocio,Nombre,apellido1,apellido2,correo,cuota,moroso FROM Socio WHERE idSocio=?";
		List<SocioEntity> datossocio = db.executeQueryPojo(SocioEntity.class, sql, idsocio);
		
		if(datossocio.isEmpty()) {
			return null;
		}
		return datossocio.get(0);
	}
}
