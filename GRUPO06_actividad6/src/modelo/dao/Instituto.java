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
		cargarDatos();

	}

	private void cargarDatos() {
		personas.add(new Administrativo("999999999Z", "Sara Lopez Vega", "C/ Real, 6", "952 555 555", "hacer matrículas y controlar asistencias"));;
		personas.add(new Administrativo("888888888Y", "Ruben Diaz Velgara", "C/ Malaga, 10", "952 555 555", "atender llamadas y comprobar los pagos"));;
		personas.add(new Profesor("777777777A", "Maria Jiménez Soria", "C/Almadraba, 5", "956 333 333", "Matemáticas y física"));
		personas.add(new Profesor("666666666B", "Eduardo Arauzo Perez", "C/Arganda, 56", "956 333 333", "Lengua y literatura"));
		personas.add(new Alumno("555555555N", "Lucia Parrado Mendez", "Avda, Descubrimientos, 17", "958 444 444", "1º de Bachillerato"));
		personas.add(new Alumno("123987456L", "Javier Nieto Sanchez", "Plaza España, 19", "958 444 444", "2º de Bachillerato"));

	}

	@Override
	public boolean altaPersona(Persona persona) {
		
		if (personas.contains(persona)) {
			return false;
		} else {
			return personas.add(persona);
		}
	}

	@Override
	public Persona buscarPersona(String nif) {
		
		for (Persona persona : personas) {
			if (persona.getNif().equalsIgnoreCase(nif)) {
				return persona;
			}
		}
		return null;
	}

	@Override
	public List<Persona> buscarTodas() {
		
		return personas;
	}

	@Override
	public boolean eliminarPersona(Persona persona) {
		
		return personas.remove(persona);
	}

	@Override
	public List<Persona> buscarPersonaPorTipo(String tipoPersona) {
		List<Persona> resultadoBusqueda = new ArrayList <Persona>();
		
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
