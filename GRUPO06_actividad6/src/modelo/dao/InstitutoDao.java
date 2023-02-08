package modelo.dao;

import java.util.List;

import modelo.javabean.Persona;

public interface InstitutoDao {
	public boolean altaPersona(Persona persona);
	public Persona buscarPersona(String nif);
	public List<Persona> buscarTodas();
	public boolean eliminarPersona(Persona persona);
	public List<Persona> buscarPersonaPorTipo(String tipoPersona);
	
}
