package daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Proyecto;

public class ProyectoDaoImplMy8 extends AbstractDao implements ProyectoDao {

	@Override
	public int altaProyecto(Proyecto proyecto) {
		Date fechaFinReal = null;
		int filas = 0;

		if (!(proyecto.getFechaFinReal() == null)) {
			fechaFinReal = proyecto.getFechaFinReal();
		}

		try {
			PreparedStatement statement = conn.prepareStatement("Insert into proyectos values (?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, proyecto.getIdProyecto());
			statement.setString(2, proyecto.getDescripcion());
			statement.setDate(3, proyecto.getFechaInicio());
			statement.setDate(4, proyecto.getFechaFinPrevisto());
			statement.setDate(5, fechaFinReal);
			statement.setDouble(6, proyecto.getVentaPrevista());
			statement.setDouble(7, proyecto.getCostePrevisto());
			statement.setDouble(8, proyecto.getCosteReal());
			statement.setString(9, proyecto.getEstado());
			statement.setInt(10, proyecto.getJefeProyecto().getIdEmpleado());
			statement.setString(11, proyecto.getCliente().getCif());
			filas = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo proyecto.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarProyecto(String idProyecto) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement("Delete From proyectos WHERE id_proyecto=?");
			statement.setString(1, idProyecto);
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarProyecto(Proyecto proyecto) {
		Date fechaFinReal = null;
		int filas = 0;
		if (!(proyecto.getFechaFinReal() == null)) {
			fechaFinReal = proyecto.getFechaFinReal();
		}

		try {
			PreparedStatement statement = conn.prepareStatement(
					"Update proyectos set descripcion = ?, fecha_inicio = ?, fecha_fin_previsto = ?, fecha_fin_real = ?, venta_previsto = ?, costes_previsto = ?, coste_real = ?, estado = ?, jefe_proyecto = ?, cif = ? WHERE id_proyecto=?");
			statement.setString(11, proyecto.getIdProyecto());
			statement.setString(1, proyecto.getDescripcion());
			statement.setDate(2, proyecto.getFechaInicio());
			statement.setDate(3, proyecto.getFechaFinPrevisto());
			statement.setDate(4, fechaFinReal);
			statement.setDouble(5, proyecto.getVentaPrevista());
			statement.setDouble(6, proyecto.getCostePrevisto());
			statement.setDouble(7, proyecto.getCosteReal());
			statement.setString(8, proyecto.getEstado());
			statement.setInt(9, proyecto.getJefeProyecto().getIdEmpleado());
			statement.setString(10, proyecto.getCliente().getCif());
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Proyecto buscarUnProyecto(String idProyecto) {
		Proyecto proyecto = new Proyecto();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();
		ClienteDao clienteDao = new ClienteDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM proyectos WHERE id_proyecto=?");
			statement.setString(1, idProyecto);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				proyecto.setIdProyecto(resultSet.getString("id_proyecto"));
				proyecto.setDescripcion(resultSet.getString("descripcion"));
				proyecto.setFechaInicio(resultSet.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(resultSet.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(resultSet.getDate("fecha_fin_real"));
				proyecto.setVentaPrevista(resultSet.getDouble("venta_previsto"));
				proyecto.setCostePrevisto(resultSet.getDouble("costes_previsto"));
				proyecto.setCosteReal(resultSet.getDouble("coste_real"));
				proyecto.setEstado(resultSet.getString("estado"));
				proyecto.setJefeProyecto(empleadoDao.buscarUnEmpleado(resultSet.getInt("jefe_proyecto")));
				proyecto.setCliente(clienteDao.buscarUno(resultSet.getString("cif")));

			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return proyecto;
	}

	@Override
	public List<Proyecto> buscarTodosProyectos() {
		List<Proyecto> proyectos = new ArrayList<>();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();
		ClienteDao clienteDao = new ClienteDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM proyectos ");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Proyecto proyecto = new Proyecto();
				proyecto.setIdProyecto(resultSet.getString("id_proyecto"));
				proyecto.setDescripcion(resultSet.getString("descripcion"));
				proyecto.setFechaInicio(resultSet.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(resultSet.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(resultSet.getDate("fecha_fin_real"));
				proyecto.setVentaPrevista(resultSet.getDouble("venta_previsto"));
				proyecto.setCostePrevisto(resultSet.getDouble("costes_previsto"));
				proyecto.setCosteReal(resultSet.getDouble("coste_real"));
				proyecto.setEstado(resultSet.getString("estado"));
				proyecto.setJefeProyecto(empleadoDao.buscarUnEmpleado(resultSet.getInt("jefe_proyecto")));
				proyecto.setCliente(clienteDao.buscarUno(resultSet.getString("cif")));
				proyectos.add(proyecto);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return proyectos;
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {

		List<Proyecto> proyectos = new ArrayList<>();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();
		ClienteDao clienteDao = new ClienteDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM proyectos where estado = ? ");
			statement.setString(1, estado);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Proyecto proyecto = new Proyecto();
				proyecto.setIdProyecto(resultSet.getString("id_proyecto"));
				proyecto.setDescripcion(resultSet.getString("descripcion"));
				proyecto.setFechaInicio(resultSet.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(resultSet.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(resultSet.getDate("fecha_fin_real"));
				proyecto.setVentaPrevista(resultSet.getDouble("venta_previsto"));
				proyecto.setCostePrevisto(resultSet.getDouble("costes_previsto"));
				proyecto.setCosteReal(resultSet.getDouble("coste_real"));
				proyecto.setEstado(resultSet.getString("estado"));
				proyecto.setJefeProyecto(empleadoDao.buscarUnEmpleado(resultSet.getInt("jefe_proyecto")));
				proyecto.setCliente(clienteDao.buscarUno(resultSet.getString("cif")));
				proyectos.add(proyecto);

			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return proyectos;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		List<Proyecto> proyectos = new ArrayList<>();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();
		ClienteDao clienteDao = new ClienteDaoImplMy8();

		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM proyectos where cif = ? ");
			statement.setString(1, cif);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Proyecto proyecto = new Proyecto();
				proyecto.setIdProyecto(resultSet.getString("id_proyecto"));
				proyecto.setDescripcion(resultSet.getString("descripcion"));
				proyecto.setFechaInicio(resultSet.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(resultSet.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(resultSet.getDate("fecha_fin_real"));
				proyecto.setVentaPrevista(resultSet.getDouble("venta_previsto"));
				proyecto.setCostePrevisto(resultSet.getDouble("costes_previsto"));
				proyecto.setCosteReal(resultSet.getDouble("coste_real"));
				proyecto.setEstado(resultSet.getString("estado"));
				proyecto.setJefeProyecto(empleadoDao.buscarUnEmpleado(resultSet.getInt("jefe_proyecto")));
				proyecto.setCliente(clienteDao.buscarUno(resultSet.getString("cif")));
				proyectos.add(proyecto);

			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return proyectos;
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		List<Proyecto> proyectos = new ArrayList<>();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();
		ClienteDao clienteDao = new ClienteDaoImplMy8();

		try {
			PreparedStatement statement = conn
					.prepareStatement("Select * FROM proyectos where estado = ? AND jefe_proyecto = ?");
			statement.setString(1, estado);
			statement.setInt(2, jefeProyecto);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Proyecto proyecto = new Proyecto();
				proyecto.setIdProyecto(resultSet.getString("id_proyecto"));
				proyecto.setDescripcion(resultSet.getString("descripcion"));
				proyecto.setFechaInicio(resultSet.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(resultSet.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(resultSet.getDate("fecha_fin_real"));
				proyecto.setVentaPrevista(resultSet.getDouble("venta_previsto"));
				proyecto.setCostePrevisto(resultSet.getDouble("costes_previsto"));
				proyecto.setCosteReal(resultSet.getDouble("coste_real"));
				proyecto.setEstado(resultSet.getString("estado"));
				proyecto.setJefeProyecto(empleadoDao.buscarUnEmpleado(resultSet.getInt("jefe_proyecto")));
				proyecto.setCliente(clienteDao.buscarUno(resultSet.getString("cif")));
				proyectos.add(proyecto);

			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return proyectos;
	}

	@Override
	public double importesVentaProyectosTerminados() {
		double ventasProyectosTerminados = 0.0;

		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT SUM(venta_previsto) FROM proyectos Where fecha_fin_real< now()");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				ventasProyectosTerminados = resultSet.getDouble(1);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return ventasProyectosTerminados;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		double margenProyectosTerminados = 0.0;

		try {
			PreparedStatement statement = conn.prepareStatement(
					"SELECT (venta_previsto - coste_real) FROM proyectos Where fecha_fin_real< now()");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				margenProyectosTerminados = resultSet.getDouble(1);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return margenProyectosTerminados;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {

		int diasParaTermino = 0;

		try {
			PreparedStatement statement = conn.prepareStatement(
					"SELECT datediff(now(), fecha_fin_previsto) FROM proyectos Where  fecha_fin_real IS null AND id_proyecto = ?");
			statement.setString(1, codigoProyecto);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				diasParaTermino = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return diasParaTermino;
	}

}
