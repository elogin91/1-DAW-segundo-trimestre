package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase singleton encargada de unificar la conexión con la base de datos.
 */
public class Conexion {

	/**
	 * Objeto estático con la conexión abierta a la BBDD.
	 */
	private static Connection conn;
	/**
	 * URL de conexión con la BBDD.
	 */
	private static String url = "jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023";
	/**
	 * Usuario de la BBDD.
	 */
	private static String user = "root";
	/**
	 * Contraseña de la BBDD.
	 */
	private static String password = "1234";

	/**
	 * Constructor privado para evitar su inicialización por alguna clase no
	 * controlada.
	 */
	private Conexion() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Error al conectar.");
			e.printStackTrace();
		}
	}

	/**
	 * Método estático que permite al resto de clases obtener la conexión de manera
	 * única.
	 * 
	 * @return Conexión con la BBDD.
	 */
	public static Connection getConexion() {
		if (conn == null) {
			new Conexion();
		}
		return conn;
	}
}
