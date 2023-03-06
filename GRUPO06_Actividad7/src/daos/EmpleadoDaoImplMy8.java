package daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Empleado;

public class EmpleadoDaoImplMy8 extends AbstractDao implements EmpleadoDao {

	@Override
	public int altaEmpleado(Empleado empleado) {
		int filas = 0;

		try {
			PreparedStatement statement = conn.prepareStatement("Insert into empleados values (?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, empleado.getIdEmpleado());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellidos());
			statement.setString(4, String.valueOf(empleado.getGenero()));
			statement.setString(5, empleado.getEmail());
			statement.setString(6, empleado.getPassword());
			statement.setDouble(7, empleado.getSalario());
			statement.setDate(8, new Date(empleado.getFechaIngreso().getTime()));
			statement.setDate(9, new Date(empleado.getFechaNacimiento().getTime()));
			statement.setInt(10, empleado.getPerfil().getIdPerfil());
			statement.setInt(11, empleado.getDepartamento().getIdDepartamento());
			filas = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo empleado.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarEmpleado(int idEmpleado) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Delete From empleados WHERE id_empl=?");
			statement.setInt(1, idEmpleado);
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificalEmpleado(Empleado empleado) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(
					"Update empleados set nombre = ?, apellidos = ?, genero = ?, email = ?, password = ?, salario = ?, fecha_ingreso = ?, fecha_nacimiento = ?, id_perfil = ?, id_depar = ? WHERE id_empl=?");
			statement.setInt(11, empleado.getIdEmpleado());
			statement.setString(1, empleado.getNombre());
			statement.setString(2, empleado.getApellidos());
			statement.setString(3, String.valueOf(empleado.getGenero()));
			statement.setString(4, empleado.getEmail());
			statement.setString(5, empleado.getPassword());
			statement.setDouble(6, empleado.getSalario());
			statement.setDate(7, new Date(empleado.getFechaIngreso().getTime()));
			statement.setDate(8, new Date(empleado.getFechaNacimiento().getTime()));
			statement.setInt(9, empleado.getPerfil().getIdPerfil());
			statement.setInt(10, empleado.getDepartamento().getIdDepartamento());
			filas = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al modificar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Empleado buscarUnEmpleado(int idEmpleado) {
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();
		Empleado empleado = new Empleado();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM empleados WHERE id_empl=?");
			statement.setInt(1, idEmpleado);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				empleado.setIdEmpleado(resultSet.getInt("id_empl"));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setApellidos(resultSet.getString("apellidos"));
				empleado.setGenero(resultSet.getString("genero").charAt(0));
				empleado.setEmail(resultSet.getString("email"));
				empleado.setPassword(resultSet.getString("password"));
				empleado.setSalario(resultSet.getDouble("salario"));
				empleado.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
				empleado.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
				empleado.setPerfil(perfilDao.buscarUnPerfil(resultSet.getInt("id_perfil")));
				empleado.setDepartamento(departamentoDao.buscarUnDepartamento(resultSet.getInt("id_depar")));
			}
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return empleado;
	}

	@Override
	public List<Empleado> buscarTodosEmpleados() {
		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM empleados");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setIdEmpleado(resultSet.getInt("id_empl"));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setApellidos(resultSet.getString("apellidos"));
				empleado.setGenero(resultSet.getString("genero").charAt(0));
				empleado.setEmail(resultSet.getString("email"));
				empleado.setPassword(resultSet.getString("password"));
				empleado.setSalario(resultSet.getDouble("salario"));
				empleado.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
				empleado.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
				empleado.setPerfil(perfilDao.buscarUnPerfil(resultSet.getInt("id_perfil")));
				empleado.setDepartamento(departamentoDao.buscarUnDepartamento(resultSet.getInt("id_depar")));
				empleados.add(empleado);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM empleados WHERE id_depar = ?");
			statement.setInt(1, idDepar);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setIdEmpleado(resultSet.getInt("id_empl"));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setApellidos(resultSet.getString("apellidos"));
				empleado.setGenero(resultSet.getString("genero").charAt(0));
				empleado.setEmail(resultSet.getString("email"));
				empleado.setPassword(resultSet.getString("password"));
				empleado.setSalario(resultSet.getDouble("salario"));
				empleado.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
				empleado.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
				empleado.setPerfil(perfilDao.buscarUnPerfil(resultSet.getInt("id_perfil")));
				empleado.setDepartamento(departamentoDao.buscarUnDepartamento(resultSet.getInt("id_depar")));
				empleados.add(empleado);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public List<Empleado> empleadosBySexo(char sexo) {
		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM empleados WHERE genero = ?");
			statement.setString(1, String.valueOf(sexo));
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setIdEmpleado(resultSet.getInt("id_empl"));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setApellidos(resultSet.getString("apellidos"));
				empleado.setGenero(resultSet.getString("genero").charAt(0));
				empleado.setEmail(resultSet.getString("email"));
				empleado.setPassword(resultSet.getString("password"));
				empleado.setSalario(resultSet.getDouble("salario"));
				empleado.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
				empleado.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
				empleado.setPerfil(perfilDao.buscarUnPerfil(resultSet.getInt("id_perfil")));
				empleado.setDepartamento(departamentoDao.buscarUnDepartamento(resultSet.getInt("id_depar")));
				empleados.add(empleado);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {

		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM empleados WHERE apellidos = ?");
			statement.setString(1, subcadena);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setIdEmpleado(resultSet.getInt("id_empl"));
				empleado.setNombre(resultSet.getString("nombre"));
				empleado.setApellidos(resultSet.getString("apellidos"));
				empleado.setGenero(resultSet.getString("genero").charAt(0));
				empleado.setEmail(resultSet.getString("email"));
				empleado.setPassword(resultSet.getString("password"));
				empleado.setSalario(resultSet.getDouble("salario"));
				empleado.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
				empleado.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
				empleado.setPerfil(perfilDao.buscarUnPerfil(resultSet.getInt("id_perfil")));
				empleado.setDepartamento(departamentoDao.buscarUnDepartamento(resultSet.getInt("id_depar")));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return empleados;
	}

	@Override
	public Double salarioTotal() {
		Double salarioTotal = 0.0;

		try {
			PreparedStatement statement = conn.prepareStatement("SELECT sum(salario) FROM empleados");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				salarioTotal = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salarioTotal;
	}

	@Override
	public Double salarioTotal(int idDepar) {
		Double salarioTotal = 0.0;
		ResultSet resultSet;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT sum(salario) FROM empleados Where id_depar = ?");
			statement.setInt(1, idDepar);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				salarioTotal = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salarioTotal;
	}
}