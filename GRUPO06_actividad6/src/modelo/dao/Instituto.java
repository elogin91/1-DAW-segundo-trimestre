package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Administrativo;
import modelo.javabean.Alumno;
import modelo.javabean.Persona;
import modelo.javabean.Profesor;

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
		List<Persona> resultadoBusqueda = new ArrayList <Persona>();
		// TODO Auto-generated method stub
		for (Persona persona : personas) {
			if (tipoPersona.equalsIgnoreCase("profesor")) {
				if(persona instanceof Profesor) {
				resultadoBusqueda.add(persona);
				}
			}
			else if (tipoPersona.equalsIgnoreCase("alumno")) {
				if(persona instanceof Alumno) {
				resultadoBusqueda.add(persona);
				}
			}
			else if (tipoPersona.equalsIgnoreCase("administrativo")) {
				if(persona instanceof Administrativo) {
				resultadoBusqueda.add(persona);
				}
			}

		}
		return resultadoBusqueda;
	}

	@Override
	public String toString() {
		return "Instituto [personas=" + personas + "]";
	}
	
	
}
