package daos;

import java.sql.Connection;

import conexion.Conexion;

/**
 * Clase abstracta encargada de unificar el comportamiento de obtener la
 * conexión para todos los DAOs
 * 
 * Nota: En esta clase no se ha incluido el ResultSet ni ningún atributo
 * relacionado con las consultas para evitar posibles problemas de concurrencia
 * en el caso de que fuesen estas clases utilizadas por varios hilos.
 */
public abstract class AbstractDao {

	/**
	 * Conexión obtenida al inicializarse el objeto
	 */
	protected Connection conn;

	/**
	 * Iniciación de la conexión mediante el singleton {@link Conexion}
	 */
	public AbstractDao() {
		conn = Conexion.getConexion();
	}
}
