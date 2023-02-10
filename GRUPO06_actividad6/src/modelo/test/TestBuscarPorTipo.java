package modelo.test;

import modelo.dao.Instituto;
import modelo.javabean.Administrativo;
import modelo.javabean.Alumno;
import modelo.javabean.Persona;
import modelo.javabean.Profesor;

public class TestBuscarPorTipo {
	public static void main(String[] args) {
		
		// Probando creación de Instituto
		Instituto instituto = new Instituto();
		String tipoAlumno = "AlUmNo";
		String tipoProfesor = "pROFESOR";
		String tipoAdministrativo = "Administrativo";

		// Probando Buscar Persona Por Tipo Alumno
		System.out.println("Listado de las personas del tipo " + tipoAlumno + ":");

		for (Persona persona : instituto.buscarPersonaPorTipo(tipoAlumno)) {
			System.out.println(persona);
			((Alumno) persona).hacerExamen();
		}

		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");

		// Probando Buscar Persona Por Tipo Profesor
		System.out.println("Listado de las personas del tipo " + tipoProfesor + ":");

		for (Persona persona : instituto.buscarPersonaPorTipo(tipoProfesor)) {
			System.out.println(persona);
			((Profesor) persona).ponerNotas();
		}

		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");

		// Probando Buscar Persona Por Tipo Administrativo
		System.out.println("Listado de las personas del tipo " + tipoAdministrativo + ":");

		for (Persona persona : instituto.buscarPersonaPorTipo(tipoAdministrativo)) {
			System.out.println(persona);
			((Administrativo) persona).gestionarMatricula();
		}

		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");

	}
}
