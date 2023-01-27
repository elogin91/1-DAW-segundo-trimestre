package test;

import java.util.ArrayList;

import modelo.dao.Empresa;
import modelo.javabean.Departamento;
import modelo.javabean.Empleado;
import modelo.javabean.Localidad;
import modelo.javabean.Trabajo;

public class Principal {
	public static void main(String[] args) {

		System.out.println("Empezamos a probar los métodos implementados en la clase Empresa:");

		// Prueba Constructor, creamos una empresa.
		Empresa empresa = new Empresa("AmorAJava");

		System.out.println("Probando el constructor: ");

		for (Empleado empleado : empresa.buscarTodos()) {
			System.out.println(empleado);
		}
		System.out.println("------------------------------------");

		// Prueba Método: Alta Empleados.
		Localidad localizacionMadrid = new Localidad(2, "Calle Real", "Madrid", "España");
		Departamento departamentoLimpiezaMadrid = new Departamento(2, "Limpieza", localizacionMadrid);
		Trabajo trabajoSupervisor = new Trabajo("2", "Supervisor", 2000.99, 4999.99);
		Empleado empleado5 = new Empleado(5, "Ana", "Rico Ruiz", "super_limpi1@hotmail.es", 4000.99, 288.99, 'm',
				trabajoSupervisor, departamentoLimpiezaMadrid);
		Empleado empleado6 = new Empleado(6, "Luis", "Rico Ruiz", "super_limpi2@hotmail.es", 4000.99, 288.99, 'h',
				trabajoSupervisor, departamentoLimpiezaMadrid);
		Empleado empleado7 = new Empleado(5, "Ana", "Rico Ruiz", "super_limpi1@hotmail.es", 4000.99, 288.99, 'M',
				trabajoSupervisor, departamentoLimpiezaMadrid);

		System.out.println("Probando altas de empleados: ");
		System.out.println(empresa.alta(empleado5));
		System.out.println(empresa.alta(empleado6));
		System.out.println(empresa.alta(empleado7)); // Devolverá false, porque este objeto ya está dado de alta.

		for (Empleado empleado : empresa.buscarTodos()) {
			System.out.println(empleado);
		}
		System.out.println("------------------------------------");

		// Prueba Método: Eliminar Empleados.
		System.out.println("Probando baja de empleado:");
		System.out.println(empresa.eliminarUno(empleado5));
		System.out.println(empresa.eliminarUno(empleado5)); // Devolverá false, porque ese objeto ya no está en la
															// plantilla.

		for (Empleado empleado : empresa.buscarTodos()) {
			System.out.println(empleado);
		}

		System.out.println("------------------------------------");

		// Prueba Método: Modificar Empleado.
		Empleado empleado6Modificado = new Empleado(6, "Luis MODIFICADO", "Modificado Modificado",
				"super_limpi@hotmail.es", 4000.99, 288.99, 'h', trabajoSupervisor, departamentoLimpiezaMadrid);

		System.out.println("Probando modificar empleado: ");
		System.out.println(empresa.modificarUno(empleado6Modificado));
		System.out.println(empresa.buscarUno(6));

		System.out.println("------------------------------------");

		// Prueba Método: BuscarPorSexo.
		System.out.println("Probando Busquedas por Género:");

		for (Empleado empleado : empresa.buscarPorSexo('m')) {
			System.out.println(empleado);
		}

		System.out.println("------------------------------------");

		// Prueba Método: BuscarPor IdEmpleado.
		System.out.println("Probando Busquedas por IdEmpleado:");
		System.out.println(empresa.buscarUno(2));
		System.out.println("------------------------------------");

		// Prueba Método: Buscar TODOS Los Empleados.
		System.out.println("Probando Busqueda  de TODOS:");

		for (Empleado empleado : empresa.buscarTodos()) {
			System.out.println(empleado);
		}

		System.out.println("------------------------------------");

		// Prueba Método: Masa Salarial.
		System.out.println("Probando Masa Salarial: " + empresa.masaSalarial());
		System.out.println("------------------------------------");

		// Prueba Método: Buscar Por Departamento.
		System.out.println("Probando Busquedas por Departamento:");

		for (Empleado empleado : empresa.buscarPorDepartamento(1)) {
			System.out.println(empleado);
		}

		System.out.println("------------------------------------");

		// Prueba Método: Buscar Por Trabajo.
		System.out.println("Probando Busquedas por Trabajo:");

		for (Empleado empleado : empresa.buscarPorTrabajo("1")) {
			System.out.println(empleado);
		}

		System.out.println("------------------------------------");

		// Prueba Método: Buscar Por País.
		System.out.println("Probando Busquedas por País:");

		for (Empleado empleado : empresa.buscarPorPais("España")) {
			System.out.println(empleado);
		}

		System.out.println("------------------------------------");

	}

}
