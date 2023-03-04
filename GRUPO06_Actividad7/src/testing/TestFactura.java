package testing;

import daos.FacturaDao;
import daos.FacturaDaoImplMy8;
import daos.ProyectoDao;
import daos.ProyectoDaoImplMy8;
import javabeans.Factura;

public class TestFactura {

	public static void main(String[] args) {

		FacturaDao facturaDao = new FacturaDaoImplMy8();

		comprobarBuscarUno(facturaDao);

		comprobarBuscarTodo(facturaDao);

		compobarAlta(facturaDao);

		comprobarBuscarTodo(facturaDao);

		comprobarModidificarUno(facturaDao);

		comprobarBuscarTodo(facturaDao);

		comprobarEliminar(facturaDao);

		comprobarBuscarTodo(facturaDao);
	}

	private static void comprobarModidificarUno(FacturaDao facturaDao) {
		System.out.println("--------------------- Comprobar modificar una  FACTURA:");
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		Factura factura = new Factura("F2020002", "Formacion a empleado MODIFICADO",
				proyectoDao.buscarUnProyecto("FOR2020001"));
		int fila = facturaDao.modificalFactura(factura);
		System.out.println(fila);

	}

	private static void compobarAlta(FacturaDao facturaDao) {
		System.out.println("--------------------- Comprobar alta una  FACTURA:");
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		Factura factura = new Factura("F2020002", "Formacion a ", proyectoDao.buscarUnProyecto("FOR2020001"));
		int fila = facturaDao.altaFactura(factura);
		System.out.println(fila);
	}

	private static void comprobarEliminar(FacturaDao facturaDao) {
		System.out.println("--------------------- Comprobar eliminar una  FACTURA:");
		int fila = facturaDao.eliminarFactura("F2020002");
		System.out.println(fila);
	}

	private static void comprobarBuscarTodo(FacturaDao facturaDao) {
		System.out.println("--------------------- Comprobar buscar TODAS las FACTURAS:");
		for (Factura factura : facturaDao.buscarTodasFacturas()) {
			System.out.println(factura);
		}
	}

	private static void comprobarBuscarUno(FacturaDao facturaDao) {
		System.out.println("--------------------- Comprobar buscar una  FACTURA:");
		Factura factura = facturaDao.buscarUnaFactura("F2020001");

		if (factura != null) {
			System.out.println("La factura que busca tiene la descripcion : " + factura.getDescripcion());
		} else {
			System.out.println("Departamento no encontrado.");
		}
	}

}
