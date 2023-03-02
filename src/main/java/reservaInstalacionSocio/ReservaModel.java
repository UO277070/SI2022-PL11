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


/*
public void demo3Parameters(javax.swing.DefaultComboBoxModel a) {
	createTable();
	//En vez de crear un Statement y pasar el sql en executeQuery,
	//se crea un PreparedStatement con el sql, luego se le ponen los parametros y finalmente se ejecuta
	try (Connection cn=DriverManager.getConnection(URL); //NOSONAR
		PreparedStatement pstmt=cn.prepareStatement("select * from test")) {
		//pstmt.setInt(1, 2); // pone valor 2 en el primer (y unico) parametro
		try (ResultSet rs=pstmt.executeQuery()) {
			while (rs.next()) {
				log.info("demo3Parameters: "+rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3));
				a.addElement(rs.getObject(3));
			}
		}
	} catch (SQLException e) {
		throw new UnexpectedException(e);
	}
	//de forma similar se pueden ejecutar acciones de actualizacion sobre el PreparedStatement*/
}

