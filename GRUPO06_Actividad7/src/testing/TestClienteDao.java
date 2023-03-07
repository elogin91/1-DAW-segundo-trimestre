package testing;

import daos.ClienteDao;
import daos.ClienteDaoImplMy8;
import javabeans.Cliente;

/**
 * 
 * En esta clase se realizan test para probar los métodos implementados en la
 * clase ClienteDaoImplMy8.
 * 
 */
public class TestClienteDao {

	public static void main(String[] args) {

		ClienteDao clienteDao = new ClienteDaoImplMy8();

		comprobarBuscarUno(clienteDao);

		comprobarBuscarTodo(clienteDao);

		comprobarAltaCliente(clienteDao);

		comprobarModificarCliente(clienteDao);

		comprobarEliminarCliente(clienteDao);

	}

	// Comprobamos el método modificarCliente.
	private static void comprobarModificarCliente(ClienteDao clienteDao) {
		System.out.println("--------------Comprobando modificar cliente:");
		Cliente cliente = new Cliente("A33333333", "Ana Maria Modificado", "Perez", "Málaga", 13000.99, 13);
		int fila = clienteDao.modificarCliente(cliente);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(clienteDao);

	}

	// Comprobamos el método altaCliente.
	private static void comprobarAltaCliente(ClienteDao clienteDao) {
		System.out.println("--------------Comprobando alta cliente:");
		Cliente cliente = new Cliente("A33333333", "Ana", "Perez", "Málaga", 13000.99, 13);
		int fila = clienteDao.altaCliente(cliente);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(clienteDao);
	}

	// Comprobamos el método eliminarCliente.
	private static void comprobarEliminarCliente(ClienteDao clienteDao) {
		System.out.println("--------------Comprobando eliminar cliente:");
		int fila = clienteDao.eliminarCliente("A33333333");
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(clienteDao);
	}

	// Método que imprime por consola los clientes de la lista que devuelve el
	// método
	// buscarTodo.
	private static void imprimirTodos(ClienteDao clienteDao) {
		for (Cliente cliente : clienteDao.buscarTodo()) {
			System.out.println(cliente);
		}
	}

	// Comprobamos el método buscarCliente.
	private static void comprobarBuscarTodo(ClienteDao clienteDao) {
		System.out.println("--------------Comprobando buscar todos los clientes:");
		imprimirTodos(clienteDao);
	}

	// Comprobamos el método buscarUno.
	private static void comprobarBuscarUno(ClienteDao clienteDao) {
		System.out.println("--------------Comprobando buscar uno:");
		Cliente cliente = clienteDao.buscarUno("A22222222");

		if (cliente != null) {
			System.out.println("El cliente que busca tiene el nombre : " + cliente.getNombre());
		} else {
			System.out.println("Cliente no encontrado.");
		}
	}

}
