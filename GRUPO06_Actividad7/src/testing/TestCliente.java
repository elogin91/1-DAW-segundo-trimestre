package testing;

import daos.ClienteDao;
import daos.ClienteDaoImplMy8;
import javabeans.Cliente;

public class TestCliente {

	public static void main(String[] args) {

		ClienteDao clienteDao = new ClienteDaoImplMy8();

		comprobarBuscarUno(clienteDao);

		comprobarBuscarTodo(clienteDao);
		
		comprobarEliminarCliente(clienteDao);
		
		comprobarBuscarTodo(clienteDao);
		
		comprobarAltaCliente(clienteDao);
		
		comprobarBuscarTodo(clienteDao);
		
		comprobarModificarCliente(clienteDao);
	}

	private static void comprobarModificarCliente(ClienteDao clienteDao) {
		Cliente cliente = new Cliente("A33333333", "Ana Maria Modificado", "Perez", "Málaga", 13000.99, 13);
		int fila = clienteDao.modificarCliente(cliente);
		System.out.println(fila);
		
	}

	private static void comprobarAltaCliente(ClienteDao clienteDao) {
		Cliente cliente = new Cliente("A33333333", "Ana", "Perez", "Málaga", 13000.99, 13);
		int fila = clienteDao.altaCliente(cliente);
		System.out.println(fila);
	}
	
	private static void comprobarEliminarCliente(ClienteDao clienteDao) {
		int fila = clienteDao.eliminarCliente("A33333333");
		System.out.println(fila);
	}

	private static void comprobarBuscarTodo(ClienteDao clienteDao) {
		for (Cliente cliente : clienteDao.buscarTodo()) {
			System.out.println(cliente);
		}
	}

	private static void comprobarBuscarUno(ClienteDao clienteDao) {
		Cliente cliente = clienteDao.buscarUno("A22222222");

		if (cliente != null) {
			System.out.println("El cliente que busca tiene el nombre : " + cliente.getNombre());
		} else {
			System.out.println("Cliente no encontrado.");
		}
	}

}
