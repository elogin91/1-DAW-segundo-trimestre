package modelo.javabean;

public class Profesor extends Persona{

	private String competencias;
	
	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}
	
	public Profesor() {
		super();
	}

	
	public Profesor(String nif, String nombre, String direccion, String telefono, String competencias) {
		super(nif, nombre, direccion, telefono);
		this.competencias = competencias;
	}

	public String ponerNotas() {
		return "El profesor " + this.getNombre() + " va a corregir los exámenes." ;
	}

	@Override
	public String trabajar() {
		// TODO Auto-generated method stub
		return "El profesor " + this. getNombre() + " va a impartir su clase.";
	}

	@Override
	public String toString() {
		return  super.toString() + " Competencias: " + competencias ;
	}
	
	
	
}
