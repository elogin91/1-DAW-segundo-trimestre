package daos;

import java.util.List;

import javabeans.EmpleadoConProyecto;

/**
 * Interface EmpleadoConProyectoDao CRUD y otros métodos.
 *
 */
public interface EmpleadoConProyectoDao {

	/**
	 * Método que introduce un empleadoConProyecto con sus respectivos atributos en
	 * la BBDD.
	 * 
	 * @param empleadoConProyecto que contiene los datos del empleadoConProyecto que
	 *                            queremos introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int altaEmpleadoConProyecto(EmpleadoConProyecto empleadoConProyecto);

	/**
	 * Método que a través de su identificador elimina un empleadoConProyecto con
	 * sus respectivos atributos de la BBDD.
	 * 
	 * @param numeroOrden identificador de empleadoConProyecto.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int eliminarEmpleadoConProyecto(int numeroOrden);

	/**
	 * Método que modifica un empleadoConProyecto con sus respectivos atributos en
	 * la BBDD.
	 * 
	 * @param empleadoConProyecto que contiene los datos del empleadoConProyecto que
	 *                            queremos modificar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int modificaEmpleadoConProyecto(EmpleadoConProyecto empleadoConProyecto);

	/**
	 * Método el cual recupera un empleadoConProyecto de la BBDD en base a su
	 * identificador.
	 * 
	 * @param numeroOrden identificador de empleadoConProyecto.
	 * @return EmpleadoConProyecto con todas sus propiedades.
	 */
	EmpleadoConProyecto buscarEmpleadoConProyecto(int numeroOrden);

	/**
	 * Método que recolecta todos los empleadoConProyecto con sus respectivas
	 * propiedades de la BBDD.
	 * 
	 * @return una lista de todos los empleadoConProyecto de la BBDD.
	 */
	List<EmpleadoConProyecto> buscarTodosEmpleadoConProyecto();

	/**
	 * Método el cual recupera una lista de empleadoConProyecto de la BBDD en base a
	 * codigoProyecto.
	 * 
	 * @param codigoProyecto criterio de filtrado de empleadoConProyecto.
	 * @return Lista de EmpleadoConProyecto con todas sus propiedades
	 *         correspondiente al criterio de filtrado.
	 */
	List<EmpleadoConProyecto> empleadosByProyecto(String codigoProyecto);

	/**
	 * Método que introduce una lista de empleadoConProyecto con sus respectivos
	 * atributos en la BBDD.
	 * 
	 * @param Lista de empleadoConProyecto que contiene los datos de los
	 *              empleadoConProyecto que queremos introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int asignarEmpleadosAProyecto(List<EmpleadoConProyecto> empleados);

	/**
	 * Método que devuleve la suma de las horas de los empleados asignados al
	 * proyecto.
	 * 
	 * @param codigoProyecto identificador del proyecto en los cuales los empeleados
	 *                       tienen asiganadas horas.
	 * @return numero entero resultado de suma de las horas asignadas al proyecto.
	 */
	int horasAsignadasAProyecto(String codigoProyecto);

	/**
	 * Método que devuleve el coste actual del proyecto en base al producto de las
	 * horas asignadas y el coste de horas.
	 * 
	 * @param codigoProyecto identificador del proyecto los cuales tienen asiganadas
	 *                       horas con un coste determinado por empleado.
	 * @return número real resultado del coste de las horas asignadas al proyecto.
	 */
	double costeActualDeProyecto(String codigoProyecto);

	/**
	 * Método que devuleve la resta del importe de ventas del proyecto - el
	 * resultado del costeActualDelProyecto.
	 * 
	 * @param codigoProyecto identificador del proyecto.
	 * 
	 * @return numero real resultado de la resta de las ventas y el
	 *         costeActualDelProyecto.
	 */
	double margenActualProyecto(String codigoProyecto);
}