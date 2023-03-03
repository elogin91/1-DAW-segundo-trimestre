package daos;

import java.util.List;

import javabeans.Empleado;


public interface EmpleadoDao {

	int altaEmpleado(Empleado empleado);
	int eliminarEmpleado(int idEmpleado);
	int modificalEmpleado(Empleado empleado);
	Empleado buscarUnEmpleado(int idEmpleado);
	List <Empleado> buscarTodosEmpleados();
	List <Empleado> empleadosByDepartamento(int idDepar);
	List <Empleado> empleadosBySexo(char sexo);
	List <Empleado> empleadosByApellido(String subcadena);
	Double salarioTotal();
	Double salarioTotal(int idDepar);
}
