package daos;

import java.util.List;

import javabeans.Departamento;

public interface DepartamentoDao {
	
	int altaDepartamento(Departamento departamento);
	int eliminarDepartamento(int idDepartamento);
	int modificarDepartamento(Departamento departamento);
	Departamento buscarUnDepartamento(int idDepartamento);
	List <Departamento> buscarTodosDepartamentos();

}
