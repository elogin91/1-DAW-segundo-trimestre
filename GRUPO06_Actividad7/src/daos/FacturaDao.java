package daos;

import java.util.List;

import javabeans.Factura;

/**
 * Interface FacturaDao CRUD.
 *
 */
public interface FacturaDao {

	/**
	 * Método que introduce una factura con sus respectivos atributos en la BBDD.
	 * 
	 * @param factura que contiene los datos de la factura que queremos introducir.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int altaFactura(Factura factura);

	/**
	 * Método que elimina una factura con sus respectivos atributos de la BBDD.
	 * 
	 * @param idFactura criterio de filtro para selecccionar la factura que queremos
	 *                  eliminar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int eliminarFactura(String idFactura);

	/**
	 * Método que modifica una factura con sus respectivos atributos de la BBDD.
	 * 
	 * @param factura que contiene los datos de la factura que queremos modificar.
	 * @return número entero que hace referencia al número de filas afectadas en la
	 *         tabla de la BBDD.
	 */
	int modificarFactura(Factura factura);

	/**
	 * Método el cual recupera una factura de la BBDD en base a su identificador.
	 * 
	 * @param idFactura identificador que nos sirve de criterio de filtrado.
	 * @return Factura que cumple el criterio de filtrado con todas sus propiedades.
	 */
	Factura buscarUnaFactura(String idFactura);

	/**
	 * Método que recolecta todas las facturas con sus respectivas propiedades de la
	 * BBDD.
	 * 
	 * @return una lista de todas las facturas de la BBDD.
	 */
	List<Factura> buscarTodasFacturas();
}
