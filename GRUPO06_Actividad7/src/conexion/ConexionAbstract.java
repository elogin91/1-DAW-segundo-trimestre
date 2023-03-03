package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ConexionAbstract {
	
	protected Connection conn;
	protected int filas;
	
	public ConexionAbstract () {
		conn = Conexion.getConexion();
	}
	
	protected PreparedStatement prepareStatement(String sql) {
		try {
			return conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("Error al preparar el statement. ");
			e.printStackTrace();
			return null;
		}
	}
}
