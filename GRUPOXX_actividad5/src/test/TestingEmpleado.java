package test;

import empleado.javabean.Departamento;
import empleado.javabean.Empleado;
import empleado.javabean.Localidad;
import empleado.javabean.Trabajo;

public class TestingEmpleado {

	public static void main(String[] args) {
	

		//Crea un objeto Localización, departamento con esa Localización, un Trabajo, y un Empleado con su departamento y su Trabajo.
		
		Localidad localizacionMadrid = new Localidad(1, "Calle Real", "Madrid", "España");
		
		Departamento departamentoAdmin = new Departamento(1, "Administración", localizacionMadrid);
		
		Trabajo trabajoJefe = new Trabajo ("1", "Jefe de equipo", 5000.99, 9999.99);
		
		Empleado empleado = new Empleado (1, "Pepe", "Lopez Lopez", "pepe.lplp@gmail.com", 6000.99, 1500.99,'h', trabajoJefe,departamentoAdmin);
		
		//SIN usar toString: Nombre, apellidos, género, nombre del departamento, nombre de su trabajo, dirección , ciudad y país.
		System.out.println("--------------Mostrando datos de empleado, sin usar toString--------------");
		System.out.println(empleado.getNombre());
		System.out.println(empleado.getApellidos());
		System.out.println(empleado.getGenero());
		System.out.println(empleado.getDepartamento().getDescripcion());
		System.out.println(empleado.getTrabajo().getDescripcion());
		System.out.println(empleado.getDepartamento().getLocalidad().getDireccion());
		System.out.println(empleado.getDepartamento().getLocalidad().getCiudad());
		System.out.println(empleado.getDepartamento().getLocalidad().getPais());
		
		//Extraer del empleado su trabajo y su departamento en variables de su tipo.
		
		Trabajo trabajoEmpleado = empleado.getTrabajo();
		Departamento deptartamentoEmpleado = empleado.getDepartamento();
		
		System.out.println("--------------Extraemos el trabajo y departamento en variables de su tipo,y las pintamos--------------");
		//Y pintarlas con syso. (No se especifica que no se pueda pintar con toString en este apartado, por tanto lo usamos)
		System.out.println(trabajoEmpleado);
		System.out.println(deptartamentoEmpleado);
	}
	
}
