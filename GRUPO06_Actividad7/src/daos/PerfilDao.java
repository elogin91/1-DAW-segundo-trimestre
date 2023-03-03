package daos;

import java.util.List;

import javabeans.Perfil;

public interface PerfilDao {
	int altaPerfil(Perfil perfil);
	int eliminarPerfil(int idPerfil);
	int modificarPerfil(Perfil perfil);
	Perfil buscarUnEmpleado(int idPerfil);
	List <Perfil> buscarTodosPerfiles();
}
