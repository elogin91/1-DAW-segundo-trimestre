package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionAbstract;

import javabeans.Perfil;

public class PerfilDaoImplMy8 extends ConexionAbstract implements PerfilDao {

	@Override
	public int altaPerfil(Perfil perfil) {
		PreparedStatement statement = prepareStatement("Insert into perfiles values (?,?)");

		try {
			statement.setInt(1, perfil.getIdPerfil());
			statement.setString(2, perfil.getNombre());

			filas = statement.executeUpdate();
			filas = 1;

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo cliente.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarPerfil(int idPerfil) {
		PreparedStatement statement = prepareStatement("Delete From perfiles WHERE id_perfil=?");
		try {
			statement.setInt(1, idPerfil);
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
	public Perfil buscarUnPerfil(int idPerfil) {
		PreparedStatement statement = prepareStatement("Select * FROM perfiles WHERE id_perfil=?");

		try {

			statement.setInt(1, idPerfil);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(resultSet.getInt("id_perfil"));
				perfil.setNombre(resultSet.getString("nombre"));

				return perfil;
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Perfil> buscarTodosPerfiles() {
		PreparedStatement statement = prepareStatement("Select * FROM perfiles");
		List<Perfil> perfiles = new ArrayList<>();

		try {

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(resultSet.getInt("id_perfil"));
				perfil.setNombre(resultSet.getString("nombre"));
				perfiles.add(perfil);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return perfiles;
	}

	@Override
	public int modificarPerfil(Perfil perfil) {
		PreparedStatement statement = prepareStatement("Update perfiles set nombre = ? WHERE id_perfil=?");
		try {
			statement.setString(1, perfil.getNombre());
			statement.setInt(2, perfil.getIdPerfil());
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
