package daos;

import java.util.List;

import javabeans.Empleado;

/**
 * Interface EmpleadoDao CRUD y otros métodos.
 *
 */
public interface EmpleadoDao {

	/**
	 * Método que introduce un empleado con sus respectivos atributos en la BBDD.
	 * 
	 * @param empleado que contiene los datos del empleado que queremos introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int altaEmpleado(Empleado empleado);

	/**
	 * Método que a través de su identificador elimina un empleado con sus
	 * respectivos atributos de la BBDD.
	 * 
	 * @param idEmpleado identificador de empleado.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int eliminarEmpleado(int idEmpleado);

	/**
	 * Método que modifica un empleado con sus respectivos atributos en la BBDD.
	 * 
	 * @param empleado que contiene los datos del empleado que queremos modificar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int modificarEmpleado(Empleado empleado);

	/**
	 * Método el cual recupera un empleado de la BBDD en base a su identificador.
	 * 
	 * @param idEmpleado identificador de empleado.
	 * @return empleado con todas sus propiedades.
	 */
	Empleado buscarUnEmpleado(int idEmpleado);

	/**
	 * Método que recolecta todos los empleado con sus respectivas propiedades de la
	 * BBDD.
	 * 
	 * @return una lista de todos los empleado de la BBDD.
	 */
	List<Empleado> buscarTodosEmpleados();

	/**
	 * Método el cual recupera una lista de empleado de la BBDD en base a
	 * idDepartamento.
	 * 
	 * @param idDepartamento criterio de filtrado de empleado.
	 * @return Lista de Empleado con todas sus propiedades correspondiente al
	 *         criterio de filtrado.
	 */
	List<Empleado> empleadosByDepartamento(int idDepar);

	/**
	 * Método el cual recupera una lista de empleado de la BBDD en base al sexo.
	 * 
	 * @param sexo criterio de filtrado de empleado.
	 * @return Lista de Empleado con todas sus propiedades correspondiente al
	 *         criterio de filtrado.
	 */
	List<Empleado> empleadosBySexo(char sexo);

	/**
	 * Método el cual recupera una lista de empleado de la BBDD en base a la
	 * subcadena.
	 * 
	 * @param subcadena criterio de filtrado de empleado.
	 * @return Lista de Empleado con todas sus propiedades correspondiente al
	 *         criterio de filtrado.
	 */
	List<Empleado> empleadosByApellido(String subcadena);

	/**
	 * Método que devuleve la suma de los salarios de los empleados.
	 * 
	 * @return numero entero resultado de suma de los salarios de los empelados.
	 */
	Double salarioTotal();

	/**
	 * Método que devuleve la suma de los salarios de los empleados.
	 * 
	 * @param idDepar riterio de filtrado de empleados por departamentos.
	 * @return numero entero resultado de suma de los salarios de los empelados.
	 */
	Double salarioTotal(int idDepar);
}
