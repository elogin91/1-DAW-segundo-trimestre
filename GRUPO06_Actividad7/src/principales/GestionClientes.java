package principales;

import java.util.Scanner;

import daos.ClienteDao;
import daos.ClienteDaoImplMy8;
import javabeans.Cliente;

/*
 * Hacer una clase con main estático GestionClientes con un menú con las
 * siguientes opciones:
 * 
 * 	1.Alta del Cliente.
 * 	2.Buscar un Cliente.
 *  3.Mostrar Todos. 
 *  4.Eliminar un cliente 
 *  5.Salir.
 *  
 */
public class GestionClientes {
	private int opcion = 0;
	Scanner leer = new Scanner(System.in);

	public static void main(String[] args) {

		GestionClientes gestionandoCliente = new GestionClientes();

		// Iniciamos el programa para gestionar clientes, hasta que el usuario pulse la
		// operación "Salir".
		while (gestionandoCliente.opcion != 5) {
			gestionandoCliente.pintaMenu();
			gestionandoCliente.leerOpcion();
			gestionandoCliente.seleccionaOpcion();
		}
	}

	/**
	 * Método que selecciona la operación a realizar según la opción elegida.
	 */
	private void seleccionaOpcion() {
		if (opcion == 1) {
			ejecutarAltaCliente();
		} else if (opcion == 2) {
			ejecutarBuscarCliente();
		} else if (opcion == 3) {
			ejecutarMostrarTodosClientes();
		} else if (opcion == 4) {
			ejecutarEliminarCliente();
		} else if (opcion == 5) {
			ejecutarSalir();
		} else {
			System.out.println("Opción elegida no correcta. Por favor pulse un número correcto.");
		}

	}

	/**
	 * Método que ejecuta la opcion salir del programa.
	 */
	private void ejecutarSalir() {
		System.out.println("Cerrando el programa. ¡Hasta la próxima!");

	}

	/**
	 * Método que ejecuta la opcion eliminar cliente del programa.
	 */
	private void ejecutarEliminarCliente() {
		System.out.println("Introduzca el cif del cliente a eliminar:");
		String cif = leer.nextLine();
		ClienteDao clienteDao = new ClienteDaoImplMy8();
		Cliente cliente = clienteDao.buscarUno(cif);

		if (cliente != null) {
			System.out.println("Borrando el cliente con nombre : " + cliente.getNombre());
			clienteDao.eliminarCliente(cif);
		} else {
			System.out.println("Cliente no encontrado.");
		}

	}

	/**
	 * Método que ejecuta la mostrar todos los clientes del programa.
	 */
	private void ejecutarMostrarTodosClientes() {
		ClienteDao clienteDao = new ClienteDaoImplMy8();

		System.out.println("Mostrando Todos los Clientes:");
		for (Cliente cliente : clienteDao.buscarTodo()) {
			System.out.println(cliente);
		}
	}

	/**
	 * Método que ejecuta la opcion buscar un cliente del programa.
	 */
	private void ejecutarBuscarCliente() {
		System.out.println("Introduzca el cif del cliente a mostrar:");
		String cif = leer.nextLine();
		ClienteDao clienteDao = new ClienteDaoImplMy8();
		Cliente cliente = clienteDao.buscarUno(cif);

		if (cliente != null) {
			System.out.println("Mostrando el cliente buscado : " + cliente);
		} else {
			System.out.println("Cliente no encontrado.");
		}

	}

	/**
	 * Método que ejecuta la opcion alta de cliente del programa.
	 */
	private void ejecutarAltaCliente() {
		System.out.println("Introduzca los datos del cliente a agregar:");
		System.out.println("Introduzca el CIf:");
		String cif = leer.nextLine();
		System.out.println("Introduzca el nombre:");
		String nombre = leer.nextLine();
		System.out.println("Introduzca los apellidos:");
		String apellidos = leer.nextLine();
		System.out.println("Introduzca el domicilio:");
		String domicilio = leer.nextLine();
		System.out.println("Introduzca la facturacion anual:");
		double facturacionAnual = Double.parseDouble(leer.nextLine());
		System.out.println("Introduzca el número de empleados:");
		int numeroEmpleados = Integer.parseInt(leer.nextLine());

		Cliente cliente = new Cliente(cif, nombre, apellidos, domicilio, facturacionAnual, numeroEmpleados);
		ClienteDao clienteDao = new ClienteDaoImplMy8();

		if (clienteDao.altaCliente(cliente) == 1) {
			System.out.println("Cliente agregado correctamente.");
			System.out.println("Cliente agregado: " + clienteDao.buscarUno(cif));
		}
	}

	/**
	 * Método recolecta la opción cogida por el usuario.
	 */
	private int leerOpcion() {
		return opcion = Integer.parseInt(leer.nextLine());

	}

	/**
	 * Método que imprime el menú de las opciones disponibles en el programa por
	 * consola.
	 */
	private void pintaMenu() {
		System.out.println("Iniciando Gestión de Clientes, por favor elija una opción marcando el número:");
		System.out.println("1. Alta de Cliente.");
		System.out.println("2. Buscar un Cliente.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Eliminar un cliente.");
		System.out.println("5. Salir.");
	}

}
