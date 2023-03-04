package daos;

import java.util.List;

import javabeans.Factura;

public interface FacturaDao {

	int altaFactura(Factura factura);

	int eliminarFactura(String idFactura);

	int modificalFactura(Factura factura);

	Factura buscarUnaFactura(String idFactura);

	List<Factura> buscarTodasFacturas();
}
