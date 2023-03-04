package daos;

import java.util.List;

import javabeans.EmpleadoConProyecto;

public interface EmpleadoConProyectoDao {
	
	//Métodos CRUD
	int altaEmpleadoConProyecto(EmpleadoConProyecto empleadoConProyecto);

	int eliminarEmpleadoConProyecto(int numeroOrden);

	int modificaEmpleadoConProyecto(EmpleadoConProyecto empleadoConProyecto);

	EmpleadoConProyecto buscarEmpleadoConProyecto(int numeroOrden);

	List<EmpleadoConProyecto> buscarTodosEmpleadoConProyecto();
	
	//Métodos obligatorios.
	List <EmpleadoConProyecto>empleadosByProyecto(String codigoProyecto);
	
	int asignarEmpleadosAProyecto(List<EmpleadoConProyecto> empleados);
	
	int horasAsignadasAProyecto(String codigoProyecto);

	// Suma de las horas de los empleados asignados al proyecto.
	
	double costeActualDeProyecto(String codigoProyecto);
	// Horas*coste-hora de cada empleado asignado al proyecto.
	
	double margenActualProyecto(String codigoProyecto);
	//Importe_venta del proyecto – costeActual del Proyecto
}