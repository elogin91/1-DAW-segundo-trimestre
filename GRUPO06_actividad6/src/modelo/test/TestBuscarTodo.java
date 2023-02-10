package modelo.test;

import modelo.dao.Instituto;
import modelo.javabean.Persona;

public class TestBuscarTodo {

	public static void main(String[] args) {

		// Probando creación de Instituto
		Instituto instituto = new Instituto();

		// Probando Buscar Todas Las Personas
		System.out.println("Listado de todas las personas: ");

		for (Persona persona : instituto.buscarTodas()) {
			System.out.println(persona);
		}

		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");

	}

}
