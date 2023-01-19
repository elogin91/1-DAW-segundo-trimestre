package empleado.test;

import empleado.javabean.Departamento;
import empleado.javabean.Empleado;
import empleado.javabean.Localidad;
import empleado.javabean.Trabajo;

public class TestingEmpleado {

	public static void main(String[] args) {
	

		//Crea un objeto Localización, departamento con esa Localización, un Trabajo, y un Empleado con su departamento y su Trabajo.
		
		Localidad localizacion = new Localidad(1, "Calle Real", "Madrid", "España");
		
		Departamento departamento = new Departamento(1, "Administración", localizacion);
		
		Trabajo trabajo = new Trabajo ("1", "Jefe de equipo", 5000.99, 9999.99);
		
		Empleado empleado = new Empleado (1, "Pepe", "Lopez Lopez", "pepe.lplp@gmail.com", 6000.99, 1500.99,'h', trabajo,departamento);
		
		//SIN usar toString: Nombre, apellidos, género, nombre del departamento, nombre de su trabajo, dirección , ciudad y país.
		System.out.println(empleado.getNombre());
		System.out.println(empleado.getApellidos());
		System.out.println(empleado.getGenero());
		System.out.println(empleado.getDepartamento().getDescripcion());
		System.out.println(empleado.getTrabajo().getDescripcion());
		System.out.println(empleado.getDepartamento().getLocalidad().getDireccion());
		System.out.println(empleado.getDepartamento().getLocalidad().getCiudad());
		System.out.println(empleado.getDepartamento().getLocalidad().getPais());
		
		//Extraer del empleado su trabajo y su departamento en variables de su tipo. Y pintarlas con syso.
		
		Trabajo trabajoEmpleado = empleado.getTrabajo();
		Departamento deptartamentoEmpleado = empleado.getDepartamento();
		
		System.out.println(trabajoEmpleado);
		System.out.println(deptartamentoEmpleado);
	}
	
	//Creamos Empleados para probar, de distintos trabajos, departamentos con sus localidades.
	private void cargarDatos() {
		
	}
}