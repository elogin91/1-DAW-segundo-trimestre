package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionAbstract;
import javabeans.Factura;

public class FacturaDaoImplMy8 extends ConexionAbstract implements FacturaDao {

	@Override
	public int altaFactura(Factura factura) {
		PreparedStatement statement = prepareStatement("Insert into facturas values (?,?,?)");

		try {
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

	@Override
	public int eliminarFactura(String idFactura) {
		PreparedStatement statement = prepareStatement("Delete From facturas WHERE id_factura=?");
		try {
			statement.setString(1, idFactura);
			filas = statement.executeUpdate();

			return filas;

		} catch (SQLException e) {
			System.out.println("Error al borrar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificalFactura(Factura factura) {
		PreparedStatement statement = prepareStatement(
				"Update facturas set descripcion = ?, id_proyecto = ? WHERE id_factura=?");
		try {
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

	@Override
	public Factura buscarUnaFactura(String idFactura) {
		PreparedStatement statement = prepareStatement("Select * FROM facturas WHERE id_factura=?");
		Factura factura = new Factura();
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();

		try {

			statement.setString(1, idFactura);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

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

	@Override
	public List<Factura> buscarTodasFacturas() {
		PreparedStatement statement = prepareStatement("Select * FROM facturas");
		List<Factura> facturas = new ArrayList<>();
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();

		try {

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
