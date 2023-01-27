package modelo.dao;

import java.util.ArrayList;

import modelo.javabean.Empleado;

public interface IntGestionEmpresa {

	public boolean alta(Empleado empleado);

	public boolean eliminarUno(Empleado empleado);

	public boolean modificarUno(Empleado empleado);

	public ArrayList<Empleado> buscarPorSexo(char sexo);

	public Empleado buscarUno(int idEmpleado);

	public ArrayList<Empleado> buscarTodos();

	public Double masaSalarial();

	public ArrayList<Empleado> buscarPorDepartamento(int idDepar);

	public ArrayList<Empleado> buscarPorTrabajo(String idTrabajo);

	public ArrayList<Empleado> buscarPorPais(String pais);
}
