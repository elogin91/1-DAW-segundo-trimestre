package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Departamento;

public class DepartamentoDaoImplMy8 extends AbstractDao implements DepartamentoDao {

	@Override
	public int altaDepartamento(Departamento departamento) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Insert into departamentos values (?,?,?)");
			statement.setInt(1, departamento.getIdDepartamento());
			statement.setString(2, departamento.getNombre());
			statement.setString(3, departamento.getDireccion());
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo cliente.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarDepartamento(int idDepartamento) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Delete From departamentos WHERE id_depar=?");
			statement.setInt(1, idDepartamento);
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificalDepartamento(Departamento departamento) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(
					"Update departamentos set nombre = ?, direccion = ? WHERE id_depar=?");
			statement.setString(1, departamento.getNombre());
			statement.setString(2, departamento.getDireccion());
			statement.setInt(3, departamento.getIdDepartamento());
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Departamento buscarUnDepartamento(int idDepartamento) {
		Departamento departamento = null;
		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM departamentos WHERE id_depar=?");
			statement.setInt(1, idDepartamento);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				departamento = new Departamento();
				departamento.setIdDepartamento(resultSet.getInt("id_depar"));
				departamento.setNombre(resultSet.getString("nombre"));
				departamento.setDireccion(resultSet.getString("direccion"));
			}
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return departamento;
	}

	@Override
	public List<Departamento> buscarTodosDepartamentos() {
		List<Departamento> departamentos = new ArrayList<>();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM departamentos");
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
