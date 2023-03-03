package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionAbstract;
import javabeans.Cliente;

public class ClienteDaoImplMy8 extends ConexionAbstract implements ClienteDao{

	@Override
	public Cliente buscarUno(String cif) {
		
		PreparedStatement statement = prepareStatement("Select * FROM clientes WHERE cif=?" );
		
		try {
			
			statement.setString(1, cif);
			 ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				Cliente cliente = new Cliente ();
				cliente.setCif(resultSet.getString("cif"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellidos(resultSet.getString("apellidos"));
				cliente.setDomicilio(resultSet.getString("domicilio"));
				cliente.setFacturacionAnual(resultSet.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleado(resultSet.getInt("numero_empleados"));
				return cliente;
			}
			
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> buscarTodo() {
		
		PreparedStatement statement = prepareStatement("Select * FROM clientes" );
		List<Cliente> clientes = new ArrayList <>();
		
		try {
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cliente cliente =new Cliente();
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

	@Override
	public int altaCliente(Cliente cliente) {

		PreparedStatement statement =prepareStatement("Insert into clientes values (?,?,?,?,?,?)");
		
		try {
			statement.setString(1, cliente.getCif());
			statement.setString(2, cliente.getNombre());
			statement.setString(3, cliente.getApellidos());
			statement.setString(4, cliente.getDomicilio());
			statement.setDouble(5, cliente.getFacturacionAnual());
			statement.setInt(6, cliente.getNumeroEmpleado());
			filas = statement.executeUpdate();
			filas = 1;

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo cliente.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarCliente(String cif) {

		PreparedStatement statement = prepareStatement("Delete From Clientes WHERE cif=?" );
		try {
			statement.setString(1, cif);
			filas = statement.executeUpdate();
			filas = 1;
			
			return filas;	
			
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarCliente(Cliente cliente) {
		PreparedStatement statement = prepareStatement("Update clientes set nombre = ?, apellidos = ?, domicilio = ?, facturacion_anual = ?, numero_empleados= ? WHERE cif=?" );
		try {
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getApellidos());
			statement.setString(3, cliente.getDomicilio());
			statement.setDouble(4, cliente.getFacturacionAnual());
			statement.setInt(5, cliente.getNumeroEmpleado());
			statement.setString(6, cliente.getCif());
			filas = statement.executeUpdate();
			filas = 1;
			
			return filas;	
			
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

}
