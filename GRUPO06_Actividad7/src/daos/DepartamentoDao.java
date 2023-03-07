package daos;

import java.util.List;

import javabeans.Departamento;

/**
 * Interface DepartamentoDao CRUD.
 */
public interface DepartamentoDao {

	/**
	 * Método que introduce un departamento con sus respectivos atributos en la
	 * BBDD.
	 * 
	 * @param departamento que contiene los datos del departamento que queremos
	 *                     introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int altaDepartamento(Departamento departamento);

	/**
	 * Método que a través de su identificador elimina un departamento con sus
	 * respectivos atributos de la BBDD.
	 * 
	 * @param idDepartamento identificador de departamento.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int eliminarDepartamento(int idDepartamento);

	/**
	 * Método que modifica un departamento con sus respectivos atributos de la BBDD.
	 * 
	 * @param departamento que contiene los datos del departamento que queremos
	 *                     modificar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int modificarDepartamento(Departamento departamento);

	/**
	 * Método el cual recupera un departamento de la BBDD en base a su
	 * identificador.
	 * 
	 * @param idDepartamento identificador de departamento.
	 * @return Departamento con todas sus propiedades.
	 */
	Departamento buscarUnDepartamento(int idDepartamento);

	/**
	 * Método que recolecta todos los departamentos con sus respectivas propiedades
	 * de la BBDD.
	 * 
	 * @return una lista de todos los clientes de la BBDD.
	 */
	List<Departamento> buscarTodosDepartamentos();

}
