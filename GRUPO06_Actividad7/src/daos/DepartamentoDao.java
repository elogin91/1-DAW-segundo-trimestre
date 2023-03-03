package daos;

import java.util.List;

import javabeans.Departamento;
import javabeans.Empleado;
import javabeans.Perfil;

public interface DepartamentoDao {
	
	int altaDepartamento(Departamento departamento);
	int eliminarDepartamento(int idDepartamento);
	int modificalDepartamento(Departamento departamento);
	Departamento buscarUnDepartamento(int idDepartamento);
	List <Departamento> buscarTodosDepartamentos();

}
