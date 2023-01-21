package empresa.javabean;

import empleado.javabean.Departamento;
import empleado.javabean.Empleado;
import empleado.javabean.Localidad;
import empleado.javabean.Trabajo;

public class CargarDatos {
	//Creamos Empleados para probar, de distintos trabajos, departamentos con sus localidades.
	private void cargarDatos() {
		Localidad localizacionMalaga = new Localidad(2, "Calle Feria", "Malaga", "España");
		
		Departamento departamentoInforMalaga = new Departamento(2, "Informático", localizacionMalaga);
		
		Trabajo trabajoTecnico = new Trabajo ("2", "Técnico", 2000.99, 4999.99);
		
		Empleado empleado2 = new Empleado (2, "Loli", "Lopez Lopez", "loli.lplp@gmail.com", 3000.99, 500.99,'m', trabajoTecnico,departamentoInforMalaga);
		
		Empleado empleado3 = new Empleado (3, "Luisita", "Lopez Lopez", "luisita.lplp@gmail.com", 6000.99, 2500.99,'m', trabajoTecnico,departamentoInforMalaga);

	}
}
