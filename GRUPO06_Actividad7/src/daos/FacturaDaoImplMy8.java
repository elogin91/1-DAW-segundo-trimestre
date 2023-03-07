package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Factura;

public class FacturaDaoImplMy8 extends AbstractDao implements FacturaDao {

	// Implementación del método altaFactura.
	@Override
	public int altaFactura(Factura factura) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Insert into facturas values (?,?,?)");
			statement.setString(1, factura.getIdFactura());
			statement.setString(2, factura.getDescripcion());
			statement.setString(3, factura.getProyecto().getIdProyecto());
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al introducir una nueva factura.");
			e.printStackTrace();
		}
		return filas;
	}

	// Implementación del método eliminarFactura.
	@Override
	public int eliminarFactura(String idFactura) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Delete From facturas WHERE id_factura=?");
			statement.setString(1, idFactura);
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al borrar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	// Implementación del método modificarFactura.
	@Override
	public int modificarFactura(Factura factura) {
		int filas = 0;
		try {
			PreparedStatement statement = conn
					.prepareStatement("Update facturas set descripcion = ?, id_proyecto = ? WHERE id_factura=?");
			statement.setString(1, factura.getDescripcion());
			statement.setString(2, factura.getProyecto().getIdProyecto());
			statement.setString(3, factura.getIdFactura());
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	// Implementación del método buscarUnaFactura.
	@Override
	public Factura buscarUnaFactura(String idFactura) {
		Factura factura = null;
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM facturas WHERE id_factura=?");
			statement.setString(1, idFactura);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				factura = new Factura();
				factura.setIdFactura(resultSet.getString("id_factura"));
				factura.setDescripcion(resultSet.getString("descripcion"));
				factura.setProyecto(proyectoDao.buscarUnProyecto((resultSet.getString("id_proyecto"))));
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return factura;
	}

	// Implementación del método buscarTodasFacturas.
	@Override
	public List<Factura> buscarTodasFacturas() {
		List<Factura> facturas = new ArrayList<>();
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM facturas");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Factura factura = new Factura();
				factura.setIdFactura(resultSet.getString("id_factura"));
				factura.setDescripcion(resultSet.getString("descripcion"));
				factura.setProyecto(proyectoDao.buscarUnProyecto((resultSet.getString("id_proyecto"))));
				facturas.add(factura);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return facturas;
	}

}
