package testing;

import java.sql.Date;
import java.text.ParseException;

import daos.ClienteDao;
import daos.ClienteDaoImplMy8;
import daos.EmpleadoDao;
import daos.EmpleadoDaoImplMy8;
import daos.ProyectoDao;
import daos.ProyectoDaoImplMy8;
import javabeans.Proyecto;

public class TestProyectosDao {

	public static void main(String[] args) throws Exception {

		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();

		comprobarBuscarUno(proyectoDao);

		comprobarBuscarTodo(proyectoDao);

		comprobarAlta(proyectoDao);

		comprobarModificarUno(proyectoDao);

		comprobarEliminarUno(proyectoDao);

		comprobarProyectosByEstado(proyectoDao);

		comprobarProyectosByCliente(proyectoDao);

		comprobarProyectosByJefeProyectoAndByEstado(proyectoDao);

		comprobarImportesVentaProyectosTerminados(proyectoDao);

		comprobarMargenBrutoProyectosTerminados(proyectoDao);

		comprobarDiasATerminoProyectoActivo(proyectoDao);

	}

	// Comprobamos método diasATerminoProyectoActivo.
	private static void comprobarDiasATerminoProyectoActivo(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando dias de terminos del proyecto activo:");
		System.out.println("Quedan los siguientes días para terminar el proyecto "
				+ proyectoDao.diasATerminoProyectoActivo("FOR2021001"));
	}

	// Compprobamos método margenBrutoProyectosTerminados.
	private static void comprobarMargenBrutoProyectosTerminados(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando el margen bruto de las ventas y costes reales:");
		System.out.println("El margen de de ganancia del proyecto terminado y seleccionado es:"
				+ proyectoDao.margenBrutoProyectosTerminados());
	}

	// Comprobamos el método importesVentaProyectosTerminados.
	private static void comprobarImportesVentaProyectosTerminados(ProyectoDao proyectoDao) {
		System.out.println(
				"---------------------Comprobando suma de los importes de las ventas de los proyectos terminados:");
		System.out.println(
				"Ventas del proyecto terminado y seleccionado: " + proyectoDao.importesVentaProyectosTerminados());

	}

	// Comprobamos el método proyectosByJefeProyectoAndByEstado.
	private static void comprobarProyectosByJefeProyectoAndByEstado(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando proyectos por Estado y Jefe de Proyecto:");
		for (Proyecto proyecto : proyectoDao.proyectosByJefeProyectoAndByEstado(114, "ACTIVO")) {
			System.out.println(proyecto);
		}
	}

	// Comprobamos el método proyectosByCliente.
	private static void comprobarProyectosByCliente(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando proyectos por Cliente:");
		for (Proyecto proyecto : proyectoDao.proyectosByCliente("A22222222")) {
			System.out.println(proyecto);
		}
	}

	// Comprobamos el método proyectosByEstado.
	private static void comprobarProyectosByEstado(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando proyectos por Estado:");
		for (Proyecto proyecto : proyectoDao.proyectosByEstado("ACTIVO")) {
			System.out.println(proyecto);
		}
	}

	// Comprobamos el método modificarProyecto.
	private static void comprobarModificarUno(ProyectoDao proyectoDao) throws ParseException {
		System.out.println("---------------------Comprobando modificar proyecto");
		ClienteDao clienteDao = new ClienteDaoImplMy8();
		EmpleadoDao jefeProyectoDao = new EmpleadoDaoImplMy8();

		Proyecto proyecto = new Proyecto("FOR2021004", "Formación técnicos en marketing MODIFICADO", "ACTIVO",
				Date.valueOf("2020-01-13"), Date.valueOf("2025-01-13"), null, 75000.00, 50000.00, 48765.99,
				jefeProyectoDao.buscarUnEmpleado(114), clienteDao.buscarUno("A22222222"));

		int fila = proyectoDao.modificarProyecto(proyecto);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodo(proyectoDao);
	}

	// Comprobamos el método altaProyecto.
	private static void comprobarAlta(ProyectoDao proyectoDao) throws ParseException {
		System.out.println("---------------------Comprobando alta proyecto");
		ClienteDao clienteDao = new ClienteDaoImplMy8();
		EmpleadoDao jefeProyectoDao = new EmpleadoDaoImplMy8();

		Proyecto proyecto = new Proyecto("FOR2021004", "Formación técnicos en marketing", "ACTIVO",
				Date.valueOf("2020-01-13"), Date.valueOf("2025-01-13"), null, 75000.00, 50000.00, 48765.99,
				jefeProyectoDao.buscarUnEmpleado(114), clienteDao.buscarUno("A22222222"));

		int fila = proyectoDao.altaProyecto(proyecto);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodo(proyectoDao);
	}

	// Comprobamos el método eliminarProyecto.
	private static void comprobarEliminarUno(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando eliminar proyecto");
		int fila = proyectoDao.eliminarProyecto("FOR2021004");
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodo(proyectoDao);
	}

	// Comprobamos el método buscarTodosProyectos.
	private static void comprobarBuscarTodo(ProyectoDao proyectoDao) {
		System.out.println("--------------------- Comprobando Mostrando todos los proyectos");
		imprimirTodo(proyectoDao);
	}

	// Método que imprime por consola los poyectos de la lista que devuelve el
	// método buscarTodo.
	private static void imprimirTodo(ProyectoDao proyectoDao) {
		for (Proyecto proyecto : proyectoDao.buscarTodosProyectos()) {
			System.out.println(proyecto);
		}
	}

	// Comprobamos el método buscarUnProyecto.
	private static void comprobarBuscarUno(ProyectoDao proyectoDao) {
		System.out.println("--------------------- Comprobando buscar un proyecto");
		Proyecto proyecto = proyectoDao.buscarUnProyecto("FOR2021002");

		if (proyecto != null) {
			System.out.println("El proyecto que busca tiene la descripcion : " + proyecto.getDescripcion());
		} else {
			System.out.println("Proyecto no encontrado.");
		}
	}

}
