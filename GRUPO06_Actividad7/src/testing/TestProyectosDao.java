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

		comprobarBuscarTodo(proyectoDao);

		comprobarModificarUno(proyectoDao);

		comprobarBuscarTodo(proyectoDao);

		comprobarEliminarUno(proyectoDao);

		comprobarBuscarTodo(proyectoDao);

		comprobarProyectosByEstado(proyectoDao);

		comprobarProyectosByCliente(proyectoDao);

		comprobarProyectosByJefeProyectoAndByEstado(proyectoDao);

		comprobarImportesVentaProyectosTerminados(proyectoDao);

		comprobarMargenBrutoProyectosTerminados(proyectoDao);

		comprobarDiasATerminoProyectoActivo(proyectoDao);

	}

	private static void comprobarDiasATerminoProyectoActivo(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando dias de terminos del proyecto activo:");
		System.out.println(proyectoDao.diasATerminoProyectoActivo("FOR2021001"));

	}

	private static void comprobarMargenBrutoProyectosTerminados(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando el margen bruto de las ventas y costes reales:");
		System.out.println(proyectoDao.margenBrutoProyectosTerminados());
	}

	private static void comprobarImportesVentaProyectosTerminados(ProyectoDao proyectoDao) {
		System.out.println(
				"---------------------Comprobando suma de los importes de las ventas de los proyectos terminados:");
		System.out.println(proyectoDao.importesVentaProyectosTerminados());

	}

	private static void comprobarProyectosByJefeProyectoAndByEstado(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando proyectos por Estado y Jefe de Proyecto:");
		for (Proyecto proyecto : proyectoDao.proyectosByJefeProyectoAndByEstado(114, "ACTIVO")) {
			System.out.println(proyecto);
		}
	}

	private static void comprobarProyectosByCliente(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando proyectos por Cliente:");
		for (Proyecto proyecto : proyectoDao.proyectosByCliente("FOR2020001")) {
			System.out.println(proyecto);
		}
	}

	private static void comprobarProyectosByEstado(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando proyectos por Estado:");
		for (Proyecto proyecto : proyectoDao.proyectosByEstado("ACTIVO")) {
			System.out.println(proyecto);
		}
	}

	private static void comprobarModificarUno(ProyectoDao proyectoDao) throws ParseException {
		System.out.println("---------------------Comprobando modificar proyecto");
		ClienteDao clienteDao = new ClienteDaoImplMy8();
		EmpleadoDao jefeProyectoDao = new EmpleadoDaoImplMy8();

		Proyecto proyecto = new Proyecto("FOR2021004", "Formación técnicos en marketing MODIFICADO", "ACTIVO",
				Date.valueOf("2020-01-13"), Date.valueOf("2025-01-13"), null, 75000.00, 50000.00,
				48765.99, jefeProyectoDao.buscarUnEmpleado(114), clienteDao.buscarUno("A22222222"));

		int fila = proyectoDao.modificarProyecto(proyecto);
		System.out.println(fila);
	}

	private static void comprobarAlta(ProyectoDao proyectoDao) throws ParseException {
		System.out.println("---------------------Comprobando alta proyecto");
		ClienteDao clienteDao = new ClienteDaoImplMy8();
		EmpleadoDao jefeProyectoDao = new EmpleadoDaoImplMy8();

		Proyecto proyecto = new Proyecto("FOR2021004", "Formación técnicos en marketing", "ACTIVO",
				Date.valueOf("2020-01-13"), Date.valueOf("2025-01-13"), null, 75000.00, 50000.00,
				48765.99, jefeProyectoDao.buscarUnEmpleado(114), clienteDao.buscarUno("A22222222"));

		int fila = proyectoDao.altaProyecto(proyecto);
		System.out.println(fila);
	}

	private static void comprobarEliminarUno(ProyectoDao proyectoDao) {
		System.out.println("---------------------Comprobando eliminar proyecto");
		int fila = proyectoDao.eliminarProyecto("FOR2021004");
		System.out.println(fila);
	}

	private static void comprobarBuscarTodo(ProyectoDao proyectoDao) {
		System.out.println("--------------------- Comprobando Mostrando todos los proyectos");
		for (Proyecto proyecto : proyectoDao.buscarTodosProyectos()) {
			System.out.println(proyecto);
		}
	}

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
