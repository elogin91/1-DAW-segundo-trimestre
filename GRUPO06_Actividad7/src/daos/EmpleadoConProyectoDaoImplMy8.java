package daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.EmpleadoConProyecto;

public class EmpleadoConProyectoDaoImplMy8 extends AbstractDao implements EmpleadoConProyectoDao {

	@Override
	public int altaEmpleadoConProyecto(EmpleadoConProyecto proyectoEmpleado) {
		int filas = 0;
		try {
			PreparedStatement statement = conn
					.prepareStatement("Insert into proyecto_con_empleados values (?,?,?,?,?)");
			statement.setInt(1, proyectoEmpleado.getNumeroOrden());
			statement.setString(2, proyectoEmpleado.getProyecto().getIdProyecto());
			statement.setInt(3, proyectoEmpleado.getEmpleado().getIdEmpleado());
			statement.setInt(4, proyectoEmpleado.getHorasAsignadas());
			statement.setDate(5, new Date(proyectoEmpleado.getFechaIncorporacion().getTime()));
			filas = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al introducir un nuevo proyecto con Empleado.");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarEmpleadoConProyecto(int numeroOrden) {
		int filas = 0;
		try {
			PreparedStatement statement = conn
					.prepareStatement("Delete From proyecto_con_empleados WHERE numero_orden=?");
			statement.setInt(1, numeroOrden);
			filas = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al borrar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificaEmpleadoConProyecto(EmpleadoConProyecto proyectoEmpleado) {
		int filas = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(
					"Update proyecto_con_empleados set id_proyecto = ?, id_empl = ?, horas_asignadas = ?, fecha_incorporacion WHERE numero_orden=?");

			statement.setInt(5, proyectoEmpleado.getNumeroOrden());
			statement.setString(1, proyectoEmpleado.getProyecto().getIdProyecto());
			statement.setInt(2, proyectoEmpleado.getEmpleado().getIdEmpleado());
			statement.setInt(3, proyectoEmpleado.getHorasAsignadas());
			statement.setDate(4, new Date(proyectoEmpleado.getFechaIncorporacion().getTime()));
			filas = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar los datos");
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public EmpleadoConProyecto buscarEmpleadoConProyecto(int numeroOrden) {
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();
		EmpleadoConProyecto EmpleadoConProyecto = new EmpleadoConProyecto();

		try {
			PreparedStatement statement = conn
					.prepareStatement("Select * FROM proyecto_con_empleados WHERE numero_orden=?");
			statement.setInt(1, numeroOrden);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				EmpleadoConProyecto.setNumeroOrden(resultSet.getInt("numero_orden"));
				EmpleadoConProyecto.setProyecto(proyectoDao.buscarUnProyecto(resultSet.getString("id_proyecto")));
				EmpleadoConProyecto.setEmpleado(empleadoDao.buscarUnEmpleado(resultSet.getInt("id_empl")));
				EmpleadoConProyecto.setHorasAsignadas(resultSet.getInt("horas_asignadas"));
				EmpleadoConProyecto.setFechaIncorporacion(resultSet.getDate("fecha_incorporacion"));
			}
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return EmpleadoConProyecto;
	}

	@Override
	public List<EmpleadoConProyecto> buscarTodosEmpleadoConProyecto() {
		List<EmpleadoConProyecto> EmpleadoConProyectos = new ArrayList<>();
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();
		try {
			PreparedStatement statement = conn.prepareStatement("Select * FROM proyecto_con_empleados");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				EmpleadoConProyecto EmpleadoConProyecto = new EmpleadoConProyecto();
				EmpleadoConProyecto.setNumeroOrden(resultSet.getInt("numero_orden"));
				EmpleadoConProyecto.setProyecto(proyectoDao.buscarUnProyecto(resultSet.getString("id_proyecto")));
				EmpleadoConProyecto.setEmpleado(empleadoDao.buscarUnEmpleado(resultSet.getInt("id_empl")));
				EmpleadoConProyecto.setHorasAsignadas(resultSet.getInt("horas_asignadas"));
				EmpleadoConProyecto.setFechaIncorporacion(resultSet.getDate("fecha_incorporacion"));
				EmpleadoConProyectos.add(EmpleadoConProyecto);
			}
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return EmpleadoConProyectos;
	}

	@Override
	public List<EmpleadoConProyecto> empleadosByProyecto(String codigoProyecto) {
		List<EmpleadoConProyecto> EmpleadoConProyectos = new ArrayList<>();
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8();

		try {
			PreparedStatement statement = conn
					.prepareStatement("Select * FROM proyecto_con_empleados where id_proyecto =?");
			statement.setString(1, codigoProyecto);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				EmpleadoConProyecto EmpleadoConProyecto = new EmpleadoConProyecto();
				EmpleadoConProyecto.setNumeroOrden(resultSet.getInt("numero_orden"));
				EmpleadoConProyecto.setProyecto(proyectoDao.buscarUnProyecto(resultSet.getString("id_proyecto")));
				EmpleadoConProyecto.setEmpleado(empleadoDao.buscarUnEmpleado(resultSet.getInt("id_empl")));
				EmpleadoConProyecto.setHorasAsignadas(resultSet.getInt("horas_asignadas"));
				EmpleadoConProyecto.setFechaIncorporacion(resultSet.getDate("fecha_incorporacion"));
				EmpleadoConProyectos.add(EmpleadoConProyecto);
			}
		} catch (SQLException e) {
			System.out.println("Error al recolectar los datos");
			e.printStackTrace();
		}
		return EmpleadoConProyectos;
	}

	@Override
	public int asignarEmpleadosAProyecto(List<EmpleadoConProyecto> empleados) {
		int count = 0;
		for (EmpleadoConProyecto EmpleadoConProyecto : empleados) {
			count += altaEmpleadoConProyecto(EmpleadoConProyecto);
		}
		return count;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		int horasProyecto = 0;
		try {
			PreparedStatement statement = conn
					.prepareStatement("Select SUM(horas_asignadas) FROM proyecto_con_empleados where id_proyecto =?");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				horasProyecto = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horasProyecto;
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		List<EmpleadoConProyecto> empleadosConProyecto = empleadosByProyecto(codigoProyecto);
		double costeTotal = 0.0;
		for (EmpleadoConProyecto empleadoConProyecto : empleadosConProyecto) {
			costeTotal += empleadoConProyecto.costeHorasAsignadas();
		}
		return costeTotal;
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		ProyectoDao proyectoDao = new ProyectoDaoImplMy8();
		EmpleadoConProyectoDao empleadoConProyectoDao = new EmpleadoConProyectoDaoImplMy8();
		return proyectoDao.buscarUnProyecto(codigoProyecto).getVentaPrevista()
				- empleadoConProyectoDao.costeActualDeProyecto(codigoProyecto);
	}
}