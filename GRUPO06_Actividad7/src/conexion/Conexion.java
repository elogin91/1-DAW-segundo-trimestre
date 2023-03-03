package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conn;
	private static String url = "jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023";
	private static String user = "root";
	private static String password = "1234";


	private Conexion() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		}
		catch (SQLException e){
			System.out.println("Error al conectar.");
			e.printStackTrace();
		}
	}
	
	public static Connection getConexion() {
		if (conn==null) {
			new Conexion();
		}
		return conn;
	}
}
