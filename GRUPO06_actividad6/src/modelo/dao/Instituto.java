package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Persona;

public class Instituto implements InstitutoDao{
	
	private ArrayList <Persona> personas;
	
	

	public Instituto() {
		super();
		this.personas = new ArrayList<>();
	}

	@Override
	public boolean altaPersona(Persona persona) {
		// TODO Auto-generated method stub
		if (personas.contains(persona)) {
			return false;
		} else {
			return personas.add(persona);
		}
	}

	@Override
	public Persona buscarPersona(String nif) {
		// TODO Auto-generated method stub
		for (Persona persona : personas) {
			if (persona.getNif().equalsIgnoreCase(nif)) {
				return persona;
			}
		}
		return null;
	}

	@Override
	public List<Persona> buscarTodas() {
		// TODO Auto-generated method stub
		return personas;
	}

	@Override
	public boolean eliminarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return personas.remove(persona);
	}

	@Override
	public List<Persona> buscarPersonaPorTipo(String tipoPersona) {
		// TODO Auto-generated method stub
		return null;
	}
}
