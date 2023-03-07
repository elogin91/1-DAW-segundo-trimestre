package testing;

import java.sql.Date;
import java.text.ParseException;

import daos.DepartamentoDao;
import daos.DepartamentoDaoImplMy8;
import daos.EmpleadoDao;
import daos.EmpleadoDaoImplMy8;
import daos.PerfilDao;
import daos.PerfilDaoImplMy8;
import javabeans.Empleado;

public class TestEmpleadoDao {

	public static void main(String[] args) throws Exception {

		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();

		comprobarBuscarUno(empleadoDao);

		comprobarBuscarTodo(empleadoDao);

		comprobarAltaEmpleado(empleadoDao);

		comprobarModificarEmpleado(empleadoDao);

		comprobarEliminarEmpleado(empleadoDao);

		comprobarEmpleadosByDepartamento(empleadoDao);

		comprobarEmpleadosBySexo(empleadoDao);

		comprobarEmpleadosByApellido(empleadoDao);

		comprobarSalarioTotal(empleadoDao);
	}

	// Comprobamos el método salarioTotal.
	private static void comprobarSalarioTotal(EmpleadoDao empleadoDao) {
		System.out.println("--------------------Comprobando salario total pasando parametros:");
		System.out.println(empleadoDao.salarioTotal(10));
		System.out.println("--------------------Comprobando salario total SIN parametros:");
		System.out.println(empleadoDao.salarioTotal());
	}

	// Comprobamos el método empleadosByApellido.
	private static void comprobarEmpleadosByApellido(EmpleadoDao empleadoDao) {
		System.out.println("--------------------Comprobando empleados por apellido:");
		for (Empleado empleado : empleadoDao.empleadosByApellido("az")) {
			System.out.println(empleado);
		}

	}

	// Comprobamos el método empleadosBySexo.
	private static void comprobarEmpleadosBySexo(EmpleadoDao empleadoDao) {
		System.out.println("--------------------Comprobando empleados por sexo:");
		for (Empleado empleado : empleadoDao.empleadosBySexo('h')) {
			System.out.println(empleado);
		}

	}

	// Comprobamos el método empleadosByDepartamento.
	private static void comprobarEmpleadosByDepartamento(EmpleadoDao empleadoDao) {
		System.out.println("--------------------Comprobando empleados por departamento:");
		for (Empleado empleado : empleadoDao.empleadosByDepartamento(10)) {
			System.out.println(empleado);
		}

	}

	// Comprobamos el método modificarEmpleado.
	private static void comprobarModificarEmpleado(EmpleadoDao empleadoDao) throws ParseException {
		System.out.println("-------------------Comprobando modificar empleado:");
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		Empleado empleado = new Empleado(150, perfilDao.buscarUnPerfil(1), departamentoDao.buscarUnDepartamento(10),
				"Luisa", "Pérez", 'm', "nuevoluisita@gmail.com", "1234", 14000.99, Date.valueOf("2020-01-13"),
				Date.valueOf("2020-01-13"));
		int fila = empleadoDao.modificarEmpleado(empleado);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodo(empleadoDao);
	}

	// Comprobamos el método altaEmpleado.
	private static void comprobarAltaEmpleado(EmpleadoDao empleadoDao) throws ParseException {
		System.out.println("-------------------Comprobando alta cliente:");
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		Empleado empleado = new Empleado(150, perfilDao.buscarUnPerfil(1), departamentoDao.buscarUnDepartamento(10),
				"Luisa", "Perez", 'm', "luisita@gmail.com", "1234", 13000.99, Date.valueOf("2020-01-13"),
				Date.valueOf("2020-01-13"));
		int fila = empleadoDao.altaEmpleado(empleado);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodo(empleadoDao);
	}

	// Comprobamos el método eliminarEmpleado.
	private static void comprobarEliminarEmpleado(EmpleadoDao empleadoDao) {
		System.out.println("-------------------Comprobando eliminar cliente");
		int fila = empleadoDao.eliminarEmpleado(150);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodo(empleadoDao);
	}

	// Comprobamos el método buscarTodosEmpleados.
	private static void comprobarBuscarTodo(EmpleadoDao empleadoDao) {
		System.out.println("-------------------Mostrando todos los empleados");
		imprimirTodo(empleadoDao);
	}

	// Método que imprime por consola los empledados de la lista que devuelve el
	// método
	// buscarTodo.
	private static void imprimirTodo(EmpleadoDao empleadoDao) {
		for (Empleado empleado : empleadoDao.buscarTodosEmpleados()) {
			System.out.println(empleado);
		}
	}

	// Comprobamos el método buscarUnEmpleado.
	private static void comprobarBuscarUno(EmpleadoDao empleadoDao) {
		System.out.println("-------------------Comprobando buscar un empleado");
		Empleado empleado = empleadoDao.buscarUnEmpleado(100);

		if (empleado != null) {
			System.out.println("El empleado que busca tiene el nombre : " + empleado.getNombre());
		} else {
			System.out.println("Empleado no encontrado.");
		}
	}

}
