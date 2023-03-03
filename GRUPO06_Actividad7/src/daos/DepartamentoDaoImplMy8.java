package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionAbstract;
import javabeans.Departamento;

public class DepartamentoDaoImplMy8 extends ConexionAbstract implements DepartamentoDao {

	@Override
	public int altaDepartamento(Departamento departamento) {
		PreparedStatement statement = prepareStatement("Insert into departamentos values (?,?,?)");

		try {
			statement.setInt(1, departamento.getIdDepartamento());
			statement.setString(2, departamento.getNombre());
			statement.setString(3, departamento.getDireccion());

			filas = statement.executeUpdate();
			filas = 1;

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo cliente.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarDepartamento(int idDepartamento) {
		PreparedStatement statement = prepareStatement("Delete From departamentos WHERE id_depar=?");
		try {
			statement.setInt(1, idDepartamento);
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
	public int modificalDepartamento(Departamento departamento) {
		PreparedStatement statement = prepareStatement(
				"Update departamentos set nombre = ?, direccion = ? WHERE id_depar=?");
		try {
			statement.setString(1, departamento.getNombre());
			statement.setString(2, departamento.getDireccion());
			statement.setInt(3, departamento.getIdDepartamento());

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
	public Departamento buscarUnDepartamento(int idDepartamento) {
		PreparedStatement statement = prepareStatement("Select * FROM departamentos WHERE id_depar=?");

		try {

			statement.setInt(1, idDepartamento);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Departamento departamento = new Departamento();
				departamento.setIdDepartamento(resultSet.getInt("id_depar"));
				departamento.setNombre(resultSet.getString("nombre"));
				departamento.setDireccion(resultSet.getString("direccion"));
				return departamento;
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Departamento> buscarTodosDepartamentos() {
		PreparedStatement statement = prepareStatement("Select * FROM departamentos");
		List<Departamento> departamentos = new ArrayList<>();

		try {

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Departamento departamento = new Departamento();
				departamento.setIdDepartamento(resultSet.getInt("id_depar"));
				departamento.setNombre(resultSet.getString("nombre"));
				departamento.setDireccion(resultSet.getString("direccion"));

				departamentos.add(departamento);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return departamentos;
	}

}
