package test;

import java.util.ArrayList;

import empleado.javabean.Departamento;
import empleado.javabean.Empleado;
import empleado.javabean.Localidad;
import empleado.javabean.Trabajo;
import empresa.javabean.Empresa;

public class Principal {
	public static void main(String[] args) {
		
		Localidad localizacionMalaga = new Localidad(2, "Calle Feria", "Malaga", "España");
		Departamento departamentoInforMalaga = new Departamento(2, "Informático", localizacionMalaga);
		Trabajo trabajoTecnico = new Trabajo ("2", "Técnico", 2000.99, 4999.99);
		Localidad localizacionMadrid = new Localidad(1, "Calle Real", "Madrid", "España");
		Departamento departamentoAdmin = new Departamento(1, "Administración", localizacionMadrid);
		Trabajo trabajoJefe = new Trabajo ("1", "Jefe de equipo", 5000.99, 9999.99);
		
		Empleado empleado = new Empleado (1, "Pepe", "Lopez Lopez", "pepe.lplp@gmail.com", 6000.99, 1500.99,'h', trabajoJefe,departamentoAdmin);
		Empleado empleado2 = new Empleado (2, "Loli", "Lopez Lopez", "loli.lplp@gmail.com", 3000.99, 500.99,'m', trabajoTecnico,departamentoInforMalaga);
		Empleado empleado3 = new Empleado (3, "Luisita", "Lopez Lopez", "luisita.lplp@gmail.com", 6000.99, 2500.99,'m', trabajoTecnico,departamentoInforMalaga);
		
		System.out.println("Empezamos a probar los métodos implementados en la clase Empresa:");
		
		//Prueba Constructor
		Empresa empresa = new Empresa("AmorAJava");
		
		System.out.println("Probando el constructor: " + empresa);
		System.out.println("------------------------------------");
		
		//Prueba Alta Empleado
		empresa.alta(empleado);
		empresa.alta (empleado2);
		empresa.alta(empleado3);
		
		System.out.println("Probando Altas: " + empresa);
		System.out.println("------------------------------------");

		//Prueba Eliminar Empleado
		empresa.eliminarUno(empleado3);
		
		System.out.println("Probando Baja: " + empresa);
		System.out.println("------------------------------------");

		//Prueba Modificar Empleado
		Empleado empleado2Modificado = new Empleado (2, "Loli", "Fernandez Diaz", "loli.lplp@gmail.com", 3000.99, 500.99,'m', trabajoTecnico,departamentoInforMalaga);
		
		empresa.modificarUno(empleado2Modificado);
		
		System.out.println("Probando Modificar: " + empresa.buscarUno(2));
		System.out.println("------------------------------------");

		//Prueba BuscarPorSexo
		System.out.println("Probando Busquedas por Género: " + empresa.buscarPorSexo('m'));
		System.out.println("------------------------------------");

		//Prueba BuscarPor IDEmpleado
		System.out.println("Probando Busquedas por IdEmpleado: " + empresa.buscarUno(2));
		System.out.println("------------------------------------");

		//Prueba Buscar TODOS Los Empleados
		System.out.println("Probando Busqueda TODO: " + empresa.buscarTodos());
		System.out.println("------------------------------------");

		//Prueba Masa Salarial
		System.out.println("Probando Masa Salarial: " + empresa.masaSalarial());
		System.out.println("------------------------------------");

		//Prueba Buscar Por Departamento
		System.out.println("Probando Busquedas por Departamento: " + empresa.buscarPorDepartamento(1));
		System.out.println("------------------------------------");

		//Prueba Buscar Por Trabajo
		System.out.println("Probando Busquedas por Trabajo: " + empresa.buscarPorTrabajo("1")); 
		System.out.println("------------------------------------");

		//Prueba Buscar Por País
		System.out.println("Probando Busquedas por País: " + empresa.buscarPorPais ("España"));
		System.out.println("------------------------------------");

	}
	

}
