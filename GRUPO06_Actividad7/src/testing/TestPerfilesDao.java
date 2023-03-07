package testing;

import daos.PerfilDaoImplMy8;
import javabeans.Perfil;

public class TestPerfilesDao {

	public static void main(String[] args) {

		PerfilDaoImplMy8 perfilDao = new PerfilDaoImplMy8();

		comprobarBuscarUno(perfilDao);

		comprobarBuscarTodo(perfilDao);

		comprobarAltaCliente(perfilDao);

		comprobarModificarCliente(perfilDao);

		comprobarEliminarCliente(perfilDao);

	}

	// Comprobamos el método modificarPerfil.
	private static void comprobarModificarCliente(PerfilDaoImplMy8 perfilDao) {
		System.out.println("--------------------- Comprobar modificar un PERFIL:");
		Perfil perfil = new Perfil(5, "Product Manager", 11.99);
		int fila = perfilDao.modificarPerfil(perfil);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(perfilDao);
	}

	// Comprobamos el método altaPerfil.
	private static void comprobarAltaCliente(PerfilDaoImplMy8 perfilDao) {
		System.out.println("--------------------- Comprobar alta un  PERFIL:");
		Perfil perfil = new Perfil(5, "Product Galleta", 12.00);
		int fila = perfilDao.altaPerfil(perfil);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(perfilDao);
	}

	// Comprobamos el método elimiarPerfil.
	private static void comprobarEliminarCliente(PerfilDaoImplMy8 perfilDao) {
		System.out.println("--------------------- Comprobar eliminar un  PERFIL:");
		int fila = perfilDao.eliminarPerfil(5);
		System.out.println("Número de filas afectadas por el statement: " + fila);
		imprimirTodos(perfilDao);
	}

	// Comprobamos el método buscarTodosPerfiles.
	private static void comprobarBuscarTodo(PerfilDaoImplMy8 perfilDao) {
		System.out.println("--------------------- Comprobar buscar TODOS los  PERFILES:");
		imprimirTodos(perfilDao);
	}

	// Método que imprime por consola los perfiles de la lista que devuelve el
	// método buscarTodo.
	private static void imprimirTodos(PerfilDaoImplMy8 perfilDao) {
		for (Perfil perfil : perfilDao.buscarTodosPerfiles()) {
			System.out.println(perfil);
		}
	}

	// Comprobamos el método buscarUnPerfil.
	private static void comprobarBuscarUno(PerfilDaoImplMy8 perfilDao) {
		System.out.println("--------------------- Comprobar buscar un  PERFIL:");
		Perfil perfil = perfilDao.buscarUnPerfil(1);

		if (perfil != null) {
			System.out.println("El PERFIL que busca tiene el nombre : " + perfil.getNombre());
		} else {
			System.out.println("Perfil no encontrado.");
		}
	}

}
