package modelo.dao;

import java.util.List;

import modelo.javabean.Persona;

//Interface InstitutoDao con los métodos del esquema
public interface InstitutoDao {
	
	public boolean altaPersona(Persona persona);

	public Persona buscarPersona(String nif);

	public List<Persona> buscarTodas();

	public boolean eliminarPersona(Persona persona);

	public List<Persona> buscarPersonaPorTipo(String tipoPersona);

}
