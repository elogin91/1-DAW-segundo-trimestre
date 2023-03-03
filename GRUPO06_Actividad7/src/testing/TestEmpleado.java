package testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import daos.DepartamentoDao;
import daos.DepartamentoDaoImplMy8;
import daos.EmpleadoDao;
import daos.EmpleadoDaoImplMy8;
import daos.PerfilDao;
import daos.PerfilDaoImplMy8;

import javabeans.Empleado;

public class TestEmpleado {

	public static void main(String[] args) throws Exception {

		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();

		comprobarBuscarUno(empleadoDao);

		comprobarBuscarTodo(empleadoDao);

		comprobarAltaCliente(empleadoDao);

		comprobarBuscarTodo(empleadoDao);

		comprobarModificarCliente(empleadoDao);

		comprobarBuscarTodo(empleadoDao);

		comprobarEliminarEmpleado(empleadoDao);

		comprobarBuscarTodo(empleadoDao);

		comprobarEmpleadosByDepartamento(empleadoDao);

		comprobarEmpleadosBySexo(empleadoDao);

		comprobarEmpleadosByApellido(empleadoDao);

		comprobarSalarioTotal(empleadoDao);
	}

	private static void comprobarSalarioTotal(EmpleadoDao empleadoDao) {
		System.out.println("Comprobando salario total");
		System.out.println(empleadoDao.salarioTotal(10));
		System.out.println(empleadoDao.salarioTotal());
	}

	private static void comprobarEmpleadosByApellido(EmpleadoDao empleadoDao) {
		System.out.println("Comprobando empleados por apellido");
		for (Empleado empleado : empleadoDao.empleadosByApellido("Diaz")) {
			System.out.println(empleado);
		}

	}

	private static void comprobarEmpleadosBySexo(EmpleadoDao empleadoDao) {
		System.out.println("Comprobando empleados por sexo");
		for (Empleado empleado : empleadoDao.empleadosBySexo('h')) {
			System.out.println(empleado);
		}

	}

	private static void comprobarEmpleadosByDepartamento(EmpleadoDao empleadoDao) {
		System.out.println("Comprobando empleados por departamento");
		for (Empleado empleado : empleadoDao.empleadosByDepartamento(10)) {
			System.out.println(empleado);
		}

	}

	private static void comprobarModificarCliente(EmpleadoDao empleadoDao) throws ParseException {
		System.out.println("Comprobando modificar cliente");
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Empleado empleado = new Empleado(150, perfilDao.buscarUnPerfil(1), departamentoDao.buscarUnDepartamento(10),
				"Luisa", "Pérez", 'm', "nuevoluisita@gmail.com", "1234", 14000.99, dateFormatter.parse("2020-01-13"),
				dateFormatter.parse("2020-01-13"));
		int fila = empleadoDao.modificalEmpleado(empleado);
		System.out.println(fila);
	}

	private static void comprobarAltaCliente(EmpleadoDao empleadoDao) throws ParseException {
		System.out.println("Comprobando alta cliente");
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Empleado empleado = new Empleado(150, perfilDao.buscarUnPerfil(1), departamentoDao.buscarUnDepartamento(10),
				"Luisa", "Perez", 'm', "luisita@gmail.com", "1234", 13000.99, dateFormatter.parse("2020-01-13"),
				dateFormatter.parse("2020-01-13"));
		int fila = empleadoDao.altaEmpleado(empleado);
		System.out.println(fila);
	}

	private static void comprobarEliminarEmpleado(EmpleadoDao empleadoDao) {
		System.out.println("Comprobando eliminar cliente");
		int fila = empleadoDao.eliminarEmpleado(150);
		System.out.println(fila);
	}

	private static void comprobarBuscarTodo(EmpleadoDao empleadoDao) {
		System.out.println("Mostrando todos los empleados");
		for (Empleado empleado : empleadoDao.buscarTodosEmpleados()) {
			System.out.println(empleado);
		}
	}

	private static void comprobarBuscarUno(EmpleadoDao empleadoDao) {
		System.out.println("Comprobando buscar un empleado");
		Empleado empleado = empleadoDao.buscarUnEmpleado(100);

		if (empleadoDao.buscarUnEmpleado(100) != null) {
			System.out.println("El empleado que busca tiene el nombre : " + empleado.getNombre());
		} else {
			System.out.println("Empleado no encontrado.");
		}
	}

}
