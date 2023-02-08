package modelo.test;

import modelo.javabean.Administrativo;
import modelo.javabean.Alumno;
import modelo.javabean.Persona;
import modelo.javabean.Profesor;

public class Principal {
	public static void main(String[] args) {
		//Crea un objeto Profesor, un objeto Alumno y un objeto Administrativo.
		
		Profesor profesor = new Profesor("111111111A", "Pepe Lopez Mai", "C/Real, 1", "956 333 333", "Matemáticas y lengua");
		Alumno alumno = new Alumno("222222222B", "Maria Díaz Pérez", "Avda, España s/n", "958 444 444", "1º de Bachillerato");
		Administrativo administrativo = new Administrativo("333333333C", "Luisa Martín Marín", "C/ Ronda, 3", "952 555 555", "hacer matrículas y controlar asistencias");
		
		//Ejecuta el método toString() sobre cada uno de ellos + Ejecuta el método trabajar() sobre cada uno de ellos.
		System.out.println(profesor.toString());
		System.out.println(profesor.trabajar());
		System.out.println();

		
		System.out.println(alumno.toString());
		System.out.println(alumno.trabajar());
		System.out.println();

		System.out.println(administrativo.toString());
		System.out.println(administrativo.trabajar());
		System.out.println();
		
		//Ejecuta el método llamar(Persona p) para que el alumno llame al profesor.
		System.out.println(alumno.llamar(profesor));
		System.out.println();
		
		//Ejecuta el método ponerNotas() del objeto Profesor.
		System.out.println(profesor.ponerNotas());
		
		//Ejecuta el método hacerExamen() del objeto Alumno.
		System.out.println(alumno.hacerExamen());

		//Ejecuta el método gestionarMatricula() del objeto Administrativo.
		System.out.println(administrativo.gestionarMatricula());

		
		}
}
