package daos;

import java.util.List;

import javabeans.Cliente;

/**
 * Interface ClienteDao CRUD.
 */
public interface ClienteDao {

	/**
	 * Método que introduce un cliente con sus respectivos atributos en la BBDD.
	 * 
	 * @param cliente contiene los datos del cliente que queremos introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int altaCliente(Cliente cliente);

	/**
	 * Método que a través de su identificador elimina un cliente con sus
	 * respectivos atributos de la BBDD.
	 * 
	 * @param cif cif identificador del cliente.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int eliminarCliente(String cif);

	/**
	 * Método que a través de su identificador modifica un cliente con sus
	 * respectivos atributos de la BBDD.
	 * 
	 * @param cliente que contiene los datos del cliente que queremos modificar de
	 *                la BBDD.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int modificarCliente(Cliente cliente);

	/**
	 * Método el cual recupera un cliente de la BBDD en base a su identificador.
	 * 
	 * @param cif identificador de cliente.
	 * @return Cliente con todos sus atributos.
	 */
	Cliente buscarUno(String cif);

	/**
	 * Método que recolecta todos los clientes con sus respectivas propiedades de la
	 * BBDD.
	 * 
	 * @return una lista de todos los clientes de la BBDD.
	 */
	List<Cliente> buscarTodo();

}
