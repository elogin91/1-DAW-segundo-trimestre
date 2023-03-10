package test;

import modelo.javabean.Departamento;
import modelo.javabean.Empleado;
import modelo.javabean.Localidad;
import modelo.javabean.Trabajo;

public class TestingEmpleado {

	public static void main(String[] args) {

		// Crea un objeto Localización, departamento con esa Localización, un Trabajo, y
		// un Empleado con su departamento y su Trabajo.

		Localidad localizacionMadrid = new Localidad(1, "Calle Real", "Madrid", "España");

		Departamento departamentoAdmin = new Departamento(1, "Administración", localizacionMadrid);

		Trabajo trabajoJefe = new Trabajo("1", "Jefe de equipo", 5000.99, 9999.99);

		Empleado empleado = new Empleado(1, "Pepe", "Lopez Lopez", "pepe.lplp@gmail.com", 6000.99, 1500.99, 'h',
				trabajoJefe, departamentoAdmin);

		// SIN usar toString: Nombre, apellidos, género, nombre del departamento, nombre
		// de su trabajo, dirección , ciudad y país.
		System.out.println("--------------Mostrando datos de empleado, sin usar toString--------------");
		System.out.println("Nombre: " + empleado.getNombre());
		System.out.println("Apellidos: " + empleado.getApellidos());
		System.out.println("Género: " + empleado.getGenero());
		System.out.println("Nombre del departamento: " + empleado.getDepartamento().getDescripcion());
		System.out.println("Nombre de su trabajo: " + empleado.getTrabajo().getDescripcion());
		System.out.println("Dirección: " + empleado.getDepartamento().getLocalidad().getDireccion());
		System.out.println("Ciudad: " + empleado.getDepartamento().getLocalidad().getCiudad());
		System.out.println("País: " + empleado.getDepartamento().getLocalidad().getPais());

		// Extraer del empleado su trabajo y su departamento en variables de su tipo.
		Trabajo trabajoEmpleado = empleado.getTrabajo();
		Departamento deptartamentoEmpleado = empleado.getDepartamento();

		System.out.println(
				"--------------Extraemos el trabajo y departamento en variables de su tipo,y las pintamos--------------");
		// Y pintarlas con syso. (No se especifica que no se pueda pintar con toString
		// en este apartado, por tanto lo usamos)
		System.out.println(trabajoEmpleado);
		System.out.println(deptartamentoEmpleado);
	}

}
