package testing;

import daos.DepartamentoDao;
import daos.DepartamentoDaoImplMy8;
import javabeans.Departamento;

public class TestDepartamentoDao {

	public static void main(String[] args) {

		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		comprobarBuscarUno(departamentoDao);

		comprobarBuscarTodo(departamentoDao);

		comprobarAltaDepartamento(departamentoDao);

		comprobarModificarDepartamento(departamentoDao);

		comprobarEliminarDepartamento(departamentoDao);
	}

	// Comprobar método modificarDepartamento.
	private static void comprobarModificarDepartamento(DepartamentoDao departamentoDao) {
		System.out.println("------------------Comprobando modificar departamentos:");
		Departamento departamento = new Departamento(50, "DataBase", "Cadiz");
		int fila = departamentoDao.modificarDepartamento(departamento);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(departamentoDao);

	}

	// Comprobar método altaDepartamento.
	private static void comprobarAltaDepartamento(DepartamentoDao departamentoDao) {
		System.out.println("------------------Comprobando alta departamentos:");
		Departamento departamento = new Departamento(50, "DataBase", "Malaga");
		int fila = departamentoDao.altaDepartamento(departamento);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(departamentoDao);
	}

	// Comprobar método eliminarDepartamento.
	private static void comprobarEliminarDepartamento(DepartamentoDao departamentoDao) {
		System.out.println("------------------Comprobando eliminar departamentos:");
		int fila = departamentoDao.eliminarDepartamento(50);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(departamentoDao);
	}

	// Comprobar método buscarTodosDepartamento.
	private static void comprobarBuscarTodo(DepartamentoDao departamentoDao) {
		System.out.println("------------------Comprobando buscar todos los departamentos:");
		imprimirTodos(departamentoDao);
	}

	// Método que imprime por consola los departamentos que devuelve el método
	// buscarTodosDepartamentos.
	private static void imprimirTodos(DepartamentoDao departamentoDao) {
		for (Departamento departamento : departamentoDao.buscarTodosDepartamentos()) {
			System.out.println(departamento);
		}
	}

	// Comprobar método buscarUnDepartamento.
	private static void comprobarBuscarUno(DepartamentoDao departamentoDao) {
		System.out.println("------------------Comprobando buscar un departamento:");
		Departamento departamento = departamentoDao.buscarUnDepartamento(50);

		if (departamentoDao.buscarUnDepartamento(50) != null) {
			System.out.println("El Departamento que busca tiene el nombre : " + departamento.getNombre());
		} else {
			System.out.println("Departamento no encontrado.");
		}
	}

}
