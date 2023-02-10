package modelo.test;

import modelo.dao.Instituto;
import modelo.javabean.Administrativo;
import modelo.javabean.Alumno;
import modelo.javabean.Persona;
import modelo.javabean.Profesor;

public class TestInstituto {
	public static void main(String[] args) {
		
		//Probando creación de Instituto
		Instituto instituto = new Instituto();
		
		System.out.println("Creando El Instituto con las siguientes personas:");
		
		for(Persona persona: instituto.buscarTodas()) {
			System.out.println(persona);
		}
		
		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");
		
		//Probando AltasNuevas
		Administrativo administrativoNuevo = new Administrativo("333333333C", "Luisa Martín Marín", "C/ Ronda, 3", "952 555 555", "hacer matrículas y controlar asistencias");
		Profesor profesorNuevo = new Profesor("111111111A", "Pepe Lopez Mai", "C/Real, 1", "956 333 333", "Matemáticas y lengua");
		Alumno alumnoNuevo = new Alumno("222222222B", "Maria Díaz Pérez", "Avda, España s/n", "958 444 444", "1º de Bachillerato");

		System.out.println(instituto.altaPersona(administrativoNuevo));
		System.out.println(instituto.altaPersona(profesorNuevo));
		System.out.println(instituto.altaPersona(alumnoNuevo));
		
		System.out.println("Listado Instituto con las nuevas incorporaciones: ");
		
		for(Persona persona: instituto.buscarTodas()) {
			System.out.println(persona);
		}
		
		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");
		
		//Probando Eliminar Persona
		System.out.println(instituto.eliminarPersona(administrativoNuevo));
		
		System.out.println("Listado eliminando  un Administrativo: ");
		
		for(Persona persona: instituto.buscarTodas()) {
			System.out.println(persona);
		}
		
		System.out.println("__________________________________________________");
		System.out.println("__________________________________________________");
		
	}
}
