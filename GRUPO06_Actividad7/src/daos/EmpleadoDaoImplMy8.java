package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionAbstract;
import javabeans.Empleado;

public class EmpleadoDaoImplMy8 extends ConexionAbstract implements EmpleadoDao {

	@Override
	public int altaEmpleado(Empleado empleado) {

		PreparedStatement statement = prepareStatement("Insert into empleados values (?,?,?,?,?,?,?,?,?,?,?)");

		try {
			statement.setInt(1, empleado.getIdEmpleado());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellidos());
			statement.setString(4, String.valueOf(empleado.getGenero()));
			statement.setString(5, empleado.getEmail());
			statement.setString(6, empleado.getPassword());
			statement.setDouble(7, empleado.getSalario());
			statement.setDate(8, empleado.getFechaIngreso());
			statement.setDate(9, empleado.getFechaNacimiento());
			statement.setInt(10, empleado.getPerfil().getIdPerfil());
			statement.setInt(11, empleado.getDepartamento().getIdDepartamento());

			filas = statement.executeUpdate();
			filas = 1;

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo empleado.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarEmpleado(int idEmpleado) {
		PreparedStatement statement = prepareStatement("Delete From empleados WHERE id_empl=?");
		try {
			statement.setInt(1, idEmpleado);
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
	public Empleado buscarUnEmpleado(int idEmpleado) {

		PreparedStatement statement = prepareStatement("Select * FROM empleados WHERE id_empl=?");
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();
		Empleado empleado = new Empleado();

		try {

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

				return empleado;
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Empleado> buscarTodosEmpleados() {

		PreparedStatement statement = prepareStatement("Select * FROM empleados");
		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {

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
		PreparedStatement statement = prepareStatement("Select * FROM empleados WHERE id_depar = ?");
		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {

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
		PreparedStatement statement = prepareStatement("Select * FROM empleados WHERE genero = ?");
		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {

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
		PreparedStatement statement = prepareStatement("Select * FROM empleados WHERE apellidos = ?");
		List<Empleado> empleados = new ArrayList<>();
		PerfilDao perfilDao = new PerfilDaoImplMy8();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8();

		try {

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
		PreparedStatement statement = prepareStatement("SELECT sum(salario) FROM empleados");
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery();
			salarioTotal = resultSet.getDouble(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salarioTotal;
	}

	@Override
	public Double salarioTotal(int idDepar) {
		Double salarioTotal = 0.0;
		PreparedStatement statement = prepareStatement("SELECT sum(salario) FROM empleados Where id_depar = ?");
		ResultSet resultSet;
		try {
			statement.setInt(1, idDepar);
			resultSet = statement.executeQuery();
			salarioTotal = resultSet.getDouble(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salarioTotal;
	}

	@Override
	public int modificalEmpleado(Empleado empleado) {
		PreparedStatement statement = prepareStatement(
				"Update empleados set nombre = ?, apellidos = ?, genero = ?, email = ?, password = ?, salario = ?, fecha_ingreso = ?, fecha_nacimiento = ?, id_perfil = ?, id_depar = ? WHERE id_empl=?");
		try {
			statement.setInt(11, empleado.getIdEmpleado());
			statement.setString(1, empleado.getNombre());
			statement.setString(2, empleado.getApellidos());
			statement.setString(3, String.valueOf(empleado.getGenero()));
			statement.setString(4, empleado.getEmail());
			statement.setString(5, empleado.getPassword());
			statement.setDouble(6, empleado.getSalario());
			statement.setDate(7, empleado.getFechaIngreso());
			statement.setDate(8, empleado.getFechaNacimiento());
			statement.setInt(9, empleado.getPerfil().getIdPerfil());
			statement.setInt(10, empleado.getDepartamento().getIdDepartamento());

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
