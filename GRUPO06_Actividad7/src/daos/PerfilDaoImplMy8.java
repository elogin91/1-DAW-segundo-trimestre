package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Perfil;

public class PerfilDaoImplMy8 extends AbstractDao implements PerfilDao {

	@Override
	public int altaPerfil(Perfil perfil) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Insert into perfiles values (?,?,?)");
			statement.setInt(1, perfil.getIdPerfil());
			statement.setString(2, perfil.getNombre());
			statement.setDouble(3, perfil.getPrecioHora());
			filas = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo cliente.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarPerfil(int idPerfil) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Delete From perfiles WHERE id_perfil=?");
			statement.setInt(1, idPerfil);
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarPerfil(Perfil perfil) {
		int filas = 0;
		try {
			PreparedStatement statement = conn
					.prepareStatement("Update perfiles set nombre = ?, precio_hora = ? WHERE id_perfil=?");
			statement.setString(1, perfil.getNombre());
			statement.setInt(2, perfil.getIdPerfil());
			statement.setDouble(3, perfil.getPrecioHora());
			filas = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Perfil buscarUnPerfil(int idPerfil) {
		Perfil perfil = new Perfil();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM perfiles WHERE id_perfil=?");
			statement.setInt(1, idPerfil);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				perfil.setIdPerfil(resultSet.getInt("id_perfil"));
				perfil.setNombre(resultSet.getString("nombre"));
				perfil.setPrecioHora(resultSet.getDouble("precio_hora"));
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return perfil;
	}

	@Override
	public List<Perfil> buscarTodosPerfiles() {
		List<Perfil> perfiles = new ArrayList<>();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM perfiles");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(resultSet.getInt("id_perfil"));
				perfil.setNombre(resultSet.getString("nombre"));
				perfil.setPrecioHora(resultSet.getDouble("precio_hora"));
				perfiles.add(perfil);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return perfiles;
	}

}
