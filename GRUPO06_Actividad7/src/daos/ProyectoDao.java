package daos;

import java.util.List;

import javabeans.Proyecto;

public interface ProyectoDao {
	
	//CRUD
	int altaProyecto(Proyecto proyecto);
	int eliminarProyecto(String idProyecto);
	int modificarProyecto(Proyecto proyecto);
	Proyecto buscarUnProyecto(String idProyecto);
	List <Proyecto> buscarTodosProyectos();
	
	//Otros Métodos.
	List<Proyecto> proyectosByEstado(String estado); 
	List<Proyecto> proyectosByCliente(String cif);
	List<Proyecto>proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado); 
	double importesVentaProyectosTerminados();
	double margenBrutoProyectosTerminados(); 
	//Diferencia suma Importes venta y gastos reales.
	int diasATerminoProyectoActivo(String codigoProyecto);
	//Cuantos días quedan para terminar el proyecto (diferencia entre fecha_fin_previsto y la fecha de hoy
}
