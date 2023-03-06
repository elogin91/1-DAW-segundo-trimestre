package testing;

import daos.PerfilDaoImplMy8;
import javabeans.Perfil;

public class TestPerfiles {

	public static void main(String[] args) {

		PerfilDaoImplMy8 perfilDao = new PerfilDaoImplMy8();

		comprobarBuscarUno(perfilDao);

		comprobarBuscarTodo(perfilDao);

		comprobarEliminarCliente(perfilDao);

		comprobarBuscarTodo(perfilDao);

		comprobarAltaCliente(perfilDao);

		comprobarBuscarTodo(perfilDao);

		comprobarModificarCliente(perfilDao);
	}

	private static void comprobarModificarCliente(PerfilDaoImplMy8 perfilDao) {
		Perfil perfil = new Perfil(5, "Product Manager", 11.99);
		int fila = perfilDao.modificarPerfil(perfil);
		System.out.println(fila);

	}

	private static void comprobarAltaCliente(PerfilDaoImplMy8 perfilDao) {
		Perfil perfil = new Perfil(5, "Product Galleta", 12.00);
		int fila = perfilDao.altaPerfil(perfil);
		System.out.println(fila);
	}

	private static void comprobarEliminarCliente(PerfilDaoImplMy8 perfilDao) {
		int fila = perfilDao.eliminarPerfil(5);
		System.out.println(fila);
	}

	private static void comprobarBuscarTodo(PerfilDaoImplMy8 perfilDao) {
		for (Perfil perfil : perfilDao.buscarTodosPerfiles()) {
			System.out.println(perfil);
		}
	}

	private static void comprobarBuscarUno(PerfilDaoImplMy8 perfilDao) {
		Perfil perfil = perfilDao.buscarUnPerfil(5);

		if (perfilDao.buscarUnPerfil(5) != null) {
			System.out.println("El Departamento que busca tiene el nombre : " + perfil.getNombre());
		} else {
			System.out.println("Departamento no encontrado.");
		}
	}

}
