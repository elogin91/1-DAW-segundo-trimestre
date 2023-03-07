package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Cliente;

/**
 * Clase que implementa los métodos de la interfaz Cliente DAO, con acceso a
 * base de datos.
 *
 */
public class ClienteDaoImplMy8 extends AbstractDao implements ClienteDao {

	// Implementación del método buscarUno.
	@Override
	public Cliente buscarUno(String cif) {
		Cliente cliente = null;
		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM clientes WHERE cif=?");
			statement.setString(1, cif);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				cliente = new Cliente();
				cliente.setCif(resultSet.getString("cif"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellidos(resultSet.getString("apellidos"));
				cliente.setDomicilio(resultSet.getString("domicilio"));
				cliente.setFacturacionAnual(resultSet.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleado(resultSet.getInt("numero_empleados"));
			}
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return cliente;
	}

	// Implementación del método buscarTodo.
	@Override
	public List<Cliente> buscarTodo() {
		List<Cliente> clientes = new ArrayList<>();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM clientes");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setCif(resultSet.getString("cif"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellidos(resultSet.getString("apellidos"));
				cliente.setDomicilio(resultSet.getString("domicilio"));
				cliente.setFacturacionAnual(resultSet.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleado(resultSet.getInt("numero_empleados"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return clientes;
	}

	// Implementación del método altaCliente.
	@Override
	public int altaCliente(Cliente cliente) {
		int filas = 0;

		try {
			PreparedStatement statement = conn.prepareStatement("Insert into clientes values (?,?,?,?,?,?)");
			statement.setString(1, cliente.getCif());
			statement.setString(2, cliente.getNombre());
			statement.setString(3, cliente.getApellidos());
			statement.setString(4, cliente.getDomicilio());
			statement.setDouble(5, cliente.getFacturacionAnual());
			statement.setInt(6, cliente.getNumeroEmpleado());
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo cliente.");
			e.printStackTrace();
		}
		return filas;
	}

	// Implementación del método eliminarCliente.
	@Override
	public int eliminarCliente(String cif) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Delete From Clientes WHERE cif=?");
			statement.setString(1, cif);
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	// Implementación del método modificarCliente.
	@Override
	public int modificarCliente(Cliente cliente) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(
					"Update clientes set nombre = ?, apellidos = ?, domicilio = ?, facturacion_anual = ?, numero_empleados= ? WHERE cif=?");
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getApellidos());
			statement.setString(3, cliente.getDomicilio());
			statement.setDouble(4, cliente.getFacturacionAnual());
			statement.setInt(5, cliente.getNumeroEmpleado());
			statement.setString(6, cliente.getCif());
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

}
