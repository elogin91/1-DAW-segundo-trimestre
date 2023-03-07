package daos;

import java.util.List;

import javabeans.Proyecto;

/**
 * Interface ProyectoDao CRUD y otros métodos.
 *
 */
public interface ProyectoDao {

	/**
	 * Método que introduce un proyecto con sus respectivos atributos en la BBDD.
	 * 
	 * @param proyecto que contiene los datos del proyecto que queremos introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int altaProyecto(Proyecto proyecto);

	/**
	 * Método que elimina un proyecto con sus respectivos atributos de la BBDD.
	 * 
	 * @param idProyecto criterio de filtro para selecccionar el proyecto que
	 *                   queremos eliminar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int eliminarProyecto(String idProyecto);

	/**
	 * Método que modifica un proyecto con sus respectivos atributos de la BBDD.
	 * 
	 * @param proyecto que contiene los datos del proyecto que queremos modificar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int modificarProyecto(Proyecto proyecto);

	/**
	 * Método el cual recupera un proyecto de la BBDD en base a su identificador.
	 * 
	 * @param idProyecto identificador que nos sirve de criterio de filtrado.
	 * @return proyecto que cumple el criterio de filtrado con todas sus
	 *         propiedades.
	 */
	Proyecto buscarUnProyecto(String idProyecto);

	/**
	 * Método que recolecta todos los proyectos con sus respectivas propiedades de
	 * la BBDD.
	 * 
	 * @return una lista de todos los proyectos de la BBDD.
	 */
	List<Proyecto> buscarTodosProyectos();

	/**
	 * Método que recolecta todos los proyectos con sus respectivas propiedades de
	 * la BBDD en base a su estado.
	 * 
	 * @param estado de los proyectos que se desean recuperar.
	 * @return una lista de todos los proyectos de la BBDD con el estado recibido
	 */
	List<Proyecto> proyectosByEstado(String estado);

	/**
	 * Método que recolecta todos los proyectos con sus respectivas propiedades de
	 * la BBDD en base a un cliente.
	 * 
	 * @param cif del cliente de los proyectos que se desean recuperar.
	 * @return una lista de todos los proyectos de la BBDD con el cif del cliente
	 *         recibido.
	 */
	List<Proyecto> proyectosByCliente(String cif);

	/**
	 * Método que recolecta todos los proyectos con sus respectivas propiedades de
	 * la BBDD en base al jefe de proyecto y su estado.
	 * 
	 * @param jefeProyecto identificador del jefe de los proyectos a recuperar.
	 * @param estado       de los proyectos que se desean recuperar.
	 * @return una lista de todos los proyectos de la BBDD del jefe de proyecto y el
	 *         estado recibido.
	 */
	List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado);

	/**
	 * Método que calcula el importe de venta de los proyectos terminados.
	 * 
	 * @return Valor del importe de venta de los proyectos terminados.
	 */
	double importesVentaProyectosTerminados();

	/**
	 * Método que calcula el margen bruto de los proyectos terminados.
	 * 
	 * @return Valor del margen bruto de los proyectos terminados.
	 */
	double margenBrutoProyectosTerminados();

	/**
	 * Método que devuelve cuantos días quedan para terminar un proyecto.
	 * 
	 * @param codigoProyecto identificador del proyecto del que se desea obtener la
	 *                       información.
	 * @return Días que quedan para terminar el proyecto.
	 */
	int diasATerminoProyectoActivo(String codigoProyecto);
}
