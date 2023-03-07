package testing;

import java.sql.Date;
import java.util.Arrays;

import daos.EmpleadoConProyectoDao;
import daos.EmpleadoConProyectoDaoImplMy8;
import daos.EmpleadoDao;
import daos.EmpleadoDaoImplMy8;
import daos.ProyectoDao;
import daos.ProyectoDaoImplMy8;
import javabeans.EmpleadoConProyecto;

public class TestEmpleadoConProyecto {
	public static void main(String[] args) {

		EmpleadoConProyectoDao empleadoConProyectoDao = new EmpleadoConProyectoDaoImplMy8();

		comprobarBuscarUno(empleadoConProyectoDao);

		comprobarBuscarTodo(empleadoConProyectoDao);

		comprobarAltaEmpleadoConProyecto(empleadoConProyectoDao);

		comprobarModificarEmpleadoConProyecto(empleadoConProyectoDao);

		comprobarBajaEmpleadoConProyecto(empleadoConProyectoDao);

		comprobarAsignarEmpleadosAProyecto(empleadoConProyectoDao);

		comprobarEmpleadosByProyecto(empleadoConProyectoDao);

		comprobarHorasAsignadasAProyecto(empleadoConProyectoDao);

		comprobarCosteActualDeProyecto(empleadoConProyectoDao);

		comprobarMargenActualProyecto(empleadoConProyectoDao);
	}

	// Comprobar método comprobarBuscarUno.
	private static void comprobarBuscarUno(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando buscar un empleado por proyecto:");

		System.out.println(empleadoConProyectoDao.buscarEmpleadoConProyecto(2));
	}

	// Comprobar método comprobarBuscarTodo.
	private static void comprobarBuscarTodo(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando buscar todos los empleado por proyecto:");

		imprimirTodos(empleadoConProyectoDao);
	}

	// Comprobar método comprobarAltaEmpleadoConProyecto.
	private static void comprobarAltaEmpleadoConProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando alta de empleado con proyecto:");
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();

		EmpleadoConProyecto empleadoConProyecto = new EmpleadoConProyecto();
		empleadoConProyecto.setNumeroOrden(5);
		empleadoConProyecto.setHorasAsignadas(40);
		empleadoConProyecto.setProyecto(proyectoDao.buscarUnProyecto("FOR2021002"));
		empleadoConProyecto.setEmpleado(empleadoDao.buscarUnEmpleado(114));
		empleadoConProyecto.setFechaIncorporacion(Date.valueOf("2023-03-07"));

		System.out.println(empleadoConProyectoDao.altaEmpleadoConProyecto(empleadoConProyecto));
		imprimirTodos(empleadoConProyectoDao);
	}

	// Comprobar método comprobarModificarDepartamento.
	private static void comprobarModificarEmpleadoConProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando modificar un empleado con proyecto:");

		EmpleadoConProyecto empleadoConProyecto = empleadoConProyectoDao.buscarEmpleadoConProyecto(5);

		empleadoConProyecto.setHorasAsignadas(80);

		System.out.println(empleadoConProyectoDao.modificaEmpleadoConProyecto(empleadoConProyecto));
		imprimirTodos(empleadoConProyectoDao);
	}

	// Comprobar método comprobarBajaEmpleadoConProyecto.
	private static void comprobarBajaEmpleadoConProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando baja de empleado con proyecto:");
		System.out.println(empleadoConProyectoDao.eliminarEmpleadoConProyecto(5));
		imprimirTodos(empleadoConProyectoDao);
	}

	// Comprobar método comprobarAsignarEmpleadosAProyecto.
	private static void comprobarAsignarEmpleadosAProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando alta de varios empleados con proyecto:");
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();

		EmpleadoConProyecto primerEmpleadoConProyecto = new EmpleadoConProyecto();
		primerEmpleadoConProyecto.setNumeroOrden(5);
		primerEmpleadoConProyecto.setHorasAsignadas(40);
		primerEmpleadoConProyecto.setProyecto(proyectoDao.buscarUnProyecto("FOR2021002"));
		primerEmpleadoConProyecto.setEmpleado(empleadoDao.buscarUnEmpleado(114));
		primerEmpleadoConProyecto.setFechaIncorporacion(Date.valueOf("2023-03-07"));

		EmpleadoConProyecto segundoEmpleadoConProyecto = new EmpleadoConProyecto();
		segundoEmpleadoConProyecto.setNumeroOrden(6);
		segundoEmpleadoConProyecto.setHorasAsignadas(20);
		segundoEmpleadoConProyecto.setProyecto(proyectoDao.buscarUnProyecto("FOR2021002"));
		segundoEmpleadoConProyecto.setEmpleado(empleadoDao.buscarUnEmpleado(115));
		segundoEmpleadoConProyecto.setFechaIncorporacion(Date.valueOf("2023-03-07"));

		System.out.println(empleadoConProyectoDao
				.asignarEmpleadosAProyecto(Arrays.asList(primerEmpleadoConProyecto, segundoEmpleadoConProyecto)));
		imprimirTodos(empleadoConProyectoDao);

		// Eliminamos de la BBDD las tuplas insertadas para el test.
		empleadoConProyectoDao.eliminarEmpleadoConProyecto(5);
		empleadoConProyectoDao.eliminarEmpleadoConProyecto(6);
	}

	// Comprobar método comprobarEmpleadosByProyecto.
	private static void comprobarEmpleadosByProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando buscar empleados por proyecto:");

		for (EmpleadoConProyecto empleadoConProyecto : empleadoConProyectoDao.empleadosByProyecto("FOR2021001")) {
			System.out.println(empleadoConProyecto);
		}
	}

	// Comprobar método comprobarHorasAsignadasAProyecto.
	private static void comprobarHorasAsignadasAProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando horas asignadas al proyecto:");
		System.out.println(empleadoConProyectoDao.horasAsignadasAProyecto("FOR2020001"));
	}

	// Comprobar método comprobarCosteActualDeProyecto.
	private static void comprobarCosteActualDeProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando coste actual proyecto:");
		System.out.println(empleadoConProyectoDao.costeActualDeProyecto("FOR2020001"));
	}

	// Comprobar método comprobarMargenActualProyecto.
	private static void comprobarMargenActualProyecto(EmpleadoConProyectoDao empleadoConProyectoDao) {
		System.out.println("------------------Comprobando margen actual proyecto:");
		System.out.println(empleadoConProyectoDao.margenActualProyecto("FOR2020001"));
	}

	// Método para imprimir el resultado de la búsqueda.
	private static void imprimirTodos(EmpleadoConProyectoDao empleadoConProyectoDao) {
		for (EmpleadoConProyecto empleadoConProyecto : empleadoConProyectoDao.buscarTodosEmpleadoConProyecto()) {
			System.out.println(empleadoConProyecto);
		}
	}
}
