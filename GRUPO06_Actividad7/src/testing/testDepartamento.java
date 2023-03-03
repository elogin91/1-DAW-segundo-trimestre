package testing;

import daos.ClienteDao;
import daos.ClienteDaoImplMy8;
import daos.DepartamentoDao;
import daos.DepartamentoDaoImplMy8;
import javabeans.Cliente;
import javabeans.Departamento;

public class testDepartamento {

	public static void main(String[] args) {

		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		comprobarBuscarUno(departamentoDao);

		comprobarBuscarTodo(departamentoDao);

		comprobarEliminarCliente(departamentoDao);

		comprobarBuscarTodo(departamentoDao);

		comprobarAltaCliente(departamentoDao);

		comprobarBuscarTodo(departamentoDao);

		comprobarModificarCliente(departamentoDao);
	}

	private static void comprobarModificarCliente(DepartamentoDao departamentoDao) {
		Departamento departamento = new Departamento(50, "DataBase", "Cadiz");
		int fila = departamentoDao.modificalDepartamento(departamento);
		System.out.println(fila);

	}

	private static void comprobarAltaCliente(DepartamentoDao departamentoDao) {
		Departamento departamento = new Departamento(50, "DataBase", "Malaga");
		int fila = departamentoDao.altaDepartamento(departamento);
		System.out.println(fila);
	}

	private static void comprobarEliminarCliente(DepartamentoDao departamentoDao) {
		int fila = departamentoDao.eliminarDepartamento(50);
		System.out.println(fila);
	}

	private static void comprobarBuscarTodo(DepartamentoDao departamentoDao) {
		for (Departamento departamento : departamentoDao.buscarTodosDepartamentos()) {
			System.out.println(departamento);
		}
	}

	private static void comprobarBuscarUno(DepartamentoDao departamentoDao) {
		Departamento departamento = departamentoDao.buscarUnDepartamento(50);

		if (departamentoDao.buscarUnDepartamento(50) != null) {
			System.out.println("El Departamento que busca tiene el nombre : " + departamento.getNombre());
		} else {
			System.out.println("Departamento no encontrado.");
		}
	}

}
