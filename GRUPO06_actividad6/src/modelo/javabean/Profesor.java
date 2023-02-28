package modelo.javabean;

//La clase Profesor heredará de la clase Persona.
public class Profesor extends Persona{

	//Propiedad  privada de la clase Profesor.
	private String competencias;
	
	//Get & Set.
	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}
	
	//Constructor.
	public Profesor() {
		super();
	}

	//Constructor de la case Profesor, con parametros de sus propieades propias y heredadas.
	public Profesor(String nif, String nombre, String direccion, String telefono, String competencias) {
		super(nif, nombre, direccion, telefono);
		this.competencias = competencias;
	}
	
	//Sobrescritura del método toString.
	@Override
	public String toString() {
		return  super.toString() + " Competencias: " + competencias ;
	}
	
	//Método propio de la clase Profesor, que devuelve una cadena que utiliza la propiedad nombre.
	public String ponerNotas() {
		return "El profesor " + this.getNombre() + " va a corregir los exámenes." ;
	}
	
	//Sobrescritura  y especialización del método abstracto trabajar heredado de Persona.
	@Override
	public String trabajar() {
		
		return "El profesor " + this. getNombre() + " va a impartir su clase.";
	}

}