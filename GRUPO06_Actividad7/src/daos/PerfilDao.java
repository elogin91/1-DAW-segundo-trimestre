package daos;

import java.util.List;

import javabeans.Perfil;

/**
 * Interface PerfilDao CRUD.
 *
 */
public interface PerfilDao {

	/**
	 * Método que introduce un perfil con sus respectivos atributos en la BBDD.
	 * 
	 * @param perfil que contiene los datos del perfil que queremos introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int altaPerfil(Perfil perfil);

	/**
	 * Método que elimina un perfil con sus respectivos atributos de la BBDD.
	 * 
	 * @param idPerfil criterio de filtro para selecccionar el perfil que queremos
	 *                 eliminar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int eliminarPerfil(int idPerfil);

	/**
	 * Método que modifica un perfil con sus respectivos atributos de la BBDD.
	 * 
	 * @param perfil que contiene los datos del perfil que queremos modificar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int modificarPerfil(Perfil perfil);

	/**
	 * Método el cual recupera un perfil de la BBDD en base a su identificador.
	 * 
	 * @param idPerfil identificador que nos sirve de criterio de filtrado.
	 * @return Perfil que cumple el criterio de filtrado con todas sus propiedades.
	 */
	Perfil buscarUnPerfil(int idPerfil);

	/**
	 * Método que recolecta todos los perfiles con sus respectivas propiedades de la
	 * BBDD.
	 * 
	 * @return una lista de todos los perfiles de la BBDD.
	 */
	List<Perfil> buscarTodosPerfiles();
}
