package daos;

import java.sql.Connection;

import conexion.Conexion;

public abstract class AbstractDao {
	
	protected Connection conn;
	
	public AbstractDao () {
		conn = Conexion.getConexion();
	}
}
